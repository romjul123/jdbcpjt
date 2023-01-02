package com.kh.jdbc.day02.member.controller;

import java.util.List;

import com.kh.jdbc.day02.member.model.dao.MemberDAO;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberController {
	
	/**
	 * 회원 전체 조회
	 * @return
	 */
	public List<Member> printAll() {     // SELECT * FROM MEMBER_TBL
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectAll();
		return mList;
	}
		/**
		 * 회원 아이디로 조회
		 * @param memberId
		 * @return
		 */
		public Member printOneById(String memberId) {           // SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?
			// ResultSet이 1개면 Member
			// ResultSet이 1개 이상이면 List<Member>
			MemberDAO mDao = new MemberDAO();
			Member member = mDao.selectOneById(memberId);
			return member;
		}
		
		//	/**
		//	 * 회원 이름으로 조회
		//	 * @param memberName
		//	 * @return
		//	 */
		//	public List<Member> printAllByName(String memberName){
		//		MemberDAO mDao = new MemberDAO();
		//		List<Member> mList = mDao.selectAllByName(memberName);
		//		return mList;
		//	}
		
	   /**
		 * 회원 이름으로 조회
		 * @param memberName
		 * @return
		 */
		public List<Member> printMembersByName(String memberName) {  // SELECT * FROM MEMBER_TBL WHERE MEMBER_NAME = ?
			// ResultSet이 1개면 Member
			// ResultSet이 1개 이상이면 List<Member>
			MemberDAO mDao = new MemberDAO();
			List<Member> mList = mDao.selectMembersByName(memberName);
			return mList;
		}
	/**
	
	 * 회원 가입
	 * @param member
	 * @return
	 */
	public int registerMember(Member member) {  // INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)
		MemberDAO mDao = new MemberDAO();
		int result = mDao.inserMember(member);
		return result;
	}
	/**
	 * 회원정보 수정
	 * @param member
	 * @return
	 */
	public int modifyMemberInfo(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.updateMember(member);
		return result;  // return을 0으로 두지 않는다
	}
	/**
	 * 회원 탈퇴
	 * @param memberId
	 * @return
	 */
	public int removeMember(String memberId) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.deleteMember(memberId);
		return result;
	}
	/**
	 * 회원 로그인
	 * @param member
	 * @return
	 */
	public int checkInfo(Member member) {    // SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PWD = ?
		MemberDAO mDao = new MemberDAO();
		int result = mDao.checkLogin(member);
		return result;
	}

}
