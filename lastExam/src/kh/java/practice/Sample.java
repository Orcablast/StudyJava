package kh.java.practice;
import java.util.Scanner;

public class Sample {
	public void sample1() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("문자 입력 : ");
		char word = sc.next().charAt(0);
		System.out.println(word+"의 유니코드 값 : " + (int)word);
	}
	
	public void sample2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 입력 : ");
		double scr1 = sc.nextDouble();
		System.out.print("수학 점수 입력 : ");
		double scr2 = sc.nextDouble();
		System.out.print("영어 점수 입력 : ");
		double scr3 = sc.nextDouble();
		System.out.println("======== 결과 ========");
		int sumscr = (int)scr1+(int)scr2+(int)scr3;
		System.out.println("총점 : " + sumscr);
		int avgscr = sumscr/3;
		System.out.println("평균 : " + avgscr);
	}
}
