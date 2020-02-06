package kh.java.game;

import java.util.Scanner;

import java.util.Random;

public class MineSweeper {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	int gameNum;
	int mineNum;

	boolean boom = false; // 유저가 지뢰를 밟았는지 논리 여부

	public void main() { // 메인 메뉴
		while (true) {
			
			boom = false;
					
			System.out.println("====== 지뢰 찾기 ======");
			System.out.println("1. 난이도 : 쉬움 (5x5)");
			System.out.println("2. 난이도 : 중간 (7x7)");
			System.out.println("3. 난이도 : 어려움 (10x10)");
			System.out.println("4. 커스텀 난이도");
			System.out.println("5. 게임 끝내기");
			System.out.println("===================");
			System.out.print("선택 : ");
			int inputSlt = sc.nextInt();
			
			switch (inputSlt) {
			case 1:
				
				gameNum = 5;
				mineNum = 5;

				int easy[][] = new int[gameNum][gameNum]; // 지뢰가 있는 배열 선언

				putMine(easy);

				while (!boom) {

					showCurrent(easy); // 화면 출력 메소드, 테스트용

					showScreen(easy);

					userSelect(easy);
				}

				continue;

			case 2:

				gameNum = 7;
				mineNum = 12;

				int mid[][] = new int[gameNum][gameNum]; // 지뢰가 있는 배열 선언

				putMine(mid);

				while (!boom) {

					showCurrent(mid); // 화면 출력 메소드, 테스트용

					showScreen(mid);

					userSelect(mid);
				}

				continue;

			case 3:

				gameNum = 10;
				mineNum = 25;

				int dif[][] = new int[gameNum][gameNum]; // 지뢰가 있는 배열 선언

				putMine(dif);

				while (!boom) {

					showCurrent(dif); // 화면 출력 메소드, 테스트용

					showScreen(dif);

					userSelect(dif);
				}

				continue;

			case 4:
				System.out.println("미구현 ㅎㅎ... ㅈㅅ!!");
				break;

			case 5:
				return;

			default: // 메뉴 이외의 정수를 입력했을 경우
				System.out.println("잘못 입력하셨습니다.");

			}
		}
	}

	public void putMine(int arr[][]) { // 배열에 지뢰를 배치하는 난수로직 , 지뢰는 -1

		while (mineNum != 0) {
			arr[rn.nextInt(gameNum-1)][rn.nextInt(gameNum-1)] = -1; // 지뢰값 -1
			mineNum--;
		}

	}

	public void showCurrent(int arr[][]) { // 지뢰 위치를 스크린에 표시, 테스트용
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void showScreen(int arr[][]) { // 사용자 화면
		int k = 1;

		int mineCount;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {

				mineCount = 0;

				switch (arr[i][j]) {
				case -1:
				case 0:
					if (k < 10) {
						System.out.print("[");
						System.out.print("0" + k++);
						System.out.print("]");
					} else {
						System.out.print("[");
						System.out.print(k++);
						System.out.print("]");
					}
					break;

				case 2:
					mineCount = check(arr, i, j);

					if (mineCount == 0) {
						System.out.print("    ");
					} else {
						System.out.print("  " + mineCount + " ");
					}
					k++;
					break;
				}
			}
			System.out.println();
		} // 2중 for문 종료시점
	}

	public void userSelect(int arr[][]) { // 사용자가 입력한 값에 해당하는 배열에 지뢰가 있는지 확인
		int userNum;

		while (true) {
			System.out.println("숫자를 선택하세요! (1~" + (gameNum * gameNum) + ")");
			userNum = sc.nextInt();

			if (userNum < 0 || userNum > (gameNum * gameNum)) {
				System.out.println("잘못된 입력입니다!");
				continue;
			} else {

				int row = 0;
				int column = 0;

				for (int i=0; (i<gameNum) && userNum!=0; i++) {
					row = i;
					for (int j=0; (j<gameNum) && userNum!=0; j++) {
						column = j;
						userNum--;
					}
				}
				
				if (arr[row][column] == -1) {

					System.out.println("게임 오버!!");

					boom = true;
					return;

				} else if (arr[row][column] == 0) {
					arr[row][column] = 2;
					check2(arr, row, column);
					return;

				} else {
					System.out.println("잘못 입력하셨습니다");
				}
			}
		}
	}

	public void userNumChk(int num, int arr[][]) { // 폐기 로직
		int row = 0;
		int column = 0;

		for (int i = 0; i < gameNum - 1; i++) {

			if (num == 0) {
				break;
			} else {
				row++;
				num--;
			}

			for (int j = 0; j < gameNum - 1; j++) {

				if (num == 0) {
					break;
				} else {
					column++;
					num--;
				}
			}
		}

		if (arr[row][column] == -1) {
			boom = true;
			return;
		} else if (arr[row][column] == 0) {
			arr[row][column] = 2;
			return;
		} else {
			System.out.println("잘못 입력하셨습니다");
		}
	}

	public int check(int arr[][], int row, int column) {
		int mineCount = 0;

		for (int r = row - 1; r <= row + 1; r++) {

			if (r < 0 || r > gameNum - 1) {

				continue;

			} else {

				for (int c = column - 1; c <= column + 1; c++) {

					if (c < 0 || c > gameNum - 1) {

						continue;
					}

					if (arr[r][c] == -1) {
						mineCount++;
					}
				}
			}
		}

		return mineCount;
	}
	
	public void check2(int arr[][], int row, int column) { // 주변 공백을 자동으로 오픈하는 로직 check 로직 활용
		for (int r = row - 1; r <= row + 1; r++) {

			if (r < 0 || r > gameNum - 1) {

				continue;

			} else {

				for (int c = column - 1; c <= column + 1; c++) {

					if (c < 0 || c > gameNum - 1) {

						continue;
					}

					if (arr[r][c] == 0) {
						arr[r][c] = 2;
					}
				}
			}
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
