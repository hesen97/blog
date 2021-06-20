package com.hesen.blog.dao;

import com.hesen.blog.dao.TypeMapper;
import com.hesen.blog.po.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TypeMapperTest {

    @Autowired
    private TypeMapper typeMapper;

//    int insertType(Type type);
//
//    int deleteType(long id);
//
//    int updateType(Type type);
//
//    Type selectTypeById(long id);

    @Test
    public void selectTypeById() {
        Type type = typeMapper.selectTypeById(3L);
        assertEquals("update书籍", type.getName());
    }

    @Test
    public void updateType() {
        Type type = new Type(3L, "update书籍", null);
        int i = typeMapper.updateType(type);
        assertEquals(1, i);
    }

    @Test
    public void deleteType() {
        int affectRows = typeMapper.deleteType(2);
        assertEquals(1, affectRows);
    }

    @Test
    public void insertType() {
        Type type = new Type(null, "书籍", null);
        typeMapper.insertType(type);
    }
}
