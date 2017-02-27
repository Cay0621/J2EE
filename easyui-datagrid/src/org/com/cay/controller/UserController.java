package org.com.cay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.com.cay.entity.User;
import org.com.cay.model.Condition;
import org.com.cay.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/list")
	@ResponseBody
	public String listAll(Condition condition) {
		//List<User> users = userService.getListAllUser();
		List<User> users = userService.getUser(condition);
		int total = userService.getTotal(condition);
		Map<String, Object> maps = new HashMap<>();
		maps.put("total", total);
		maps.put("rows", users);
		return JSON.toJSONString(maps);
	}
}
