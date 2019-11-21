package com.cnct.mapper;

import com.cnct.pojo.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
@Component(value = "userMapper")
public interface UserMapper extends Mapper<User> {
}
