package com.leshang.user.service.impl;

import com.leshang.user.mapper.AreasMapper;
import com.leshang.user.mapper.UserAddressMapper;
import com.leshang.user.pojo.ZkAreas;
import com.leshang.user.pojo.ZkUserAddress;
import com.leshang.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-10-19 9:44
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    private AreasMapper areasMapper;

    @Override
    public List<ZkAreas> queryAddress() {
        return areasMapper.selectAll();
    }

    @Override
    public List<ZkUserAddress> queryAddressByUid(Long id) {
        Example example = new Example(ZkUserAddress.class);
        example.createCriteria().andEqualTo("userId",id);
        return userAddressMapper.selectByExample(example);
    }

    @Override
    public void saveUserAddress(ZkUserAddress address) {
        address.setCreatedTime(new Date());
        userAddressMapper.insertSelective(address);
    }

    @Override
    public void deleteUserAddress(Long addressId) {
        userAddressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public void updateUserAddress(ZkUserAddress address) {
        userAddressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public ZkUserAddress queryAddressByAddressId(Long addressId) {
        return userAddressMapper.selectByPrimaryKey(addressId);
    }
}
