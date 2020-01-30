package kh.java.func;

import java.util.Scanner;

public class Example4 {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~3사이의 수 입력 : ");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			System.out.println("1을 입력");
			break;
		case 2:
			System.out.println("2를 입력");
			break;
		case 3:
			System.out.println("3을 입력");
			break;
		default:
			System.out.println("잘못 입력");
		}
	}

	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("일수를 알고싶은 달을 입력하세요 : ");
		int inputNum = sc.nextInt();
		switch (inputNum) {
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 : 
			System.out.printf("%d월달은 31일까지 있습니다.",inputNum);
			break;
		case 4 :
		case 6 :
		case 9 :
		case 11 : 
			System.out.printf("%d월달은 30일까지 있습니다.",inputNum);
			break;
		case 2 : 
			System.out.printf("%d월달은 28일까지 있습니다.",inputNum);
			break;
		default :
			System.out.println("1~12 사이의 값을 입력해주세요.");
		}

	}

	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학점을 입력하세요 (A,B,C,D,F) : ");
		char grade = sc.next().charAt(0);
		switch (grade) {
		case 'A':
			System.out.println("수고하셨습니다. 장학금을 100%  지급 해드리겠습니다!");
			break;
		case 'B':
			System.out.println("아쉽군요. 장학금을 50%  지급 해드리겠습니다.");
			break;
		case 'C':
			System.out.println("장학금을 바라시면 좀 더 열심히 해주세요.");
			break;
		case 'D':
			System.out.println("크흠......");
			break;
		case 'F':
			System.out.println("학사 경고입니다!!");
			break;
		default:
			System.out.println("지정된 값을 입력하세요.");
		}

	}
	
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=========== 계산기 프로그램 ===========");
		System.out.print("연산자를 입력하세요 (+,-,*,/) : ");
		char oper = sc.next().charAt(0);
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		int sum = num1+num2;
		int min = num1-num2;
		int multi = num1*num2;
		double div = (double)num1/num2;
		
		switch(oper){
		case '+' :
			System.out.printf("%d%c%d=%d",num1,oper,num2,sum);
			break;
		case '-' :
			System.out.printf("%d%c%d=%d",num1,oper,num2,min);
			break;
		case '*' :
			System.out.printf("%d%c%d=%d",num1,oper,num2,multi);
			break;
		case '/' :
			System.out.printf("%d%c%d=%.6f",num1,oper,num2,div);
			break;			
		}
		
		
		
	}
	
	
	public void exam5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();		
		if(score<=100 && score>=0) {
			int grade = score/10;
			switch(grade) {			
			case 10 : 
				System.out.printf("%d점 ==> A 등급",score);
				break;
			case 9 : 
				System.out.printf("%d점 ==> A 등급",score);
				break;
			case 8 :
				System.out.printf("%d점 ==> B 등급",score);
				break;
			case 7 :
				System.out.printf("%d점 ==> C 등급",score);
				break;
			case 6 :
				System.out.printf("%d점 ==> D 등급",score);
				break;
			default : 
				System.out.printf("%d점 ==> F 0등급",score);
			}
		} else {
			System.out.println("0~100 사이의 값을 입력하세요.");
		}
		
	}
	
	
	
}
