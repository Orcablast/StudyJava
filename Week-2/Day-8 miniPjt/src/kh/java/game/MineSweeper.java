package kh.java.game;

import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
	
	int gameNum;
	int mineNum;
	
	int game[][];
	
	public void main() { // 메인 메뉴
		while (true) {
			System.out.println("====== 지뢰 찾기 ======");
			System.out.println("1. 난이도 : 쉬움 (5x5)");
			System.out.println("2. 난이도 : 중간 (10x10)");
			System.out.println("3. 난이도 : 어려움 (15x15)");
			System.out.println("4. 커스텀 난이도");
			System.out.println("5. 게임 끝내기");
			System.out.println("===================");
			System.out.println("선택 : ");
			int inputSlt = sc.nextInt();


			switch (inputSlt) {
			case 1:
				// gameDif = 5;
				// newGame(gameDif);
				
				gameNum = 5;
				mineNum = 5;
				
				int back[][] = new int[gameNum][gameNum]; // 지뢰가 있는 배열 선언
				int front[][] = new int[gameNum][gameNum]; // 유저에게 보여줄 배열
								
				putMine(back);
				
				showCurrent(back); // 화면 출력 메소드
				
				continue;

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
				return;

			default: // 메뉴 이외의 정수를 입력했을 경우
				System.out.println("잘못 입력하셨습니다.");

			}
		}

	}

	public void newGame() {
		int back[][] = new int[gameNum][gameNum];
		int front[][] = new int[gameNum][gameNum];

	}
	
	
	
	public void putMine(int arr[][]) {
		
		while(mineNum!=0) {
			arr[rn.nextInt(5)][rn.nextInt(5)] = -1;
			mineNum--;
		}
		
	}

	
	
	public void showCurrent(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
