package com.zlm.community.service.impl;

import com.zlm.community.model.Question;
import com.zlm.community.dao.QuestionMapper;
import com.zlm.community.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
