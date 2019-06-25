package com.zlm.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlm.community.dao.UserMapper;
import com.zlm.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Value("${community.token}")
    private String     communityToken;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (communityToken.equals(cookie.getName())) {
                    User user = userMapper
                        .selectOne(new QueryWrapper<User>().eq("token", cookie.getValue()));
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        return "index";
    }
}
