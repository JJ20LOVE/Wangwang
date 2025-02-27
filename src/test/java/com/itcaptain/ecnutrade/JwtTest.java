package com.itcaptain.ecnutrade;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class JwtTest {

    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","大丁丁");
        //生成jwt代码
        String token = JWT.create()
                .withClaim("user",claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*72))//添加过期时间\
                .sign(Algorithm.HMAC256("WangWang"));//指定算法,配置密钥

        System.out.println(token);
    }


    @Test
    public void testParse(){
        //定义字符串, 模拟用户传的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuWkp-S4geS4gSJ9LCJleHAiOjE3MzkwMTU3Mjd9" +
                ".73sc2t1gza_sgaaBuAC6xnw0e_buBZkF1xMorOtBYr4";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("WangWang")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token,生成解析后的jwt对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
