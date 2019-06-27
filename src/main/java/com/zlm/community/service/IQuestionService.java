package com.zlm.community.service;

import com.zlm.community.dto.QuestionDTO;
import com.zlm.community.model.Question;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 问题表 服务类
 * </p>
 *
 * @author zhuluming
 * @since 2019-06-25
 */
public interface IQuestionService extends IService<Question> {

    QuestionDTO selectQuestionList();
}
