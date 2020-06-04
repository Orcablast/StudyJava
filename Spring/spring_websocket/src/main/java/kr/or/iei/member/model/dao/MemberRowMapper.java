package kr.or.iei.member.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.iei.member.model.vo.Member;

public class MemberRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member m = new Member();
		m.setMemberNo(rs.getInt("member_no"));
		m.setMemberId(rs.getString("member_id"));
		m.setMemberPw(rs.getString("member_pw"));
		m.setMemberName(rs.getString("member_name"));
		m.setAge(rs.getInt("age"));
		m.setEnrollDate(rs.getString("enroll_date"));		
		
		return m;
	}
	
	
	
}
