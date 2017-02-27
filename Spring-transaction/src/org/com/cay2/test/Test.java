package org.com.cay2.test;

import javax.annotation.Resource;

import org.com.cay2.service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring的声明式事务管理的方式一
 * @author Cay
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class Test {

	@Resource(name = "accountServiceProxy")
	private AccountService accountService;
	
	@org.junit.Test
	public void test() {
		accountService.transfer(1, 2, 100);
	}

}
