package com.lingfenglong.boot315school.controller;

import com.lingfenglong.boot315school.entity.Field;
import com.lingfenglong.boot315school.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FieldController {
    private FieldService fieldService;

    @Autowired
    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping("/findAll")
    public List<Field> findAll() {
        return fieldService.findAll();
    }
}
