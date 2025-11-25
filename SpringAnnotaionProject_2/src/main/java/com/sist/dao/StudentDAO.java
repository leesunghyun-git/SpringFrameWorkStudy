package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.StudentMapper;
import com.sist.vo.StudentVO;
// Spring => 메모리할당이 안된다 : Mapper / VO 
@Repository
public class StudentDAO {
	@Autowired
	private StudentMapper mapper; 
	
	public void studentInsert(StudentVO vo)
	{
		mapper.studentInsert(vo);
	}
	
	public List<StudentVO> studentListData()
	{
		return mapper.studentListData();
	}
	// update
	public void studentUpdate(StudentVO vo)
	{
		mapper.studentUpdate(vo);
	}
	// select
	public StudentVO studentDetailData(int hakbun)
	{
		return mapper.studentDetailData(hakbun);
	}
	// delete
	public void studentDelete(int hakbun)
	{
		mapper.studentDelete(hakbun);
	}
}
