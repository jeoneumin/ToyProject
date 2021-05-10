package com.spring.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;

@Service
public class ManagerRegisterService {
	@Autowired
	private MemberDao dao;
	
	public boolean managerRegister(Member member) {
		String memberId = dao.searchMemberIdByMemberId(member.getMemberId());
		boolean isSuccess =false;
		if(memberId ==null) {
			//아이디 중복없음
			isSuccess = dao.managerInsert(member);
			return isSuccess;
			
			
		}else {
			//아이디 중복있음
			return isSuccess;
		}
	}
}
