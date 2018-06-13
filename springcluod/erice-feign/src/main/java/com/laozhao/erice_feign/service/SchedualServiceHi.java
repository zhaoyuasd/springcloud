package com.laozhao.erice_feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.laozhao.erice_feign.FeignMultipartSupportConfig;
import com.laozhao.erice_feign.service.imp.SchedualServiceHiHystric;

@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class,configuration = FeignMultipartSupportConfig.class)
//fallback 熔断器设置
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
   

}
