package com.hesen.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hesen.blog.dao.BlogMapper;
import com.hesen.blog.exception.DaoFailException;
import com.hesen.blog.po.Blog;
import com.hesen.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Transactional
    @Override
    public void saveBlog(Blog blog) {
        try {
            int affectRows = blogMapper.insertBlog(blog);
            if (affectRows != 1) {
                throw new DaoFailException("保存博客异常");
            }
        } catch (DaoFailException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoFailException("保存博客失败", e);
        }
    }

    @Transactional
    @Override
    public void deleteBlog(long id) {
        try {
            int affectRows = blogMapper.deleteBlog(id);
            if (affectRows != 1) {
                throw new DaoFailException("删除博客异常");
            }
        } catch (DaoFailException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoFailException("删除博客失败", e);
        }
    }

    @Transactional
    @Override
    public void updateBlog(Blog blog) {
        try {
            int affectRows = blogMapper.updateBlog(blog);
            if (affectRows != 1) {
                throw new DaoFailException("更新博客异常");
            }
        } catch (DaoFailException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoFailException("更新博客失败", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Blog getBlog(long id) {
        try {
            Blog blog = blogMapper.selectBlogById(id);
            return blog;
        } catch(Exception e) {
            throw new DaoFailException("查询博客失败", e);
        }
    }
}
