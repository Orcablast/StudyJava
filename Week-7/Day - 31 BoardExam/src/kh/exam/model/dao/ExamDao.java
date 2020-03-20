package kh.exam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;

public class ExamDao {

	public int signup(Connection conn, Member m) {

		int result = 0;

		String query = "insert into exam_member values (seq_member_no.nextval,?,?,?,?)";

		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement(query);

			pst.setString(1, m.getMemberId());
			pst.setString(2, m.getMemberPw());
			pst.setString(3, m.getMemberName());
			pst.setString(4, m.getPhone());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}

		return result;
	}

	public Member searchMember(Connection conn, Member m) {

		String query = null;

		String key1 = null;
		String key2 = null;

		if (m.getMemberId() != null) {
			query = "select * from exam_member where member_id = ? and member_pw = ?";
			key1 = m.getMemberId();
			key2 = m.getMemberPw();

		} else if (m.getMemberName() != null) {
			query = "select member_id from exam_member where member_name = ? and phone = ?";
			key1 = m.getMemberName();
			key2 = m.getPhone();
		}

		PreparedStatement pst = null;
		ResultSet rset = null;

		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, key1);
			pst.setString(2, key2);

			rset = pst.executeQuery();

			if (m.getMemberId() != null && rset.next()) {
				m = setMember(rset);

			} else if (m.getMemberId() == null && rset.next()) {
				m.setMemberId(rset.getString(1));

			} else {
				m = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}

		return m;
	}

	public Member setMember(ResultSet rset) {
		Member m = new Member();

		try {

			m.setMemberNo(rset.getInt(1));
			m.setMemberId(rset.getString(2));
			m.setMemberPw(rset.getString(3));
			m.setMemberName(rset.getString(4));
			m.setPhone(rset.getString(5));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return m;
	}

	public int modifyUserInfo(Connection conn, Member m) {

		int result = 0;

		String query = "update exam_member set member_pw = ?, phone = ? where member_id = ?";

		PreparedStatement pst = null;

		try {

			pst = conn.prepareStatement(query);

			pst.setString(1, m.getMemberPw());
			pst.setString(2, m.getPhone());
			pst.setString(3, m.getMemberId());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}

		return result;
	}

	public int deleteMbr(Connection conn, String memberId) {

		String query = "delete from exam_member where member_id = ?";

		PreparedStatement pst = null;

		int result = 0;

		try {
			pst = conn.prepareStatement(query);

			pst.setString(1, memberId);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			JDBCTemplate.close(pst);
		}

		return result;

	}

	public int boardWrite(Connection conn, Board b) {

		int result = 0;

		String query = "insert into exam_board values (seq_board_no.nextval,?,?,?,0,sysdate)";

		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement(query);

			pst.setString(1, b.getBoardTitle());
			pst.setString(2, b.getBoardContent());
			pst.setString(3, b.getBoardWriter());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}

		return result;

	}

	public ArrayList<Board> boardList(Connection conn, int key) {
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		String query = null;
		
		if(key == 0) {
			query = "select * from exam_board";
		} else {
			query = "select board_no, board_title, board_content, nvl(member_name,'탈퇴회원'), read_count, write_date from exam_board left join exam_member on (board_writer = member_id)";
			
		}
		
		PreparedStatement pst = null;
		ResultSet rset = null;
		
		
		try {
			
			pst = conn.prepareStatement(query);
			
			if(key > 0) {
				pst.setInt(1, key);
			}
							
			rset = pst.executeQuery();
			
			
			while(rset.next()) {
				list.add(setBoard(rset));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}
		
		return list;
	}

	public Board setBoard(ResultSet rset) {
		Board b = new Board();

		try {

			b.setBoardNo(rset.getInt(1));
			b.setBoardTitle(rset.getString(2));
			b.setBoardContent(rset.getString(3));
			b.setBoardWriter(rset.getString(4));
			b.setReadCount(rset.getInt(5));
			b.setWriteDate(rset.getDate(6));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	public int countRead(Connection conn, Board b) {

		String query = "update exam_board set read_count = ? where board_no = ?";

		int result = 0;

		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement(query);

			pst.setInt(1, (b.getReadCount() + 1));
			pst.setInt(2, b.getBoardNo());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}

		return result;
	}

	public Board readBoard(Connection conn, int slt) {
		
		Board b = null;
		
		String query = "select * from exam_board where board_no = ?";
		
		PreparedStatement pst = null;
		ResultSet rset = null;
		
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setInt(1, slt);
			
			rset = pst.executeQuery();
			
			if(rset.next()) {
				b = setBoard(rset);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pst);
		}
		
		
		return b;
	}

	public int modifyBoard(Connection conn, Board b) {
		
		PreparedStatement pst = null;
		
		int result = 0;
		String query = "update exam_board set board_title = ?, board_content = ? where member_no = ?";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, b.getBoardTitle());
			pst.setString(2, b.getBoardContent());
			pst.setInt(3, b.getBoardNo());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}
		
		return result;
	}
	
public int deleteBoard(Connection conn, Board b) {
		
		PreparedStatement pst = null;
		
		int result = 0;
		String query = "update exam_board set board_title = ?, board_content = ? where member_no = ?";
		
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, b.getBoardTitle());
			pst.setString(2, b.getBoardContent());
			pst.setInt(3, b.getBoardNo());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pst);
		}
		
		return result;
	}

}
