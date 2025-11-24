package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {
	/*
	 * 	@Insert		<insert> => mapper.xml , Config.xml(x)
	 * 	@Update		<update>
	 * 	@Delete		<delete>
	 * 	@Results	<resultMap>
	 * 	@SelectKey	
	 * 	-------------
	 */
	@Select("SELECT fno,name,address,type,num "
			+ "FROM (SELECT fno,name,address,type,ROWNUM as num "
			+ "FROM (SELECT fno,name,address,type "
			+ "FROM menupan_food "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
}
