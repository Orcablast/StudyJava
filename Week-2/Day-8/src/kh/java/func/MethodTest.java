package kh.java.func;

import java.util.Scanner;

public class MethodTest {
	public void main() { //
		Scanner sc = new Scanner(System.in); // Scanner의 호출 약어를 sc로 정이

		System.out.print("첫번째 정수  : ");
		int num1 = sc.nextInt();

		System.out.print("두번째 정수  : ");
		int num2 = sc.nextInt();

		System.out.println("연산자를 입력하세요");
		System.out.print("[+, -, *, /] : ");
		char oper = sc.next().charAt(0);

		System.out.println("======= 결과 출력 =======");
		switch (oper) {
		case '+':
			int sum = sum(num1, num2);
			System.out.println(num1 + " + " + num2 + " = " + sum);
			break;
		case '-':
			int sub = sub(num1, num2);
			System.out.println(num1 + " - " + num2 + " = " + sub);
			break;
		case '*':
			int multi = multi(num1, num2);
			System.out.println(num1 + " * " + num2 + " = " + multi);
			break;
		case '/':
			double div = div(num1, num2);
			System.out.printf(num1 + " / " + num2 + " = %.2f",div);
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");

		}

	}

	public int sum(int num1, int num2) {
		System.out.println("정수 3개 더하는 메소드");
		int result = num1 + num2;
		return result;
	}
	
	// method overloading
	// 메소드 명이 같아도 매개변수 자료형과 매개변수의 갯수에 따라 자동으로 해당 메소드를 실행 
	public int sum(int num1, int num2, int num3) {
		System.out.println("정수 3개 더하는 메소드");
		int result = num1 + num2 + num3;
		return result;
	}

	public int sub(int num1, int num2) {
		return num1 - num2;
	}

	public int multi(int num1, int num2) {
		return num1 * num2;
	}

	public double div(int num1, int num2) {
		return (double) num1 / num2;
	}
}
