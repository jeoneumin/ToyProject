package com.spring.test2.member.service;

import java.util.List;

import com.spring.test2.member.Member;

public interface IMemberService {
	//회원 등록
	void memberRegister(Member member);
	//회원 조회
	List<Member> memberRead();
	//회원 삭제
	void memberDelete(String id);
	//회원 정보 변경
	void memberChange(String id , String userName, String answer);
}
