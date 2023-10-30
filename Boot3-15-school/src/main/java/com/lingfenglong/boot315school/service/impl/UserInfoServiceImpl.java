package com.lingfenglong.boot315school.service.impl;

import com.lingfenglong.boot315school.entity.Field;
import com.lingfenglong.boot315school.repository.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl {
     private FieldRepository fieldRepository;

     public List<Field> findAll() {
         return fieldRepository.findAll();
     }

}
