package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.BoardVO;

public interface BoardMapper {
	@Select("SELECT no,name,subject,TO_CHAR(regdate,'YYYY-MM-DD') AS dbday , hit , num "
			+ "FROM (SELECT no,name,subject,regdate , hit , ROWNUM AS num "
			+ "FROM (SELECT no,name,subject,regdate , hit "
			+ "FROM springBoard ORDER BY no DESC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start")int start,@Param("end")int end);
	
	@Insert("INSERT INTO springBoard(no,name,subject,content,pwd) VALUES "
			+ "( sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
	public void boardInsert(BoardVO vo);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springboard")
	public int boardTotalPage();
	
	@Select("SELECT no,name,subject,TO_CHAR(regdate,'YYYY-MM-DD') AS dbday, content,hit "
			+ "FROM springBoard "
			+ "WHERE no = #{no}" )
	public BoardVO boardDetailData(int no);
	
	@Update("UPDATE springBoard SET "
			+ "name = #{name}, subject= #{subject}, content=#{content} "
			+ "WHERE no = #{no}")
	public void boardUpdate(BoardVO vo);
	
	@Delete("DELETE springBoard WHERE no = #{no}")
	public void boardDelete(int no);
	
	@Select("SELECT pwd FROM springboard WHERE no= #{no}")
	public String boardPwdCheck(int no);
	@Update("UPDATE springboard SET hit=hit+1 WHERE no =#{no}")
	public void boardHitUpdate(int no);
	@Select("SELECT no,name,content,subject FROM springBoard WHERE no =#{no}")
	public BoardVO boardUpdateData(int no);
}
