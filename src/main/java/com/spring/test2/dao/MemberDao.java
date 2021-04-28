package com.spring.test2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.test2.dto.Member;



@Repository
public class MemberDao implements IMemberDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public int memberInsert(Member member) {
		// TODO Auto-generated method stub
		String sql = "insert into member values(?,?,?,?)";
		int result = jdbcTemplate.update(sql,member.getMemberId(),member.getUserName(),member.getPw(),member.getAnswer());
		return result;
	}
	
	public String searchPwByMemberId(String memberId) {
		String sql= "select pw from member where memberid = ?";
		String pw = jdbcTemplate.queryForObject(sql,String.class,memberId );
		return pw;
	}

	@Override
	public void memberDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member memberSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> memberAllSelect() {
		// TODO Auto-generated method stub
		
		List<Member> results = jdbcTemplate.query("select * from MEMBER",
				new RowMapper<Member>() {
			 @Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("memberid"),rs.getString("username"),rs.getString("pw"),rs.getString("answer"));
				return member;
			}
		});
		return results;
	}
	
}
