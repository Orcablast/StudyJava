package kh.java.func;

import java.util.Scanner;

public class Example03 {
	public void exam01() { // ��ø for��
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.println("i = " + i + " / j = " + j);
			}
		}
	}

	public void exam02() { // ���� ������ 01
		while (true) {
		}
	}

	public void exam03() { // ���ѷ����� 02
		for (;;) {
		}
	}

	public void exam04() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("�ݺ�");
			System.out.println("�ѹ� ��? [y/n] : ");
			char ch = sc.next().charAt(0);
			if (ch == 'n') {
				break;
			}
		}
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}

	public void exam05() { // �ݺ���� break
		for (int i = 1; i <= 10; i++) {
			System.out.println(i+"���");
			if (i == 5) {
				break;
			}
			System.out.println("test");
		}
		System.out.println("���α׷� ����");
	}
	
	public void exam06() { // �ݺ� ��� continue
		for (int i = 1; i <= 10; i++) {
			System.out.println(i+"���");
			if (i == 5) {
				continue;
			}
			System.out.println("test");
		}
		System.out.println("���α׷� ����");
	}
	
	public void exam07() { // �ݺ� ��� continue
		for (int i = 1; i <= 10; i++) {
			System.out.println(i+"���");
			if (i%2 == 0) {
				continue;
			}
			System.out.println("Ȧ��");
		}
		System.out.println("���α׷� ����");
	}
}
