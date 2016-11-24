package com.wind.test;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wind.dao.impl.UserDao;

public class RealDataTest {
	
	public static void main(String[] args) {
		String[] config = new String[1];
    	config[0] = "applicationContext.xml";
    	AbstractApplicationContext ctx =
    		    new ClassPathXmlApplicationContext(config);
    	UserDao userDao = ctx.getBean(UserDao.class);
    	System.out.println(userDao);
	}
	
}
