package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("SELECT fno,address,poster,type,name,num "
			+ "FROM (SELECT fno,address,poster,type,name,ROWNUM AS num "
			+ "FROM (SELECT fno,address,poster,name,type "
			+ "FROM menupan_food "
			+ "ORDER BY fno))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start")int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
	public int foodTotalpage();
	
	@Select("SELECT fno,address,poster,type,name,num "
			+ "FROM (SELECT fno,address,poster,type,name,ROWNUM AS num "
			+ "FROM (SELECT fno,address,poster,name,type "
			+ "FROM menupan_food "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%' "
			+ "ORDER BY fno))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food WHERE ${column} LIKE '%'||#{ss}||'%'")
	public int foodFindTotalpage(Map map);
	
}
