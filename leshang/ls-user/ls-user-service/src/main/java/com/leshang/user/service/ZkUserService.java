package com.leshang.user.service;

import com.leshang.user.pojo.ZkUser;

public interface ZkUserService {
    void sendCode(String phone);

    void register(ZkUser user, String code);

    ZkUser queruUserByUsernameAndPassword(String username, String password);

    Boolean checkData(String data, Integer type);

    ZkUser queryUserById(Long id);

    void updateUserById(ZkUser user);
}
