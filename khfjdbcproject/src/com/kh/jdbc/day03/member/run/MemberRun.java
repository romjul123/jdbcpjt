package com.kh.jdbc.day03.member.run;

import java.util.List;

import com.kh.jdbc.day03.member.controller.MemberController;
import com.kh.jdbc.day03.member.model.vo.Member;
import com.kh.jdbc.day03.member.view.MemberView;

public class MemberRun {
	
	public static void main(String [] args) {
		MemberView mView = new MemberView();
		MemberController mCon = new MemberController();
		List<Member> mList = null;
		Member member = null;
		int result = 0;
		String memberId = "";
		String memberName = "";
		gone:
		while(true) {
			int choice = mView.mainMenu();
			switch(choice) {
			case 0 : break gone;
			case 1 : 
				mList = mCon.printAll();
				if(mList.size() > 0) {
					mView.showAll(mList);
				}else {
					mView.displayError("회원 정보가 없습니다.");
				}
				break;
			case 2 : 
				// 회원 아이디로 조회
				memberId = mView.inputMemberId("검색");
				member = mCon.printOneById(memberId);
				if(member != null) {
					mView.showOne(member);
				}else {
					mView.displayError("해당 데이터가 존재하지 않습니다.");
				}
				break;
			case 3 :
				// 회원 이름으로 조회
				memberName = mView.inputMemberName("검색");
				mList = mCon.printMembersByName(memberName);
				if(!mList.isEmpty()) {
					mView.showAll(mList);
				}else {
					mView.displayError("해당 데이터가 존재하지 않습니다.");
				}
				break;
			case 4 : 
				member = mView.inputMember();
				result = mCon.registerMember(member);
				if(result > 0) {
					mView.displayScuccess("가입 성공");
				}else {
					mView.displayError("회원가입이 완료되지 않았습니다.");
				}
				break;
			case 5 : 
				memberId = mView.inputMemberId("수정");
				member = mCon.printOneById(memberId);
				if(member != null) {
					member = mView.modifyMember(memberId);
					result = mCon.modifyMember(member);
					if(result > 0) {
						mView.displayScuccess("정보 수정 성공");
					}else {
						mView.displayError("정보 수정이 완료되지 않았습니다.");
					}
				}else {
					mView.displayError("존재하지 않는 회원입니다.");
				}
				break;
			case 6 : 
				memberId = mView.inputMemberId("삭제");
				result = mCon.removeMember(memberId);
				if(result > 0) {
					mView.displayScuccess("회원 탈퇴 성공");
				}else {
					mView.displayError("회원 탈퇴가 완료되지 않았습니다.");
				}
				break;
			}
		}
	}

}
