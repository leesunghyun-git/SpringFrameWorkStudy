package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.FoodService;
import com.sist.service.RecipeService;
import com.sist.vo.FoodVO;
import com.sist.vo.RecipeVO;

@RestController
public class RestFoodController {
	@Autowired
	private FoodService service;
	
	@GetMapping(value="food/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String recipe_list_vue(int page) throws Exception
	{
		int curPage=page;
		int rowSize=12;
		int start=(rowSize*curPage)-(rowSize-1);
		int end=(rowSize*curPage);
		List<FoodVO> list=service.foodListData(start, end);
		int totalPage=service.foodTotalpage();
		final int BLOCK=10;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalPage)
			endPage=totalPage;
		Map map=new HashMap();
		map.put("list", list);
		map.put("curPage", curPage);
		map.put("totalPage", totalPage);
		map.put("endPage", endPage);
		map.put("startPage", startPage);
		ObjectMapper obj=new ObjectMapper();
		String json=obj.writeValueAsString(map);
		
		return json;
	}
	@GetMapping(value="food/find.do",produces = "text/plain;charset=UTF-8")
	public String recipe_find(String ss, String column, int page) throws Exception
	{
		int curPage=page;
		Map smap=new HashMap();
		if(ss==null || ss.isEmpty())
			if(column.equals("address"))
				ss="서울";
			else if(column.equals("type"))
				ss="한식";
			else
				ss="서울";
		if(column ==null || column.isEmpty())
			column="name";
		int rowSize=12;
		int start=(rowSize*curPage)-(rowSize-1);
		int end=(rowSize*curPage);
		smap.put("ss", ss);
		smap.put("column", column);
		int totalPage=service.foodFindTotalpage(smap);	
		smap.put("start",start);
		smap.put("end", end);
		List<FoodVO> list=service.foodFindData(smap);
		final int BLOCK=10;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalPage)
			endPage=totalPage;
		Map map=new HashMap();
		map.put("list", list);
		map.put("curPage", curPage);
		map.put("totalPage", totalPage);
		map.put("endPage", endPage);
		map.put("startPage", startPage);
		ObjectMapper obj=new ObjectMapper();
		String json=obj.writeValueAsString(map);
		
		return json;
	}
}
