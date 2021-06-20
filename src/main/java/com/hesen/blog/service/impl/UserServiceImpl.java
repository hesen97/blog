package com.hesen.blog.service.impl;

import com.alibaba.druid.support.monitor.dao.MonitorDaoJdbcImpl;
import com.hesen.blog.dao.UserMapper;
import com.hesen.blog.exception.DaoFailException;
import com.hesen.blog.po.User;
import com.hesen.blog.service.UserService;
import com.hesen.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public User checkUser(String username, String password) {
        try {
            User user = userMapper.selectByUsernameAndPassword(username, MD5Utils.encode(password));
            return user;
        } catch (Exception e) {
            throw new DaoFailException("检查用户信息失败", e);
        }
    }
}
