package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Controller
@RequestMapping("food/")
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("list.do")
	public String Food_list(String page,Model model)
	{
		if(page==null)
		{
			page="1";
		}
		int curPage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curPage)-(rowSize-1);
		int end=rowSize*curPage;
		List<FoodVO> list=dao.foodListData(start, end);
		int totalPage=dao.foodTotalPage();
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
		return "food/list";
	}
}
