package com.cnct.service;

import com.cnct.mapper.RoleMapper;
import com.cnct.common.enums.ExceptionEnums;
import com.cnct.common.exception.CnctException;
import com.cnct.common.vo.PageResult;
import com.cnct.pojo.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;
    public PageResult<Role> findRoles(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        Example example = new Example(Role.class);
        example.createCriteria().andEqualTo("status",1);
        List<Role> roles = roleMapper.selectByExample(example);
        PageInfo info = new PageInfo(roles);
        PageResult<Role> list = new PageResult<>();
        list.setItems(roles);
        list.setTotal(info.getTotal());
        list.setTotalPage(Long.valueOf(info.getPages()));
        return list;
    }

    public Role addRole(Role role) {
        role.setStatus(1L);
        int i = roleMapper.insertSelective(role);
        if(i>0){
            return role;
        }else{
            throw new CnctException(ExceptionEnums.FAIL_ADD_ROLE);
        }
    }

    public Role editRole(Role role) {
        int i = roleMapper.updateByPrimaryKeySelective(role);
        if(i>0){
            return role;
        }else{
            throw new CnctException(ExceptionEnums.FAIL_ADD_ROLE);
        }
    }

    public int deleteRole(Long id) {
        if(id == null){
            throw new CnctException(ExceptionEnums.NO_AUTHORIZED);
        }
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role.getId() != id){
            throw new CnctException(ExceptionEnums.NO_AUTHORIZED);
        }
        role.setStatus(0L);
        int i = roleMapper.updateByPrimaryKeySelective(role);
        if(i>0){
            return i;
        }else{
            throw new CnctException(ExceptionEnums.FAIL_ADD_ROLE);
        }
    }
    //TODO 调用user微服务中的 方法查询该角色现在是否有用户存在
    public Boolean checkRole(Long id) {

        return null;
    }
}
