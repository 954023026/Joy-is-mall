package com.leshang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.leshang.user.mapper")
public class LsUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsUserApplication.class, args);
    }
}