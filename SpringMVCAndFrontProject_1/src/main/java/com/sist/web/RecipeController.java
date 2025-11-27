package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;
@RequestMapping("recipe/")
@Controller
public class RecipeController {
	@Autowired
	private RecipeService service;
	
	@GetMapping("list.do")
	public String recipe_list(String page,Model model)
	{
		// 처음 실행시 데이터가 없는 경우 => String
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		final int rowSize=12;
		int start=(curPage*rowSize)-(rowSize-1);
		int end=(curPage*rowSize);
		int totalPage=service.recipeTotalPage();
		List<RecipeVO> list = service.recipeListData(start, end);
		final int BLOCK = 10;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		
		if (endPage>totalPage)
			endPage=totalPage;
		
		model.addAttribute("list",list);
		model.addAttribute("curPage",curPage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		return "recipe/list";
	}
	@GetMapping("detail.do")
	public String recipe_detail(int no,Model model)
	{
		RecipeDetailVO vo = service.recipeDetailData(no);
		model.addAttribute("vo", vo);
		return "recipe/detail";
	}
	
}
