package com.laozhao.erice_feign;

import static java.lang.String.format;

import java.lang.reflect.Type;

import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

	@Configuration
	public class FeignMultipartSupportConfig {

	    @Bean
	    @Primary
	    @Scope("prototype")
	    public Encoder multipartFormEncoder() {
	        return new SpringFormEncoder();
	    }

	    @Bean
	    public feign.Logger.Level multipartLoggerLevel() {
	        return feign.Logger.Level.FULL;
	    }
	}