package com.zlm.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zlm.community.dao.UserMapper;
import com.zlm.community.model.User;
import com.zlm.community.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Auther: zhuluming
 * @Email: Luming.Zhu@paat.com
 * @Date: 2019/6/25 18:49
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
