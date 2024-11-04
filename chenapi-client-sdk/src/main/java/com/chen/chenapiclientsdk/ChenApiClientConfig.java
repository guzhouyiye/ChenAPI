package com.chen.chenapiclientsdk;

import com.chen.chenapiclientsdk.client.ChenApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("chenapi.client")
@Data
@ComponentScan
public class ChenApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public ChenApiClient chenApiClient() {
        return new ChenApiClient(accessKey, secretKey);
    }
}
