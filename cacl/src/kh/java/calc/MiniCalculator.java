package kh.java.calc;
import java.util.Scanner;

public class MiniCalculator {
	public void calc() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("세번째 숫자를 입력 : ");
		int num3 = sc.nextInt();
		System.out.println("===== 결과를 출력합니다 =====");
		int sum = num1+num2+num3;
		int min = num1-num2-num3;
		int multi = num1*num2*num3;
		double avg = sum/3.0; 
		System.out.println("세 숫자의 합 : "+sum);
		System.out.println("세 숫자의 차 : "+min);
		System.out.println("세 숫자의 곱 : "+multi);
		System.out.println("세 숫자의 평균 : "+avg);
			
	}

}
