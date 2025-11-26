package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.RecipeVO;

public interface RecipeMapper {
	@Select("SELECT no,title,chef,poster FROM recipe ORDER BY no ASC OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<RecipeVO> recipeListData(int start);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
	public int recipeTotalPage();
}
