package com.zlm.community.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlm.community.dto.PaginationDTO;
import com.zlm.community.dto.QuestionDTO;
import com.zlm.community.model.Question;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 问题表 服务类
 * </p>
 *
 * @author zhuluming
 * @since 2019-06-25
 */
public interface IQuestionService extends IService<Question> {

    PaginationDTO<QuestionDTO> selectQuestionList(Integer page, Integer size);
}
