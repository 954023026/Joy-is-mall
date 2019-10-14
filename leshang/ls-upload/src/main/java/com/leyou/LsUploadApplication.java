package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-08-25 16:44
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LsUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(LsUploadApplication.class,args);
    }
}
