package kr.or.iei.func;
import java.util.Scanner;

public class Func {
	public void exam1(){
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸���? ");
		String name = sc.next();		
		System.out.print("���̴�? ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("�ּҴ�? ");
		String addr = sc.nextLine();				
		System.out.print("Ű��? ");
		double height = sc.nextDouble();		
		System.out.print("�����Դ�? ");
		double weight = sc.nextDouble();		
		System.out.print("������? ");
		char gender = sc.next().charAt(0);
		
		System.out.printf("�ȳ��ϼ���! %s��!\n���̴� %d��, %s�� ����ð�\nŰ�� %dcm�� �����Դ� %.1fkg�� %c���̽ñ���!",name,age,addr,(int)height,weight,gender);
	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�������� �Է� : ");
		int score1 = sc.nextInt();
		System.out.print("�������� �Է� : ");
		int score2 = sc.nextInt();
		System.out.print("�������� �Է� : ");
		int score3 = sc.nextInt();
		int sumscore = score1+score2+score3;
		double avgscore = sumscore/3.0;
		for(int i =1; i<=19; i++) {
			System.out.print("--");
		}
		System.out.printf("\n��� ������ �� ���� %d���̰� ����� %.2f���Դϴ�!",sumscore,avgscore);
	}
	
	public void exam3() {
		
	}
}
