package com.leshang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-08-22 20:19
 */
@EnableEurekaServer
@SpringBootApplication
public class LsRegistry {
    public static void main(String[] args) {
        SpringApplication.run(LsRegistry.class);
    }
}
