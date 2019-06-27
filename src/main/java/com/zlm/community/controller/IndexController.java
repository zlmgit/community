package com.zlm.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlm.community.dto.QuestionDTO;
import com.zlm.community.model.User;
import com.zlm.community.service.IQuestionService;
import com.zlm.community.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Value("${community.token}")
    private String     communityToken;

    @Autowired
    private IUserService userService;

    @Autowired
    private IQuestionService iQuestionService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (communityToken.equals(cookie.getName())) {
                    User user = userService.getOne(new QueryWrapper<User>().eq("token",cookie.getValue()));
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        List<QuestionDTO> questionDTOS = iQuestionService.selectQuestionList();
        model.addAttribute("questions", questionDTOS);
        return "index";
    }
}
