package com.bryan.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryan.domain.Person;

@RestController
public class JsonController {
	
	@RequestMapping("/requestJson")
	public Person requestJson(@RequestBody Person p){
		return p;
	}
	
	@RequestMapping("/requestJson2")
	public void requestJson2(@RequestBody String param,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
	    response.setContentType("application/json;charset=utf-8");
	    response.getWriter().write(param);
	}
	
	@RequestMapping("/responseJson")
	public Person responseJson(Person p,HttpServletResponse response){
		return p;
	}

}
