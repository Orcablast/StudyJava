package kh.java.func;

import java.util.Scanner;

public class Example03 {
	public void exam01() { // 중첩 for문
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.println("i = " + i + " / j = " + j);
			}
		}
	}

	public void exam02() { // 무한 루프문 01
		while (true) {
		}
	}

	public void exam03() { // 무한루프문 02
		for (;;) {
		}
	}

	public void exam04() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("반복");
			System.out.println("한번 더? [y/n] : ");
			char ch = sc.next().charAt(0);
			if (ch == 'n') {
				break;
			}
		}
		System.out.println("프로그램이 종료되었습니다.");
	}

	public void exam05() { // 반복출력 break
		for (int i = 1; i <= 10; i++) {
			System.out.println(i+"출력");
			if (i == 5) {
				break;
			}
			System.out.println("test");
		}
		System.out.println("프로그램 종료");
	}
	
	public void exam06() { // 반복 출력 continue
		for (int i = 1; i <= 10; i++) {
			System.out.println(i+"출력");
			if (i == 5) {
				continue;
			}
			System.out.println("test");
		}
		System.out.println("프로그램 종료");
	}
	
	public void exam07() { // 반복 출력 continue
		for (int i = 1; i <= 10; i++) {
			System.out.println(i+"출력");
			if (i%2 == 0) {
				continue;
			}
			System.out.println("홀수");
		}
		System.out.println("프로그램 종료");
	}
}
