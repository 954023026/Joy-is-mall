package com.leshang.page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-06 17:35
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class LsPageApplication {
    public static void main(String[] args) {
        SpringApplication.run(LsPageApplication.class);
    }

}
