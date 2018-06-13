package com.laozhao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginController", urlPatterns = {"/login"}, loadOnStartup = 1)   
public class LoginController extends HttpServlet {  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
        System.out.println("asdasdasdasd");
    }
	
	@Override
	public  void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
        System.out.println("asdasdasdasd");
    	request.setAttribute("msg", "HelloWorld!");  
        request.getRequestDispatcher("response.jsp").forward(request, response);  
    }  
}  
