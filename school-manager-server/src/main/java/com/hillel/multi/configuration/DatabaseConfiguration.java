package com.hillel.multi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfiguration {

    @ConfigurationProperties(prefix = "spring.datasource")
    public record ImmutableCredentials(String url, String username, String password, String driverClassName) {
    }
}