package com.sist.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.service.RecipeService;
import com.sist.vo.RecipeVO;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app= new ClassPathXmlApplicationContext("application-*.xml");
		RecipeService service=(RecipeService)app.getBean("service");
		Scanner scan=new Scanner(System.in);

		while(true)
		{
			System.out.println("=======================");
			System.out.println("검색어 메뉴");
			System.out.println("1. 레시피 제목 검색");
			System.out.println("2. 쉐프 검색");
			System.out.println("3. 시스템 종료");
			System.out.println("======================");
			System.out.println("메뉴 선택 :");
			int menu = scan.nextInt();
			Map map=new HashMap();
			switch (menu)
			{
				case 1:
				{
					map.put("column", "title");
					System.out.println("레시피 입력 :");
					map.put("ss", scan.next());
					int count=service.recipeFindCountData(map);
					if(count==0)
					{
						System.out.println("검색하신 내용에 해당하는 레시피가 없습니다.");
						break;
					}
					else
					{
						List<RecipeVO> list=service.recipeFindListData(map);
						System.out.println("검색 결과 : "+count+" 건");
						for(RecipeVO vo:list)
						{
							System.out.println(vo.getNo()+"."+vo.getTitle()+"/"+vo.getChef()+"/"+vo.getLink());
						}
						break;
					}
				}
				case 2:
				{
					map.put("column", "chef");
					System.out.println("쉐프명 입력:");
					map.put("ss", scan.next());
					int count=service.recipeFindCountData(map);
					if(count==0)
					{
						System.out.println("검색하신 내용에 해당하는 레시피가 없습니다.");
						break;
					}
					else
					{
						List<RecipeVO> list=service.recipeFindListData(map);
						System.out.println("검색 결과 : "+count+" 건");
						for(RecipeVO vo:list)
						{
							System.out.println(vo.getNo()+"."+vo.getTitle()+"/"+vo.getChef()+"/"+vo.getLink());
						}
						break;
					}
				}
				case 3:
				{
					System.out.println("시스템 종료");
					System.exit(0);
				}
				default :
				{
					System.out.println("잘못된 입력입니다.");
					break;
				}
			}
		}

	}

}
