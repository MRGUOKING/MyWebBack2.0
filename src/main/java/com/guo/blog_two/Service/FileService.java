package com.guo.blog_two.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {
//    private String host= "http://localhost:8083/images/";
    private String host ="http://8.129.131.7:9090/";
//    private String filePath = "D:\\imgs\\";
    private String filePath = "/home/picture/";

//    添加图片的方法
    public String addImage(@RequestBody MultipartFile image){

        System.out.println("image"+image);
        //判断文件夹是否存在,不存在则创建
        File file=new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        String originalFileName = image.getOriginalFilename();//获取原始图片的扩展名
//        获得文件存储时的新名称
        String newFileName = UUID.randomUUID()+originalFileName;
//        文件在本地的存储路径
        String newFilePath=filePath+newFileName; //新文件的路径
        try {
            image.transferTo(new File(newFilePath));//将传来的文件写入新建的文件
            return host+newFileName;
        }catch (IllegalStateException e ) {
            //处理异常
        }catch(IOException e1){
            //处理异常
        }
        return "图片上传错误";
    }
}
