package com.hesen.blog;

import com.hesen.blog.dao.UserMapper;
import com.hesen.blog.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User hesen = userMapper.selectByUsernameAndPassword("hesen", "123456");
        System.out.println(hesen);
    }

}
