package org.com.cay.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.com.cay.entity.Account;
import org.com.cay.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TransformAction extends ActionSupport {

	@Autowired
	private AccountService accountService;

	private int accountid1;
	private int accountid2;
	private int money;

	public void setAccountid1(int accountid1) {
		this.accountid1 = accountid1;
	}

	public void setAccountid2(int accountid2) {
		this.accountid2 = accountid2;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @RequestMapping(value = "/transform.action" ,method = RequestMethod.POST)
	// 添加事务处理
	@Transactional(propagation = Propagation.REQUIRED)
	public String transform() {
		Account account1 = accountService.getAccountById(accountid1);
		Account account2 = accountService.getAccountById(accountid2);

		if (account1.getMoney() > money) {
			accountService.transform(account1, account2, money);
			ServletContext sc = ServletActionContext.getServletContext();
			List<Account> listAccounts = new ArrayList<Account>();
			listAccounts.add(account1);
			listAccounts.add(account2);
			sc.setAttribute("listAccounts", listAccounts);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
