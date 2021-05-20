package com.guo.blog_two.controller;

import com.guo.blog_two.Service.TypeService;
import com.guo.blog_two.dao.TypesMapper;
import com.guo.blog_two.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/type")
@RestController
@CrossOrigin
public class TypeController {
    @Autowired
    TypesMapper typesMapper;
    @Autowired
    TypeService typeService;

    @GetMapping("/listType")
    public List<Type> listType(){
        return typesMapper.getListType();
    }

    @GetMapping("/listPhotoType")
    public List<Type> listPhotoType(){
        return typesMapper.getListPhotoType();
    }

    @GetMapping("/deleteType/{id}")
    public Map deleteType(@PathVariable int id){
        Map<String,Integer> map = new HashMap<>();
        map.put("message",typesMapper.deleteTypeById(id));
        return map;
    }

    @PostMapping("/addType")
    public Map addType(@RequestBody Type type){
        Map<String,Integer> map = new HashMap<>();
        map.put("message",typeService.addType(type));
        return map;
    }

    @PostMapping("/updateType")
    public Map updateType(@RequestBody Type type){
        Map<String,Integer> map = new HashMap<>();
        map.put("message",typeService.updateType(type));
        return map;
    }

}
