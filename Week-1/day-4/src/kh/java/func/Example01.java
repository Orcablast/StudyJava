package kh.java.func;

import java.util.Scanner;

public class Example01 {
	public void exam01() { // for�� ���� 1)
		// 1. ���� i ���� ���� 1�� ���� (�ʱ⹮)
		// 2. i���� 50���� �۰ų� ������ �� = true or false (���ǹ�)
		// 3. ���ǹ��� true�� ��� for�� ���� ��ɾ ���� -> i++(������)�� �����ϰ� ���ǹ����� ȸ��(2��)
		// 4. ���ǹ��� false�� ��� for�� ���� ��ɾ �������� ���� (����)
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "��° �ݺ��ؼ� ���� ��");
		}
	}

	public void exam02() {// ������ ������ �ݺ��Ǵ� �߸��� ���ǹ�
		for (int i = 1; i <= 5; i--) {
			System.out.println(i + "��° �ݺ��ؼ� ���� ��");
		}
	}

	public void exam03() { // �������� 01)
		// ���� i�� ���� 5�� �����ϰ� (�ʱ⹮), i�� 5���� �۰ų� ������ �� (����), ���ǹ��� true��� for�� ���� ��ɾ ����
		for (int i = 1; i <= 5; i++) { 
			System.out.println("�ȳ��ϼ���");
		}
	}

	public void exam04() { // �������� 02
		Scanner sc = new Scanner(System.in); 
		System.out.print("��� ����Ͻðڽ��ϱ�? : "); 
		int num = sc.nextInt(); // �Է��� ���� ���� num���� ����
		// ���� i�� ���� 1�� ���� (�ʱ⹮), i��  ����ڰ� �Է��Ͽ� ����� ���� num���� �۰ų� ������ �� (����)
		// ���ǹ��� true��� for�� ���� ��ɾ ���� �� i���� 1 �����Ͽ� ���� -> ���ǹ����� �ݺ�
		for (int i = 1; i <= num; i++) {
			System.out.println("�ȳ��ϼ���! " + i + "��°!"); // for���� �ݺ��ɶ����� ���ڿ��� ���
		}

	}

	public void exam05() { // �������� 03
		System.out.println("������ 2�� ����ϱ�");
		
		// ���� i�� ���� 0 ���� ���� (�ʱ⹮), ���� i�� 9���� �۰ų� ������ �� (���ǹ�)
		// ���ǹ��� ����� true ��� for�� ���� ��ɾ ���� �� i���� 1 �����Ͽ� ���� -> ���ǹ����� �ݺ�
		for (int i = 0; i <= 9; i++) {
			if (i == 0) { // i�� ���� 0�� ������ if�� ���� ��ɾ ����
				System.out.println("2�� �Դϴ�!"); 				
			} else { // i�� ���� 0�� �ƴ� ��� ��� else�� ���� ��ɾ ����
				System.out.println("2 * " + i + " = " + (i * 2)); // 2 * ���� i = i * 2
			}
		}

	}

	public void exam06() { // �������� 04
		Scanner sc = new Scanner(System.in);
		System.out.println("======= ������ ���� =======");
		System.out.print("�� ���� ����Ͻðڽ��ϱ�? : ");
		int selectNum = sc.nextInt(); // �Է¹��� ���� ����Ÿ�� ���� selectNum���� ����
		// ���� i�� ���� 0���� ���� (�ʱ⹮), ���� i�� ���� 9���� �۰ų� ������ �� (���ǹ�)
		// ���ǹ��� ����� true �϶� for�� ���� ��ɾ ���� �� i���� 1 �����Ͽ� ���� -> ���ǹ����� �ݺ� 
		for (int i = 0; i <= 9; i++) {
			if (i == 0) { // ���� i�� ���� 0�϶� if�� ���� ��ɾ ����
				System.out.println("==========================");
				System.out.println(selectNum + "���Դϴ�");
			} else { // ���� i�� ���� 0�� �ƴҶ� ��� ��� else�� ���� ��ɾ ����
				System.out.println(selectNum + " * " + i + " = " + selectNum * i);
			}
		}
	}
	
	public void exam07() { // �������� 05
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <= 5; i++ ) { 
			System.out.print("���� ���� �Է��ϼ��� : ");
			int num = sc.nextInt();
			sum += num;	
		}
		System.out.println("�Է��� 5���� ������ �� : " + sum);
	}
	
	public void exam08() { // �������� 06
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° �� �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° �� �Է� : ");
		int num2 = sc.nextInt();
		int sum = 0;
		for(int i=num1 ; i<=num2; i++) {
			sum += i;
		}		
		System.out.println("������ �� : " + sum);
	}
	
	public void exam09() { // �������� 06
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		int even = num/2;
		int sum = 0;
		for (int i=1; i<=even; i++) {
			sum += (i*2);			
		}
		System.out.println("¦������ ���� = " + sum);
	}	
}
