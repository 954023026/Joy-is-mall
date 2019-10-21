package com.leshang.user.service;

import com.leshang.user.pojo.ZkAreas;
import com.leshang.user.pojo.ZkUserAddress;

import java.util.List;

public interface AddressService {
    List<ZkAreas> queryAddress();

    List<ZkUserAddress> queryAddressByUid(Long id);

    void saveUserAddress(ZkUserAddress address);

    void deleteUserAddress(Long addressId);

    void updateUserAddress(ZkUserAddress address);

    ZkUserAddress queryAddressByAddressId(Long addressId);
}
