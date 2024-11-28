package com.example.payment.config;

import com.siot.IamportRestClient.Iamport;
import com.siot.IamportRestClient.IamportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IamportConfig {
    @Value("${import.api.key}")
    private String apiKey;

    @Value("${import.api.secret}")
    private String apiSecret;

    // Iamport 빈을 등록
    @Bean
    public IamportClient iamport() {
        return new IamportClient(apiKey, apiSecret);
    }
}