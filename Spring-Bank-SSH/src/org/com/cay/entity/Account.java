package org.com.cay.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer aid;
	private String aname;
	private Integer money;

	public Account() {

	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", aname=" + aname + ", money=" + money
				+ "]";
	}

}
