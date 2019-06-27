package com.zlm.community.service.impl;

import com.zlm.community.dto.QuestionDTO;
import com.zlm.community.model.Question;
import com.zlm.community.dao.QuestionMapper;
import com.zlm.community.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlm.community.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 问题表 服务实现类
 * </p>
 *
 * @author zhuluming
 * @since 2019-06-25
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private IUserService iUserService;
    @Override
    public List<QuestionDTO> selectQuestionList() {
        List<Question> questions = questionMapper.selectList(null);
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        questions.forEach(question -> {
            QuestionDTO questionDTO= new QuestionDTO();
            BeanUtils.copyProperties(question , questionDTO);
            questionDTO.setUser(iUserService.getById(question.getCreator()));
            questionDTOS.add(questionDTO);
        });
        return questionDTOS;
    }
}
