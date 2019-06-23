package com.zlm.community.controller;

import com.zlm.community.dao.UserMapper;
import com.zlm.community.model.User;
import com.zlm.community.pojo.AccessTokenDTO;
import com.zlm.community.pojo.GitUser;
import com.zlm.community.provider.GIthubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class OAuthController {

    @Value("${github.clientId}")
    private String clientId ;
    @Value("${github.clientSecret}")
    private String clientSecret ;
    @Value("${community.token}")
    private String communityToken;
    @Autowired
    private GIthubProvider gitHubProvider;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/callback")
    public String hello(String code, String state, HttpServletRequest request, HttpServletResponse response){

        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setCode(code);
        dto.setState(state);
        dto.setClient_id(clientId);
        dto.setClient_secret(clientSecret);
        String accessToken = gitHubProvider.getAccessToken(dto);
        GitUser gitUser = gitHubProvider.getUserByAccessToken(accessToken);
        if(gitUser!=null){
            //HttpSession session = request.getSession();
            //session.setAttribute("user",gitUser);
            String token = UUID.randomUUID().toString();
            User user= new User();
            user.setAccountId(gitUser.getId());
            user.setName(gitUser.getName());
            user.setCreat(System.currentTimeMillis());
            user.setToken(token);
            user.setModify(user.getCreat());
            userMapper.insertUser(user);
            response.addCookie(new Cookie(communityToken,token));
            return "redirect:/";
        }
        return "redirect:/";
    }
}
