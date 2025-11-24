package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		// 1. 积己等 按眉 佬扁
		Sawon sa1=(Sawon)app.getBean("sa1");
		sa1.print();
		Sawon sa2=(Sawon)app.getBean("sa2");
		sa2.print();
		Sawon sa3=(Sawon)app.getBean("sa3");
		sa3.print();
	}
}
