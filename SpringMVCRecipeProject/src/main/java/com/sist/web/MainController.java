package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

@Controller
@RequestMapping("recipe/")
public class MainController {
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping("list.do")
	public String recipe_list(String page,Model model)
	{
		if(page==null)
		{
			page="1";
		}
		int curPage=Integer.parseInt(page);
		int rowSize=12;
		int start=(curPage-1)*rowSize;
		
		List<RecipeVO> list=dao.recipeListData(start);
		int totalPage=dao.recipeTotalPage();
		final int BLOCK=10;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalPage)
			endPage=totalPage;
		model.addAttribute("list",list);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		return "recipe/list";
	}
}
