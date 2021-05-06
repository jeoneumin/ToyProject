package com.spring.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;

@Service
public class ManagerRegisterService {
	@Autowired
	private MemberDao dao;
	
	public int managerRegister(Member member) {
		String memberId = dao.searchMemberIdByMemberId(member.getMemberId());
		int result;
		if(memberId ==null) {
			//아이디 중복없음
			result = dao.managerInsert(member);
			if(result == 1) {
				return 1;
			}else {
				return 0;
			}
			
		}else {
			//아이디 중복있음
			return 0;
		}
	}
}
