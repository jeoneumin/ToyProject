package com.spring.test2.manager.dao;

import com.spring.test2.manager.Manager;

public interface IManagerDao {
	void managerInsert();
	void managerDelete();
	void managerUpdate();
	Manager managerSelect();
}
