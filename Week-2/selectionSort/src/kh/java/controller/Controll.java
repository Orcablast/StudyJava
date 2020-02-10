package kh.java.controller;

import java.util.Scanner;
import java.util.Random;
import kh.java.vo.Data;

public class Controll {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	Data[] arr;

	public void main() {
		
		Data[] arr = new Data[10];

		while (true) {
			

			System.out.println("��ü �迭�� �����մϴ�");

			createArr();

			System.out.println("��ü �迭�� ����մϴ�");

			showArrAll();

			System.out.println("� ������ �Ͻðڽ��ϱ�?");
			System.out.println("1. ���� ����");
			System.out.println("2. ���� ����");			
			int inputNum = sc.nextInt();

			switch (inputNum) {
			case 1: // ���� ����
				selecSort();
				
				System.out.println("��ü �迭�� ����մϴ�");

				showArrAll();
				break;

			case 2: // ���� ����
				insertSort();
				
				System.out.println("��ü �迭�� ����մϴ�");
				
				showArrAll();				
				break;

			case 3: // �պ� ����
				break;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
				continue;

			}

			break;
		}

	}

	public void createArr() {				
		
		for (int i = 0; i < arr.length; i++) { // Data ��ü�� 10�� �����Ͽ� arr[i]��°�� ����
			Data dt = new Data(rn.nextInt(50) + 1);
			for(int j=0; j<i; j++) { // �ߺ��Ͻ� ���� ���Է�
				if(dt.getData()==arr[j].getData()) {
					dt.setData(rn.nextInt(50)+1);
					j=-1;
				}				
			}
			arr[i] = dt;
		}

	}

	public void showArrAll() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].getData() + " ");
		}
		System.out.println();
	}
	
	public void selecSort() {
		for(int j=0; j<arr.length; j++) {
			int index=j;
			int temp;
			for(int i=j; i<arr.length; i++) {
				if (arr[i].getData()<arr[index].getData()) {
					index=i;
				} 
				
				if(i==arr.length-1) {
					temp = arr[j].getData();
					arr[j].setData(arr[index].getData());
					arr[index].setData(temp);
				}
			}
			System.out.println((j+1)+"��° ����");
			
			showArrAll();
			
		}		
	}
	
	public void insertSort() { // ���� ���� �޼ҵ�
		
		for(int i=0; i<arr.length; i++) {
			int index=i;
			int temp;
			
			for(int j=i; j<arr.length; j++) {
				if(arr[index].getData()>arr[j].getData()) {
					index=j;					
				}
			}			
			
			if(index!=i) {
				temp = arr[index].getData();
				for(int j=index; j>i; j--) {
					arr[j].setData(arr[j-1].getData());					
				}
				arr[i].setData(temp);
			}
			System.out.println((i+1)+"��° ����");
			
			showArrAll();
			
		}		
	}
	
	public void mergeSort() {
		
	}
	
}
