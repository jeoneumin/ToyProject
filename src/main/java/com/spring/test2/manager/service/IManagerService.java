package com.spring.test2.manager.service;

import java.util.List;

import com.spring.test2.manager.Manager;

public interface IManagerService {
	//manager등록
	void managerRegister();
	//manager조회
	List<Manager> managerRead();
	//manager삭제
	void managerDelete();
	//manager정보 변경
	void managerUpdate();
	void managerOneSelect();
	

}
