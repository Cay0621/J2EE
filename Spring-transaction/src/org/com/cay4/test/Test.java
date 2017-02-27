package org.com.cay4.test;

import javax.annotation.Resource;

import org.com.cay4.service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring的声明式事务管理的方式三：基于注解的方式
 * @author Cay
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class Test {

	@Resource(name = "accountService")
	private AccountService accountService;
	
	@org.junit.Test
	public void test() {
		accountService.transfer(1, 2, 100);
	}

}
