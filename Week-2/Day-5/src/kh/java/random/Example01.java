package kh.java.random;

import java.util.Random;
import java.util.Scanner;

public class Example01 {
	public void exam01() {
		Random r = new Random();
		// r.nextInt(); �������� ���� -> ������ ������ ����(int)
		// -2^31 ~ 2^31-1
		int rndNum = r.nextInt();
		System.out.println(rndNum);
		// 0���� 10�� ������ �������� ����
		// 0 1 2 3 4 5 6 7 8 9
		rndNum = r.nextInt(10);
		System.out.println(rndNum);
		// 0~31�������� �������� ����
		rndNum = r.nextInt(32);
		System.out.println(rndNum);
	}

	public void exam02() { // ������ ������ �����ϴ� ����
		Random r = new Random();
		int rndNum = r.nextInt(10);
		System.out.print("0~9������ ���� ���� ����մϴ� :" + rndNum);
		System.out.println();
		// 0~9������ ������ ����� �� 1�� ���Ͽ� rndNum�� ����
		rndNum = r.nextInt(10) + 1;
		System.out.print("1~10������ ���� ���� ����մϴ� : " + (rndNum));
		System.out.println();
		// 0~15������ ������ ����� �� 20�� ���Ͽ� rndNum�� ����
		rndNum = r.nextInt(16) + 20;
		System.out.print("20~35������ ���� ���� ����մϴ� : " + (rndNum));
		System.out.println();
		rndNum = r.nextInt(2);
		System.out.print("0 �Ǵ� 1 : " + rndNum);
	}

	public void exam03() { // ������ �����ϰ� ����ڰ� �Է��� ������ ���ϴ� ����
		Scanner sc = new Scanner(System.in); // Scanner�� ��� sc�� ����
		Random r = new Random(); // Random�� ��� r �� ����
		System.out.println("== ���� �յ� ���߱� ==");
		System.out.print("���ڸ� �Է����ּ��� (1.�ո� / 2.�޸�) : ");		
		int sltNum = sc.nextInt(); // ����ڰ� �Է��� ���� sltNum���� ����
		// 0~1������ ������ 1�� ���Ѱ��� rndNum���� ����
		int rndNum = r.nextInt(2) + 1;		
		if (sltNum == rndNum) { // ����ڰ� �Է��� ���� ���� ���尪�� ���Ͽ� true�� �� 
			System.out.println("������ϴ�!");
		} else if (sltNum != rndNum) { // ����ڰ� �Է��� ���� ���� ���尪�� ���Ͽ� false�� ��
			System.out.println("��! Ʋ�Ⱦ��~~");
		} else { // 1�̳� 2 �̿��� ���� �Է����� �ʾ��� ���
			System.out.println("1�̳� 2�� �Է��ϼ���");
		}
	}

	public void exam04() { // exam03�� �ݺ�/���� �����Ҽ� �ִ� ����� �߰�
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int restNum = 1;
		while (true) {
			System.out.println("== ���� �յ� ���߱� ==");
			System.out.print("���ڸ� �Է����ּ��� (1.�ո� / 2.�޸�) : ");
			int sltNum = sc.nextInt();
			int rndNum = r.nextInt(2) + 1;
			if (sltNum == rndNum) {
				System.out.println("������ϴ�!");
			} else {
				System.out.println("��! Ʋ�Ⱦ��~~");
			}
			System.out.print("����Ϸ��� 1, �׸��η��� 2�� �Է��ϼ��� : ");
			restNum = sc.nextInt();
			if (restNum == 2) {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}
		}
	}
	
	public void exam05() {
		Scanner sc = new Scanner(System.in); // Scanner�� ��� sc�� ����
		Random r = new Random(); // Random�� ��� r �� ����
		while(true) {
			System.out.println("== ���� �յ� ���߱� ==");
			System.out.print("���ڸ� �Է����ּ��� (1.�ո� / 2.�޸�) : ");		
			int sltNum = sc.nextInt(); // ����ڰ� �Է��� ���� sltNum���� ����
			// 0~1������ ������ 1�� ���Ѱ��� rndNum���� ����
			int rndNum = r.nextInt(2) + 1;		
			if (sltNum == rndNum) { // ����ڰ� �Է��� ���� ���� ���尪�� ���Ͽ� true�� �� 
				System.out.println("������ϴ�!");
			} else if (sltNum != rndNum) { // ����ڰ� �Է��� ���� ���� ���尪�� ���Ͽ� false�� ��
				System.out.println("��! Ʋ�Ⱦ��~~");
			} else { // 1�̳� 2 �̿��� ���� �Է����� �ʾ��� ���
				System.out.println("1�̳� 2�� �Է��ϼ���");
			}
			System.out.print("�ѹ� �� [y/n] ? :");
			char sel = sc.next().charAt(0);
			if (sel=='n') {
				System.out.println("���α׷��� �����մϴ�");
				break;
			} else if (sel=='y') {
				continue;
			}
				
		}
	}
}
