package com.itcaptain.ecnutrade.mapper;

import com.itcaptain.ecnutrade.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from user where username = #{username}")
    User findByUserName(String username);

    //添加
    @Insert("insert into user(username,password)"+
            "values(#{username},#{password})")
    void add(String username, String password);

    @Update("update user set email = #{email},weixinId = #{weixinId},phonenumber = #{phoneNumber} where id = #{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUserById(Integer id);
}
