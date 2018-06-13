package com.laozhao.service_ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
   
    @HystrixCommand(fallbackMethod = "hiError") //熔断器配置
    public String hiService(String name) {
    	//restTemplate.exchange(requestEntity, responseType)
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
   
    
    //熔断器对应的处理方法
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
