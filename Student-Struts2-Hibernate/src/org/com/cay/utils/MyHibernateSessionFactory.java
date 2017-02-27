package org.com.cay.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernateSessionFactory {

	private static SessionFactory sessionFactory;
	
	//保证单例
	private MyHibernateSessionFactory(){
		
	}
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}
}
