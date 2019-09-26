package com.leshang.user.service;

import com.leshang.user.pojo.ZkAreas;
import com.leshang.user.pojo.ZkUser;

import java.util.List;

public interface ZkUserService {
    void sendCode(String phone);

    void register(ZkUser user, String code);

    ZkUser queruUserByUsernameAndPassword(String username, String password);

    Boolean checkData(String data, Integer type);

    List<ZkAreas> queryAddress();
}
