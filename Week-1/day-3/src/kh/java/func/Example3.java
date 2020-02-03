package kh.java.func;
import java.util.Scanner;

public class Example3 { // if ~ else if 연습문제
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~3 사이 수를 입력하세요 : ");
		int num = sc.nextInt();
		if(num==1) {
			System.out.println("One");
		} else if(num==2) {
			System.out.println("Two");
		} else if(num==3) {
			System.out.println("Three");			
		} else {
			System.out.println("잘못된 값입니다.");
		}
	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=========== 대/소문자 변환 프로그램 ===========");
		System.out.print("문자 입력 : ");
		char ch = sc.next().charAt(0); // 입력받은 문자열의 0번째 문자를 char타입 변수 ch로 선언
		System.out.println("==== 결과 ====");
		if (ch>=65 && ch<=90) { // 아스키 코드상 대문자의 범위 ch 변수값이 속하는지 비교, 둘다 true면 명령어 실행, 하나라도 false면 else if로 이동
			System.out.println("대문자를 입력하였습니다.");			
			System.out.printf("소문자로 변환 : %c",ch^32);			
		} else if (ch>=97 && ch<=122) { // 아스키 코드상 소문자의 범위 ch 변수값이 속하는지 비교, 둘다 true면 명령어 실행, 하나라도 false면 else로 이동
			System.out.println("소문자를 입력하였습니다.");
			System.out.printf("대문자로 변환 : %c",ch^32);
		} else { // 위의 두 조건문에 속하지 않는 char 값은 영문 대문자, 소문자가 아니므로 아래와 같이 출력
			System.out.println("잘못 입력하셨습니다. 영문자를 입력해주세요.");
		}
		
		
	}
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		System.out.println("===== 결과 =====");		
		if (num==0) { // num의 값이 0이면 아래 명령어 출력 
			System.out.printf("[%d]은(는) 어떤수의 배수도 아닙니다.",num);
		} else if ((num%3==0) && (num%4==0)) {
			System.out.printf("[%d]은(는) 3의 배수면서 4의 배수입니다.",num);
		} else if (num%3==0) {
			System.out.printf("[%d]은(는) 3의 배수입니다.",num);
		} else if (num%4==0) {
			System.out.printf("[%d]은(는) 4의 배수입니다.",num);
		} else {
			System.out.printf("[%d]은(는) 3의 배수도 4의 배수도 아닙니다.",num);
		}
	}
}
