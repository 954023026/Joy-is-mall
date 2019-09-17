package com.leshang.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-13 0:02
 */
@Data
@ConfigurationProperties(prefix = "ls.sms")
public class SmsProperties {

    String accessKeyId;
    String accessKeySecret;
    String signName;
    String verifyCodeTemplate;

}
