package com.zlm.community.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlm.community.model.Question;
import com.zlm.community.model.User;
import com.zlm.community.service.IQuestionService;
import com.zlm.community.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 问题表 前端控制器
 * </p>
 *
 * @author zhuluming
 * @since 2019-06-25
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private IQuestionService questionService;

    @Autowired
    private IUserService userService;

    @Value("${community.token}")
    private String     communityToken;

    @PostMapping("/publish")
    public String doPublish( Question question, Model model, HttpServletRequest request){
        model.addAttribute("tag",question.getTag());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("title",question.getTitle());
        User user=null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (communityToken.equals(cookie.getName())) {
                    user = userService.getOne(new QueryWrapper<User>().eq("token",cookie.getValue()));
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        if(user==null&&user.getAccountId()!=null){
            model.addAttribute("error","请先登录");
            return "publish";
        }
        question.setCreateTi(System.currentTimeMillis());
        question.setCreator(Integer.valueOf(user.getAccountId()));
        boolean save = questionService.save(question);
        return "redirect:/";
    }

}
