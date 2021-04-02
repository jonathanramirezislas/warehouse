package com.item;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("clienteRest")
    @LoadBalanced //config for using RestTemplate
    public RestTemplate registrarRestTemplate() {
        return new RestTemplate();
    }
}

