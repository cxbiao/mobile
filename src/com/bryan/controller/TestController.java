package com.bryan.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.bryan.domain.Person;
import com.bryan.domain.User;
import com.bryan.exception.CustomException;

@Controller
@RequestMapping("/test")
public class TestController {

	/**
	 * 
	 * 在参数列表上直接定义要接收的参数名称，只要参数名称能匹配的上就能接收所传过来的数据,
	 * 可以自动转换成参数列表里面的类型，注意的是值与类型之间是可以转换的
	 */
	@RequestMapping("/toPerson1")
	public String toPerson1(Person p, User u) {
		// p和u对应参数都会有值
		System.out.println(p);
		System.out.println(u);
		return "success";
	}

	@RequestMapping(value = "/toPerson2", method = RequestMethod.POST)
	public String toPerson2(@RequestParam(value = "pname") String name,
			Date birthday) {
		System.out.println(birthday);
		System.out.println(name);
		return "success";
	}

	/**
	 * 
	 * 方法的返回值采用ModelAndView， new ModelAndView("index", map);
	 * ，相当于把结果数据放到request里面
	 */
	@RequestMapping("/toPerson3")
	public ModelAndView toPerson3() throws Exception {

		Person p = new Person();
		p.setId(1);
		p.setName("jim");
		p.setAddress("北京");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		p.setBirthday(sf.parse("1990-03-17 12:24:00"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p", p);
		return new ModelAndView("success", map);
	}

	/**
	 * 
	 * 直接在方法的参数列表中来定义Map，这个Map即是ModelAndView里面的Map，
	 * 由视图解析器统一处理，统一走ModelAndView的接口 也不建议使用
	 */
	@RequestMapping("/toPerson4")
	public String toPerson4(Map<String, Object> map) throws Exception {

		Person p = new Person();
		p.setId(1);
		p.setName("jim");
		p.setAddress("北京");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		p.setBirthday(sf.parse("1990-03-17 12:24:00"));
		map.put("p", p);
		return "success";
	}

	/**
	 * 
	 * desc：在参数列表中直接定义Model，model.addAttribute("p",
	 * person);把参数值放到request类里面去，建议使用
	 */
	@RequestMapping("/toPerson5")
	public String toPerson5(Model model) throws Exception {

		Person p = new Person();
		p.setId(1);
		p.setName("jim");
		p.setAddress("北京");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		p.setBirthday(sf.parse("1990-03-17 12:24:00"));
		model.addAttribute("p", p);
		return "success";
	}

	// 同一个controller中重定向，不需要命名空间和/
	@RequestMapping("/redirect1")
	public String redirect1() {
		return "redirect:toPerson1";
	}

	// 转发
	@RequestMapping("/forward")
	public String forward() {
		return "forward:toPerson1";
	}

	// 不同controller之间重定向
	@RequestMapping("/redirect2")
	public String redirect2() {
		return "redirect:/test2/toForm";
	}

	@RequestMapping("/getData")
	public void getData(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/**
		 * 获得body体的原始内容
		 */
		// ServletInputStream sis=request.getInputStream();
		// byte[] bytes=new byte[1024];
		// int len=0;
		// StringBuilder sb=new StringBuilder();
		// while((len=sis.read(bytes))!=-1){
		// String temp=new String(bytes,0,len);
		// sb.append(temp);
		// }
		// System.out.println(sb.toString());

		int i = 0;
		if (i == 0)
			throw new CustomException("自定义异常");

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String result = "{\"name\":\"" + name + "\",\"age\":" + age + "}";
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(result);

	}

	// 数组的参数绑定
	// list和map的参数绑定需要使用包装pojo类型
	@RequestMapping("/getArray")
	public String getArray(Integer[] item_id) {

		return "success";
	}

	// 返回json 使用jakeson
	@RequestMapping("/rest/view/{id}")
	@ResponseBody
	public Person getView(@PathVariable Integer id) {
		Person person = new Person();
		person.setId(id);
		person.setName("tom");
		person.setAddress("河北");
		return person;
	}

	// 多文件上传
	@RequestMapping("/upload")
	public String upload(Person p, HttpServletRequest request) throws Exception {

		System.out.println(p);
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转化request
			MultipartHttpServletRequest ms = (MultipartHttpServletRequest) request;
			MultiValueMap<String, MultipartFile> filesMap = ms
					.getMultiFileMap();
			for (Entry<String, List<MultipartFile>> entry : filesMap.entrySet()) {
				System.out.println("key:"+entry.getKey());
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
				}
			}

		}

		return "success";
	}


}
