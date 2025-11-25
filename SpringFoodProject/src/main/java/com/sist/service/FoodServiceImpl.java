package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Service("service")
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO dao;
	@Override
	public int foodFindCount(Map map) {
		// TODO Auto-generated method stub
		return dao.foodFindCount(map);
	}
	
	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return dao.foodFindData(map);
	}
	
}
