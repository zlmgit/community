package com.zlm.community.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlm.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Insert("insert into user (account_id,name,token,creat,modify) values (#{accountId},#{name},#{token},#{creat},#{modify}) ")
    void insertUser(User user);
    @Select("select * from user where id=1")
    User selectUserById();

    List<User> selectAll();
}
