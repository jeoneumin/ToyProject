package com.spring.test2;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.AutomapConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Dao {
	
	private DataSource dataSource;
	
	public Connection getCon() {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
		
	}
}
