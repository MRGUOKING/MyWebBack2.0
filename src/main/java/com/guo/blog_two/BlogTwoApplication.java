package com.guo.blog_two;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.guo.blog_two.dao")
public class BlogTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogTwoApplication.class, args);
    }

}
