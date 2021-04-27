package com.spring.test2.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.member.Member;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public void memberRegister(Member member) {
		memberDao.insert(member.getMemberId(),member.getUserName(),member.getPw(),member.getAnswer());

	}

	@Override
	public List<Member> memberRead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void memberDelete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void memberUpdate(String id, String userName, String answer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void memberAllSelect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void memberOneSelect() {
		// TODO Auto-generated method stub

	}

}
