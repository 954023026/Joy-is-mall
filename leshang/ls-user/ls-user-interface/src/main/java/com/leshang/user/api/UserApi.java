package com.leshang.user.api;

import com.leshang.user.pojo.ZkUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-16 15:32
 */
public interface UserApi {

    @GetMapping("/query")
    public ZkUser queruUserByUsernameAndPassword(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    );
}
