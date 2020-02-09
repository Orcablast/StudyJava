package kh.java.controller;

import java.util.Scanner;
import java.util.Random;
import kh.java.vo.Data;

public class Controll {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	Data[] arr = new Data[10];

	public void main() {

		while (true) {
			

			System.out.println("��ü �迭�� �����մϴ�");

			createArr();

			System.out.println("��ü �迭�� ����մϴ�");

			showArrAll();

			System.out.println("� ������ �Ͻðڽ��ϱ�?");
			int inputNum = sc.nextInt();

			switch (inputNum) {
			case 1: // ���� ����
				selecSort();
				
				System.out.println("��ü �迭�� ����մϴ�");

				showArrAll();
				break;

			case 2:
				break;

			case 3:
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
			Data dt = new Data(rn.nextInt(10) + 1);
			for(int j=0; j<i; j++) { // �ߺ��Ͻ� ���� ���Է�
				if(dt.getData()==arr[j].getData()) {
					dt.setData(rn.nextInt(10)+1);
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

		for(int j=0; j<10; j++) {
			int index=j;
			int temp;
			for(int i=j; i<10; i++) {
				if (arr[i].getData()<arr[index].getData()) {
					index=i;
				}
				
				if(i==9) {
					temp = arr[j].getData();
					arr[j].setData(arr[index].getData());
					arr[index].setData(temp);
				}				
			}
			System.out.println((j+1)+"��° ����");
			
			showArrAll();
			
		}
		
		
		
	}
	
}
