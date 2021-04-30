package com.spring.test2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;

@Service
public class MemberListGet {
	@Autowired
	private MemberDao dao;
	
	public List<Member> getMemberList(int currentPage, int pageSize){
		
		int endNum = currentPage * pageSize;
		int startNum = endNum - (pageSize-1);
		List<Member> memberList = dao.selectMemberRownum(startNum, endNum);
		return memberList;
		
	}

}
