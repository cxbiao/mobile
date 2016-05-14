package com.bryan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author bryan
 * 1)两个拦截器都放行
 * MyInterceptor1...preHandle
  MyInterceptor2...preHandle
  MyInterceptor2...postHandle
  MyInterceptor1...postHandle
  MyInterceptor2...afterCompletion
  MyInterceptor1...afterCompletion
 *preHandle方法按顺序执行
 *postHandle与afterCompletion逆序执行
 *
 *
 *2)MyInterceptor1放行，MyInterceptor2不放行
 *MyInterceptor1...preHandle
  MyInterceptor2...preHandle
  MyInterceptor1...afterCompletion
  
   只要有一个拦截器不放行，就不会执行postHandle方法
   
 *3)MyInterceptor1不放行，MyInterceptor2不放行
 *  MyInterceptor1...preHandle
 */

public class MyInterceptor1 implements HandlerInterceptor{

	
	//进入Handler方法之前
	//用于身份认证等
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//实现跨域
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Headers"," Origin, X-Requested-With, Content-Type, Accept");
		//return false表示拦截，不向下执行
		//return true表示告放行
		System.out.println("MyInterceptor1...preHandle");	
		return true;
	}

	//执行Handler方法之后，返回ModelAndView之前执行
	//应用场景从modelAndView出发:将公用的模型数据在这里传到视图
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("MyInterceptor1...postHandle");	
		
	}

	//执行Handler完成后执行此方法
    //应用场景：统一异常处理，统一日志处理	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor1...afterCompletion");	
		
	}

}
