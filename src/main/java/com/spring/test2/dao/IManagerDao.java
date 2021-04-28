package com.spring.test2.dao;

import java.util.List;

import com.spring.test2.manager.Manager;
import com.spring.test2.member.Member;

public interface IManagerDao {
	void managerInsert();
	void managerDelete();
	void managerUpdate();
	Manager managerSelect();
	List<Member> selectAllManager();
}
