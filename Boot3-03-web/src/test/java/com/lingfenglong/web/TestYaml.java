package com.lingfenglong.web;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.lingfenglong.web.entity.Person;
import org.junit.jupiter.api.Test;

public class TestYaml {
    @Test
    public void testYaml() throws JsonProcessingException {
        Person person = new Person();
        person.setName("ZhangSan");
        person.setAge(18);
        person.setSex("男");

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));

        System.out.println(mapper.writeValueAsString(person));
    }
}
