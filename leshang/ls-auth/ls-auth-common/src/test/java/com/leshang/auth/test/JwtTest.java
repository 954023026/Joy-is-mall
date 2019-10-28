package com.leshang.auth.test;

import com.leshang.common.pojo.UserInfo;
import com.leshang.common.utils.JwtUtils;
import com.leshang.common.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

    private static final String pubKeyPath = "D:\\coding\\rsa\\rsa.pub";

    private static final String priKeyPath = "D:\\coding\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
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
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU3MTYzNzcxNn0.Ig0u2tMpxZkuRCzKIYT9zq87z6FeU855mwqCzXWvUsb5znAdkcjCRkKLiWnIuFrloyK4H7E_gZcENljrUJNfAYG9vbN9zL7tXdiJHH6MEZJR0vBuWOTureVDSBvu1nEmb2Pxxa32RlT72sY5FmI05Hj5EybI4PF1Fouz5RxlPaY";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}
