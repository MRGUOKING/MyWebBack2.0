package com.guo.blog_two.Service;

import com.guo.blog_two.dao.BlogMapper;
import com.guo.blog_two.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogService {
    @Autowired
    BlogMapper blogMapper;

//    获得所有的blog
    public List<Blog> getBlogByPage(int page){
        int startIndex = page*10;
        return blogMapper.getBlogByPage(startIndex);
    }
//
    public int addBlog(Blog blog){
        return blogMapper.addBlog(blog);
    }

    public Map getBlogNumMessage(){
        Map<String,Integer> map = new HashMap();
        int allBlogNumbers = blogMapper.getAllBlogNumbers();
        int totalPages = allBlogNumbers%10 == 0 ? allBlogNumbers/10 : allBlogNumbers/10+1;
        map.put("totalNumber",allBlogNumbers);
        map.put("maxPageNum",totalPages);
        return map;
    }
}
