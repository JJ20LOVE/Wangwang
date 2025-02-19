package com.itcaptain.ecnutrade.service;

import com.itcaptain.ecnutrade.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;


public interface UserService {
    //根据用户名查询用户
    User findByUserName(String username);
    //注册
    void register(String username, String password);

    //更新
    void update(User user);

    //删除
    void deleteById(Integer id);
}
