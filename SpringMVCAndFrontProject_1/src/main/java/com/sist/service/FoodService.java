package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.FoodVO;

public interface FoodService {
	public List<FoodVO> foodListData(int start,int end);
	public int foodTotalpage();
	public List<FoodVO> foodFindData(Map map);
	public int foodFindTotalpage(Map map);
}
