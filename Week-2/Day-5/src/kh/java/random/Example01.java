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
		Random r = new Random(); // Random�� ��� r�� ����
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
		char rest = 'y';
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
			System.out.print("����Ϸ��� y, �׸��η��� n�� �Է��ϼ��� : ");
			rest = sc.next().charAt(0);
			if (rest == 'n') {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}
		}
	}

	public void exam05() {
		Scanner sc = new Scanner(System.in); // Scanner�� ��� sc�� ����
		Random r = new Random(); // Random�� ��� r �� ����
		while (true) {
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
			if (sel == 'n') {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}
		}
	}

	public void exam06() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("=== ���� ���� �� ���� ===");
		System.out.print("���ڸ� �����ϼ��� (1.����/ 2.���� / 3.��) : ");
		int sltNum = sc.nextInt(); // �Է¹��� ���� ���� sltNum���� ����
		int rndNum = r.nextInt(3) + 1; // 1~3������ ���� ���ڸ� ����
		System.out.println("============���=============");
		String userHand = ""; // ���ڿ� ���� userHand�� �ʱ�ȭ, ����ڰ� ������ ������������ �ȴ�
		String comHand = ""; // ���ڿ� ���� comHand�� �ʱ�ȭ, ��ǻ�Ͱ� ������ ������������ �ȴ�
		switch (sltNum) { // �Է¹��� ���� sltNum�� ���ͷ����� ���� 3���� �б⸦ ����		
		case 1: // ����ڰ� 1�� �Է����� ���
			userHand = "����"; // ���ڿ� ���� userHand�� "����"�� ����
			break;
		case 2: // ����ڰ� 2�� �Է����� ���
			userHand = "����"; // ���ڿ� ���� userHand�� "����"�� ����
			break;
		case 3: // ����ڰ� 3�� �Է����� �ܿ�
			userHand = "��"; // ���ڿ� ���� userHand�� "��"�� ����
			break;
		}
		switch (rndNum) { // 1~3���� ���� ���ڸ� �Է¹޾� 3���� �б⸦ ����
		case 1: // random���� 1�� ���
			comHand = "����"; // ���ڿ� ���� comHand�� ���ڿ� "����"�� ����
			break;
		case 2: // random���� 2�� ���
			comHand = "����"; // ���ڿ� ���� comHand�� ���ڿ� "����"�� ����
			break;
		case 3: // random���� 3�� ���
			comHand = "��"; // ���ڿ� ���� comHand�� ���ڿ� "��"�� ����
			break;
		}
		System.out.println("����� " + userHand + "�� �½��ϴ�"); 
		System.out.println("��ǻ�ʹ� " + comHand + "�� �½��ϴ�");
		System.out.println("============================");
		if (sltNum == rndNum) { // ����ڰ� �Է��� ���� �������� ���� ���
			System.out.println("�����ϴ�!");
		} else if (sltNum == (rndNum-1) || (sltNum-rndNum)==2) { // 
			System.out.println("�����ϴ�!");
		} else {
			System.out.println("�̰���ϴ�!");
		}

//		if (sltNum == rndNum) {
//			System.out.println("�����ϴ�!");
//		} else if (userHand.equals("����") && comHand.equals("����") || "��".equals(userHand) && "����".equals(comHand)) { // string Ÿ���� ���ϴ� ���
//			System.out.println("�����ϴ�!");
//		} else {
//			System.out.println("�̰���ϴ�!");
//		}
	}
}
