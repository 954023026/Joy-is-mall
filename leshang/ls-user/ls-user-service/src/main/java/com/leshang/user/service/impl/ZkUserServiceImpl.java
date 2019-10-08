package com.leshang.user.service.impl;

import com.leshang.common.enums.ExceptionEnum;
import com.leshang.common.exception.LyException;
import com.leshang.common.utils.NumberUtils;
import com.leshang.user.mapper.AreasMapper;
import com.leshang.user.mapper.UserMapper;
import com.leshang.user.pojo.ZkAreas;
import com.leshang.user.pojo.ZkUser;
import com.leshang.user.service.ZkUserService;
import com.leshang.user.utils.CodecUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-16 14:32
 */
@Service
public class ZkUserServiceImpl implements ZkUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AreasMapper areasMapper;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "lsUser:verify:phone:";


    @Override
    public void sendCode(String phone) {
        //生成key
        String key = KEY_PREFIX + phone;
        //生成验证码
        String code = NumberUtils.generateCode(6);
        HashMap<String, String> msg = new HashMap<>();
        msg.put("phone", phone);
        msg.put("code", code);

        //发送验证码
//        amqpTemplate.convertAndSend("ls.sms.exchange", "sms.verify.code", msg);

        //保存验证码
        redisTemplate.opsForValue().set(key, code, 5, TimeUnit.MINUTES);
    }

    @Override
    public void register(ZkUser user, String code) {
        //从reids中取出验证码
        /*String cacheCode = redisTemplate.opsForValue().get(KEY_PREFIX + user.getPhone());
        //校验验证码
        if (!StringUtils.equals(code, cacheCode)) {
            throw new LyException(ExceptionEnum.INVALID_VERIFY_CODE);
        }*/
        //生成盐
        String salt = CodecUtils.generateSalt();
        user.setSalt(salt);
        //对密码加密
        user.setPassword(CodecUtils.md5Hex(user.getPassword(), salt));

        //写入数据库
        user.setCreated(new Date());
        userMapper.insert(user);
    }

    @Override
    public ZkUser queruUserByUsernameAndPassword(String username, String password) {
        //查询用户
        ZkUser record = new ZkUser();
        record.setUsername(username);
        ZkUser user = userMapper.selectOne(record);
        //校验
        if (user == null) {
            throw new LyException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
        //校验密码
        if (!StringUtils.equals(user.getPassword(), CodecUtils.md5Hex(password,user.getSalt()))) {
            throw new LyException(ExceptionEnum.INVALID_USERNAME_PASSWORD);
        }
        return user;
    }

    @Override
    public Boolean checkData(String data, Integer type) {
        //判断数据类型
        ZkUser record = new ZkUser();
        switch (type) {
            case 1:
                record.setUsername(data);
                break;
            case 2:
                record.setPhone(data);
                break;
            default:
                throw new LyException(ExceptionEnum.INVALID_USER_DATA_TYPE);
        }
        return userMapper.selectCount(record) == 0;
    }

    @Override
    public List<ZkAreas> queryAddress() {
        return areasMapper.selectAll();
    }
}
