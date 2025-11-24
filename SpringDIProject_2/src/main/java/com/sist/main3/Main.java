package com.sist.main3;

import com.sist.main2.ApplicationContext;
import com.sist.main2.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		Member m=(Member)app.getBean("mem");
		System.out.println("¹øÈ£"+m.getNo());
	}
}
