package com.zlm.community.controller;

import com.alibaba.fastjson.JSON;
import com.zlm.community.pojo.AccessTokenDTO;
import com.zlm.community.pojo.GitUser;
import com.zlm.community.provider.GIthubProvider;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class OAuthController {

    @Value("${github.clientId}")
    String clientId ;
    @Value("${github.clientSecret}")
    String clientSecret ;
    @Autowired
    private GIthubProvider gitHubProvider;

    @RequestMapping("/callback")
    public String hello(String code,String state){

        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setCode(code);
        dto.setState(state);
        dto.setClient_id(clientId);
        dto.setClient_secret(clientSecret);
        String accessToken = gitHubProvider.getAccessToken(dto);
        GitUser gitUser = gitHubProvider.getUserByAccessToken(accessToken);
        return "index";
    }
}
