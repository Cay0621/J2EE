package org.com.cay.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.com.cay.entity.Person;
import org.com.cay.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	//登录的前置操作
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(String username, String password){
		if(Objects.equals(username, "admin") && Objects.equals(password, "admin")){
			return "redirect:main";
		}
		return "redirect:login";
	}
	
	@RequestMapping("/main")
	public String main(Model model){
		model.addAttribute("persons", this.personService.getPersons());
		return "main";
	}
	
	@RequestMapping("/getPersons")
	@ResponseBody
	public List<Person> getPersons(){
		return personService.getPersons();
	}
	
	@RequestMapping("/getPersonById")
	@ResponseBody
	public Person getPersonById(String id){
		return personService.getPersonById(id);
	}
	
	@RequestMapping("/addPrompt")//添加Person的前置操作
	public String addPrompt(){
		return "addPrompt";
	}
	
	@RequestMapping("/addPerson")
	public String addPerson(Person person){
		personService.addPerson(person);
		return "redirect:main";
	}
	
	@RequestMapping("/updatePrompt")//修改Person的前置操作
	public String updatePrompt(Model model, String id){
		//System.out.println(id);
		model.addAttribute("person", this.personService.getPersonById(id));
		return "updatePrompt";
	}
	
	
	@RequestMapping("/updatePerson")
	public String updatePerson(Person person){
		personService.updatePerson(person);
		return "redirect:main";
	}
	
	
	
	@RequestMapping("/deletePersonById")
	public String deletePersonById(String id){
		personService.deletePersonById(id);
		return "redirect:main";
	}
}
