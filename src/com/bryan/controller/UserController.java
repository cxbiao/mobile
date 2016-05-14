package com.bryan.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bryan.domain.UserCustom;
import com.bryan.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
   //只有在返回值类型是ModelAndView时可以返回null,
	@RequestMapping("/queryUsers")
	public ModelAndView queryItems() throws Exception{

		List<UserCustom> listUsers=userService.findUserList(null);
		
		ModelAndView modelAndView=new ModelAndView("user");
		modelAndView.addObject("listUsers", listUsers);
		return modelAndView;
	}

	@RequestMapping("/editUsers")
	public String editItems(UserCustom userCustom) throws Exception{
		
		System.out.println(userCustom);
		userService.updateUser(userCustom);
		return "success";
	}

}
