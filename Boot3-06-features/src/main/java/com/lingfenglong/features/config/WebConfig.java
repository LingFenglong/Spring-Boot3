package com.lingfenglong.features.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Profile("dev")
    @Bean("dev")
    public String dev() {
        return "dev";
    }

    @Profile("test")
    @Bean("test")
    public String test() {
        return "test";
    }

    @Profile("prod")
    @Bean("prod")
    public String prod () {
        return "prod";
    }

    @Profile("devTools")
    @Bean("devTools")
    public String devTools () {
        return "devTools";
    }
    @Profile("testTools")
    @Bean("testTools")
    public String testTools () {
        return "testTools";
    }

}
