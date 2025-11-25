package com.sist.main;
import com.sist.vo.*;
import com.sist.service.*;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainClass {
	
	public static void main(String[] args) {
		ApplicationContext app= new ClassPathXmlApplicationContext("application-*.xml");
		FoodService service=(FoodService)app.getBean("service");
		Scanner scan=new Scanner(System.in);

		while(true)
		{
			System.out.println("=======================");
			System.out.println("검색어 메뉴");
			System.out.println("1. 맛집 이름 검색");
			System.out.println("2. 주소 검색");
			System.out.println("3. 종류 검색");
			System.out.println("4. 시스템 종료");
			System.out.println("======================");
			System.out.println("메뉴 선택 :");
			int menu = scan.nextInt();
			Map map=new HashMap();
			switch (menu)
			{
				case 1:
				{
					map.put("column", "name");
					System.out.println("검색할 맛집명 입력 :");
					map.put("ss", scan.next());
					int count=service.foodFindCount(map);
					if(count==0)
					{
						System.out.println("검색하신 내용에 해당하는 맛집이 없습니다.");
						break;
					}
					else
					{
						List<FoodVO> list=service.foodFindData(map);
						System.out.println("검색 결과 : "+count+" 건");
						for(FoodVO vo:list)
						{
							System.out.println(vo.getFno()+"."+vo.getName()+"/"+vo.getAddress()+"/"+vo.getType()+"/"+vo.getPhone());
						}
						break;
					}
				}
				case 2:
				{
					map.put("column", "address");
					System.out.println("검색할 주소 입력:");
					map.put("ss", scan.next());
					int count=service.foodFindCount(map);
					if(count==0)
					{
						System.out.println("검색하신 내용에 해당하는 맛집이 없습니다.");
						break;
					}
					else
					{
						List<FoodVO> list=service.foodFindData(map);
						System.out.println("검색 결과 : "+count+" 건");
						for(FoodVO vo:list)
						{
							System.out.println(vo.getFno()+"."+vo.getName()+"/"+vo.getAddress()+"/"+vo.getType()+"/"+vo.getPhone());
						}
						break;
					}
				}
				case 3:
				{
					map.put("column", "type");
					System.out.println("검색할 음식 종류 입력 :");
					map.put("ss", scan.next());
					int count=service.foodFindCount(map);
					if(count==0)
					{
						System.out.println("검색하신 내용에 해당하는 맛집이 없습니다.");
						break;
					}
					else
					{
						List<FoodVO> list=service.foodFindData(map);
						System.out.println("검색 결과 : "+count+" 건");
						for(FoodVO vo:list)
						{
							System.out.println(vo.getFno()+"."+vo.getName()+"/"+vo.getAddress()+"/"+vo.getType()+"/"+vo.getPhone());
						}
						break;
					}
				}
				case 4:
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
