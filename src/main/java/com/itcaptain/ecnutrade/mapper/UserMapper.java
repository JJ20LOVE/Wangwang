package com.itcaptain.ecnutrade.mapper;

import com.itcaptain.ecnutrade.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from user where username = #{username}")
    User findByUserName(String username);

    //添加
    @Insert("insert into user(username,password,phone_number)"+
            "values(#{username},#{password},#{phoneNumber})")
    void add(String username, String password, String phoneNumber);

    @Update("update user set username = #{username},password = #{password},phone_number = #{phoneNumber} where id = #{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUserById(Integer id);
}
