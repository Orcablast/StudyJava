package kh.java.array;
import java.util.Scanner;

public class Example02 {
	public void exam01() {
		String [] fruit = new String[5];
		fruit[0] = "����";
		fruit[1] = "������";
		fruit[2] = "Ű��";
		fruit[3] = "���";
		fruit[4] = "�ٳ���";
		
		System.out.println("�ǽ� ���� 1-1");
		System.out.println(fruit[4]);
		System.out.println();
		
		System.out.println("�ǽ����� 1-2");
		System.out.println(fruit[0]);
		System.out.println(fruit[1]);
		System.out.println(fruit[2]);
		System.out.println(fruit[3]);
		System.out.println(fruit[4]);
		System.out.println();
		
		System.out.println("�ǽ����� 1-3");
		for(int i=0; i<fruit.length; i++) {
			System.out.println(fruit[i]);
		}
	
	}
	
	public void exam02() { // �ǽ����� 2.
		int array [] = new int[100];
		for(int i=0; i<array.length; i++) {
			array[i] = i;
			System.out.println((i+1)+"��° ���� "+array[i]+"�Դϴ�");
		}
	}
	
	public void exam03() { // �ǽ����� 3.
		Scanner sc = new Scanner(System.in);
		int arr [] = new int[4];
		int scrSum = 0; // ������ �հ谡 ����� ����
		
		for(int i=0; i<arr.length; i++) { // 0���� �����Ͽ� �迭�� ���̺��� ���������� i���� 1 ����		
			
			if(i==arr.length-1) { // i���� �迭�� ����-1 �� ������ -> �迭�� ���� ��������
				arr[i] = scrSum; // 
				
				for(int j=0; j<arr.length; j++) { // j���� �迭�� ���̺��� ���������� j���� 1 ����
					
					if(j==arr.length-1) { // 
						
						System.out.println("�հ� : " + scrSum);
						System.out.printf("��� : %.2f",(double)scrSum/(arr.length-1));
						
					} else {
						
						System.out.println((j+1)+"��° ������ : "+arr[j]);
					}
				}
			} else { // i���� �迭�� ���� ���������� �ƴ� ��� ���
				
				System.out.print((i+1)+"��° ������ �Է��ϼ��� : ");
				arr[i] = sc.nextInt(); // �Է¹��� ������ �迭 i��° ������ ����
				scrSum += arr[i]; // ������ �������� scrSum�� ���Ͽ� ���� (������ �հ�)
			}
		}
		
	}
}
