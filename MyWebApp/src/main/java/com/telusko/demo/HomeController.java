package com.telusko.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
//	@RequestMapping("/home")	
//	public String home(HttpServletRequest req) {
//		
//		HttpSession session = req.getSession();
//		String name = req.getParameter("name");
//		System.out.println("hi "+name);
//		session.setAttribute("name",name);
//		return "home";
//	}
	
	
	@RequestMapping("/home1")	
	public ModelAndView home1(@RequestParam("name") String myName) {

		ModelAndView mv = new ModelAndView();
		
		System.out.println("hi "+myName);
		mv.addObject("name",myName);
		mv.setViewName("home");
	
		
		return mv;
	}
	
	@RequestMapping("/home")	
	public ModelAndView home(Alien alien, String myName) {

		ModelAndView mv = new ModelAndView();
		alien.setAid(1);
		System.out.println("hi "+alien.getAname());
		System.out.println("hi "+alien.getLang());
		mv.addObject("obj",alien);
		mv.setViewName("home");
	
		
		return mv;
	}
	
	
	
	@RequestMapping("/data")
    @ResponseBody
	public Map<String,String> getData() {
		Map<String,String>map = new HashMap<String,String>();
		map.put("id", "1");
		map.put("name", "Anish");
		
		return map;
	}
}
