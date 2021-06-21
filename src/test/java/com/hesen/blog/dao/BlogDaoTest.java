package com.hesen.blog.dao;

import com.hesen.blog.po.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BlogDaoTest {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void insertBlog() {
        Blog blog = new Blog(null, "hello", "hello", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        blogMapper.insertBlog(blog);
    }

    @Test
    public void updateBlog() {
        Blog blog = new Blog(1L, "hello", "hello world", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        blogMapper.updateBlog(blog);
    }

    @Test
    public void selectBlog() {
        Blog blog = blogMapper.selectBlogById(1L);
        System.out.println(blog);
    }
}
