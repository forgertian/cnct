package com.cnct.api;

import com.cnct.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserAPI {
    @GetMapping("/user/query")
    User queryUser(@RequestParam("phone") String phone, @RequestParam("password") String password);
}
