package com.softexpert.calculatorms.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springSwagger() {
        return new OpenAPI()
                .info(new Info().title("Order API")
                        .description("Order Swagger")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://example.com")));
    }
}
