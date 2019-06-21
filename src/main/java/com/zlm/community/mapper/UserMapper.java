package com.zlm.community.mapper;

import com.zlm.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
    @Insert("insert into user (accountid,name,token,creat,modify) values (#{accountId},#{name},#{token},#{creat},#{modify}) ")
    void insertUser(User user);
    @Select("select * from user where id=1")
    User selectUserById();
}
