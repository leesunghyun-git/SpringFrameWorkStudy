package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
// 자바 스크립트로 데이터 전송

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@RestController
public class RestBoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping(value="board/delete.do",produces = "text/plain;charset=UTF-8")
	//response.setContentType()
	public String board_delete(int no,String pwd)
	{
		String res="";
		String dbpwd=dao.boardPwdCheck(no);
		if(dbpwd.equals(pwd))
		{
			res="yes";
			dao.boardDelete(no);
		}
		else {
			res="no";
		}
		return res;
	}
	@PostMapping("board/update_ok.do")
	public String board_update_ok(BoardVO vo)
	{
		String res="";
		String dbpwd=dao.boardPwdCheck(vo.getNo());
		if(dbpwd.equals(vo.getPwd()))
		{
			dao.boardUpdate(vo);
			res="yes";
		}
		else
		{
			res="no";
		}
		return res;
	}
}
