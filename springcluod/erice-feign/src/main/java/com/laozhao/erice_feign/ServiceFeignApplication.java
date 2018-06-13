package com.laozhao.erice_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.netflix.governator.annotations.Configuration;
import com.netflix.governator.annotations.binding.Primary;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard //熔断器的仪表盘
public class ServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }
    
    @Bean  
    @Primary  
    @Scope("prototype")
    public Encoder multipartFormEncoder() {  
        return new SpringFormEncoder();  
    }  
}
