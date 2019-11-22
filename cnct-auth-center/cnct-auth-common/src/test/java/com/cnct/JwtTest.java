package com.cnct;

import com.cnct.entity.UserInfo;
import com.cnct.utils.JwtUtils;
import com.cnct.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {
    private static final String pubKeyPath = "E:/secretkey/rsa1.pub";

    private static final String priKeyPath = "E:/secretkey/rsa1.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "ssssssss");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInBob25lIjoiamFjayIsImV4cCI6MTU3NDQwNzIwN30.WMfyd80mf8WzZuewvoHErHnhi-7VniSEgXh4vJXdoIltjyS-u6YN7QKg0DixGrsyvG6q0b-IW_G5g6PvDyLGLXLe4y9kbYKU5mRhVlIVjgsDhqmZ53VFqeaDwWAUFPcWlBxBQsZ6f_caRPwGAeCNP2Z162yLDv9PJ-uTWTuwHQg";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("phone: " + user.getPhone());
    }

}
