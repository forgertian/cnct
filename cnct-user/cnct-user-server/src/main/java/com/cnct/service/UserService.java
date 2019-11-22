package com.cnct.service;

import com.cnct.common.enums.ExceptionEnums;
import com.cnct.common.exception.CnctException;
import com.cnct.common.utils.NumberUtils;
import com.cnct.common.vo.PageResult;
import com.cnct.mapper.UserMapper;
import com.cnct.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    static final String KEY_PREFIX = "user:code:phone:";

    /**
     * 注册时进行手机号码是否可以使用
     * @param phone
     * @return
     */
    public Boolean checkPhone(String phone) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("phone",phone);
        int count = userMapper.selectCountByExample(example);
        return count == 0;
    }

    /**
     * 生成并发送短信验证码
     * @param phone
     * @return
     */
    public Boolean sendVerifyCode(String phone) {
        // 生成验证码
        String code = NumberUtils.generateCode(6);
        try {
            // 发送短信
            Map<String, String> msg = new HashMap<>();
            msg.put("phone", phone);
            msg.put("code", code);
            //测试环境暂时屏蔽短信功能 TODO 上线时进行开放
//            amqpTemplate.convertAndSend("cnct.sms.exchange", "sms.verify.code", msg);
            // 将code存入redis
            this.redisTemplate.opsForValue().set(KEY_PREFIX + phone, code, 5, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 验证短信验证码是否正确
     * @param phone
     * @param code
     * @return
     */
    public Boolean checkVerifyCode(String phone, String code) {
        //生成redis中的key
        String codeKey = KEY_PREFIX+phone;
        //从redis中取出验证码进行验证
        String redisCode = null;
        try {
            redisCode = redisTemplate.opsForValue().get(codeKey);
        } catch (Exception e) {
            throw new CnctException(ExceptionEnums.INVALID_VERFIY_CODE_DISABLED);
        }
        System.out.println("code:"+code);
        System.out.println("redisCode:"+redisCode);
        if(!StringUtils.equals(redisCode,code)){
            throw new CnctException(ExceptionEnums.INVALID_VERFIY_CODE);
        }
        return true;
    }

    /**
     * 添加用户功能
     * TODO 密码加密
     * @param user
     * @return
     */
    public User register(User user) {
        user.setBannedStatus(1L);
        user.setCreateDate(new Date());
        int i = userMapper.insertSelective(user);
        if(i == 0){
            throw new CnctException(ExceptionEnums.FAIL_ADD_USER);
        }
        return user;
    }

    public User completeInfo(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i != 1){
            throw new CnctException(ExceptionEnums.FAIL_COMPLETE_USER);
        }
        return user;
    }

    public void deleteUser(Long id) {
        User user = new User(id,0L);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i != 1){
            throw new CnctException(ExceptionEnums.FAIL_DELETE_USER);
        }
    }

    public void bannedUser(Long id) {
        User user = new User(id,99L);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i != 1){
            throw new CnctException(ExceptionEnums.FAIL_COMPLETE_USER);
        }
    }

    public PageResult<User> findAllUsersByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<User> users = userMapper.selectAll();
        PageInfo info = new PageInfo(users);
        PageResult<User> list = new PageResult<>();
        list.setTotalPage(Long.valueOf(info.getPages()));
        list.setTotal(info.getTotal());
        return list;
    }

    public User queryUser(String phone, String password) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        user = userMapper.selectOne(user);
        if(user.getId() != null)
            return user;
        else
            throw new CnctException(ExceptionEnums.INVALID_USERNAME_PASSWORD);

    }
}
