package com.cnct.service;

import com.cnct.client.UserClient;
import com.cnct.common.enums.ExceptionEnums;
import com.cnct.common.exception.CnctException;
import com.cnct.config.JwtProperties;
import com.cnct.entity.UserInfo;
import com.cnct.pojo.User;
import com.cnct.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService {
    @Autowired
    private JwtProperties prop;

    @Autowired
    private UserClient userClient;

 /*   private static Logger logger = LoggerFactory.getLogger(AuthService.class);*/

    public String login(String phone, String password) {
        try {
            // 校验用户名和密码
            User user = userClient.queryUser(phone, password);
            System.out.println("User:"+user);
            if(user == null){
                throw new CnctException(ExceptionEnums.INVALID_USERNAME_PASSWORD);
            }else if (user.getId() == null) {
                throw new CnctException(ExceptionEnums.INVALID_USERNAME_PASSWORD);
            }
            // 生成token
            String token = JwtUtils.generateToken(new UserInfo(user.getId(), phone), prop.getPrivateKey(), prop.getExpire());
            return token;
        }catch (Exception e){
//            logger.error("[授权中心] 用户名或者密码有误，用户名称：{}", username, e);
            e.printStackTrace();
            throw new CnctException(ExceptionEnums.INVALID_USERNAME_PASSWORD);
        }
    }

}
