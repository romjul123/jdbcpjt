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
		System.out.println("7. 회원 로그인");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public void showAll(List<Member> mList) {
		System.out.println("== === === 전체 회원 조회 === === ===");
		for(Member mOne : mList) {
			System.out.print("아이디 : " + mOne.getMemberId());
			System.out.print(", 비밀번호 : " + mOne.getMemberPwd());
			System.out.print(", 이름 : " + mOne.getMemberName());
			System.out.print(", 성별 : " + mOne.getMemberGender());
			System.out.print(", 나이 : " + mOne.getMemberAge());
			System.out.print(", 이메일 : " + mOne.getMemberEmail());
			System.out.print(", 전화번호 : " + mOne.getMemberPhone());
			System.out.print(", 주소 : " + mOne.getMemberAddress());
			System.out.print(", 취미 : " + mOne.getMemberHobby());
			System.out.println(" 가입날짜 : " + mOne.getMemberDate());
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
		System.out.println(" 가입날짜 : " + member.getMemberDate());
	}
	
	public Member inputMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === 회원 정보 입력 ==== ===");
		System.out.println("아이디 : " );
		String memberId = sc.next();
		System.out.println("비밀번호 : " );
		String memberPwd = sc.next();
		System.out.println("이름 : " );
		String memberName = sc.next();
		System.out.println("성별 : " );
		String memberGender = sc.next();
		System.out.println("나이 : " );
		int memberAge = sc.nextInt();
		System.out.println("이메일 : " );
		String memberEmail = sc.next();
		System.out.println("전화번호 : " );
		String memberPhone = sc.next();
		System.out.println("주소 : " );
		sc.nextLine();
		String memberAddress = sc.nextLine();
		System.out.println("취미 : " );
		String memberHobby = sc.next();
		Member member = new Member(memberId, memberPwd, memberName, memberGender, memberAge, memberEmail, memberPhone, memberAddress, memberHobby);
		return member;
	}
	
	public Member inputLoginInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === 로그인 정보 입력 === ===");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.next();
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		return member;
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
	
	public Member modifyMember(Member member) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 비밀번호 입력 : ");
		String memberPwd = sc.next();
		System.out.println("수정할 이메일 입력 : ");
		String memberEmail = sc.next();
		System.out.println("수정할 전화번호 입력 : ");
		String memberPhone = sc.next();
		System.out.println("수정할 주소 입력 : ");
		sc.nextLine();
		String memberAddress = sc.nextLine();
		System.out.println("수정할 취미 입력 : ");
		String memberHobby = sc.next();
		member.setMemberPwd(memberPwd);
		member.setMemberEmail(memberEmail);
		member.setMemberPhone(memberPhone);
		member.setMemberAddress(memberAddress);
		member.setMemberHobby(memberHobby);
		return member;
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
