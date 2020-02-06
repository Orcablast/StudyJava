package kh.java.func;

import java.util.Scanner;

public class MethodTest {
	public void main() { //
		Scanner sc = new Scanner(System.in); // Scanner�� ȣ�� �� sc�� ����

		System.out.print("ù��° ����  : ");
		int num1 = sc.nextInt();

		System.out.print("�ι�° ����  : ");
		int num2 = sc.nextInt();

		System.out.println("�����ڸ� �Է��ϼ���");
		System.out.print("[+, -, *, /] : ");
		char oper = sc.next().charAt(0);

		System.out.println("======= ��� ��� =======");
		switch (oper) {
		case '+':
			int sum = sum(num1, num2);
			System.out.println(num1 + " + " + num2 + " = " + sum);
			break;
		case '-':
			int sub = sub(num1, num2);
			System.out.println(num1 + " - " + num2 + " = " + sub);
			break;
		case '*':
			int multi = multi(num1, num2);
			System.out.println(num1 + " * " + num2 + " = " + multi);
			break;
		case '/':
			double div = div(num1, num2);
			System.out.printf(num1 + " / " + num2 + " = %.2f",div);
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");

		}

	}

	public int sum(int num1, int num2) {
		System.out.println("���� 3�� ���ϴ� �޼ҵ�");
		int result = num1 + num2;
		return result;
	}
	
	// method overloading
	// �޼ҵ� ���� ���Ƶ� �Ű����� �ڷ����� �Ű������� ������ ���� �ڵ����� �ش� �޼ҵ带 ���� 
	public int sum(int num1, int num2, int num3) {
		System.out.println("���� 3�� ���ϴ� �޼ҵ�");
		int result = num1 + num2 + num3;
		return result;
	}

	public int sub(int num1, int num2) {
		return num1 - num2;
	}

	public int multi(int num1, int num2) {
		return num1 * num2;
	}

	public double div(int num1, int num2) {
		return (double) num1 / num2;
	}
}
