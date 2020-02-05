package kh.java.func;

import java.util.Scanner;
import java.util.Random;

public class Example01 { // 2���� �迭
	public void exam01() {
		int arr[][] = new int[3][5];
		arr[0][3] = 10;
		arr[2][1] = 20;
		System.out.println(arr[0][3]);
		System.out.println(arr[2][1]);
	}

	public void exam02() {
		int arr[][] = new int[3][5];
		int k = 1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = k++;

			}
		}

		for (int i = 0; i < arr.length; i++) { // ���
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");

			}
			System.out.println();
		}
	}

	public void exam03() { // �ǽ����� 1-1.
		int arr[][] = new int[5][5];
		int k = 1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = (arr[i].length - 1); j >= 0; j--) {
				arr[i][j] = k++;
			}
		}

		for (int i = 0; i < arr.length; i++) { // ���
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");

			}
			System.out.println();
		}
	}

	public void exam04() { // �ǽ����� 1-2.
		int arr[][] = new int[5][5];
		int k = 1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[j][i] = k++;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public void exam05() { // �ǽ����� 1-3.

		int arr[][] = new int[5][5];
		int k = 1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = (arr.length - 1); j >= 0; j--) {
				arr[j][i] = k++;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void exam06() { // �ǽ����� 1-4.

		int arr[][] = new int[5][5];
		int k = 1;

		for (int i = 0; i < arr.length; i++) {

			if (i % 2 == 0) { // �ప�� ¦���϶� (0����)

				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = k++;
				}

			} else {

				for (int j = (arr[i].length) - 1; j >= 0; j--)
					arr[i][j] = k++;
			}
		}

		for (int i = 0; i < arr.length; i++) { // ��� ����
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public void exam07() { // �ǽ����� 2-1.
		int arr[][] = new int[5][5];
		int k = 1;

		for (int i = 0; i < arr.length; i++) {

			if (i % 2 == 0) {

				for (int j = (arr[i].length - 1); j >= 0; j--) {
					arr[i][j] = k++;

				}
			} else {

				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = k++;
				}
			}

		}

		for (int i = 0; i < arr.length; i++) { // ��� ����
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public void exam08() { // �ǽ����� 2-2.
		int arr[][] = new int[5][5];
		int k = 1;

		for (int i = 0; i < arr.length; i++) {

			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[j][i] = k++;
				}
			} else {
				for (int j = (arr[i].length - 1); j >= 0; j--) {
					arr[j][i] = k++;
				}
			}

		}

		for (int i = 0; i < arr.length; i++) { // ��� ����
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void exam09() { // �ǽ����� 2-3.

		int arr[][] = new int[5][5];
		int k = 1;

		for (int i = 0; i < arr.length; i++) {

			if (i % 2 == 0) {
				for (int j = (arr[i].length - 1); j >= 0; j--) {
					arr[j][i] = k++;
				}
			} else {
				for (int j = 0; j < arr[i].length; j++) {
					arr[j][i] = k++;
				}
			}

		}

		for (int i = 0; i < arr.length; i++) { // ��� ����
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void exam10() { // �ǽ����� 3.
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();

		int r = 0;
		int c = 0; // �迭�� ���ο� ���ΰ��� �� ����

		while (true) {
			
			if(r==0) { // width�� �ʱⰪ�� ������ �ʾ��� �� = �Է��� ���� ������� �ʾ�����
				System.out.print("�������� ������ �Է��ϼ��� (1~10) : ");
				
				int inputR = sc.nextInt();
				
				if(inputR > 10 || inputR < 1) {
					System.out.println("�ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.");
					continue;
					
				} else {
					r = inputR;
				}
				
			}
			
			if(c==0) {

				System.out.print("�������� ������ �Է��ϼ��� (1~10) : ");
				
				int inputC = sc.nextInt();

				if(inputC > 10 || inputC < 1) {
					System.out.println("�ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.");
					continue;
					
				} else {
					c = inputC;
				}
			}
			
			if(r!=0 || c!=0) {
				break;
			}
			
		}
		
		System.out.println("�Է��Ͻ� ���� ���δ� " + r + "X" + c + "�Դϴ�.");
		
		System.out.println("==============================================");
		
		int arr[][] = new int[r][c];
		
		// int a = 97; // ���ĺ� 'a' = 97, 'z' = 122
		
		
		for(int i=0; i<arr.length; i++) {
			
			for(int j=0; j<arr[i].length; j++) {
				
				arr[i][j] = rn.nextInt(26)+97;
				System.out.print((char)arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
