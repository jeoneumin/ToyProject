package com.spring.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;

@Service
public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;
	
	public int memberRegister(Member member) {
		int result = 0;
		result = memberDao.memberInsert(member);
		if(result == 1) {
			return 1;
		}else {
			return 0;
		}
	}

}
