package org.com.cay3.test;

import javax.annotation.Resource;

import org.com.cay3.service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring的声明式事务管理的方式二：基于aspectj的xml方式的配置
 * @author Cay
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class Test {

	@Resource(name = "accountService")
	private AccountService accountService;
	
	@org.junit.Test
	public void test() {
		accountService.transfer(1, 2, 100);
	}

}
