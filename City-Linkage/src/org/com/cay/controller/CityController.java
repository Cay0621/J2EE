package org.com.cay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.com.cay.entity.City;
import org.com.cay.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;

@Controller
public class CityController {

	@Autowired
	private CityService cityService;
	
	@RequestMapping("/getAllProvince")
	@ResponseBody
	public void getAllProvince(HttpServletResponse response) throws IOException{
		List<City> listCity = cityService.getAllProvince();
		//System.out.println(listCity);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(JSONArray.fromObject(listCity).toString());
	}
	
	@RequestMapping("/getCitiesByProvinceId")
	@ResponseBody
	public void getCitiesByProvinceId(@RequestParam("province_id") String id, HttpServletResponse response) throws IOException{
		//System.out.println(id);
		List<City> listCity = cityService.getCitiesByProvinceId(id);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(JSONArray.fromObject(listCity).toString());
	}
}
