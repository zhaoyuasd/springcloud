package com.laozhao.service_zuul;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter extends ZuulFilter{

	//private static Logger log = LoggerFactory.getLogger(MyFilter.class);
	@Override
	public String filterType() {
		return "pre";
		/*
		 *  pre：路由之前
		    routing：路由之时
		    post： 路由之后
		    error：发送错误调用
		    filterOrder：过滤的顺序
		    shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
		    run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
		 * */
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		//log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if(accessToken == null&&false) {
			//log.warn("token is empty");
			System.out.println("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			}catch (Exception e){}

			return null;
		}
		//log.info("ok");
		System.out.println("ok");
		return null;
	}
}