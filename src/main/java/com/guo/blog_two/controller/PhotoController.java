package com.guo.blog_two.controller;

import com.guo.blog_two.Service.PhotoService;
import com.guo.blog_two.dao.PhotoMapper;
import com.guo.blog_two.domain.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/photo")
@RestController
public class PhotoController {
    @Autowired
    PhotoMapper photoMapper;
    @Autowired
    PhotoService photoService;


    @PostMapping("/addPhoto")
    public Map<String,Integer> addPhoto(@RequestBody Photo[] photos){
        System.out.println("进入了addPhoto方法"+photos);
        int count = 0;
        for (int i = 0; i < photos.length; i++) {
            int message = photoMapper.addPhoto(photos[i]);
            count += message;
        }
//        int message = photoMapper.addPhoto(photo);
        Map<String,Integer> map  = new HashMap<>();
        map.put("message",count);
        return map;
    }

    @GetMapping("/photoBypage/{pageNum}")
    public List<Photo> getPhotoByPage(@PathVariable int pageNum,@RequestParam(defaultValue = "10",required = false) int size){
        return photoService.getPhotoByPage(pageNum,size);
    }

    @GetMapping("/photoNumMessage")
    public Map getBlogNumMessage(){
        return photoService.getPhotoNumMessage();
    }
    @GetMapping("/deleteAPhoto/{photo_id}")
    public Map deleteAPhoto(@PathVariable int photo_id){
        Map<String,Integer> map = new HashMap<>();
        map.put("message",photoMapper.deleteAPhoto(photo_id));
        return map;
    }

    @PostMapping("/updatePhoto")
    public Map<String,Integer> updatePhoto(@RequestBody Photo photo){
        int message = photoMapper.updatePhoto(photo);
        Map<String,Integer> map =new HashMap<>();
        map.put("message",message);
        return map;
    }

    @GetMapping("/getPhotoNum")
    public List<Map> getPhotoNum(){
        return photoMapper.getPhotoNum();
    }

    @GetMapping("/getPhotoByType/{type}")
    public List<Photo> getPhotoByNum(@PathVariable String type){
        return photoMapper.getPhotoByType(type);
    }
}


