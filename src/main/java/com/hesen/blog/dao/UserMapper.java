package com.hesen.blog.dao;

import com.hesen.blog.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User selectByUsernameAndPassword(@Param("username") String username,
                                     @Param("password") String password);
}
