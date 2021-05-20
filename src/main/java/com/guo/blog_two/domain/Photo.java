package com.guo.blog_two.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
    private String photo_id;
    private String url;
    private String name;
    private Timestamp upload_time;
    private String picture_date;
    private String type;
    private String address;
    private int is_private;

}
