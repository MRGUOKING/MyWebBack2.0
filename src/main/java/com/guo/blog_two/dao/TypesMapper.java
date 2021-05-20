package com.guo.blog_two.dao;

import com.guo.blog_two.domain.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TypesMapper {
    List<Type> getTypeByPage(int startIndex);
    // 获取文章的分类
    List<Type> getListType();

    //获取照片的分类
    List<Type> getListPhotoType();
    int deleteTypeById(@Param("id") int id);

    int addType(@Param("type") Type type);

    int updateType(@Param("type") Type type);

 }
