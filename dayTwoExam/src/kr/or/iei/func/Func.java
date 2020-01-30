package kr.or.iei.func;
import java.util.Scanner;

public class Func {
	public void exam1(){
		Scanner sc = new Scanner(System.in);
		System.out.print("이름은? ");
		String name = sc.next();		
		System.out.print("나이는? ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("주소는? ");
		String addr = sc.nextLine();				
		System.out.print("키는? ");
		double height = sc.nextDouble();		
		System.out.print("몸무게는? ");
		double weight = sc.nextDouble();		
		System.out.print("성별은? ");
		char gender = sc.next().charAt(0);
		
		System.out.printf("안녕하세요! %s님!\n나이는 %d살, %s에 살고계시고\n키는 %dcm에 몸무게는 %.1fkg인 %c성이시군요!",name,age,addr,(int)height,weight,gender);
	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 입력 : ");
		int score1 = sc.nextInt();
		System.out.print("수학점수 입력 : ");
		int score2 = sc.nextInt();
		System.out.print("영어점수 입력 : ");
		int score3 = sc.nextInt();
		int sumscore = score1+score2+score3;
		double avgscore = sumscore/3.0;
		for(int i =1; i<=19; i++) {
			System.out.print("--");
		}
		System.out.printf("\n당신 점수의 총 합은 %d점이고 평균은 %.2f점입니다!",sumscore,avgscore);
	}
	
	public void exam3() {
		
	}
}
