package kh.java.practice;
import java.util.Scanner;

public class Sample {
	public void sample1() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("���� �Է� : ");
		char word = sc.next().charAt(0);
		System.out.println(word+"�� �����ڵ� �� : " + (int)word);
	}
	
	public void sample2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� �Է� : ");
		double scr1 = sc.nextDouble();
		System.out.print("���� ���� �Է� : ");
		double scr2 = sc.nextDouble();
		System.out.print("���� ���� �Է� : ");
		double scr3 = sc.nextDouble();
		System.out.println("======== ��� ========");
		int sumscr = (int)scr1+(int)scr2+(int)scr3;
		System.out.println("���� : " + sumscr);
		int avgscr = sumscr/3;
		System.out.println("��� : " + avgscr);
	}
}
