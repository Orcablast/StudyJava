package kh.java.array;
import java.util.Scanner;

public class Example02 {
	public void exam01() {
		String [] fruit = new String[5];
		fruit[0] = "딸기";
		fruit[1] = "복숭아";
		fruit[2] = "키위";
		fruit[3] = "사과";
		fruit[4] = "바나나";
		
		System.out.println("실습 문제 1-1");
		System.out.println(fruit[4]);
		System.out.println();
		
		System.out.println("실습문제 1-2");
		System.out.println(fruit[0]);
		System.out.println(fruit[1]);
		System.out.println(fruit[2]);
		System.out.println(fruit[3]);
		System.out.println(fruit[4]);
		System.out.println();
		
		System.out.println("실습문제 1-3");
		for(int i=0; i<fruit.length; i++) {
			System.out.println(fruit[i]);
		}
	
	}
	
	public void exam02() { // 실습문제 2.
		int array [] = new int[100];
		for(int i=0; i<array.length; i++) {
			array[i] = i;
			System.out.println((i+1)+"번째 값은 "+array[i]+"입니다");
		}
	}
	
	public void exam03() { // 실습문제 3.
		Scanner sc = new Scanner(System.in);
		int arr [] = new int[4];
		int scrSum = 0; // 점수의 합계가 저장될 변수
		
		for(int i=0; i<arr.length; i++) { // 0에서 시작하여 배열의 길이보다 적을때까지 i값을 1 증가		
			
			if(i==arr.length-1) { // i값이 배열의 길이-1 과 같을때 -> 배열의 길이 마지막값
				arr[i] = scrSum; // 
				
				for(int j=0; j<arr.length; j++) { // j값이 배열의 길이보다 적을때까지 j값을 1 증가
					
					if(j==arr.length-1) { // 
						
						System.out.println("합계 : " + scrSum);
						System.out.printf("평균 : %.2f",(double)scrSum/(arr.length-1));
						
					} else {
						
						System.out.println((j+1)+"번째 점수는 : "+arr[j]);
					}
				}
			} else { // i값이 배열의 길이 마지막값이 아닌 모든 경우
				
				System.out.print((i+1)+"번째 점수를 입력하세요 : ");
				arr[i] = sc.nextInt(); // 입력받은 정수를 배열 i번째 변수로 저장
				scrSum += arr[i]; // 저장한 변수값을 scrSum에 더하여 저장 (점수의 합계)
			}
		}
		
	}
}
