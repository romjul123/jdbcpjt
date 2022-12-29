package com.kh.jdbc.day02.member.controller;

import java.util.List;

import com.kh.jdbc.day02.member.model.dao.MemberDAO;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberController {
	
	/**
	 * 회원 전체 조회
	 * @return
	 */
	public List<Member> printAll() {
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectAll();
		return mList;
	}
	/**
	 * 회원 이름으로 조회
	 * @param memberName
	 * @return
	 */
	public List<Member> printAllByName(String memberName){
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectAllByName(memberName);
		return mList;
	}
	
//	public Member printOneById(String memberId) {
//		MemberDao mDao = new MemberDao();
//		Member member = sDao.
//	}

}
