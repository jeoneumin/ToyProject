package com.spring.test2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogTest {

	private static final Logger logger = LogManager.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setAge(4);
		user.setName("aaa");
		System.out.println("hello");
		logger.info("Hello, World");

	}

}
