package com.guo.blog_two.dao;

import com.guo.blog_two.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface BlogMapper {
//    获得所有公开文章
    List<Blog> getListBlog();
//    根据缩影获得10篇文章
    List<Blog> getBlogByPage(int startIndex);
//    增加一篇文章
    int addBlog(@Param("blog") Blog blog);
//    修改文章
    int updateBlog(@Param("blog") Blog blog,@Param("id") int id);
//    删除文章
    int deleteBlog(int id);
//获得最新的四篇文章
    List<Blog> getNewBlog();
    int getAllBlogNumbers();
    List<Map> getBlogTypeNum();
    List<Blog> getBlogByTypeName(@Param("typeName") String typeName);
    //获得所有文章的发布的所有年份
    List<Map> getAllYears();
    List<Blog> getBlogsByYears(@Param("year") String year);

}
