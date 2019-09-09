package com.leshang.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.leshang.item.mapper")
public class LsItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LsItemApplication.class, args);
    }
}