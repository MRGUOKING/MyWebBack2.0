package com.guo.blog_two.controller;


import com.guo.blog_two.Service.FileService;
import org.apache.tomcat.util.http.fileupload.util.mime.MimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/img")
public class ImgController {

    @Autowired
    FileService fileService;

    @PostMapping("/addPirstPicture")
    public String addPirstPicture(@RequestParam("image") MultipartFile image){
        return fileService.addImage(image);
    }
    @PostMapping("/addImg")
    public List addImg(@RequestParam("files") MultipartFile[] files){
        List<String> list= new ArrayList<>();
        if (files != null && files.length>0){
            for (MultipartFile file : files) {
                String filePath = fileService.addImage(file);
                list.add(filePath);
            }
        }
        return list;
//        return fileService.addImage(image);
    }
}
