package com.lingfenglong.web.controller;

import com.lingfenglong.web.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/person")
    public Person person() {
        Person person = new Person();
        person.setName("ZhangSan");
        person.setAge(18);
        person.setSex("男");
        return person;
    }
}
