package kh.java.array;

import java.util.Scanner;

public class Example01 {
	public void exam01() {
//		// 배열을 사용하지 않고 정수형 변수 5개를 만들어야 한다면?
//		int num1, num2, num3, num4, num5;
//		// 배열을 사용하여 정수형 변수 5개를 만들어야 한다면?
//		int[] num = new int[5];
//		// num[0],num[1], ...num[4]
//		System.out.println(num[0]);
//		System.out.println(num[1]);
//		System.out.println(num[2]);
//		System.out.println(num[3]);
//		System.out.println(num[4]);
//
//		num[1] = 10; // num 배열의 1번째 변수를 10으로 선언
//		System.out.println(num[1]);
//
//		num[0] = 1; // num 배열의 0번째 변수를 1으로 선언
//		num[1] = 2; // num 배열의 1번째 변수를 2으로 선언
//		num[2] = 3; // num 배열의 2번째 변수를 3으로 선언
//		num[3] = 4; // num 배열의 3번째 변수를 4으로 선언
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
//			System.out.print("이름을 입력하세요 : ");
//			arr[i] = sc.next();
//		}
//		while(true) {
//			System.out.print("몇번째 이름을 보시겠습니까? : ");
//			int userNum = sc.nextInt();
//			System.out.println(userNum + "번째 이름은 " + arr[userNum] + "입니다");			
//		}
		
		
		String[] arr = new String[10];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<arr.length; i++) {
			System.out.print("이름을 입력하세요 : ");
			arr[i] = sc.next();
		}

		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
			
		
	}
}
