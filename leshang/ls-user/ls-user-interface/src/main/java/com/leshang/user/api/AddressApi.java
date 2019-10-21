package com.leshang.user.api;

import com.leshang.user.pojo.ZkUserAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("address")
public interface AddressApi {
    @GetMapping("id")
    public ZkUserAddress queryAddressByAddressId(@RequestParam("addressId") Long addressId);
}
