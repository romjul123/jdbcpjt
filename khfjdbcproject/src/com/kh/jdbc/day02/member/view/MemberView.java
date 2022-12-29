package com.kh.jdbc.day02.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day01.student.model.vo.Student;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberView {
	
	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === === 회원관리 프로그램 === === ===");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 아이디로 조회");
		System.out.println("3. 회원 이름으로 조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public void showAll(List<Member> mList) {
		System.out.println("== === === 회원 전체 조회 === === ===");
		for(Member mOne : mList) {
//			System.out.println(member.toString());
			System.out.print("아이디 : " + mOne.getMemberId());
			System.out.print(", 비밀번호 : " + mOne.getMemberPwd());
			System.out.print(", 이름 : " + mOne.getMemberName());
			System.out.print(", 성별 : " + mOne.getMemberGender());
			System.out.print(", 나이 : " + mOne.getMemberAge());
			System.out.print(", 이메일 : " + mOne.getMemberEmail());
			System.out.print(", 전화번호 : " + mOne.getMemberPhone());
			System.out.print(", 주소 : " + mOne.getMemberAddress());
			System.out.print(", 취미 : " + mOne.getMemberHobby());
			System.out.println("가입날짜 : " + mOne.getMemberDate());
		}
	}
	
	public void showOne(Member member) {
		System.out.println(member.toString());
		System.out.print("아이디 : " + member.getMemberId());
		System.out.print(", 비밀번호 : " + member.getMemberPwd());
		System.out.print(", 이름 : " + member.getMemberName());
		System.out.print(", 성별 : " + member.getMemberGender());
		System.out.print(", 나이 : " + member.getMemberAge());
		System.out.print(", 이메일 : " + member.getMemberEmail());
		System.out.print(", 전화번호 : " + member.getMemberPhone());
		System.out.print(", 주소 : " + member.getMemberAddress());
		System.out.print(", 취미 : " + member.getMemberHobby());
		System.out.println("가입날짜 : " + member.getMemberDate());
	}
	
	
	public String inputMemberId(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message + "할 아이디 입력 : ");
		String memberId = sc.next();
		return memberId;
	}
	
	
	public String inputMemberName(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message + "할 이름 입력 : ");
		String memberName = sc.next();
		return memberName;
	}
	
	public void printMessage(String msg){
		System.out.println(msg);
	}
	
	public void displayScuccess(String message) {
		System.out.println("[서비스 성공] : " + message);
	}
	public void displayError(String message) {
		System.out.println("[서비스 실패] : " + message);
	}
	
}
