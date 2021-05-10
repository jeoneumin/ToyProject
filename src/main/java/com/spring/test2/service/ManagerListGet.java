package com.spring.test2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;

@Service
public class ManagerListGet {

	@Autowired
	private MemberDao dao;

	private final int PAGESCOPE = 3;
	private final int PAGESIZE = 3;

	public List<Member> getManagerList(int currentPage) {

		int offSet = (currentPage - 1) * PAGESIZE;
		int fetch = PAGESIZE;

		List<Member> managerList = dao.selectManagerRownum(offSet, fetch);
		return managerList;

	}
	
	public int getPageScope() {
		return this.PAGESCOPE;
	}
	
	public int getTotal() {
		int total = dao.selectManagerCountAll(); 
		
		return total;
	}
}
