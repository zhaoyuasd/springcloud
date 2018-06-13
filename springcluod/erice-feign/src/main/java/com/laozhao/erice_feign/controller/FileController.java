package com.laozhao.erice_feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.laozhao.erice_feign.service.FeginUpload;

@RestController
public class FileController {
	    @Autowired
	    private  FeginUpload feginUpload;
	    
	    @RequestMapping(value = "/test",method = RequestMethod.GET)
	    public String test()
	    {
	    	return feginUpload.test();
	    }
	    
	    @RequestMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
	    		method = RequestMethod.POST)
	    public String upload(@RequestHeader(value = "Content-Type") String type, @RequestParam(value = "filename", required = true)MultipartFile file)
	    {
	    	System.out.println(type);
	    	return feginUpload.fileUpload(file);
	    }
	    
	    
}
