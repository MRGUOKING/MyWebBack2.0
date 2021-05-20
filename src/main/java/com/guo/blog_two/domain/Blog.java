package com.guo.blog_two.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog {
    private int id;
    private String title;
    private String description;
    private String type_name;
    private String update_time;
    private String picture_src;
    private int pprivate;
    private int view_numbers;
    private int publish;
}
