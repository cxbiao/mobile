package com.bryan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor2 implements HandlerInterceptor{

	
	//进入Handler方法之前
	//用于身份认证等
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//return false表示拦截，不向下执行
		//return true表示告放行
		System.out.println("MyInterceptor2...preHandle");
		return true;
	}

	//执行Handler方法之后，返回ModelAndView之前执行
	//应用场景从modelAndView出发:将公用的模型数据在这里传到视图
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor2...postHandle");
	}

	//执行Handler完成后执行此方法
    //应用场景：统一异常处理，统一日志处理	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor2...afterCompletion");		
	}

}
