package com.lingfenglong.boot315school.service.impl;

import com.lingfenglong.boot315school.entity.Field;
import com.lingfenglong.boot315school.repository.FieldRepository;
import com.lingfenglong.boot315school.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldServiceImpl implements FieldService {
    private FieldRepository fieldRepository;

    @Autowired
    public FieldServiceImpl(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public List<Field> findAll() {
        return fieldRepository.findAll();
    }
}
