package org.com.cay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/hello")
public class HelloMvcController {

	@RequestMapping(value="/mvc")
	public String helloMvc(){
		return "home";
	}
}
