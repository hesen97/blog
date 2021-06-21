package com.hesen.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hesen.blog.po.Blog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    int insertBlog(Blog blog);

    int deleteBlog(long id);

    int updateBlog(Blog blog);

    Blog selectBlogById(long id);
}
