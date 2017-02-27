package org.com.cay1.test;

import javax.annotation.Resource;

import org.com.cay1.service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring编程式事务管理的测试类
 * @author Cam
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext1.xml")
public class Test {

	@Resource(name = "accountService")
	private AccountService accountService;
	
	@org.junit.Test
	public void test() {
		accountService.transfer(1, 2, 100);
	}

}
