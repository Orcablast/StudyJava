package kh.java.game;

import java.util.Scanner;

import java.util.Random;

public class MineSweeper {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	int gameNum;
	int mineNum;
	int winNum;

	boolean boom = false; // 유저가 지뢰를 밟았는지 논리 여부

	boolean win = false; // 유저가 승리했는지 논리 여부

	int blankCount; // 유저의 공백 갯수

	public void main() { // 메인 메뉴
		while (true) {

			blankCount = 0;

			boom = false;

			System.out.println("====== 지뢰 찾기 ======");
			System.out.println("1. 난이도 : 쉬움 (5x5)");
			System.out.println("2. 난이도 : 중간 (7x7)");
			System.out.println("3. 난이도 : 어려움 (10x10)");
			System.out.println("4. 커스텀 난이도");
			System.out.println("5. 게임 설명");
			System.out.println("6. 게임 끝내기");
			System.out.println("===================");
			System.out.print("선택 : ");
			int inputSlt = sc.nextInt();

			switch (inputSlt) {
			case 1:

				gameNum = 5;
				mineNum = 5;
				winNum = 5;

				int easy[][] = new int[gameNum][gameNum]; // 지뢰가 있는 배열 선언

				putMine(easy);

				while (!boom ) {

					blankCount = 0;

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

//					showCurrent(easy); // 화면 출력 메소드, 테스트용

					showScreen(easy);

					userSelect(easy);

					winCount(easy);

					if (blankCount >= (gameNum * gameNum) - winNum) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						showScreen(easy);
						System.out.println("승리하셨습니다!!");
						delay(2000);
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}

				}

				continue;

			case 2:

				gameNum = 7;
				mineNum = 10;
				winNum = 10;

				int mid[][] = new int[gameNum][gameNum]; // 지뢰가 있는 배열 선언

				putMine(mid);

				while (!boom) {

					blankCount = 0;

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

//					showCurrent(mid); // 화면 출력 메소드, 테스트용

					showScreen(mid);

					userSelect(mid);

					winCount(mid);

					if (blankCount >= (gameNum * gameNum) - winNum) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						showScreen(mid);
						System.out.println("승리하셨습니다!!");
						delay(2000);
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}
				}

				continue;

			case 3:

				gameNum = 10;
				mineNum = 25;

				int dif[][] = new int[gameNum][gameNum]; // 지뢰가 있는 배열 선언

				putMine(dif);

				while (!boom) {

					blankCount = 0;

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

//					showCurrent(dif); // 화면 출력 메소드, 테스트용

					showScreen(dif);

					userSelect(dif);

					winCount(dif);

					if (blankCount >= (gameNum * gameNum) - winNum) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						showScreen(dif);
						System.out.println("승리하셨습니다!!");
						delay(2000);
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}
				}
				continue;

			case 4:
				System.out.print("가로x세로 길이를 정하세요 : ");
				gameNum = userSelectNum(sc.nextInt());
				System.out.print("지뢰 갯수를 입력하세요 : ");
				mineNum = userSelectNum(sc.nextInt());
				winNum = mineNum;

				int custom[][] = new int[gameNum][gameNum]; // 지뢰가 있는 배열 선언

				putMine(custom);

				while (!boom) {

					blankCount = 0;

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

//					showCurrent(custom); // 화면 출력 메소드, 테스트용

					showScreen(custom);

					userSelect(custom);

					winCount(custom);

					if (blankCount >= (gameNum * gameNum) - winNum) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						showScreen(custom);
						System.out.println("승리하셨습니다!!");
						delay(2000);
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}
				}

				continue;

			case 5:
				System.out.println("숫자로 표시된 지역에 지뢰가 숨겨져 있으면 패배합니다");
				System.out.println("만일 해당 지역에 지뢰가 없다면 주변 8칸 중  지뢰의 갯수를 표시하고");
				System.out.println("해당 지역 주변 8칸의 안전 지역을 해방합니다");
				System.out.println("모든 안전지역이 해방되면 승리합니다");
				System.out.println("게임을 계속 플레이하시려면 아무키나 입력해주세요");
				if(sc.hasNext()) {
					sc.next();
					continue;
				}
			case 6:
				System.out.println("게임을 종료합니다. Bye~");
				return;

			default: // 메뉴 이외의 정수를 입력했을 경우
				System.out.println("잘못 입력하셨습니다.");

			}
		}
	}

	public void putMine(int arr[][]) { // 배열에 지뢰를 배치하는 난수로직 , 지뢰는 -1

		while (mineNum != 0) {
			int randomRow = rn.nextInt(gameNum - 1);
			int randomColumn = rn.nextInt(gameNum - 1);

			if (arr[randomRow][randomColumn] != -1) {
				arr[randomRow][randomColumn] = -1; // 지뢰값 -1
				mineNum--;
			}

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

				for (int i = 0; (i < gameNum) && userNum != 0; i++) {
					row = i;
					for (int j = 0; (j < gameNum) && userNum != 0; j++) {
						column = j;
						userNum--;
					}
				}

				if (arr[row][column] == -1) {

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("게임 오버!!");
					System.out.println("게임 오버!!");
					System.out.println("게임 오버!!");
					delay(1500);

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

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

	public int check(int arr[][], int row, int column) { // 주변 8칸의 지뢰 갯수를 카운트 하여 int값으로 return
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

	public int userSelectNum(int num) { // 0 이하의 숫자를 입력했을때 재입력을 요구
		while (num < 1) {
			System.out.println("다시 입력하세요.");
			num = sc.nextInt();
		}
		return num;
	}

	public void winCount(int arr[][]) { // 승리 조건을 만듦ㅇㄴㄹㄷㅈ멎 아 졸려 몰라

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 2) {
					blankCount++;
				}
			}
		}

	}
	
	public void delay(int time) { // 딜레이 타임
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
