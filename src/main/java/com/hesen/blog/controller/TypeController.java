package com.hesen.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hesen.blog.constant.MyConst;
import com.hesen.blog.exception.DaoFailException;
import com.hesen.blog.po.Type;
import com.hesen.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                        Model model) {
        Page<Type> page = new Page<>(pageNo, MyConst.PAGE_SIZE);
        Page<Type> pageResult = typeService.page(page);

        model.addAttribute("page", pageResult);
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable("id") long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String addType(@Validated Type type,
                          BindingResult result,
                          RedirectAttributes attributes) {
        if (typeService.getTypeByName(type.getName()) != null) {
            // 作用相当于给name属性添加了一个叫做nameError的错误，错误信息是"类型名字重复"
            result.rejectValue("name", "nameError", "博客类型名字重复");
        }

        if (result.hasErrors()) {
            return "admin/types-input";
        }

        try {
            typeService.saveType(type);
//            attributes.addAttribute("pageNo", Integer.MAX_VALUE);
            attributes.addFlashAttribute("message", "新增成功");
        } catch (Exception e) {
            attributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String editPost(@Validated Type type,
                           BindingResult result,
                           RedirectAttributes attributes) {
        if (typeService.getTypeByName(type.getName()) != null) {
            result.rejectValue("name", "nameError", "博客类型名字重复");
        }

        if (result.hasErrors()) {
            return "admin/types-input";
        }

        try {
            typeService.updateType(type);
            attributes.addFlashAttribute("message", "更新成功");
        } catch (Exception e) {
            attributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable("id") Long id,
                         RedirectAttributes attributes) {
        try {
            typeService.deleteType(id);
            attributes.addFlashAttribute("message", "删除成功");
        } catch (Exception e) {
            attributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/types";
    }


}
