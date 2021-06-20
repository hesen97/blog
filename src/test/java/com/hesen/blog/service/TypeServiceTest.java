package com.hesen.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hesen.blog.po.Type;
import com.hesen.blog.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TypeServiceTest {

    @Autowired
    private TypeService typeService;

    @Test
    public void page() {
        Page<Type> page = new Page<>(1, 2);
        Page<Type> result = typeService.page(page);
        System.out.println(result.getRecords());
    }
}
