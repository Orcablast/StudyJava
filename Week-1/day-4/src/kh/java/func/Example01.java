package kh.java.func;

import java.util.Scanner;

public class Example01 {
	public void exam01() { // for문 예제 1)
		// 1. 변수 i 값을 정수 1로 선언 (초기문)
		// 2. i값이 50보다 작거나 같은지 비교 = true or false (조건문)
		// 3. 조건문이 true일 경우 for문 내의 명령어를 실행 -> i++(증감문)을 실행하고 조건문으로 회귀(2로)
		// 4. 조건문이 false일 경우 for문 내의 명령어를 실행하지 않음 (종료)
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 반복해서 수행 중");
		}
	}

	public void exam02() {// 루프가 무한히 반복되는 잘못된 조건문
		for (int i = 1; i <= 5; i--) {
			System.out.println(i + "번째 반복해서 수행 중");
		}
	}

	public void exam03() { // 연습문제 01)
		// 변수 i의 값을 5로 선언하고 (초기문), i가 5보다 작거나 같은지 비교 (조건), 조건문이 true라면 for문 내의 명령어를 실행
		for (int i = 1; i <= 5; i++) { 
			System.out.println("안녕하세요");
		}
	}

	public void exam04() { // 연습문제 02
		Scanner sc = new Scanner(System.in); 
		System.out.print("몇번 출력하시겠습니까? : "); 
		int num = sc.nextInt(); // 입력한 값을 변수 num으로 선언
		// 변수 i의 값을 1로 선언 (초기문), i가  사용자가 입력하여 저장된 변수 num보다 작거나 같은지 비교 (조건)
		// 조건문이 true라면 for문 내의 명령어를 실행 후 i값을 1 증가하여 저장 -> 조건문으로 반복
		for (int i = 1; i <= num; i++) {
			System.out.println("안녕하세요! " + i + "번째!"); // for문이 반복될때마다 문자열을 출력
		}

	}

	public void exam05() { // 연습문제 03
		System.out.println("구구단 2단 출력하기");
		
		// 변수 i의 값을 0 으로 선언 (초기문), 변수 i가 9보다 작거나 같은지 비교 (조건문)
		// 조건문의 결과가 true 라면 for문 내의 명령어를 실행 후 i값을 1 증가하여 저장 -> 조건문으로 반복
		for (int i = 0; i <= 9; i++) {
			if (i == 0) { // i의 값이 0과 같을때 if문 내의 명령어를 실행
				System.out.println("2단 입니다!"); 				
			} else { // i의 값이 0이 아닐 모든 경우 else문 내의 명령어를 실행
				System.out.println("2 * " + i + " = " + (i * 2)); // 2 * 변수 i = i * 2
			}
		}

	}

	public void exam06() { // 연습문제 04
		Scanner sc = new Scanner(System.in);
		System.out.println("======= 구구단 계산기 =======");
		System.out.print("몇 단을 출력하시겠습니까? : ");
		int selectNum = sc.nextInt(); // 입력받은 값을 정수타입 변수 selectNum으로 선언
		// 변수 i의 값을 0으로 선언 (초기문), 변수 i의 값이 9보다 작거나 같은지 비교 (조건문)
		// 조건문의 결과가 true 일때 for문 내의 명령어를 실행 후 i값을 1 증가하여 저장 -> 조건문으로 반복 
		for (int i = 0; i <= 9; i++) {
			if (i == 0) { // 변수 i의 값이 0일때 if문 내의 명령어를 실행
				System.out.println("==========================");
				System.out.println(selectNum + "단입니다");
			} else { // 변수 i의 값이 0이 아닐때 모든 경우 else문 내의 명령어를 실행
				System.out.println(selectNum + " * " + i + " = " + selectNum * i);
			}
		}
	}
	
	public void exam07() { // 연습문제 05
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <= 5; i++ ) { 
			System.out.print("정수 값을 입력하세요 : ");
			int num = sc.nextInt();
			sum += num;	
		}
		System.out.println("입력한 5개의 정수의 합 : " + sum);
	}
	
	public void exam08() { // 연습문제 06
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		int sum = 0;
		for(int i=num1 ; i<=num2; i++) {
			sum += i;
		}		
		System.out.println("정수의 합 : " + sum);
	}
	
	public void exam09() { // 연습문제 06
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		int even = num/2;
		int sum = 0;
		for (int i=1; i<=even; i++) {
			sum += (i*2);			
		}
		System.out.println("짝수들의 합은 = " + sum);
	}	
}
