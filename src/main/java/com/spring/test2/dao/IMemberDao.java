package com.spring.test2.dao;

import java.util.List;

import com.spring.test2.dto.Member;



public interface IMemberDao {
	int memberInsert(Member member);
	void memberDelete();
	void memberUpdate();
	Member memberSelect();
	List<Member> memberAllSelect();

}
