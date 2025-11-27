package com.sist.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// 화면 제어(X) => Front로 데이터 전송
// => 1. 일반 문자열 , 2. 정수 , 3. JSON
// => JSON을 자동으로 구현

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.RecipeService;
import com.sist.vo.EmpVO;
import com.sist.vo.RecipeVO;
@RestController
public class RestRecipeController {
	@Autowired
	private RecipeService service;
	
	@GetMapping(value="recipe/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String recipe_list_vue(int page) throws Exception
	{
		int curPage=page;
		int rowSize=12;
		int start=(rowSize*curPage)-(rowSize-1);
		int end=(rowSize*curPage);
		List<RecipeVO> list=service.recipeListData(start, end);
		int totalPage=service.recipeTotalPage();
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
	@GetMapping(value="recipe/find.do",produces = "text/plain;charset=UTF-8")
	public String recipe_find(String ss, String column, int page) throws Exception
	{
		int curPage=page;
		Map smap=new HashMap();
		if(ss==null || ss.isEmpty())
			if(column.equals("chef"))
				ss="성현";
			else
				ss="치즈";
		if(column ==null || column.isEmpty())
			column="title";
		int rowSize=12;
		int start=(rowSize*curPage)-(rowSize-1);
		int end=(rowSize*curPage);
		smap.put("ss", ss);
		smap.put("column", column);
		int totalPage=service.recipeFindTotalPage(smap);	
		smap.put("start",start);
		smap.put("end", end);
		List<RecipeVO> list=service.recipeFindData(smap);
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
