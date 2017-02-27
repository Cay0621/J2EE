package org.com.cay.controller;

import java.util.List;

import org.com.cay.entity.User;
import org.com.cay.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/user"})
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView queryUserById(@PathVariable("id") Integer id){
		
		ModelAndView mv = new ModelAndView();
		
		User user = userService.queryUserById(id);
		mv.addObject("user", user);
		mv.setViewName("hello");
		
		return mv;
	}
	
	@RequestMapping(value = {"/list"}, method=RequestMethod.GET)
	public ModelAndView findAllUser(){
		ModelAndView mv = new ModelAndView();
		
		List<User> users = userService.queryAllUser();
		mv.addObject("users", users);
		mv.setViewName("list");
		return mv;
	}
}
