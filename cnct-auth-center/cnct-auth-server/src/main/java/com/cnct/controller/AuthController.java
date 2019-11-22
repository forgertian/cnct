package com.cnct.controller;

import com.cnct.common.enums.ExceptionEnums;
import com.cnct.common.exception.CnctException;
import com.cnct.common.utils.CookieUtils;
import com.cnct.config.JwtProperties;
import com.cnct.entity.UserInfo;
import com.cnct.service.AuthService;
import com.cnct.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtProperties prop;

    @Value("${cnct.jwt.cookieName}")
    private String cookieName;

    @PostMapping("/login")
    public ResponseEntity<Void> login(// 无需给前端浏览器返回token，token只有后端才需要使用，并且将token保存到cookie中
                                      @RequestParam("phone") String phone,
                                      @RequestParam("password") String password,
                                      HttpServletResponse response,
                                      HttpServletRequest request) {
        // 登录功能的实现
        String token = authService.login(phone, password);

        // 将token写入cookie --- 工厂模式
        // httpOnly()：避免别的js代码来操作你的cookie，是一种安全措施
        // charset(): 不需要编码 因为token中没有中文
        // maxAge()： cookie的生命周期，默认是-1，代表一次会话，浏览器关闭cookie就失效
        // response: 将cookie写入 --- response中有一个方法 addCookie()
        // request: cookie中有域的概念 domain 例如一个cookie只能在www.baidu.com生效，无法在别的域下生效
        // 给cookie绑定一个域，防止别的网站访问你的cookie，也是一种安全措施
        CookieUtils.newBuilder(response).httpOnly().request(request).build(cookieName, token);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("verify")
    public ResponseEntity<UserInfo> verify(
            @CookieValue("CNCT_TOKEN") String token,
            HttpServletResponse response,
            HttpServletRequest request
    ) {
        try {
            // 解析token
            UserInfo info = JwtUtils.getInfoFromToken(token, prop.getPublicKey());
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            throw new CnctException(ExceptionEnums.NO_AUTHORIZED);
        }
    }


}
