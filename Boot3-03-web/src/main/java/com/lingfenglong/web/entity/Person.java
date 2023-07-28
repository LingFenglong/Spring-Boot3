package com.lingfenglong.web.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
//@JacksonXmlRootElement // 可以写出为xml文档，只引入包，不写也可以
public class Person {
    private String name;
    private Integer age;
    private String sex;
}
