package org.com.cay.entity;

import java.io.Serializable;

public class District implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String post;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "District [id=" + id + ", name=" + name + ", post=" + post + "]";
	}
	
	
}
