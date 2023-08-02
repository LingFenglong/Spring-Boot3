package com.lingfenglong.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private Date birthday;
}
