package com.zlm.community;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlm.community.dao.QuestionMapper;
import com.zlm.community.dao.UserMapper;
import com.zlm.community.model.Question;
import com.zlm.community.model.User;
import com.zlm.community.service.IUserService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private IUserService userService;

    @Resource
    private QuestionMapper questionMapper;
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
    @Test
    public void testJson(){

        List<User> list = JSON.parseArray("[]",User.class);
        //System.err.println(CollectionUtils.isEmpty(list));
        if(CollectionUtils.isEmpty(list)){
            System.err.println("list是空:"+list.size());
        }else {
            System.err.println("list不是空:"+list.size());
        }
        System.err.println(list);
    }
    @Test
    public void testGetOne(){
        QueryWrapper<User>  query= new QueryWrapper<User>();
        query.eq("token","4b37b041-9ea0-4526-8cc0-ff854c1f1ca4");
        User user = userService.getOne(query);
        System.out.println(user);
    }

    @Test
    public void testStream(){
        List<User> users= Lists.newArrayList();
        users.forEach(user -> System.out.println(user.getCreateTi()));
        System.out.println(users);
    }
    @Test
    public void testPage(){
        Page<Question> page=new Page<>();
        page.setSize(2);
        page.setCurrent(1);
        IPage<Question> questionIPage = questionMapper.selectPage(page, null);
        List<Question> records = questionIPage.getRecords();
        System.out.println(records);
        System.out.println(questionIPage.getCurrent());
        System.out.println(questionIPage.getPages());
        System.out.println(questionIPage.getTotal());
        System.out.println(questionIPage.getSize());
    }
}
