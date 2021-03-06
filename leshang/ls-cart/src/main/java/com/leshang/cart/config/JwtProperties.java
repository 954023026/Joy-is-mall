package com.leshang.cart.config;

import com.leshang.common.utils.RsaUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

@Data
@ConfigurationProperties(prefix = "ls.jwt")
public class JwtProperties {
    private String pubKeyPath;// 公钥

    private String cookieName;
    private PublicKey publicKey;

    //对象一旦实例化后，就应该读取公钥和私钥
    @PostConstruct //构造函数执行完成后执行
    public void init() throws Exception {
        //读取公钥和私钥
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
    }

}
