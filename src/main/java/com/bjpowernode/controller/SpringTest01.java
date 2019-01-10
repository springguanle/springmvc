package com.bjpowernode.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjpowernode.bean.User;

@Controller
@RequestMapping("/test")
public class SpringTest01 {
	
	@RequestMapping("test.do")
	public ModelAndView test(String username,int age) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("username",username);
		mv.addObject("age",age);
		mv.setViewName("first");
		return mv;
	}
	@RequestMapping("test1.do")
	public ModelAndView test1() {
		ModelAndView mv=new ModelAndView();
		User user=new User();
		user.setName("tom");
		user.setAge(14);
		mv.addObject("user",user);
		mv.setViewName("user");
		return mv;
	} 
	//返回Map json格式的字符串
	@RequestMapping("/test2.do")
	@ResponseBody
	public Object test3() {
		HashMap<String,String> map=new HashMap<>();
		map.put("name", "张三");
		map.put("age","15");
		return map;
	}
	
	@RequestMapping("/test3.do")
	@ResponseBody
	public Object test4() {
		List list=new ArrayList<>();
		list.add("张三1");
		list.add("张三2");
		list.add("张三3");
		list.add("张三4");
		return list;
	}
	@RequestMapping("test04.do")
	public String test5(Model m) {
		m.addAttribute("name","jack");
		m.addAttribute("age","18");
		return "first2";
	}
	
	
	
}
