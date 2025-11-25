package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.sist.vo.FoodVO;

import java.util.*;

public interface FoodMapper {
	@Select("SELECT fno,name,address,type,phone FROM menupan_food WHERE ${column} LIKE '%'||#{ss}||'%'")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT count(*) FROM menupan_food WHERE ${column} LIKE '%'||#{ss}||'%'")
	public int foodFindCount(Map map);
}
