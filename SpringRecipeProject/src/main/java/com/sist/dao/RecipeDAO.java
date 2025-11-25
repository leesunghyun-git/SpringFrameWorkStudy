package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.RecipeMapper;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeFindListData(Map map)
	{
		return mapper.recipeFindListData(map);
	}
	
	public int recipeFindCountData(Map map)
	{
		return mapper.recipeFindCountData(map);
	}
}
