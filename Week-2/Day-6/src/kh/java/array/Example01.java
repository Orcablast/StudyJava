package kh.java.array;

import java.util.Scanner;

public class Example01 {
	public void exam01() {
//		// �迭�� ������� �ʰ� ������ ���� 5���� ������ �Ѵٸ�?
//		int num1, num2, num3, num4, num5;
//		// �迭�� ����Ͽ� ������ ���� 5���� ������ �Ѵٸ�?
//		int[] num = new int[5];
//		// num[0],num[1], ...num[4]
//		System.out.println(num[0]);
//		System.out.println(num[1]);
//		System.out.println(num[2]);
//		System.out.println(num[3]);
//		System.out.println(num[4]);
//
//		num[1] = 10; // num �迭�� 1��° ������ 10���� ����
//		System.out.println(num[1]);
//
//		num[0] = 1; // num �迭�� 0��° ������ 1���� ����
//		num[1] = 2; // num �迭�� 1��° ������ 2���� ����
//		num[2] = 3; // num �迭�� 2��° ������ 3���� ����
//		num[3] = 4; // num �迭�� 3��° ������ 4���� ����
//		num[4] = 5;
//		System.out.println(num[0]);
//		System.out.println(num[1]);
//		System.out.println(num[2]);
//		System.out.println(num[3]);
//		System.out.println(num[4]);
//
//		for (int i = 0; i < 5; i++) {
//			num[i] = i + 1;
//			System.out.println(num[i]);
//		}

//		String[] arr = new String[5];
//		Scanner sc = new Scanner(System.in);
//		for(int i=0; i<5; i++) {
//			System.out.print("�̸��� �Է��ϼ��� : ");
//			arr[i] = sc.next();
//		}
//		while(true) {
//			System.out.print("���° �̸��� ���ðڽ��ϱ�? : ");
//			int userNum = sc.nextInt();
//			System.out.println(userNum + "��° �̸��� " + arr[userNum] + "�Դϴ�");			
//		}
		
		
		String[] arr = new String[10];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<arr.length; i++) {
			System.out.print("�̸��� �Է��ϼ��� : ");
			arr[i] = sc.next();
		}

		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
			
		
	}
}
