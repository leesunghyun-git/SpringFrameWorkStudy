package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;
@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO dao;
	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return dao.foodFindData(map);
	}
	@Override
	public int foodFindTotalpage(Map map) {
		// TODO Auto-generated method stub
		return dao.foodFindTotalpage(map);
	}
	@Override
	public List<FoodVO> foodListData(int start, int end) {
		// TODO Auto-generated method stub
		return dao.foodListData(start, end);
	}
	@Override
	public int foodTotalpage() {
		// TODO Auto-generated method stub
		return dao.foodTotalpage();
	}
}
