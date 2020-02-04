package kh.java.array;

import java.util.Scanner;
import java.util.Random;

public class BubbleSort {
	public void sort01() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭�� ���̸� �����ּ��� : ");
		int length = sc.nextInt();
		int arr[] = new int[length];
		int temp;
		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "��° ���� �Է� : ");
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1; j++) {

				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public void sort02() { // �ǽ����� 01 ����. ������ ���ڸ� �ڵ����� �Է�
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭�� ���̸� �����ּ��� : ");
		int length = sc.nextInt();
		System.out.print("���� ������ �ִ밪 : ");
		int range = sc.nextInt();
		int arr[] = new int[length];
		int temp;
		int rnNum;
		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "��° ���� �Է� : ");
			rnNum = rn.nextInt(range);
			arr[i] = rnNum;
			System.out.println(rnNum);
		}
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1; j++) {

				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public void exam03() {
		Scanner sc = new Scanner(System.in);

		boolean programOn = true;
		int sltMenu;
		int sltRoom;

		boolean roomList[] = new boolean[10];

		while (programOn == true) {
			System.out.println("���� ���� ���α׷� v1.0");
			System.out.printf("1.�Խ�\t2.���\t3.�溸��\t4.����\n");
			System.out.print("���� > ");

			sltMenu = sc.nextInt();

			switch (sltMenu) {
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				programOn = false;
				break;

			case 3:
				for (int i = 0; i < roomList.length; i++) {
					if (!roomList[i]) {
						System.out.println((i + 1) + "������ ���� ����ֽ��ϴ�");
					} else {
						System.out.println((i + 1) + "���濡�� ���� �մ��� �ֽ��ϴ�");
					}
				}
				break;

			case 2:
				System.out.print("����濡�� ����Ͻðڽ��ϱ�? : ");
				sltRoom = (sc.nextInt()) - 1;
				if (roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "��° �濡�� ����ϼ̽��ϴ�");
					roomList[sltRoom] = false;

				} else if (!roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "������ ���� �� ���Դϴ�");
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�");
				}
				break;

			case 1:
				System.out.print("����濡 �Խ��Ͻðڽ��ϱ�? : ");
				sltRoom = (sc.nextInt()) - 1;
				if (roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "������ ���� �մ��� �ֽ��ϴ� ");
				} else if (!roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "���濡 �Խ��ϼ̽��ϴ�");
					roomList[sltRoom] = true;
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�");
				}
				break;

			default: 
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
		}
	}
	
	public void exam04() { // �ǽ����� 02 ����. ���� ���� �Է¹޾� �� ���Ǹ�ŭ�� ���α׷��� ����
		Scanner sc = new Scanner(System.in);

		boolean programOn = true;
		int roomNum;
		int occNum =0; 
		int sltMenu;
		int sltRoom;

		System.out.print("���� ������ �Է��ϼ��� : ");
		roomNum = sc.nextInt();
		
		boolean roomList[] = new boolean[roomNum];
				
		while (programOn == true) {
			System.out.println("���� ���� ���α׷� v1.0");
			System.out.println("��ü : "+roomNum+"\t�Խ� : "+occNum+"\t���� : "+(roomNum-occNum));
			System.out.printf("1.�Խ�\t2.���\t3.�溸��\t4.����\n");
			System.out.print("���� > ");

			sltMenu = sc.nextInt();

			switch (sltMenu) {
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				programOn = false;
				break;

			case 3:
				for (int i = 0; i < roomList.length; i++) {
					if (roomList[i]) {
						System.out.println((i + 1) + "������ ���� ����ֽ��ϴ�");
					} else {
						System.out.println((i + 1) + "���濡�� ���� �մ��� �ֽ��ϴ�");
					}
				}
				break;

			case 2:
				System.out.print("����濡�� ����Ͻðڽ��ϱ�? : ");
				sltRoom = (sc.nextInt()) - 1;
				if (roomList[sltRoom]) {
					occNum--;
					System.out.println((sltRoom+1) + "��° �濡�� ����ϼ̽��ϴ�");
					roomList[sltRoom] = false;

				} else if (!roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "������ ���� �� ���Դϴ�");
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�");
				}
				break;

			case 1:
				System.out.print("����濡 �Խ��Ͻðڽ��ϱ�? : ");
				sltRoom = (sc.nextInt()) - 1;
				if (roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "������ ���� �մ��� �ֽ��ϴ� ");
				} else if (!roomList[sltRoom]) {
					occNum++;
					System.out.println((sltRoom+1) + "���濡 �Խ��ϼ̽��ϴ�");
					roomList[sltRoom] = true;
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�");
				}
				break;

			default: 
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
		}
	}
	
}
