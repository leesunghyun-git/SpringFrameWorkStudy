package com.sist.main;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.StudentConfig;
/*
 * 	컨테이너
 * 		ApplicationContext
 * 		AnnotaionConfigApplicationContext
 * 
 * 		=> WebApplicationContext
 * 		   (숨겨져 있다)
 * 			DispacherServlet
 * 
 * 		=> DI를 사용하는 클래스는 
 * 		   : 사용자 정의
 * 		   : 라이브러리 클래스
 * 			============== 데이터베이스 / 보안
 * 						   ----------  ---
 * 
 */
// 5.0버전
// 2.5버전 => XML
public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app= new AnnotationConfigApplicationContext(StudentConfig.class);
		Student std=(Student)app.getBean("std");
		System.out.println("학번:"+std.getHakbun());
		System.out.println("이름:"+std.getName());
		System.out.println("성별:"+std.getSex());
		System.out.println("과목:"+std.getSubject());
	}
}
