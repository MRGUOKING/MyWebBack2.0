package com.guo.blog_two.Service;

import com.guo.blog_two.dao.TypesMapper;
import com.guo.blog_two.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    TypesMapper typesMapper;

    public int addType(Type type){
            List<Type> listType = type.getCode() == 0 ? typesMapper.getListType() : typesMapper.getListPhotoType();
            for (int i = 0; i < listType.size(); i++) {
                if (listType.get(i).getName().equals(type.getName()))
                    return -1;
            }
            typesMapper.addType(type);
            return 1;
    }

    public int updateType(Type type){
        List<Type> listType = type.getCode() == 0 ? typesMapper.getListType() : typesMapper.getListPhotoType();
        for (int i = 0; i < listType.size(); i++) {
            if (listType.get(i).getName().equals(type.getName()))
                return -1;
        }
        typesMapper.updateType(type);
        return 1;
    }



}
