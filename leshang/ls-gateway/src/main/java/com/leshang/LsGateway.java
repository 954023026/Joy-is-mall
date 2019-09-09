package com.leshang;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-09 15:56
 */
@EnableZuulProxy
@SpringCloudApplication
public class LsGateway {
    public static void main(String[] args) {
        SpringApplication.run(LsGateway.class);
    }
}
