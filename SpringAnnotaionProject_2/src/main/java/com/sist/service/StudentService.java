package com.sist.service;

import java.util.List;


import com.sist.vo.StudentVO;

public interface StudentService {
	
	public void studentInsert(StudentVO vo);
	
	public List<StudentVO> studentListData();
	// update
	public void studentUpdate(StudentVO vo);
	// select
	public StudentVO studentDetailData(int hakbun);
	// delete
	public void studentDelete(int hakbun);
}
