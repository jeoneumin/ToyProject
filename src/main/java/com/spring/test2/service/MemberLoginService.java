package com.spring.test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;

@Service
public class MemberLoginService {
	@Autowired
	private MemberDao memberdao;

	public Member tryLogin(Member member) {

		Member getMember = null;
		if (member.getPw().equals(memberdao.searchPwByMemberId(member.getMemberId()))) {
			getMember = memberdao.getOneMemberByMemberId(member.getMemberId());
			return getMember;
		} else {
			// 비밀번호가 틀림
			return getMember;
		}

	}
}
