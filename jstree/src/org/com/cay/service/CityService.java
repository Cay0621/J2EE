package org.com.cay.service;

import java.util.List;

import org.com.cay.entity.CityNode;

public interface CityService {

	public List<CityNode> getAllProvince();
	
	public List<CityNode> getCitiesByProvinceId(String id);
}
