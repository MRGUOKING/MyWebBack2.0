package com.guo.blog_two.dao;

import com.guo.blog_two.domain.Photo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PhotoMapper {
    int addPhoto(@Param("photo") Photo photo);
    List<Photo> getPhotoByPage(@Param("startIndex") int startIndex,@Param("size") int size);

    int getAllPhotoNumbers();
    int deleteAPhoto(@Param("photo_id") int photo_id);
    int updatePhoto(@Param("photo") Photo photo);
    List<Map> getPhotoNum();

    //根据分类名查询photo
    List<Photo> getPhotoByType(@Param("type") String type);
}
