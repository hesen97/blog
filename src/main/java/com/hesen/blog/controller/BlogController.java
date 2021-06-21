package com.hesen.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hesen.blog.constant.MyConst;
import com.hesen.blog.po.Blog;
import com.hesen.blog.po.Type;
import com.hesen.blog.service.BlogService;
import com.hesen.blog.service.TypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public Map blog(@RequestParam(value = "page", defaultValue = "1") int pageNo, Blog blog) {
        Page<Blog> page = new Page<>(pageNo, MyConst.PAGE_SIZE_BLOG);

        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(blog.getTitle())) {
            wrapper.eq("title", blog.getTitle());
        }
        if (blog.getTypeId() != null) {
            wrapper.eq("type_id", blog.getTypeId());
        }
        if (blog.getRecommend() != null) {
            wrapper.eq("recommend", blog.getRecommend());
        }

        Page<Blog> pageResult = blogService.page(page, wrapper);

        List<Type> types = typeService.listType();

        Map<Object, Object> retMap = new HashMap<>();
        retMap.put("pageResult", pageResult);
        retMap.put("types", types);

        return retMap;
    }

}
