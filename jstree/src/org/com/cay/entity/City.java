package org.com.cay.entity;

import java.io.Serializable;

public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cityId;
	private String cityName;
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}
	
	
}
