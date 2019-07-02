package com.zlm.community.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlm.community.dto.PaginationDTO;
import com.zlm.community.dto.QuestionDTO;
import com.zlm.community.model.Question;
import com.zlm.community.dao.QuestionMapper;
import com.zlm.community.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlm.community.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PaginationDTO<QuestionDTO> selectQuestionList(Integer page, Integer size) {
        IPage<Question> questionIPage = questionMapper.selectPage(new Page<Question>(page,size), null);
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        questionIPage.getRecords().forEach(question -> {
            QuestionDTO questionDTO= new QuestionDTO();
            BeanUtils.copyProperties(question , questionDTO);
            questionDTO.setUser(iUserService.getById(question.getCreator()));
            questionDTOS.add(questionDTO);
        });
        PaginationDTO<QuestionDTO> paginationDTO = new PaginationDTO();
        paginationDTO.setPagination(Integer.valueOf(questionIPage.getPages()+""),page);
        paginationDTO.setData(questionDTOS);
        return paginationDTO;
    }

}
