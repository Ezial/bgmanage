package com.ezial.bgmanage.dubbo.provider.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ezial.bgmanage.common.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    public static final String KEY = "abc";
    public static final String USERNAME = "ls";
    public static final String PASSWORD = "nb";
    public static final long EXPIRE_TIME = 15000l;

    @PostMapping(value = "/login")
    public String login(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        if(USERNAME.equals(username) && PASSWORD.equals(password)){
            try {
                String token = JwtUtil.createJWT(username,password,EXPIRE_TIME);
                return token;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
