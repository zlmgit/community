package com.zlm.community.controller;

import com.zlm.community.dto.PaginationDTO;
import com.zlm.community.dto.QuestionDTO;
import com.zlm.community.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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
