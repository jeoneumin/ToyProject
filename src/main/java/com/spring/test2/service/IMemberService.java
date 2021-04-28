package com.spring.test2.service;

import java.util.List;

import com.spring.test2.dto.Member;

 

public interface IMemberService {
	//회원 등록
	void memberRegister(Member member);
	//회원 조회
	List<Member> memberRead();
	//회원 삭제
	void memberDelete(String id);
	//회원 정보 변경
	void memberUpdate(String id , String userName, String answer);
	//전체회원조회
	void memberAllSelect();
	//한 회원 조회
	void memberOneSelect();
}
