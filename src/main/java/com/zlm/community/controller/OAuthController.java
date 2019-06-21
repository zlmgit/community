package com.zlm.community.controller;

import com.alibaba.fastjson.JSON;
import com.zlm.community.mapper.UserMapper;
import com.zlm.community.model.User;
import com.zlm.community.pojo.AccessTokenDTO;
import com.zlm.community.pojo.GitUser;
import com.zlm.community.provider.GIthubProvider;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Controller
public class OAuthController {

    @Value("${github.clientId}")
    String clientId ;
    @Value("${github.clientSecret}")
    String clientSecret ;
    @Autowired
    private GIthubProvider gitHubProvider;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/callback")
    public String hello(String code, String state, HttpServletRequest request){

        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setCode(code);
        dto.setState(state);
        dto.setClient_id(clientId);
        dto.setClient_secret(clientSecret);
        String accessToken = gitHubProvider.getAccessToken(dto);
        GitUser gitUser = gitHubProvider.getUserByAccessToken(accessToken);
        if(gitUser!=null){
            request.getSession().setAttribute("user",gitUser);
            User user= new User();
            user.setAccountId(gitUser.getId());
            user.setName(gitUser.getName());
            user.setCreat(System.currentTimeMillis());
            user.setModify(user.getCreat());
            user.setToken(UUID.randomUUID().toString());
            userMapper.insertUser(user);
            //User user1 = userMapper.selectUserById();
           // System.out.println(user1);
            return "redirect:/";
        }
        return "redirect:/";
    }
}
