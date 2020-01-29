package kh.java.function;
import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번 째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번 째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("======= 결과 =======");
		int sum = num1+num2;
		System.out.println("더하기 결과 : " + sum);
		int minus = num1-num2;
		System.out.println("빼기 결과 : " + minus);
		int multi = num1 * num2; 
		System.out.println("곱하기 결과 : " + multi);
		int div = num1/num2;
		System.out.println("나누기 몫 : " + div);
		int etc = num1%num2;
		System.out.println("나누기 나머지 : " + etc);

	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 길이 입력 : " );
		double width = sc.nextDouble();
		System.out.print("세로 길이 입력 : " );
		double height = sc.nextDouble();
		System.out.println("======= 결과 =======");
		double surface = width*height;
		System.out.println("면적 : " + surface);
		double circ = (width+height)*2;
		System.out.println("둘레 : " + circ);
		
	}
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);		
		System.out.print("영어단어 입력 : ");
		String word = sc.next();
		System.out.println("첫번째 문자 : "+word.charAt(0));
		System.out.println("두번째 문자 : "+word.charAt(1));
		System.out.println("세번째 문자 : "+word.charAt(2));
		
	}
	

}
