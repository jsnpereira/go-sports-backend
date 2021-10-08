package com.go.sports.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfig {
    private String driverClassName;
    private String url;

    @Profile("dev")
    @Bean
    public String devDatabaseConnection(){
        System.out.println("DriverClassName: "+driverClassName);
        System.out.println("URL: "+url);
        return "DB Connection to H2 DB - Test Instance";
    }

    @Profile("QA")
    @Bean
    public String qaDatabaseConnection(){
        System.out.println("DriverClassName: "+driverClassName);
        System.out.println("URL: "+url);
        return "DB Connection to MySQL DB - Test Instance";
    }
}
