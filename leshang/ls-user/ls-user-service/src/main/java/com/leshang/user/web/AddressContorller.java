package com.leshang.user.web;

import com.leshang.user.pojo.ZkAreas;
import com.leshang.user.pojo.ZkUser;
import com.leshang.user.pojo.ZkUserAddress;
import com.leshang.user.service.AddressService;
import com.leshang.user.service.ZkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-10-19 9:38
 */
@RestController
@RequestMapping("address")
public class AddressContorller {
    @Autowired
    private AddressService addressService;
    /**
     * 省市区信息
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ZkAreas>> queryAddress(){
        return  ResponseEntity.ok(addressService.queryAddress());
    }

    /**
     * 根据用户id查询当前用户地址值
     * @param id
     * @return
     */
    @GetMapping("{userId}")
    public ResponseEntity<List<ZkUserAddress>> queryAddressByUid(@PathVariable("userId") Long id){
        return ResponseEntity.ok(addressService.queryAddressByUid(id));
    }


    /**
     * 添加地址值
     * @param address
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveUserAddress(@RequestBody ZkUserAddress address){
        addressService.saveUserAddress(address);
        return ResponseEntity.ok().build();
    }

    /**
     * 修改用户地址值
     * @param address
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> updateUserAddress(@RequestBody ZkUserAddress address){
        addressService.updateUserAddress(address);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除当前用户选择删除地址值
     * @param addressId
     * @return
     */
    @DeleteMapping("{addressId}")
    public ResponseEntity<Void> deleteUserAddress(@PathVariable("addressId") Long addressId){
        addressService.deleteUserAddress(addressId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("id")
    public ResponseEntity<ZkUserAddress> queryAddressByAddressId(@RequestParam("addressId") Long addressId){
        return ResponseEntity.ok(addressService.queryAddressByAddressId(addressId));
    }
}
