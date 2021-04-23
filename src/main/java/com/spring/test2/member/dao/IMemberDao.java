package com.spring.test2.member.dao;

import com.spring.test2.member.Member;

public interface IMemberDao {
	void memberInsert();
	void memberDelete();
	void memberUpdate();
	Member memberSelect();

}
