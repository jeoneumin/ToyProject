package com.spring.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;

@Service
public class ManagerDeleteService {

	@Autowired
	private MemberDao dao;
	
	public boolean deleteManager(String managerId) {
		boolean isSuccess;
		isSuccess = dao.memberDeleteByMemberId(managerId);
		return isSuccess;
	}
}
