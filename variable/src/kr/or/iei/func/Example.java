package kr.or.iei.func;

import java.util.Scanner;

public class Example {
	public void exam1() {
		int num1; // num1 이라는 int 변수를 선언
		num1 = 10; // num1 변수의 값을 초기화
		char ch1 = '1'; // char 타입의 ch1 변수의 값을 '1'로 선언
		long num2 = 10000L; // long 타입의 num2 변수의 값을 10000으로 선언
		float num3 = 3.14f; // float 타입의 num3 변수의 값을 3.14로 선언
		final double PI = 3.14; // double 타입의 PI 변수의 값을 3.14로 불변 선언
		System.out.println("정수 출력 : "+(num1+num1)); // 문자열 + 정수 연산의 값을 출력
		System.out.println("문자 출력 : " +(ch1+ch1)); // 문자열 + char 타입 정수연산 값을 출력
		System.out.println(num2); //
		System.out.println(num3);
		System.out.println(PI);
	}
	
	public void exam2() {
		String name = "이도형"; // String 타입 name 변수의 값을 이도형 으로 선언
		int age = 30; // int 타입 age 변수의 값을 30 으로 선언
		String address = "경기도 부천시"; // String 타입 address 변수의 값을 경기도 부천시로 선언
		char gender = '3'; // char 타입 gender 변수의 값을 남 으로 선언
		System.out.println("제 이름은 "+ name +" 이고 나이는 " + age + "살, " + address + "에 살고있는 " + gender + "성입니다.");
		System.out.println((int)gender);
	}
	
	public void exam3() {
		int num = 2147483647; // int타입의 num 변수에 2147834647 (MAX.VALUE)를 선언
		int result = num+1; // num 값에 + 1을 연산 (overflow 발생)
		System.out.println(result); // 원하는 값이 나오지 않음
	}
	
	public void exam4() {
		int num = 2147483647;
		long result = (long)num + 1; // overflow가 발생하지 않도록 num을 long 타입으로 형변환
		System.out.println(result);
	}
	
	public void exam5() {
		int num1 = 10;
		int num2 = 20;
//		System.out.println("정수형 변수 num안에 들어있는 값은 " + num + "입니다.");
//		System.out.printf("정수형 변수 num안에 들어있는 값은 %d입니다.",num);
		System.out.println(num1 + "+" + num2 + "=" + (num1+num2) + " 입니다.");
		// printf 메소드는 행을 이동하지 않기때문에 escape 문자 \n을 사용
		System.out.printf("%d+%d=%d입니다.\n",num1,num2,num1+num2); 
		double d = 1.1233546546;
		System.out.println(d);
		System.out.printf("%.2f",d);
	}
	

	public void scan() {
		Scanner sc = new Scanner (System.in);
//		//정수형 입력받는 방법
//		System.out.print("정수 입력 : ");
//		int inputNumber;
//		inputNumber = sc.nextInt();
//		System.out.println("사용자가 입력한 값 : "+inputNumber);
//		
//		//실수형 입력받는 방법
//		System.out.print("실수 입력 : ");
//		double dNum = sc.nextDouble();
//		System.out.println("사용자가 입력한 실수값 : "+dNum);
		
		//문자열 입력받는 방법
//		System.out.print("첫번째 문자열 입력 : ");
//		String str1 = sc.next();
//		System.out.println(str1);
//		sc.nextLine(); //버퍼 비우기 (str1을 입력할때 입력받은 enter가 str2에 저장되는걸 방지)
//		System.out.print("두번째 문자열 입력 : ");
//		String str2 = sc.nextLine();
//		System.out.println(str2.charAt(3));
		
		//sc.next()는 띄어쓰기를 인지하지 못한다
		//sc.nextLine()은 띄어쓰기를 포함한 전체 행을 인지한다
		
		//문자 입력받는 방법
//		System.out.println("문자 입력 : ");
//		char ch = sc.next().charAt(0); // charAt(index) index번째의 문자를 저장 
//		System.out.println("입력한 문자는 " + ch + "입니다.");
	}
}

