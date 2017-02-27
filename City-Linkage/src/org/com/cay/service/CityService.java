package org.com.cay.service;

import java.util.List;

import org.com.cay.entity.City;

public interface CityService {

	public List<City> getAllProvince();
	
	public List<City> getCitiesByProvinceId(String id);
}
