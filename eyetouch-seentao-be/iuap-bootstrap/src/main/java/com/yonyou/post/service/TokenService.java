package com.yonyou.post.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yonyou.myuser.po.Myuser;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * Created on 2019/10/13 0013
 * BY Jianlong
 */
@Service
public class TokenService {
    public String getToken(Myuser user){
        String token="";
        try{
            // 将 user id 保存到 token 里面, 以 password 作为 token 的密钥
            token= JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return token;
    }
}
