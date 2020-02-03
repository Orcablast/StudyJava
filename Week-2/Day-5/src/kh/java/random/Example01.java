package kh.java.random;

import java.util.Random;
import java.util.Scanner;

public class Example01 {
	public void exam01() {
		Random r = new Random();
		// r.nextInt(); 랜덤숫자 생성 -> 정수형 범위와 동일(int)
		// -2^31 ~ 2^31-1
		int rndNum = r.nextInt();
		System.out.println(rndNum);
		// 0부터 10개 숫자중 랜덤숫자 추출
		// 0 1 2 3 4 5 6 7 8 9
		rndNum = r.nextInt(10);
		System.out.println(rndNum);
		// 0~31까지중의 랜덤숫자 추출
		rndNum = r.nextInt(32);
		System.out.println(rndNum);
	}

	public void exam02() { // 난수의 범위를 설정하는 예제
		Random r = new Random();
		int rndNum = r.nextInt(10);
		System.out.print("0~9까지의 랜덤 수를 출력합니다 :" + rndNum);
		System.out.println();
		// 0~9까지의 난수를 출력한 후 1을 더하여 rndNum에 저장
		rndNum = r.nextInt(10) + 1;
		System.out.print("1~10까지의 랜덤 수를 출력합니다 : " + (rndNum));
		System.out.println();
		// 0~15까지의 난수를 출력한 후 20을 더하여 rndNum에 저장
		rndNum = r.nextInt(16) + 20;
		System.out.print("20~35까지의 랜덤 수를 출력합니다 : " + (rndNum));
		System.out.println();
		rndNum = r.nextInt(2);
		System.out.print("0 또는 1 : " + rndNum);
	}

	public void exam03() { // 난수를 설정하고 사용자가 입력한 정수와 비교하는 문제
		Scanner sc = new Scanner(System.in); // Scanner를 약어 sc로 정의
		Random r = new Random(); // Random을 약어 r 로 정의
		System.out.println("== 동전 앞뒤 맞추기 ==");
		System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : ");		
		int sltNum = sc.nextInt(); // 사용자가 입력한 값을 sltNum으로 선언
		// 0~1까지의 난수에 1을 더한값을 rndNum으로 선언
		int rndNum = r.nextInt(2) + 1;		
		if (sltNum == rndNum) { // 사용자가 입력한 값과 난수 저장값을 비교하여 true일 때 
			System.out.println("맞췄습니다!");
		} else if (sltNum != rndNum) { // 사용자가 입력한 값과 난수 저장값을 비교하여 false일 때
			System.out.println("땡! 틀렸어요~~");
		} else { // 1이나 2 이외의 값을 입력하지 않았을 경우
			System.out.println("1이나 2를 입력하세요");
		}
	}

	public void exam04() { // exam03에 반복/종료 선택할수 있는 기능을 추가
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int restNum = 1;
		while (true) {
			System.out.println("== 동전 앞뒤 맞추기 ==");
			System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : ");
			int sltNum = sc.nextInt();
			int rndNum = r.nextInt(2) + 1;
			if (sltNum == rndNum) {
				System.out.println("맞췄습니다!");
			} else {
				System.out.println("땡! 틀렸어요~~");
			}
			System.out.print("계속하려면 1, 그만두려면 2를 입력하세요 : ");
			restNum = sc.nextInt();
			if (restNum == 2) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
	}
	
	public void exam05() {
		Scanner sc = new Scanner(System.in); // Scanner를 약어 sc로 정의
		Random r = new Random(); // Random을 약어 r 로 정의
		while(true) {
			System.out.println("== 동전 앞뒤 맞추기 ==");
			System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : ");		
			int sltNum = sc.nextInt(); // 사용자가 입력한 값을 sltNum으로 선언
			// 0~1까지의 난수에 1을 더한값을 rndNum으로 선언
			int rndNum = r.nextInt(2) + 1;		
			if (sltNum == rndNum) { // 사용자가 입력한 값과 난수 저장값을 비교하여 true일 때 
				System.out.println("맞췄습니다!");
			} else if (sltNum != rndNum) { // 사용자가 입력한 값과 난수 저장값을 비교하여 false일 때
				System.out.println("땡! 틀렸어요~~");
			} else { // 1이나 2 이외의 값을 입력하지 않았을 경우
				System.out.println("1이나 2를 입력하세요");
			}
			System.out.print("한번 더 [y/n] ? :");
			char sel = sc.next().charAt(0);
			if (sel=='n') {
				System.out.println("프로그램을 종료합니다");
				break;
			} else if (sel=='y') {
				continue;
			}
				
		}
	}
}
