package kh.java.array;

import java.util.Scanner;

public class Example05 {
	public void exam01() {
		Scanner sc = new Scanner(System.in);

		System.out.print("홀수를 입력하세요 : ");
		int num = sc.nextInt(); // 입력한 정수를 변수 num에 저장

		// 배열의 길이를 num으로 갖는 정수형 배열 arr을 선언
		// 배열의 각 값은 아직 선언되지 않음
		int arr[] = new int[num];

		if (num % 2 == 1) { // 입력한 변수 num이 홀수일 때

			// 배열 arr의 길이 '값' 미만까지 i값을 1씩 증가시키는 반복문
			for (int i = 0; i < arr.length; i++) {

				// i값이 num/2 + 1 값보다 작은 경우

				// num이 7이라면
				// -> 7/2 + 1 보다 작은 경우 -> i < 4
				// 이 조건문에 부합하는 i의 최댓값은 3
				if (i < (num / 2 + 1)) {

					// arr 배열의 i번째 값을 i+1 값으로 선언
					// i가 0이라면 - > arr[0] = 0+1;
					// i가 2 라면 - > arr[2] = 2+1;
					arr[i] = i + 1;

					// i값이 num/2 + 1 값보다 크거나 같은 경우
					//
				} else if (i >= (num / 2 + 1)) {
					
					// arr배열 i번째 값 i번째 [i-1]번째 값  
					arr[i] = arr[i - 1] - 1;
				}

			}

		}
		

	}

}
