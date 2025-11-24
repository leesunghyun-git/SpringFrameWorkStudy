package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;
import java.util.*;
import com.sist.mapper.*;
public class FoodDAO {
	private FoodMapper mapper;
	// 구현된 클래스를 스프링을 통해 전송 => setter
	/*
	 * @Select("SELECT fno,name,address,type,num FROM ( " +
	 * "SELECT fno,name,address,type,ROWNUM as num " +
	 * "FROM (SELECT fno,name,address,type " + "FROM menupan_food" +
	 * "ORDER BY fno))" + "WHERE num BETWEEN #{start} AND #{end}")
	 */	
	
	public void setMapper(FoodMapper mapper) {
		this.mapper = mapper;
	}

	public List<FoodVO> foodListData(int start,int end){
		return mapper.foodListData(start, end);
	};
	
}
