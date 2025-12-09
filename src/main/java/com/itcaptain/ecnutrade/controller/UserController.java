package com.itcaptain.ecnutrade.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.itcaptain.ecnutrade.pojo.Result;
import com.itcaptain.ecnutrade.pojo.User;
import com.itcaptain.ecnutrade.service.UserService;
import com.itcaptain.ecnutrade.warpbean.Duser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User newuser) {
    System.out.println(newuser!=null?newuser.getUsername():"null");
        // 查询用户
        User u = userService.findByUserName(newuser.getUsername());
        if(u == null){
            //没有占用
            //注册
            userService.register(newuser.getUsername(), newuser.getPassword(), newuser.getPhoneNumber());
            User user = userService.findByUserName(newuser.getUsername());
            return Result.success(user.getId());
        }else{
            //占用
            return Result.error(0,null);
        }
    }

    @PostMapping("/login")
    public Result login(@RequestBody User newuser) {
        //根据用户名查询
        User loginUser = userService.findByUserName(newuser.getUsername());
        //判断用户是否存在
        if(loginUser == null){
            return Result.error(0,null);
        }
        //判断密码
        if(loginUser.getPassword().equals(newuser.getPassword())){
            //登录成功
//            Map<String,Object> claims = new HashMap<>();
//            claims.put("id",loginUser.getId());
//            claims.put("username",loginUser.getUsername());
//            String token = JwtUtil.genToken(claims);

            return Result.success(loginUser.getId());
        }

        return Result.error(0,null);
    }

    @GetMapping("/user")
    public Result<User> userinfo(Integer userId){
        //根据id查询用户
        User user = userService.selectUserById(userId);
        return Result.success(user);
    }

    @PostMapping("/updateUser")
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.success(null);
    }

    @PutMapping("/deleteUser")
    public Result deleteById(Integer id){
        userService.deleteById(id);
        return Result.success(null);
    }
}
