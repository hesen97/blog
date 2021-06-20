package com.hesen.blog.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hesen.blog.po.Type;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TypeMapper extends BaseMapper<Type> {
    int insertType(Type type);

    int deleteType(long id);

    int updateType(Type type);

    Type selectTypeById(long id);

    Type selectTypeByName(String name);
}
