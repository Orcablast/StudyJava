package kr.or.iei.func;

import java.util.Scanner;

public class Example {
	public void exam1() {
		int num1; // num1 �̶�� int ������ ����
		num1 = 10; // num1 ������ ���� �ʱ�ȭ
		char ch1 = '1'; // char Ÿ���� ch1 ������ ���� '1'�� ����
		long num2 = 10000L; // long Ÿ���� num2 ������ ���� 10000���� ����
		float num3 = 3.14f; // float Ÿ���� num3 ������ ���� 3.14�� ����
		final double PI = 3.14; // double Ÿ���� PI ������ ���� 3.14�� �Һ� ����
		System.out.println("���� ��� : "+(num1+num1)); // ���ڿ� + ���� ������ ���� ���
		System.out.println("���� ��� : " +(ch1+ch1)); // ���ڿ� + char Ÿ�� �������� ���� ���
		System.out.println(num2); //
		System.out.println(num3);
		System.out.println(PI);
	}
	
	public void exam2() {
		String name = "�̵���"; // String Ÿ�� name ������ ���� �̵��� ���� ����
		int age = 30; // int Ÿ�� age ������ ���� 30 ���� ����
		String address = "��⵵ ��õ��"; // String Ÿ�� address ������ ���� ��⵵ ��õ�÷� ����
		char gender = '3'; // char Ÿ�� gender ������ ���� �� ���� ����
		System.out.println("�� �̸��� "+ name +" �̰� ���̴� " + age + "��, " + address + "�� ����ִ� " + gender + "���Դϴ�.");
		System.out.println((int)gender);
	}
	
	public void exam3() {
		int num = 2147483647; // intŸ���� num ������ 2147834647 (MAX.VALUE)�� ����
		int result = num+1; // num ���� + 1�� ���� (overflow �߻�)
		System.out.println(result); // ���ϴ� ���� ������ ����
	}
	
	public void exam4() {
		int num = 2147483647;
		long result = (long)num + 1; // overflow�� �߻����� �ʵ��� num�� long Ÿ������ ����ȯ
		System.out.println(result);
	}
	
	public void exam5() {
		int num1 = 10;
		int num2 = 20;
//		System.out.println("������ ���� num�ȿ� ����ִ� ���� " + num + "�Դϴ�.");
//		System.out.printf("������ ���� num�ȿ� ����ִ� ���� %d�Դϴ�.",num);
		System.out.println(num1 + "+" + num2 + "=" + (num1+num2) + " �Դϴ�.");
		// printf �޼ҵ�� ���� �̵����� �ʱ⶧���� escape ���� \n�� ���
		System.out.printf("%d+%d=%d�Դϴ�.\n",num1,num2,num1+num2); 
		double d = 1.1233546546;
		System.out.println(d);
		System.out.printf("%.2f",d);
	}
	

	public void scan() {
		Scanner sc = new Scanner (System.in);
//		//������ �Է¹޴� ���
//		System.out.print("���� �Է� : ");
//		int inputNumber;
//		inputNumber = sc.nextInt();
//		System.out.println("����ڰ� �Է��� �� : "+inputNumber);
//		
//		//�Ǽ��� �Է¹޴� ���
//		System.out.print("�Ǽ� �Է� : ");
//		double dNum = sc.nextDouble();
//		System.out.println("����ڰ� �Է��� �Ǽ��� : "+dNum);
		
		//���ڿ� �Է¹޴� ���
//		System.out.print("ù��° ���ڿ� �Է� : ");
//		String str1 = sc.next();
//		System.out.println(str1);
//		sc.nextLine(); //���� ���� (str1�� �Է��Ҷ� �Է¹��� enter�� str2�� ����Ǵ°� ����)
//		System.out.print("�ι�° ���ڿ� �Է� : ");
//		String str2 = sc.nextLine();
//		System.out.println(str2.charAt(3));
		
		//sc.next()�� ���⸦ �������� ���Ѵ�
		//sc.nextLine()�� ���⸦ ������ ��ü ���� �����Ѵ�
		
		//���� �Է¹޴� ���
//		System.out.println("���� �Է� : ");
//		char ch = sc.next().charAt(0); // charAt(index) index��°�� ���ڸ� ���� 
//		System.out.println("�Է��� ���ڴ� " + ch + "�Դϴ�.");
	}
}

