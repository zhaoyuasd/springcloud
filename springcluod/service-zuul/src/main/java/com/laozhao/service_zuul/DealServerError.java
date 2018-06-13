package com.laozhao.service_zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * MyFilter
 *
 * @author zhangzhidong
 * @since 2018/5/14
 */
public class DealServerError extends ZuulFilter {

	 public Object run() {
	    	RequestContext ctx = RequestContext.getCurrentContext();
	        ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
			   ctx.getResponse().getWriter().write(" sorry ,server is error  asdasdas");
			}catch (Exception e){}
	        return null;
	    }

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "error";
	}

}
