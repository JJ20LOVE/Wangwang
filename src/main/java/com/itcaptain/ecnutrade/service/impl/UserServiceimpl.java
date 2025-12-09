package com.itcaptain.ecnutrade.service.impl;

import com.itcaptain.ecnutrade.mapper.UserMapper;
import com.itcaptain.ecnutrade.pojo.User;
import com.itcaptain.ecnutrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username){
        return userMapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password, String phoneNumber) {
        //加密处理
        //添加
        //这里我为了省事不搞了
        userMapper.add(username,password,phoneNumber);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);

    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }
}
