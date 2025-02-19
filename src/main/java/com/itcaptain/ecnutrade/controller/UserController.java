package com.itcaptain.ecnutrade.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.itcaptain.ecnutrade.pojo.Result;
import com.itcaptain.ecnutrade.pojo.User;
import com.itcaptain.ecnutrade.service.UserService;
import com.itcaptain.ecnutrade.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/SignUp")
    public Result register(String username,String password) {
        // 查询用户
        User u = userService.findByUserName(username);
        if(u == null){
            //没有占用
            //注册
            userService.register(username,password);
            User user = userService.findByUserName(username);
            return Result.success(user.getId());
        }else{
            //占用
            return Result.error(0,null);
        }
    }

    @PostMapping("/login")
    public Result<String> login(String username,String password) {
        //根据用户名查询
        User loginUser = userService.findByUserName(username);
        //判断用户是否存在
        if(loginUser == null){
            return Result.error(0,null);
        }
        //判断密码
        if(loginUser.getPassword().equals(password)){
            //登录成功
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("username",loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error(0,null);
    }

    @GetMapping("/user")
    public Result<User> userinfo(@RequestHeader(name = "Authorization")String token){
        //根据用户名查询用户
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String)map.get("username");

        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/updateUser")
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
