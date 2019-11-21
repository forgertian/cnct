package com.cnct.mapper;

import com.cnct.pojo.Role;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
@Component(value = "roleMapper")
public interface RoleMapper  extends Mapper<Role> {
}
