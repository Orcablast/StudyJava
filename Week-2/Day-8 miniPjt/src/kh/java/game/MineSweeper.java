package kh.java.game;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import java.util.Random;

public class MineSweeper {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	int gameNum;
	int mineNum;

	public void main() { // 메인 메뉴
		while (true) {
			System.out.println("====== 지뢰 찾기 ======");
			System.out.println("1. 난이도 : 쉬움 (5x5)");
			System.out.println("2. 난이도 : 중간 (10x10)");
			System.out.println("3. 난이도 : 어려움 (15x15)");
			System.out.println("4. 커스텀 난이도");
			System.out.println("5. 게임 끝내기");
			System.out.println("===================");
			System.out.print("선택 : ");
			int inputSlt = sc.nextInt();

			switch (inputSlt) {
			case 1:
				// gameDif = 5;
				// newGame(gameDif);

				gameNum = 5;
				mineNum = 5;

				int back[][] = new int[gameNum][gameNum]; // 지뢰가 있는 배열 선언
				int front[][] = new int[gameNum][gameNum]; // 유저에게 보여줄 배열

				boolean boom= false; // 유저가 지뢰를 밟았는지 논리 여부 

				putMine(back);
				
				while(!boom) { // 유저가 지뢰를 밟을때까지 반복

					showCurrent(back); // 화면 출력 메소드
				}
				
				showScreen(back);

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

	public void putMine(int arr[][]) { // 배열에 지뢰를 배치하는 난수로직 , 지뢰는 -1

		while (mineNum != 0) {
			arr[rn.nextInt(5)][rn.nextInt(5)] = -1; // 지뢰값 -1
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
				
				mineCount=0;
				
				switch(arr[i][j]) {
				case -1:
				case 0:
					if(k<10) {
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
					
					if(mineCount==0) {
						System.out.print("    ");
					} else {
						System.out.print("  " + mineCount + " " );
					}
					k++;
					break;					
				}
				
//				if (arr[i][j] < 1 && k < 10) { // 초기상태 중 k가 10 미만 일 때
//					System.out.print("[");
//					System.out.print("0" + k++);
//					System.out.print("]");
//
//				} else if (arr[i][j] < 1) { // 초기상태
//					System.out.print("[");
//					System.out.print(k++);
//					System.out.print("]");
//				} else if (arr[i][j] == 2) { // 공백상태 (배열값 2)
//					k++;
//					System.out.print("  " + check(arr, i, j) + " " );
//				} else if (arr[i][j] == 0) {
//					k++;
//					System.out.print("[  ]");
//
//				}
			}
			System.out.println();
		}
	}
	
	
	public void userSelect() {
		int userNum=(gameNum*gameNum);
		
		while(true) {
			System.out.println("숫자를 선택하세요! (1~"+(gameNum*gameNum)+")");
			userNum = sc.nextInt();
			
			if(userNum<0 || userNum > (gameNum*gameNum)) {
				System.out.println("잘못된 입력입니다!");
			} else {
				
				
			}
			
		}
		
	}
	
	public int check(int arr[][], int row, int column) {
		int mineCount = 0;
		
		
		for(int r=row-1; r<=row+1; r++ ) {
			
			if(r<0 || r>gameNum-1) {
				
				continue;
				
			} else {
				
				for(int c=column-1; c<=column+1; c++) {
					
					if(c<0 || c>gameNum-1) {
						
						continue;
					}					
					
					if(arr[r][c]==-1) {
						mineCount++;
					}					
				}
			}
		}
		
		
		
		return mineCount;
		
// 		// 최초에 구상한 Boundary 로직
//		if (row == 0 && column == 0) { // row 0, column 0 -> 좌상
//		
//		} else if (row == 0 && column == gameNum - 1) { // row 0, column 4 -> 우상
//
//		} else if (row == gameNum - 1 && column == 0) { // row 4, column 0 -> 좌하
//
//		} else if (row == gameNum - 1 && column == gameNum - 1) { // row 4, column 4 -> 우하
//
//		} else if (row == 0 && (column != 0 || column != gameNum - 1)) { // row 0, 첫번째행
//
//		} else if (row == gameNum - 1 && (column != gameNum - 1 || column != 0)) { // row 4, 마지막행
//
//		} else if (column == 0 && (row != 0 || row != gameNum - 1)) { // column 0, 좌측 첫째열
//
//		} else if (column == gameNum - 1 && (row != 0 || row != gameNum - 1)) {
//
//		}
	}

	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
