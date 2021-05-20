package com.guo.blog_two;

import com.guo.blog_two.dao.BlogMapper;
import com.guo.blog_two.domain.Blog;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BlogTwoApplicationTests {
    @Autowired
    BlogMapper blogMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testMysql(){
        List<Blog> listBlog = blogMapper.getBlogByPage(1);
        System.out.println(listBlog);
    }
    @Test
    void updateBlog(){
        Blog blog = new Blog();
        blog.setTitle("测试三");
        blog.setDescription("描述三");
        blog.setPicture_src("图片路径三");
//        blog.setUpdate_time(new Timestamp(new Date().getTime()));
        blog.setPprivate(0);
        int i = blogMapper.updateBlog(blog,1);
        System.out.println(i);
    }
    @Test
    void deleteBlog(){
        System.out.println(blogMapper.deleteBlog(1));
    }

    @Test
    void testTime(){
        System.out.println(new Date());
    }

}
