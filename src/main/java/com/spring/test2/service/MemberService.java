package com.spring.test2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test2.dao.MemberDao;
import com.spring.test2.dto.Member;


@Service
public class MemberService implements IMemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public void memberRegister(Member member) {
		int result = 0;
		result = memberDao.memberInsert(member);
		if(result == 1) {
			return;
		}else {
			System.out.println("memberRegister() 실패");
			return;
		}

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
