package com.leshang.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述:
 *  鉴权服务
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-15 14:01
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class LsAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(LsAuthApplication.class,args);
    }
}
