package kh.java.array;

import java.util.Scanner;

public class Example05 {

	public void exam01() { // �ּ� ������ �Ʒ� �޼ҵ� ����
		Scanner sc = new Scanner(System.in);

		System.out.print("Ȧ���� �Է��ϼ��� : ");
		int num = sc.nextInt(); 
		
		
		int arr[] = new int[num];

		if (num % 2 == 1) {
			
			for (int i = 0; i < arr.length; i++) {

				if (i < (num / 2 + 1)) {

					arr[i] = i + 1;

				} else if (i >= (num / 2 + 1)) {
					
					arr[i] = arr[i - 1] - 1;
				}
				
				System.out.print(arr[i]+" ");
			}						
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void exam02() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Ȧ���� �Է��ϼ��� : ");
		int num = sc.nextInt(); // �Է��� ������ ���� num�� ����

		// �迭�� ���̸� num���� ���� ������ �迭 arr�� ����
		// �迭�� �� ���� ���� ������� ����
		int arr[] = new int[num];

		if (num % 2 == 1) { // �Է��� ���� num�� Ȧ���� ��

			// �迭 arr�� ���� '��' �̸����� i���� 1�� ������Ű�� �ݺ���
			for (int i = 0; i < arr.length; i++) {

				// i���� num/2 + 1 ������ ���� ���
				// num�� 7�̶��
				// -> 7/2 + 1 ���� ���� ��� -> i < 4
				// �� ���ǹ��� �����ϴ� i�� �ִ��� 3
				// i���� 0,1,2,3 �϶� true
				if (i < (num / 2 + 1)) {

					// arr �迭�� i��° ���� i+1 ������ ����
					// ����) i�� 0�̶�� - > arr[0] = 0+1;
					// ����) i�� 2 ��� - > arr[2] = 2+1;
					arr[i] = i + 1;

					// i���� num/2 + 1 ������ ũ�ų� ���� ���
					// num�� 7�̶��
					// -> 7/2 +1 ���� ũ�ų� ���� ��� -> i >= 4
					// i���� 4, 5, 6�϶� true
				} else if (i >= (num / 2 + 1)) {
					
					// arr�迭 i��° �� i��° [i-1]��° ��  
					// ����) i�� 4��� -> arr[4] = arr[3] -1
					// ����) i�� 6�̶�� -> arr[6] = arr[5] -1
					arr[i] = arr[i - 1] - 1;
				}
				
				System.out.print(arr[i]+" ");
			}						
		} else { // �Է¹��� ���� Ȧ���� �ƴҶ�
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
}