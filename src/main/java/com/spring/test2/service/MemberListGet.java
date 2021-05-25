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
	
	private final int PAGESCOPE = 3;
	private final int PAGESIZE = 3; //보여질 행의 수
	
	
	public List<Member> getMemberList(int currentPage){
		
		int offSet = (currentPage-1)*PAGESIZE; 
		int fetch = PAGESIZE;
		
		List<Member> memberList = dao.selectMemberRownum(offSet, fetch);
		return memberList;
		
	}
	
	public int getPageScope() {
		return this.PAGESCOPE;
	}
	
	public int getTotal() {
		int total = dao.selectMemberCountAll(); 
		
		return total;
	}
	
	public int getPageSize() {
		return this.PAGESIZE;
	}

}
