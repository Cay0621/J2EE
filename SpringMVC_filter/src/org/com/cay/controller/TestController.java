package org.com.cay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TestController {

	@RequestMapping(value="/viewAll",method=RequestMethod.POST)
	public ModelAndView viewAll(String name, String password){
		ModelAndView mv = new ModelAndView();
		System.out.println("name:" + name);
		System.out.println("pwd:" + password);
		mv.addObject("name", name);
		mv.addObject("password", password);
		mv.setViewName("/viewone.jsp");
		return mv;
	}
}
