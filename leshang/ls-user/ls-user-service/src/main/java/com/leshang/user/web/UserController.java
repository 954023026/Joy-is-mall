package com.leshang.user.web;

import com.leshang.user.pojo.ZkAreas;
import com.leshang.user.pojo.ZkUser;
import com.leshang.user.service.ZkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 描述:
 *      用户模块基本功能
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-13 10:45
 */
@RestController
public class UserController {
    @Autowired
    private ZkUserService userService;

    /**
     * 校验数据
     * @param data
     * @param type
     * @return
     */
    @GetMapping("check/{data}/{type}")
    public ResponseEntity<Boolean> checkData(@PathVariable("data") String data, @PathVariable("type") Integer type) {
        return ResponseEntity.ok(userService.checkData(data,type));
    }

    /**
     * 发送短信
     * @param phone
     * @return
     */
    @PostMapping("code")
    public ResponseEntity<Void> sendCode(@RequestParam("phone") String phone){
        userService.sendCode(phone);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 注册功能
     * @param user
     * @param code
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid ZkUser user, @RequestParam("code")String code){
        userService.register(user,code);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 校验用户，其他微服务调用接口，根据用户名跟密码查询该用户
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/query")
    public ResponseEntity<ZkUser> queruUserByUsernameAndPassword(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){
        return ResponseEntity.ok(userService.queruUserByUsernameAndPassword(username,password));
    }

    /**
     * 省市区信息
     * @return
     */
    @GetMapping("address")
    public ResponseEntity<List<ZkAreas>> queryAddress(){
        return  ResponseEntity.ok(userService.queryAddress());
    }

    /**
     * 根据id查询该用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ZkUser> queryUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.queryUserById(id));
    }

}
