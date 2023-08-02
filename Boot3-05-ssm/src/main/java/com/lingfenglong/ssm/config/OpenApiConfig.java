package com.lingfenglong.ssm.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public GroupedOpenApi userGroup() {
        return GroupedOpenApi.builder()
                .group("用户管理")
                .pathsToMatch("/bean/**")
                .build();
    }

    @Bean
    public GroupedOpenApi robotGroup() {
        return GroupedOpenApi.builder()
                .group("机器人")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("这是info的title")
                        .description("description")
                        .version("version")
                        .license(new License().name("licence").url("www.licence.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("externalDocumentation")
                        .url("www.externalDocumentation.org"));
    }
}
