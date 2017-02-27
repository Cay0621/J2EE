package org.com.cay.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.com.cay.entity.Account;
import org.com.cay.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class TransformAction extends ActionSupport {

	@Autowired
	private AccountService accountService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@RequestMapping(value = { "/transform.action" }, method = RequestMethod.POST)
	// 添加事务处理
	@Transactional(propagation = Propagation.REQUIRED)
	public String transform(int accountid1, int accountid2, int money,
			HttpSession session) {
		Account account1 = accountService.getAccountById(accountid1);
		Account account2 = accountService.getAccountById(accountid2);

		if (account1.getMoney() > money) {
			accountService.transform(account1, account2, money);
			ServletContext sc = session.getServletContext();
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
