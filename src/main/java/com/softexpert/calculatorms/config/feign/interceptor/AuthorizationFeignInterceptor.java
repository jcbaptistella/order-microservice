package com.softexpert.calculatorms.config.feign.interceptor;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class AuthorizationFeignInterceptor {

    @Value("${gerencianet.clientId}")
    private String clientId;

    @Value("${gerencianet.clientSecret}")
    private String clientSecret;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return  new BasicAuthRequestInterceptor(clientId , clientSecret);
    }
}
