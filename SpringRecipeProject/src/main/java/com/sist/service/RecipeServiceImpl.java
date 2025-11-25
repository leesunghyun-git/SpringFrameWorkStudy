package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.RecipeDAO;
import com.sist.vo.RecipeVO;

@Service("service")
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO dao;
	@Override
	public int recipeFindCountData(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeFindCountData(map);
	}
	@Override
	public List<RecipeVO> recipeFindListData(Map map) {
		// TODO Auto-generated method stub
		return dao.recipeFindListData(map);
	}
}
