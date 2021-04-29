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
public class MemberDao implements IMemberDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public int memberInsert(Member member) {
		// TODO Auto-generated method stub
		String sql = "insert into member values(?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, member.getMemberId(), member.getUserName(), member.getPw(),
				member.getAnswer(), 0);
		return result;
	}

	public int managerInsert(Member member) {
		String sql = "insert into member values(?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, member.getMemberId(), member.getUserName(), member.getPw(),
				member.getAnswer(), 1);
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

		List<Member> results = jdbcTemplate.query("select * from MEMBER", new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("memberid"), rs.getString("username"), rs.getString("pw"),
						rs.getString("answer"));
				return member;
			}
		});
		return results;
	}

}
