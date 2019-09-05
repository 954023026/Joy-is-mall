package com.leshang.item.mapper;

import com.leshang.item.pojo.ZkUser;
import com.leshang.item.pojo.ZkUserExtend;
import com.leyou.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ZkUserMapper extends BaseMapper<ZkUser> {
    /**
     * 添加工作记录
     *
     * @return
     */
    @Insert("insert into zk_user (username,password,phone) values (#{username},#{password},#{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    //获取添加成功后主键id
    Integer insertUser(ZkUser zkUser);


    @Select("select * from zk_user where username=#{name} and password = #{password}")
    ZkUser selectByPrimaryNameAndPwd(@Param("name") String name, @Param("password") String password);

    /**
     * 注册时判断该手机号码是否注册 || 通过手机号码查询该用户信息
     *
     * @param phone 手机号
     * @return 该用户信息
     */
    @Select("SELECT * FROM zk_user WHERE phone = #{phone}")
    ZkUser selectUserByPhone(String phone);

    //更具手机号码修改密码
    @Update("UPDATE zk_user SET password=#{password} WHERE phone=#{phone}")
    int updateUserByPhone(@Param("password") String pwd, @Param("phone") String phone);
    //根据用户id修改密码
    @Update("UPDATE zk_user SET password=#{newPass} WHERE id=#{id}")
    Integer updatePwdByUid(@Param("id") Long id, @Param("newPass") String newPass);

    /**
     * 测试，获取一对多，实例对象
     * @return
     */
    @Select("select * from zk_user")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column="id",property="orderList",one=@One(select="com.zuka.dao.ZkOrderMapper.getBooksByUserId",fetchType= FetchType.EAGER))
    })
    List<ZkUserExtend> selectUser();

}