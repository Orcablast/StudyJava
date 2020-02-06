package kh.java.func;

import java.util.Scanner;
import java.util.Random;

public class Example01 { // 2차원 배열
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

		for (int i = 0; i < arr.length; i++) { // 출력
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");

			}
			System.out.println();
		}
	}

	public void exam03() { // 실습문제 1-1.
		int arr[][] = new int[5][5];
		int k = 1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = (arr[i].length - 1); j >= 0; j--) {
				arr[i][j] = k++;
			}
		}

		for (int i = 0; i < arr.length; i++) { // 출력
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");

			}
			System.out.println();
		}
	}

	public void exam04() { // 실습문제 1-2.
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

	public void exam05() { // 실습문제 1-3.

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

	public void exam06() { // 실습문제 1-4.

		int arr[][] = new int[5][5];
		int k = 1;

		for (int i = 0; i < arr.length; i++) {

			if (i % 2 == 0) { // 행값이 짝수일때 (0포함)

				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = k++;
				}

			} else {

				for (int j = (arr[i].length) - 1; j >= 0; j--)
					arr[i][j] = k++;
			}
		}

		for (int i = 0; i < arr.length; i++) { // 출력 구문
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public void exam07() { // 실습문제 2-1.
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

		for (int i = 0; i < arr.length; i++) { // 출력 구문
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public void exam08() { // 실습문제 2-2.
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

		for (int i = 0; i < arr.length; i++) { // 출력 구문
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void exam09() { // 실습문제 2-3.

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

		for (int i = 0; i < arr.length; i++) { // 출력 구문
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void exam10() { // 실습문제 3.
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();

		int r = 0;
		int c = 0; // 배열의 가로와 세로값이 될 변수

		while (true) {
			
			if(r==0) { // width의 초기값이 변하지 않았을 때 = 입력한 값이 저장되지 않았을때
				System.out.print("가로행의 개수를 입력하세요 (1~10) : ");
				
				int inputR = sc.nextInt();
				
				if(inputR > 10 || inputR < 1) {
					System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
					continue;
					
				} else {
					r = inputR;
				}
				
			}
			
			if(c==0) {

				System.out.print("세로행의 개수를 입력하세요 (1~10) : ");
				
				int inputC = sc.nextInt();

				if(inputC > 10 || inputC < 1) {
					System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
					continue;
					
				} else {
					c = inputC;
				}
			}
			
			if(r!=0 || c!=0) {
				break;
			}
			
		}
		
		System.out.println("입력하신 가로 세로는 " + r + "X" + c + "입니다.");
		
		System.out.println("==============================================");
		
		int arr[][] = new int[r][c];
		
		// int a = 97; // 알파벳 'a' = 97, 'z' = 122
		
		
		for(int i=0; i<arr.length; i++) {
			
			for(int j=0; j<arr[i].length; j++) {
				
				arr[i][j] = rn.nextInt(26)+97;
				System.out.print((char)arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
