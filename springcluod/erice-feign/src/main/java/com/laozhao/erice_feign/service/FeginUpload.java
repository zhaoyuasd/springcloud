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
import com.laozhao.erice_feign.service.imp.FeginUploadImp;
@FeignClient(value = "service-hi",fallback = FeginUploadImp.class,
configuration = FeignMultipartSupportConfig.class)
public interface FeginUpload {
	@RequestMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
    		method = RequestMethod.POST)
    String  fileUpload(@RequestPart MultipartFile file);
    @RequestMapping(value = "/test")
    String test();
}
