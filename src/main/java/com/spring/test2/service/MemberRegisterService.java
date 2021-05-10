package com.spring.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;

@Service
public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;
	
	public boolean memberRegister(Member member) {
		boolean isSuccess;
		isSuccess = memberDao.memberInsert(member);
		return isSuccess;
	}

}
