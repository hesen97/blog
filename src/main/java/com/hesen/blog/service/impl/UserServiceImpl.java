package com.hesen.blog.service.impl;

import com.hesen.blog.dao.UserMapper;
import com.hesen.blog.po.User;
import com.hesen.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.selectByUsernameAndPassword(username, password);
        return user;
    }
}
