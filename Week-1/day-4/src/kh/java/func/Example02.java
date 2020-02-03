package kh.java.func;

import java.util.Scanner;

public class Example02 {
	public void exam01() { // while문 예제 01)
		int i = 1; // 1.변수 i의 값을 1이라 선언
		// 2. (조건문) 변수 i의 값이 5보다 작거나 같은지 비교
		// 3. 2의 결과가 true이면 while문 내의 명령어를 수행 후 다시 조건문 2로 반복
		// 4. 2의 결과 false이면 while문 내의 명령어를 수행하지 않음
		while (i <= 5) {
			System.out.println(i + "번째 반복 중");
			i++;
		}
	}

	public void exam02() { // 연습문제 01)
		int i = 1;
		while (i <= 5) {
			System.out.println("안녕하세요!");
			i++;
		}
	}
	
	public void exam03() { // 연습문제 02)
		Scanner sc = new Scanner(System.in);
		System.out.print("몇번 출력 하시겠습니까? : ");
		int selectNum = sc.nextInt();
		int i = 1;
		while(i <= selectNum) {
			System.out.println("안녕하세요! "+ i +"번째 출력");			
			i++;
		}		
	}
	
	public void exam04() { // 연습문제 03)
		System.out.println("구구단 2단 출력하기");
		System.out.println("2단 입니다.");
		int i = 1;
		while(i<=9) {
			System.out.println("2 * " + i + " = " + i*2);
			i++;
		}
	}
	
	public void exam05() { // 연습문제 04
		Scanner sc = new Scanner(System.in);
		System.out.print("몇단을 출력하시겠습니까? : ");
		int selectNum = sc.nextInt();
		System.out.println("===========================");
		System.out.println(selectNum+"단 입니다.");
		int i = 1;
		while(i<=9) {
			System.out.println(selectNum + " * " + i + " = " + (selectNum*i));
			i++;
		}
	}
	
	public void exam06() { // 연습문제 05)
		Scanner sc = new Scanner(System.in);
		int i = 1;
		int sum = 0;
		while (i<=5) {
			System.out.print("정수 값을 입력하시오 : ");		
			int num = sc.nextInt();
			sum += num;
			i++;
		}
		System.out.println("입력한 5개의 정수의 합 : " + sum);
	}
	
	public void exam07() { // 연습문제 06
		Scanner sc = new Scanner(System.in);		
		System.out.print("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		int i = num1;
		int sum = 0;
		while(i<=num2) {
			sum += i;
			i++;
		}		
		System.out.println(num1 + " ~ " + num2 + "의 정수의 합 : " + sum);
	}
	
	public void exam08() { // 연습문제 07
		Scanner sc= new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		int div = num/2;
		int sum = 0;
		int i = 1;		
		while(i<=div) {
			sum += (i*2);
			i++;
		}
		System.out.println("짝수들의 합은 : " + sum);
	}
}
