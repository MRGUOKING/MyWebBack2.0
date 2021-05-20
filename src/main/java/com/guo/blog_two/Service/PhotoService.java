package com.guo.blog_two.Service;

import com.guo.blog_two.dao.PhotoMapper;
import com.guo.blog_two.domain.Photo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhotoService {

    //根据传递的page
    @Autowired
    PhotoMapper photoMapper;
    public List<Photo> getPhotoByPage(int page, int size){
        int startIndex = page*10;
        return photoMapper.getPhotoByPage(startIndex,size);
    }

    public Map getPhotoNumMessage(){
        Map<String,Integer> map = new HashMap();
        int allPhotoNumbers = photoMapper.getAllPhotoNumbers();
        int totalPages = allPhotoNumbers%10 == 0 ? allPhotoNumbers/10 : allPhotoNumbers/10+1;
        map.put("totalNumber",allPhotoNumbers);
        map.put("maxPageNum",totalPages);
        return map;
    }

}
