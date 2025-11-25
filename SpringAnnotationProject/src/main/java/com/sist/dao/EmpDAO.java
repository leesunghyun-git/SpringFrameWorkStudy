package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.EmpMapper;
import com.sist.vo.EmpVO;

import lombok.Setter;
@Repository
public class EmpDAO{
	@Autowired // 스프링안에서 메모리 할당된 클래스만 적용이 가능
	private EmpMapper mapper;

	public List<EmpVO> empListData() {
		return mapper.empListData();
	}

	public EmpVO empDetailData(int empno) {
		return mapper.empDetailData(empno);
	}
	
	
}
