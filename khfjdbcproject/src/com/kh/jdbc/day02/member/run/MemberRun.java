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
				
				break;
			case 3 : 
				// 이름으로 조회
				
				break;
			case 4 : 
				// 회원 가입
				break;
			case 5 : 
				// 정보 수정
				break;
			case 6 : 
				// 회원 탈퇴
				break;
			default : 
				mView.printMessage("잘못입력하셨습니다. 1 ~ 6 사이의 수를 입력해주세요.");
				break;
			}
		}
	}

}
