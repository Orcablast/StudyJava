package kh.java.func;
import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("���� : ");
		int age = sc.nextInt();
		System.out.print("�ּ� : ");
		String addr = sc.next();
		System.out.print("Ű : ");
		double height = sc.nextDouble();
		System.out.print("������ : ");
		double weight = sc.nextDouble();
		System.out.print("���� : ");
		char gender = sc.next().charAt(0);
		System.out.printf("�̸��� %d ���̴� %d�� �ּҴ� %s\nŰ��%d �����Դ� %.1f ������ %c��",name,age,addr,(int)height,weight,gender);
	}

}
