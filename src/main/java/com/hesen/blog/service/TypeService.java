package com.hesen.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hesen.blog.po.Type;
import com.hesen.blog.po.User;

import java.util.List;

public interface TypeService extends IService<Type> {
    void saveType(Type type);

    void deleteType(long id);

    void updateType(Type type);

    Type getType(long id);

    Type getTypeByName(String name);

    List<Type> listType();
}
