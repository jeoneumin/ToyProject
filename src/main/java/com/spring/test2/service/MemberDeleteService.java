package com.spring.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;

@Service
public class MemberDeleteService {

	@Autowired
	private MemberDao dao;
	
	public boolean deleteMember(String memberId) {
		boolean isSuccess;
		isSuccess = dao.memberDeleteByMemberId(memberId);
		return isSuccess;
	}
}
