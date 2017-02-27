package org.com.cay.entity;

import java.io.Serializable;

public class CityNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String text;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "CityNode [id=" + id + ", text=" + text + "]";
	}
	
	
}
