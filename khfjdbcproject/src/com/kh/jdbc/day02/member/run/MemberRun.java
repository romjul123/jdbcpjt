package com.kh.jdbc.day02.member.run;

import java.util.List;

import com.kh.jdbc.day02.member.controller.MemberController;
import com.kh.jdbc.day02.member.model.vo.Member;
import com.kh.jdbc.day02.member.view.MemberView;

public class MemberRun {
	public static void main(String [] args) {
		MemberView mView = new MemberView();
		MemberController mCon = new MemberController();
		Member member = null;
		List<Member> mList = null;
		String memberId = "";
		String memberName = "";
		int result = 0;
		goodbye :
		while(true) {
			int choice = mView.mainMenu();
			switch(choice) {
			case 0 : 
				// 프로그램 종료
				break goodbye;
			case 1 : 
				// 회원 전체 조회
				mList = mCon.printAll();
				if(!mList.isEmpty()) {
					mView.showAll(mList);
				}else {
					mView.displayError("데이터가 존재하지 않습니다.");
				}
				break;
			case 2 : 
				// 아이디로 조회
				memberId = mView.inputMemberId("검색");
				member = mCon.printOneById(memberId);
				if(member != null) {
					mView.showOne(member);
				}else {
					mView.displayError("일치하는 회원이 존재하지 않습니다.");
				}
				break;
			case 3 : 
				// 이름으로 조회
				memberName = mView.inputMemberName("검색");
				mList = mCon.printMembersByName(memberName);
				if(mList.size() > 0) {
					mView.showAll(mList);
				}else {
					mView.displayError("일치하는 회원이 존재하지 않습니다.");
				}
				break;
			case 4 : 
				// 회원 가입
				member = mView.inputMember();
				result = mCon.registerMember(member);
				if(result > 0) {
					// 성공
					mView.displayScuccess("회원 가입 성공");
				}else
					// 실패
					mView.displayError("회원 가입 실패");
				break;
			case 5 : 
				// 정보 수정
				// 아이디를 입력받고
				memberId = mView.inputMemberId("수정");
				// 데이터가 존재하면
				member = mCon.printOneById(memberId);
				if(member != null) {
					// 수정할 데이터 입력 받기
					member = mView.modifyMember(memberId);
					// 입력받은 데이터로 수정하기
					result = mCon.modifyMemberInfo(member);
				    	mView.displayScuccess("수정 성공");
				    }else {
				    	mView.displayError("수정이 되지 않았습니다.");
				    }
				break;
			case 6 : 
				// 회원 탈퇴
				memberId = mView.inputMemberId("삭제");
				result = mCon.removeMember(memberId);
				if (result > 0) {
					mView.displayScuccess("탈퇴 완료");
				}else {
					mView.displayError("탈퇴되지 않았습니다.");
				}
				break;
			case 7 :
				member = mView.inputLoginInfo();
				result = mCon.checkInfo(member);
				if(result > 0) {
					//로그인 성공
					mView.displayScuccess("로그인 성공");
				}else {
					//로그인 실패
					mView.displayError("일치하는 정보가 존재하지 않습니다.");
				}
				break;
			default : 
				mView.printMessage("잘못입력하셨습니다. 1 ~ 7 사이의 수를 입력해주세요.");
				break;
			}
		}
	}

}
