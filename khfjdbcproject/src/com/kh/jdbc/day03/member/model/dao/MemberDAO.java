package com.kh.jdbc.day03.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberDAO {
	
	/**
	 * 회원 전체 조회
	 * @param conn
	 * @return
	 */
	public List<Member> selectAll(Connection conn) {
		List<Member> mList = null;
		String query = "SELECT * FROM MEMBER_TBL";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			mList = new ArrayList<Member>();
			// 후처리
			while(rset.next()) {
			 Member member = new Member();
			 	member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
				mList.add(member);
		}
			stmt.close();
			conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return mList;
	}
	
	public Member selectOneById(Connection conn, String memberId) {
		String sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		Member member = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId); // 쿼리문 실행 준비 완료
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	
	/**
	 * 회원 정보 등록
	 * @param conn
	 * @param member
	 * @return
	 */
	public int insertMember(Connection conn, Member member) {
		// Class.forName()
		// Connection conn = DriverManager
		int result = 0;
		String sql = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			pstmt.setInt(5, member.getMemberAge());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberPhone());
			pstmt.setString(8, member.getMemberAddress());
			pstmt.setString(9, member.getMemberHobby()); // 쿼리문 실행 준비완료
			result = pstmt.executeUpdate(); // 쿼리문 실행
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 회원 탈퇴
	 * @param conn
	 * @param memberId
	 * @return
	 */
	public int deleteMember(Connection conn, String memberId) {
		int result = 0;
		String sql = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 회원정보수정
	 * 
	 */
	public int updateMember(Connection conn, Member member) {
		// UPDATE MEMBER_TBL SET MEMBER_PWD = ?, MEMBER_EMAIL = ?, MEMBER_PHONE = ?, MEMBER_ADDRESS = ?, MEMBER_HOBBY = ? WHERE MEMBER_ID = ?
		String sql = "UPDATE MEMBER_TBL SET MEMBER_PWD = ?, MEMBER_EMAIL = ?, MEMBER_PHONE = ?, MEMBER_ADDRESS = ?, MEMBER_HOBBY = ? WHERE MEMBER_ID = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddress());
			pstmt.setString(5, member.getMemberHobby());
			pstmt.setString(6, member.getMemberId());  // 쿼리문 실행 준비완료
			result = pstmt.executeUpdate();            // 쿼리문 실행
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
