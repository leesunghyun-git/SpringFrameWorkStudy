package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> foodListData(int start,int end)
	{
		return mapper.foodListData(start, end);
	}
	
	public int foodTotalpage()
	{
		return mapper.foodTotalpage();
	}

	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
	}
	
	public int foodFindTotalpage(Map map)
	{
		return mapper.foodFindTotalpage(map);
	}
}
