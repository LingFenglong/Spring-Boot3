package com.lingfenglong.web.controller;

import com.lingfenglong.web.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {
    @GetMapping("/person")
    @ResponseBody
    public Person getPerson() {
        Person person = new Person();
        person.setName("ZhangSan");
        person.setAge(18);
        person.setSex("男");
        return person;
    }

    @PostMapping("/person")
    @ResponseBody
    public Person postPerson(@RequestBody Person person) {
        System.out.println(person);
        return person;
    }

    @GetMapping("/person/list")
    public String personList(Model model) {
        model.addAttribute("list", List.of(
                new Person("zhangsan", 18, "男"),
                new Person("lisi", 16, "男"),
                new Person("wangwu", 18, "女"),
                new Person("zhaoliu", 19, "女"),
                new Person("tianqi", 17, "男"),
                new Person("zhengba", 21, "男"),
                new Person("wangjiu", 19, "男")
        ));
        return "person_list";
    }
}
