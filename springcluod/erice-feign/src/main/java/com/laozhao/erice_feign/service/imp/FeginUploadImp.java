package com.laozhao.erice_feign.service.imp;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.laozhao.erice_feign.service.FeginUpload;
@Component
public class FeginUploadImp implements FeginUpload {

	 @Override
		public String fileUpload(MultipartFile file) {
			// TODO Auto-generated method stub
			return "服务器不可用";
		}
		@Override
		public String test() {
			// TODO Auto-generated method stub
			return "服务器不可用";
		}

}
