package com.leshang.auth.service.impl;

import com.leshang.auth.client.UserClient;
import com.leshang.auth.config.JwtProperties;
import com.leshang.auth.service.AuthService;
import com.leshang.common.enums.ExceptionEnum;
import com.leshang.common.exception.LyException;
import com.leshang.common.pojo.UserInfo;
import com.leshang.common.utils.JwtUtils;
import com.leshang.user.pojo.ZkUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-15 17:13
 */
@Slf4j
@EnableConfigurationProperties(JwtProperties.class)
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserClient userClient;

    @Autowired
    private JwtProperties prop;

    @Override
    public String login(String username, String password) {
        try {

            //根据用户名和密码查询
            ZkUser user = userClient.queruUserByUsernameAndPassword(username, password);
            //判断user
            if (user == null) {
                throw new LyException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
            }
            //jwtUtils生成jwt类型的token
            //生成token
            String token = JwtUtils.generateToken(new UserInfo(user.getId(), username), prop.getPrivateKey(), prop.getExpire());
            return token;
        }catch (Exception e){
            log.error("[授权中心] 用户名或密码有误,用户名称{}",username,e);
            throw new LyException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
    }
}
