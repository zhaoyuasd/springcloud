package com.laozhao.loginServer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
   
	 @PostMapping("login")
	 public void login(HttpServletRequest req, HttpServletResponse resp)
	 {
		 
	 }
	 
	 @PostMapping("auth")
	 public void auth(HttpServletRequest req, HttpServletResponse resp)
	 {
		 
	 }
	 
	 @PostMapping("logout")
	 public void logout(HttpServletRequest req, HttpServletResponse resp)
	 {
		 
	 }
}
