package com.guo.blog_two.controller;

import com.guo.blog_two.Service.BlogService;
import com.guo.blog_two.dao.BlogMapper;
import com.guo.blog_two.domain.Blog;
import com.guo.blog_two.domain.Type;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    BlogMapper blogMapper;

//    添加一篇文章
    @PostMapping("/addBlog")
    public Map addBlog(@RequestBody Blog blog){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = simpleDateFormat.format(timestamp);
        blog.setUpdate_time(datetime);
        Map map = new HashMap<String,Integer>();
        int i = blogService.addBlog(blog);
        map.put("msg",i);
        return map;
    }

//    按页获取文章
    @GetMapping("/listBlogAll")
    public Map listBlogAll(@RequestParam(value = "page",defaultValue = "0") int page){
        int startIndex = page*10;
        Map map = new HashMap<String,List<Blog>>();
        List<Blog> blogAll = blogService.getBlogByPage(startIndex);
        map.put("blogs",blogAll);
        System.out.println(blogAll);
        return map;
    }

//    @GetMapping("/listBlog")
//    public List<Blog> listBlog(){
//        return blogService.getListBlog();
//    }

    @GetMapping("/blogByPage/{pageNum}")
    public List<Blog> getBlogByPage(@PathVariable int pageNum){
        Parser parser = Parser.builder().build();
//        Node document = parser.parse(md);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
//        String html= renderer.render(document);
        List<Blog> blogs = blogService.getBlogByPage(pageNum);;
        for (Blog blog : blogs) {
            Node document = parser.parse(blog.getDescription());
            blog.setDescription(renderer.render(document));
        }
        return blogs;
    }

    @GetMapping("/blogPageMessage")
    public Map getBlogNumMessage(){
        return blogService.getBlogNumMessage();
    }

    @GetMapping("/deleteABlog/{id}")
    public Map deleteABlog(@PathVariable int id){
        Map<String,Integer> map = new HashMap();
        map.put("message",blogMapper.deleteBlog(id));
        return map;
    }

    @PostMapping("updateBlog/{blog_id}")
    public Map updateBlog(@RequestBody Blog blog,@PathVariable int blog_id){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = simpleDateFormat.format(timestamp);
        blog.setUpdate_time(datetime);
        Map<String,Integer> map = new HashMap<>();
        map.put("message",blogMapper.updateBlog(blog,blog_id));
        return map;
    }

    @GetMapping("/blogTypeNum")
    public List<Map> blogTypeNum(){
        return blogMapper.getBlogTypeNum();
    }

    @GetMapping("/getBlogByType/{typeName}")
    public List<Blog> getBlogByType(@PathVariable String typeName){
        Parser parser = Parser.builder().build();
//        Node document = parser.parse(md);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
//        String html= renderer.render(document);
        List<Blog> blogs = blogMapper.getBlogByTypeName(typeName);
        for (Blog blog : blogs) {
            Node document = parser.parse(blog.getDescription());
            blog.setDescription(renderer.render(document));
        }
        return blogs;
    }

    @GetMapping("/getAllYears")
    public List<Map> getAllYears(){
        return blogMapper.getAllYears();
    }

    @GetMapping("/getBlogsByYear/{year}")
    public List<Blog> getBlogsByYear(@PathVariable int year){
        String year_select = year+"%";
        List<Blog> blogs = blogMapper.getBlogsByYears(year_select);
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        for (Blog blog : blogs) {
            Node document = parser.parse(blog.getDescription());
            blog.setDescription(renderer.render(document));
        }
        return blogs;
    }

    @GetMapping("/getRecommend")
    public List<Blog> getRecommend(){
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        List<Blog> blogs  = blogMapper.getNewBlog();
        for (Blog blog : blogs) {
            Node document = parser.parse(blog.getDescription());
            blog.setDescription(renderer.render(document));
        }
        return blogs;
    }
}
