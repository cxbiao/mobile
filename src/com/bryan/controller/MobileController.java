package com.bryan.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.bryan.domain.User;
import com.bryan.domain.UserCustom;
import com.bryan.service.UserService;

@RestController
@RequestMapping("/rest")
public class MobileController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/findUserForGet", method = RequestMethod.GET)
	public User findUserForGet(User user) {
		System.out.println(user);
		return user;
	}

	@RequestMapping(value = "/findUserForPost", method = RequestMethod.POST)
	public User findUserForPost(User user) {
		System.out.println(user);
		return user;
	}

	@RequestMapping(value = "/findUserList", method = RequestMethod.POST)
	public List<UserCustom> findUserList() throws Exception {
		List<UserCustom> listUsers = userService.findUserList(null);
		return listUsers;
	}

	@RequestMapping(value = "/postBodyJson", method = RequestMethod.POST)
	public User postBodyJson(@RequestBody User user) {
		System.out.println(user);
		return user;
	}

	@RequestMapping(value = "/postBodyString", method = RequestMethod.POST)
	public User postBodyString(@RequestBody String str) {
		System.out.println(str);
		User user = new User();
		user.setId(10);
		user.setUsername("我是postString");
		user.setSex("1");
		user.setAddress("重庆市");
		user.setBirthday(new Date());
		return user;

	}

	// 多文件上传
	@RequestMapping("/upload")
	public void upload(User u, HttpServletRequest request,HttpServletResponse response) throws Exception {

		System.out.println(u);
		StringBuilder sb=new StringBuilder();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转化request
			MultipartHttpServletRequest ms = (MultipartHttpServletRequest) request;
			MultiValueMap<String, MultipartFile> filesMap = ms
					.getMultiFileMap();
			for (Entry<String, List<MultipartFile>> entry : filesMap.entrySet()) {
				System.out.println("key:" + entry.getKey());
				for (MultipartFile file : entry.getValue()) {
					SimpleDateFormat sf = new SimpleDateFormat(
							"yyyyMMddHHmmssSSS");
					String fname = sf.format(new Date());
					Random random = new Random();
					fname = fname + random.nextInt(9) + random.nextInt(9)
							+ random.nextInt(9);
					// 获得原始文件名
					String origFileName = file.getOriginalFilename();
					System.out.println(origFileName);
					// 获得扩展名
					fname += origFileName.substring(origFileName
							.lastIndexOf("."));
					String realPath = request.getSession().getServletContext()
							.getRealPath("/upload/" + fname);
					file.transferTo(new File(realPath));
					sb.append(realPath).append(",");
					
				}
			}

		}
		String url="";
		if(sb.length()>0){
			url=sb.substring(0, sb.length()-1);
			url=url.replace("\\", "/");
		}
		String ret="{\"status\":0,\"message\":\"上传成功\",\"url\":\""+url+"\"}";
		response.setCharacterEncoding("utf-8");
	    response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(ret);
	}
}
