package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;
@Repository
public class BoardDAO {
	
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(int start, int end)
	{
		return mapper.boardListData(start, end);
	}
	

	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	 
	

 	public BoardVO boardDetailData(int no)
	{
		return mapper.boardDetailData(no);
	}
	

	public void boardUpdate(BoardVO vo)
	{
		mapper.boardUpdate(vo);
	}
	

	public void boardDelete(int no)
	{
		mapper.boardDelete(no);
	}
	
	public String boardPwdCheck(int no)
	{
		return mapper.boardPwdCheck(no);
	}
	public void boardHitUpdate(int no)
	{
		mapper.boardHitUpdate(no);
	}
	public BoardVO boardUpdateData(int no)
	{
		return mapper.boardUpdateData(no);
	}
}
