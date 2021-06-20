package com.hesen.blog;

import com.hesen.blog.dao.UserMapper;
import com.hesen.blog.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


class BlogApplicationTests {



    @Test
    void contextLoads() {
        Object o = new ArrayList<String>();
        System.out.println(o instanceof List);
    }

}
