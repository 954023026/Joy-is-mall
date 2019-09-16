package com.leshang.auth.web;

import com.leshang.auth.config.JwtProperties;
import com.leshang.auth.service.AuthService;
import com.leshang.common.enums.ExceptionEnum;
import com.leshang.common.exception.LyException;
import com.leshang.common.pojo.UserInfo;
import com.leshang.common.utils.CookieUtils;
import com.leshang.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-15 17:09
 */
@RestController
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {
    @Autowired
    private AuthService authService;

    @Value("${ls.jwt.cookieName}")
    private String cookieName;

    @Autowired
    private JwtProperties prop;

    @PostMapping("/login")
    public ResponseEntity<Void> login(
            @RequestParam("username") String username, @RequestParam("password") String password,
            HttpServletResponse response, HttpServletRequest request) {
        //登录
        String token = authService.login(username, password);
        //写入cookie
        CookieUtils.newBuilder(response).httpOnly().request(request)
                .build("LS_TOKEN",token);
//        CookieUtils.setCookie(request, response, prop.getCookieName(), token, prop.getExpire() * 60);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 校验用户登录状态
     * @return
     */
    @GetMapping("verify")
    public ResponseEntity<UserInfo> verify(
            @CookieValue("LS_TOKEN") String token,
            HttpServletResponse response, HttpServletRequest request
    ){

        try {
            //解析token
            UserInfo info = JwtUtils.getInfoFromToken(token, prop.getPublicKey());

            //刷新token，重新生成token
            String newToken = JwtUtils.generateToken(info, prop.getPrivateKey(), prop.getExpire());
            //写入token中
            CookieUtils.newBuilder(response).httpOnly().request(request)
                    .build("LS_TOKEN",newToken);

            //已登录，返回用户信息
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            //token已过期，或者token无效
            throw new LyException(ExceptionEnum.UNAUTHORIZED);
        }

    }

}
