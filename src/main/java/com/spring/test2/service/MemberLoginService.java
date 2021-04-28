package com.spring.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;

@Service
public class MemberLoginService {
	@Autowired
	private MemberDao memberdao;
	
	public int tryLogin(String memberId, String pw) {
		String pw2 = memberdao.searchPwByMemberId(memberId);
		if(pw.equals(pw2)) {
			return 1;
		}else {
			return 0;
		}
	}
}
