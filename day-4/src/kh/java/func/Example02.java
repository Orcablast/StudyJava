package kh.java.func;

import java.util.Scanner;

public class Example02 {
	public void exam01() { // while�� ���� 01)
		int i = 1; // 1.���� i�� ���� 1�̶� ����
		// 2. (���ǹ�) ���� i�� ���� 5���� �۰ų� ������ ��
		// 3. 2�� ����� true�̸� while�� ���� ��ɾ ���� �� �ٽ� ���ǹ� 2�� �ݺ�
		// 4. 2�� ��� false�̸� while�� ���� ��ɾ �������� ����
		while (i <= 5) {
			System.out.println(i + "��° �ݺ� ��");
			i++;
		}
	}

	public void exam02() { // �������� 01)
		int i = 1;
		while (i <= 5) {
			System.out.println("�ȳ��ϼ���!");
			i++;
		}
	}
	
	public void exam03() { // �������� 02)
		Scanner sc = new Scanner(System.in);
		System.out.print("��� ��� �Ͻðڽ��ϱ�? : ");
		int selectNum = sc.nextInt();
		int i = 1;
		while(i <= selectNum) {
			System.out.println("�ȳ��ϼ���! "+ i +"��° ���");			
			i++;
		}		
	}
	
	public void exam04() { // �������� 03)
		System.out.println("������ 2�� ����ϱ�");
		System.out.println("2�� �Դϴ�.");
		int i = 1;
		while(i<=9) {
			System.out.println("2 * " + i + " = " + i*2);
			i++;
		}
	}
	
	public void exam05() { // �������� 04
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ����Ͻðڽ��ϱ�? : ");
		int selectNum = sc.nextInt();
		System.out.println("===========================");
		System.out.println(selectNum+"�� �Դϴ�.");
		int i = 1;
		while(i<=9) {
			System.out.println(selectNum + " * " + i + " = " + (selectNum*i));
			i++;
		}
	}
	
	public void exam06() { // �������� 05)
		Scanner sc = new Scanner(System.in);
		int i = 1;
		int sum = 0;
		while (i<=5) {
			System.out.print("���� ���� �Է��Ͻÿ� : ");		
			int num = sc.nextInt();
			sum += num;
			i++;
		}
		System.out.println("�Է��� 5���� ������ �� : " + sum);
	}
	
	public void exam07() { // �������� 06
		Scanner sc = new Scanner(System.in);		
		System.out.print("ù��° �� �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° �� �Է� : ");
		int num2 = sc.nextInt();
		int i = num1;
		int sum = 0;
		while(i<=num2) {
			sum += i;
			i++;
		}		
		System.out.println(num1 + " ~ " + num2 + "�� ������ �� : " + sum);
	}
	
	public void exam08() { // �������� 07
		Scanner sc= new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		int div = num/2;
		int sum = 0;
		int i = 1;		
		while(i<=div) {
			sum += (i*2);
			i++;
		}
		System.out.println("¦������ ���� : " + sum);
	}
}
