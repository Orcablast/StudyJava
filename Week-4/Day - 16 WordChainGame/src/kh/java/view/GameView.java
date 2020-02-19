package kh.java.view;

import java.util.Scanner;

public class GameView {

	Scanner sc = new Scanner(System.in);

	// 유저에게 메뉴를 보여주고 선택값을 입력받아 return
	public int main(){

		System.out.println("============ 끝말 잇기 게임 ============");
		System.out.println("1. 게임 시작");
		System.out.println("2. 게임 전적");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");

		int slt = sc.nextInt();

		return slt;
	}
	
	// 유저에게 단어를 입력받아 return
	public String userTurn() {
		System.out.print("유저 입력 : ");

		String str = sc.next();

		return str;
	}

	// 컴퓨터가 출력한 단어를 유저에게 보여주는 메소드
	public void comTurn(String msg) {
		System.out.println("컴퓨터 차례 : " + msg);
	}

	// 유저 전적을 출력하는 메소드
	public void showScore(int countWin, int countLose) {
		System.out.println("승리 횟수 : " + countWin);
		System.out.println("패배 횟수 : " + countLose);
	}

}
