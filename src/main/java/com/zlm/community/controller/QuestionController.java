package com.zlm.community.controller;


import com.zlm.community.model.Question;
import com.zlm.community.service.IQuestionService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

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

    @PostMapping("/publish")
    public String doPublish(Question question){

        questionService.save(question);

        return "publish";
    }

}
