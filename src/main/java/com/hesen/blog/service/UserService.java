package com.hesen.blog.service;

import com.hesen.blog.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
