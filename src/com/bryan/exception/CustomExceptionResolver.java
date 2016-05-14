package com.bryan.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 全局异常处理器
 * @author bryan
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		CustomException customException=null;
		if(ex instanceof CustomException){
			customException=(CustomException)ex;
		}else {
			customException=new CustomException("未知错误");
		}
		String message=customException.getMessage();
		ModelAndView modelAndView=new ModelAndView("error");
		modelAndView.addObject("message", message);
		
		String ret="{\"status\":-1,\"message\":\""+message+"\"}";
		response.setCharacterEncoding("utf-8");
	    response.setContentType("application/json;charset=utf-8");
	    try {
			response.getWriter().write(ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		//return modelAndView;
	}

	

}
