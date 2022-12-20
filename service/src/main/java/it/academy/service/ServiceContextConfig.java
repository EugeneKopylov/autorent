package it.academy.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.net.http.HttpClient;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
@ComponentScan(basePackages = {"it.academy.service"})
public class ServiceContextConfig {

    @Bean(name = "simpleHttpClient")
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

}

