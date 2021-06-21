package com.hesen.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hesen.blog.po.Blog;

public interface BlogService extends IService<Blog> {

    void saveBlog(Blog blog);

    void deleteBlog(long id);

    void updateBlog(Blog blog);

    Blog getBlog(long id);
}
