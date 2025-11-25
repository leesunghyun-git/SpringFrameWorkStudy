package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.DeptDAO;
import com.sist.dao.EmpDAO;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;
@Service // 비밀번호 암호화 / Session저장 / 자동 로그인
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpDAO eDAO;
	@Autowired
	private DeptDAO dDAO;
	
	
	@Override
	public List<DeptVO> deptListData() {
		// TODO Auto-generated method stub
		return dDAO.deptListData();
	}
	
	@Override
	public EmpVO empDetailData(int empno) {
		// TODO Auto-generated method stub
		return eDAO.empDetailData(empno);
	}
	
	@Override
	public List<EmpVO> empListData() {
		// TODO Auto-generated method stub
		return eDAO.empListData();
	}
}
