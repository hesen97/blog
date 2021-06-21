package com.hesen.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hesen.blog.dao.TypeMapper;
import com.hesen.blog.exception.DaoFailException;
import com.hesen.blog.po.Type;
import com.hesen.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Transactional
    @Override
    public void saveType(Type type) {
        try {
            int affectRows = typeMapper.insertType(type);
            if (affectRows != 1) {
                throw new DaoFailException("保存博客类型异常");
            }
        }  catch (DaoFailException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoFailException("保存博客失败", e);
        }
    }

    @Transactional
    @Override
    public void deleteType(long id) {
        try {
            int affectRows = typeMapper.deleteType(id);
            if (affectRows != 1) {
                throw new DaoFailException("删除博客类型异常");
            }
        } catch (DaoFailException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoFailException("删除博客类型失败", e);
        }
    }

    @Transactional
    @Override
    public void updateType(Type type) {
        try {
            int affectRows = typeMapper.updateType(type);
            if (affectRows != 1) {
                throw new DaoFailException("更新博客类型异常");
            }
        }  catch (DaoFailException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoFailException("更新博客失败", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Type getType(long id) {
        try {
            Type type = typeMapper.selectTypeById(id);
            return type;
        } catch (Exception e) {
            throw new DaoFailException("查询博客异常", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Type getTypeByName(String name) {
        try {
            Type type = typeMapper.selectTypeByName(name);
            return type;
        } catch (Exception e) {
            throw new DaoFailException("查询播客异常", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Type> listType() {
        return typeMapper.selectAllTypes();
    }

}
