package kh.java.array;

import java.util.Scanner;
import java.util.Random;

public class Lotto {
	public void exam01() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();

		while (true) {

			int userNum[] = new int[6];
			int comNum[] = new int[6];
			int countNum = 0;

			System.out.println("=========== 로또 프로그램 ===========");
			for (int i = 0; i < userNum.length; i++) {

				int inputNum;

				System.out.print((i + 1) + "번째 번호 입력 (1~45) : ");
				inputNum = sc.nextInt();

				if (inputNum > 45 || inputNum < 1) {
					System.out.println("잘못 입력하셨습니다");
					i--;
					continue;
				}

				boolean dup = false;

				for (int j = i; j >= 0; j--) {
					if (i == 0) {
						break;
					} else if (inputNum == userNum[j]) {
						System.out.println("이미 중복된 번호입니다. 다시 입력해주세요.");
						dup = true;
						break;
					}
				}

				if (dup == true) {
					i--;
					continue;

				} else {
					userNum[i] = inputNum;
					comNum[i] = rn.nextInt(45) + 1;
					for (int j = i; j > 0; j--) {
						if (comNum[j - 1] == comNum[i]) {
							System.out.println("컴퓨터 같은값");
							comNum[i] = rn.nextInt(45) + 1;
							j = i;
						}
					}
				}
			}

			for (int i = 0; i < userNum.length; i++) {
				for (int j = 0; j < userNum.length; j++) {
					int temp;
					if (userNum[i] == comNum[j]) {
						countNum++;
					}
					if (userNum[i] < userNum[j]) {
						temp = userNum[i];
						userNum[i] = userNum[j];
						userNum[j] = temp;
					}
					if (comNum[i] < comNum[j]) {
						temp = comNum[i];
						comNum[i] = comNum[j];
						comNum[j] = temp;
					}
				}
			}

			System.out.println("사용자 번호");
			for (int i = 0; i < userNum.length; i++) {
				if (i == userNum.length - 1) {
					System.out.print(userNum[i] + "\n");
					break;
				}
				System.out.print(userNum[i] + " ");
			}

			System.out.println("컴퓨터 번호");
			for (int i = 0; i < comNum.length; i++) {
				if (i == comNum.length - 1) {
					System.out.print(comNum[i] + "\n");
					break;
				}
				System.out.print(comNum[i] + " ");
			}

			System.out.print("맞은 갯수 : " + countNum + "\n");

			switch (countNum) {
			case 0:
			case 1:
			case 2:
				System.out.println("꽝!!!");
				break;
			case 3:
				System.out.println("5등!!!");
				break;
			case 4:
				System.out.println("4등!!!");
				break;
			case 5:
				System.out.println("3등!!!");
				break;
			case 6:
				System.out.println("1등!!!");
				break;
			}

			break;
		}
	}

	public void exam02() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();

		int userNum[] = new int[6];
		int comNum[] = new int[6];
		int countToWin = 1; // 1등까지 반복한 횟수 
		
		boolean win = false;

		System.out.println("================= 로또 프로그램 =================");

		for (int i = 0; i < userNum.length; i++) {

			System.out.print((i + 1) + "번째 번호 입력 : ");
			int userInput = sc.nextInt();

			if (userInput > 46 || userInput <= 0) { // 입력단계에서 잘못된 숫자를 입력했을 경우

				System.out.println("잘못 입력하셨습니다 ");
				i--;
				continue;
			}

			for (int j = i; j > 0; j--) {

				if (userNum[j - 1] == userInput) {
					System.out.println("중복된 번호입니다");

					System.out.print((i + 1) + "번째 번호 입력 : ");
					userInput = sc.nextInt();
					j++;

				}
			}

			userNum[i] = userInput;

		}

		while (!win) {
			int countNum = 0;
			
			int temp;
			
			for (int i = 0; i < comNum.length; i++) {

				for (int j = i; j > 0; j--) {
					
					comNum[i] = rn.nextInt(45) + 1;					

					if (comNum[i] == comNum[j - 1]) {
						j=i;
					}
				}

				for (int j = 0; j < comNum.length; j++) {
					
					if (userNum[i] == comNum[j]) {
						countNum++;
					} else if (userNum[i] < userNum[j]) {
						temp = userNum[j];
						userNum[j] = userNum[i];
						userNum[i] = temp;
					}else if (comNum[i] < comNum[j]) {
						temp = comNum[j];
						comNum[j] = comNum[i];
						comNum[i] = temp;
								
					}
				}				
			}
			
			System.out.printf("============ %d회차 ============",countToWin);

			System.out.println("사용자 번호");
			for(int i=0; i<userNum.length; i++) {
				System.out.print(userNum[i]+"  ");
			}
			System.out.println();
			
			System.out.println("컴퓨터 번호");
			for(int i=0; i<userNum.length; i++) {
				System.out.print(comNum[i]+"  ");
			}
			System.out.println();
			
			System.out.print("맞은 갯수 : " + countNum);
			
			switch (countNum) {
			case 0:
			case 1:
			case 2:
				System.out.println("꽝!!!");
				break;
			case 3:
				System.out.println("5등!");
				break;
			case 4:
				System.out.println("4등!!");
				break;
			case 5:
				System.out.println("3등!!");
				break;
			case 6:
				System.out.println("1등!! 축하합니다!!!");
				win = true;
			}
			win = true;
		} // 1등일시 while 종료
	}
	
	public void exam03() {
		
	}
}