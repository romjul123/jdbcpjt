package com.kh.jdbc.day02.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberDAO {
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "STUDENT";
	private final String PASSWORD = "STUDENT";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	public List<Member> selectAll() {
		String sql = "SELECT * FROM MEMBER_TBL";
		Member member = null;
		List<Member> mList = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			mList = new ArrayList<Member>();
			while(rset.next()) {
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
				mList.add(member);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	
//	public List<Member> selectAllByName(String memberName) {
//		List<Member> mList = null;
//		Member member = null;
//		String sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_NAME = '"+memberName+"'";
//		try {
//			Class.forName(DRIVER_NAME);
//			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			Statement stmt = conn.createStatement();
//			ResultSet rset = stmt.executeQuery(sql);
//			mList = new ArrayList<Member>();
//			while(rset.next()) {
//				member = new Member();
//				member.setMemberId(rset.getString("MEMBER_ID"));
//				member.setMemberPwd(rset.getString("MEMBER_PWD"));
//				member.setMemberName(rset.getString("MEMBER_NAME"));
//				member.setMemberGender(rset.getString("MEMBER_GENDER"));
//				member.setMemberAge(rset.getInt("MEMBER_AGE"));
//				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
//				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
//				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
//				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
//				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
//				mList.add(member);
//			}
//			rset.close();
//			stmt.close();
//			conn.close();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return mList;
//	}
	
	public Member selectOneById(String memberId) {
		Member member = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId); // 쿼리문 실행 준비
			ResultSet rset = pstmt.executeQuery(); // 쿼리문 실행
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString(1));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
//				rset.getChar() (X)
			}
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public List<Member> selectMembersByName(String memberName) {
		List<Member> mList = null;
		String sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_NAME LIKE ?";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+memberName+"%");   // 쿼리문 실행 준비
			ResultSet rset = pstmt.executeQuery();  // 쿼리문 시행
			mList = new ArrayList<Member>();
			// ResultSet에 있는 것을 그대로 쓰지 못하기 때문에 매핑작업을 해줌(후처리)
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
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	
	public int checkLogin(Member member) {
		String query = "SELECT COUNT(*) AS M_COUNT FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd()); // 쿼리문 실행 준비
			ResultSet rset = pstmt.executeQuery();     // 쿼리문 실행
			if(rset.next()) {
				result = rset.getInt("M_COUNT");
			}
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int inserMember(Member member) {
		String sql = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
//		String sql = "INSERT INTO MEMBER_TBL VALUES('"+member.getMemberId()+"', '"+member.getMemberPwd()+"', '"+member.getMemberName()+"', '"+member.getMemberGender()+"', "+member.getMemberAge()+", '"+member.getMemberEmail()+"', '"+member.getMemberPhone()+"', '"+member.getMemberAddress()+"', '"+member.getMemberHobby()+"', DEFAULT)";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			pstmt.setInt(5, member.getMemberAge());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberPhone());
			pstmt.setString(8, member.getMemberAddress());
			pstmt.setString(9, member.getMemberHobby());            // 쿼리문 실행준비
			result = pstmt.executeUpdate();                        // 쿼리문 실행, sql 필요없음
//			Statement stmt = conn.createStatement();
			// DML(INSERT, UPDATE, DELETE)은 execute() -> int 반환
//			result = stmt.executeUpdate(sql);
//			stmt.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteMember(String memberId) {
		String sql = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		int result = 0;
//		String sql = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = '"+memberId+"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);    // 실행준비X
			pstmt.setString(1, memberId);           // 쿼리문 실행 준비
			result = pstmt.executeUpdate();                 // 쿼리문 실행
//			Statement stmt = conn.createStatement();
//			result = stmt.executeUpdate(sql);
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateMember(Member member) {
		int result = 0;
		String query = "UPDATE MEMBER_TBL SET MEMBER_PWD = ?, MEMBER_EMAIL = ?, MEMBER_PHONE = ?, MEMBER_ADDRESS = ?, MEMBER_HOBBY = ? WHERE MEMBER_ID = ?";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddress());
			pstmt.setString(5, member.getMemberHobby());
			pstmt.setString(6, member.getMemberId());   // 쿼리문 실행 준비 완료
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
