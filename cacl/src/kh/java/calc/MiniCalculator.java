package kh.java.calc;
import java.util.Scanner;

public class MiniCalculator {
	public void calc() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���ڸ� �Է� : ");
		int num2 = sc.nextInt();
		System.out.print("����° ���ڸ� �Է� : ");
		int num3 = sc.nextInt();
		System.out.println("===== ����� ����մϴ� =====");
		int sum = num1+num2+num3;
		int min = num1-num2-num3;
		int multi = num1*num2*num3;
		double avg = sum/3.0; 
		System.out.println("�� ������ �� : "+sum);
		System.out.println("�� ������ �� : "+min);
		System.out.println("�� ������ �� : "+multi);
		System.out.println("�� ������ ��� : "+avg);
			
	}

}
