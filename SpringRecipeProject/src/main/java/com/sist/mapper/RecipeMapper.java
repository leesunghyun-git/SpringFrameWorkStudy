package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.RecipeVO;

import java.util.*;
public interface RecipeMapper {
	@Select("SELECT no,title,chef,link FROM recipe WHERE ${column} LIKE '%'||#{ss}||'%' ")
	public List<RecipeVO> recipeFindListData(Map map);
	
	@Select("SELECT count(*) FROM recipe WHERE ${column} LIKE '%'||#{ss}||'%' ")
	public int recipeFindCountData(Map map);
}
