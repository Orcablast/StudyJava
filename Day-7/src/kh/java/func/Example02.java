package kh.java.func;

import java.util.Scanner;

public class Example02 {
	
	public void exam01() {
		Scanner sc = new Scanner(System.in);

		int num;
		int k = 1;

		while (true) { //

			System.out.print("2차원 배열 크기 입력 (정방형): ");
			num = sc.nextInt();

			if (num < 0) {
				continue;
			} else {
				break;
			}

		}

		int arr[][] = new int[num][num];

		int row = 0;
		int column = -1;
		int inc = 1;
		
		
		while(num!=0) {
			
			for(int i=0; i < num; i++) {
				column = column+inc;
				arr [row][column]=k++;
			}
			num--;
			
			for(int i=0; i < num; i++) {
				row = row+inc;
				arr[row][column]=k++;
			}
			inc=-inc;
			
			
			
		}
		

		for (int i = 0; i < arr.length; i++) { // 출력 구문
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public void exam02() {
		Scanner sc = new Scanner(System.in);
		
		int num;

		while (true) { //

			System.out.print("2차원 배열 크기 입력 (정방형): ");
			num = sc.nextInt();

			if (num < 0) {
				continue;
			} else {
				break;
			}

		}
		
		int k =1;
		int row=0;
		int column=5;
		int inc=1;
		
		int arr[][]= new int[num][num];
		
		while(num!=0) {
			
			for(int i=0; i<num; i++) {
				column-=inc;
				arr[row][column] = k++;
			}
			num--;
			for(int i=0; i<num; i++) {
				row+=inc;
				arr[row][column] = k++;
			}
			inc=-inc;
			
		}

		for (int i = 0; i < arr.length; i++) { // 출력 구문
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
