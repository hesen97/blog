package com.hesen.blog.controller;

import com.hesen.blog.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        String blog = null;
        if (blog == null) {
            throw new NotFoundException("博客未找到");
        }
        return "index";
    }
}
