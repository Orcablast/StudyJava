package kh.java.view;

import java.util.Scanner;

public class GameView {
	
	Scanner sc = new Scanner(System.in);
	
	public int main() {
		System.out.println("============ 끝말 잇기 게임 ============");
		System.out.println("1. 게임 시작");
		System.out.println("2. 게임 전적");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");
		
		int slt= sc.nextInt();
		
				
		return slt;
	}
	
	public String userTurn() {
		System.out.print("유저 입력 : ");
		
		String str = sc.next();
		
		return str;
	}
	
	public void comTurn(String msg) {
		System.out.println("컴퓨터 차례 : " + msg);		
	}
	
}
