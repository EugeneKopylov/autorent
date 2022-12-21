package it.academy.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
@ComponentScan(basePackages = {"it.academy.service"})
public class ServiceContextConfig {

    @Bean(name = "simpleHttpClient")
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

}

