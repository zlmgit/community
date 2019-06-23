package com.zlm.community;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlm.community.dao.UserMapper;
import com.zlm.community.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    public void testMp() {
        List<User> users = userMapper.selectList(null);
        System.err.println(users);
    }

    @Test
    public void testUpdate(){
        User entity = new User();
        entity.setName("lisi");
        //entity.setAccountId("789456123");
        //QueryWrapper<User> updateWrapper = new QueryWrapper<User>();
        new QueryWrapper<User>().eq("account_id",789456123);
        int update = userMapper.update(entity, new QueryWrapper<User>().eq("account_id",789456123));
        System.out.println(update);
    }

    @Test
    public void selectAll(){
        List<User> users = userMapper.selectAll();
        System.err.println(users);

    }
    @Test
    public void selectOne(){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("token", "b32aac67-f794-4842-827b-f4308b902a32"));
        System.err.println(user);
    }
}
