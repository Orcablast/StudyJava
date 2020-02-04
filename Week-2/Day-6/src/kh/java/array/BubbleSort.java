package kh.java.array;

import java.util.Scanner;
import java.util.Random;

public class BubbleSort {
	public void sort01() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 길이를 정해주세요 : ");
		int length = sc.nextInt();
		int arr[] = new int[length];
		int temp;
		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "번째 숫자 입력 : ");
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

	public void sort02() { // 실습문제 01 응용. 랜덤한 숫자를 자동으로 입력
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 길이를 정해주세요 : ");
		int length = sc.nextInt();
		System.out.print("랜덤 범위의 최대값 : ");
		int range = sc.nextInt();
		int arr[] = new int[length];
		int temp;
		int rnNum;
		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "번째 숫자 입력 : ");
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
			System.out.println("모텔 관리 프로그램 v1.0");
			System.out.printf("1.입실\t2.퇴실\t3.방보기\t4.종료\n");
			System.out.print("선택 > ");

			sltMenu = sc.nextInt();

			switch (sltMenu) {
			case 4:
				System.out.println("프로그램을 종료합니다.");
				programOn = false;
				break;

			case 3:
				for (int i = 0; i < roomList.length; i++) {
					if (!roomList[i]) {
						System.out.println((i + 1) + "번방이 현재 비어있습니다");
					} else {
						System.out.println((i + 1) + "번방에는 현재 손님이 있습니다");
					}
				}
				break;

			case 2:
				System.out.print("몇번방에서 퇴실하시겠습니까? : ");
				sltRoom = (sc.nextInt()) - 1;
				if (roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "번째 방에서 퇴실하셨습니다");
					roomList[sltRoom] = false;

				} else if (!roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "번방은 현재 빈 방입니다");
				} else {
					System.out.println("잘못 입력하셨습니다");
				}
				break;

			case 1:
				System.out.print("몇번방에 입실하시겠습니까? : ");
				sltRoom = (sc.nextInt()) - 1;
				if (roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "번방은 현재 손님이 있습니다 ");
				} else if (!roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "번방에 입실하셨습니다");
					roomList[sltRoom] = true;
				} else {
					System.out.println("잘못 입력하셨습니다");
				}
				break;

			default: 
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}
	
	public void exam04() { // 실습문제 02 응용. 객실 수를 입력받아 그 객실만큼의 프로그램을 구동
		Scanner sc = new Scanner(System.in);

		boolean programOn = true;
		int roomNum;
		int occNum =0; 
		int sltMenu;
		int sltRoom;

		System.out.print("보유 객실을 입력하세요 : ");
		roomNum = sc.nextInt();
		
		boolean roomList[] = new boolean[roomNum];
				
		while (programOn == true) {
			System.out.println("모텔 관리 프로그램 v1.0");
			System.out.println("전체 : "+roomNum+"\t입실 : "+occNum+"\t공실 : "+(roomNum-occNum));
			System.out.printf("1.입실\t2.퇴실\t3.방보기\t4.종료\n");
			System.out.print("선택 > ");

			sltMenu = sc.nextInt();

			switch (sltMenu) {
			case 4:
				System.out.println("프로그램을 종료합니다.");
				programOn = false;
				break;

			case 3:
				for (int i = 0; i < roomList.length; i++) {
					if (roomList[i]) {
						System.out.println((i + 1) + "번방이 현재 비어있습니다");
					} else {
						System.out.println((i + 1) + "번방에는 현재 손님이 있습니다");
					}
				}
				break;

			case 2:
				System.out.print("몇번방에서 퇴실하시겠습니까? : ");
				sltRoom = (sc.nextInt()) - 1;
				if (roomList[sltRoom]) {
					occNum--;
					System.out.println((sltRoom+1) + "번째 방에서 퇴실하셨습니다");
					roomList[sltRoom] = false;

				} else if (!roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "번방은 현재 빈 방입니다");
				} else {
					System.out.println("잘못 입력하셨습니다");
				}
				break;

			case 1:
				System.out.print("몇번방에 입실하시겠습니까? : ");
				sltRoom = (sc.nextInt()) - 1;
				if (roomList[sltRoom]) {
					System.out.println((sltRoom+1) + "번방은 현재 손님이 있습니다 ");
				} else if (!roomList[sltRoom]) {
					occNum++;
					System.out.println((sltRoom+1) + "번방에 입실하셨습니다");
					roomList[sltRoom] = true;
				} else {
					System.out.println("잘못 입력하셨습니다");
				}
				break;

			default: 
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}
	
}
