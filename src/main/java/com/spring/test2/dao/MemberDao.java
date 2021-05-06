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
public class MemberDao  {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public int memberInsert(Member member) {
		// TODO Auto-generated method stub
		String sql = "insert into member values(?,?,?,?,?)";
		int result;
		try {
			result = jdbcTemplate.update(sql, member.getMemberId(), member.getUserName(), member.getPw(),
					member.getAnswer(), 0);
		} catch (Exception e) {
			// TODO: handle exception
			result = 0;
		}
		
		return result;
	}

	public int managerInsert(Member member) {
		String sql = "insert into member values(?,?,?,?,?)";
		int result;
		try {
			result = jdbcTemplate.update(sql, member.getMemberId(), member.getUserName(), member.getPw(),
					member.getAnswer(), 1);
		} catch (Exception e) {
			// TODO: handle exception
			result = 0;
		}
		
		return result;
	}

	public String searchPwByMemberId(String memberId) {
		String sql = "select pw from member where memberid = ?";
		String pw;
		try {
			pw = jdbcTemplate.queryForObject(sql, String.class, memberId);
		} catch (Exception e) {
			pw = null;
		}
		return pw;
	}

	public String searchMemberIdByMemberId(String memberId) {
		String sql = "select memberid from member where memberid = ?";
		String result;

		try {
			result = jdbcTemplate.queryForObject(sql, String.class, memberId);
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	public Member getOneMemberByMemberId(String memberId) {

		String sql = "select * from member where memberid = ?";
		Member member = jdbcTemplate.queryForObject(sql, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("memberid"), rs.getString("username"), rs.getString("pw"),
						rs.getString("answer"), rs.getInt("managevalue"));
				return member;
			}
		}, memberId);
		return member;
	}
	
	public List<Member> selectMemberRownum(int offSet, int fetch){
		String sql = "select mem.* from (select ROWNUM rm ,member.* from member where managevalue = 0) mem OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
		List<Member> results = jdbcTemplate.query(sql,
				new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("memberid"),
						rs.getString("username"),
						rs.getString("pw"),
						rs.getString("answer"),
						rs.getInt("managevalue"));
				return member;
			}
		},offSet,fetch);
		return results;
	}
	
	public int selectCountAll() {
		String sql = "select count(*) from member where managevalue = ?";
		int total;
		total = jdbcTemplate.queryForObject(sql, Integer.class,0);
		return total;
	}



	

}
