package com.zlm.community.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlm.community.dto.PaginationDTO;
import com.zlm.community.dto.QuestionDTO;
import com.zlm.community.model.Question;
import com.zlm.community.model.User;
import com.zlm.community.service.IQuestionService;
import com.zlm.community.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {


    @Autowired
    private IQuestionService iQuestionService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(value = "page",defaultValue = "1") Integer page,
                        @RequestParam(value = "size",defaultValue = "8") Integer size) {
        PaginationDTO<QuestionDTO> paginationDTO = iQuestionService.selectQuestionList(page, size);
        model.addAttribute("pagination", paginationDTO);
        return "index";
    }
}
