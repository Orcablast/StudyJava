package kh.java.view;

import java.util.Scanner;

public class View {

	Scanner sc = new Scanner(System.in);

	public int viewMain() {

		System.out.println("\n======= 회원 관리 프로그램 v1.1 =======");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원정보 출력 (전체)");
		System.out.println("3. 회원정보 출력 (1인)");
		System.out.println("4. 회원정보 수정");
		System.out.println("5. 회원탈퇴");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");

		return sc.nextInt();

	}
	
	public String inputInfo(String msg) {
		
		System.out.print(msg);		
		return sc.next();
	}


}
