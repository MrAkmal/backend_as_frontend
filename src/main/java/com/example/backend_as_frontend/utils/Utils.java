package com.example.backend_as_frontend.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Utils {



    @Bean
    public WebClient getWebClient() {
        return WebClient.builder().build();
    }
}
