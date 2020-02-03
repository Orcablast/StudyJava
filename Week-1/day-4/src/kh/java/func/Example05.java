package kh.java.func;
import java.util.Scanner;

public class Example05 { // 중첩for문 추가 실습문제
	public void exam01() { // Q16.
		// 변수 i값을 1로 선언, i값이 5보다 작거나 같을때까지 for문 실행 후 i값을 1 증가
		// i값은 1에서 5까지 총 5회 반복
		for(int i =1; i<=5; i++) {
			// 변수 j값을 i로 선언, j가 5보다 작을때까지 for문 실행 후 j값을 1 증가 
			// 입력받은 i값에 따라 j의 초기값이 변화 (i의 반복마다 j의 초기값이 변화)
			// i값이 반복증가함에 따라 j값을 반복증가시켜 5에 도달하는 횟수가 감소
			// 결과적으로 i의 반복마다 공백을 출력하는 횟수가 감소 (4회 -> 0회)
			for(int j=i; j<5; j++) {
				// 출력되는 공백을 시각적으로 확인하려면 공백대신 1을 대입해보자
				System.out.print(" ");
			}
			// 변수 h의 값을 (2*i)로 선언, h가 1보다 클때까지 for문 실행 후 h값을 1 감소
			// 입력받은 i의 2배로 j의 초기값이 변화 (i의 반복마다 j의 초기값이 변화)
			// 결과적으로 매 i값이 1 증가할때마다 h값을 반복감소시켜 1에 도달하기까지의 횟수가 2회씩 증가한다
			for(int h=2*i; h>1; h--) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
	
	public void exam02() { // Q17.
		// 변수 i의 값을 1로 선언, i가 5보다 작거나 같을때까지 for문을 실행 후 i값을 1 증가
		// i의 값은 1에서 5까지 총 5회 반복
		for(int i=1; i<=5; i++) {
			// 변수 h의 값을 1로 선언, h가 1보다 클때까지 for문을 실행후 h값을 1 감소		
			// 입력받는 i값에 따라 h의 초기값이 변화 (i의 반복마다 h의 초기값 변화)
			// 초기값에서 반복감소하여 1까지 도달하는 횟수는 i값에 의해 증가
			for(int h=i; h>1; h--) {
				System.out.print(" ");				
			}
			// 변수 j의 값을 i의 2배수로 선언, j가 10보다 같거나 클때까지 for문을 실행후 j값을 1 증가
			// 입력받는 i값의 배수로 h의 초기값이 변화
			// 초기값에서 반복증가하여 10까지 도달하는 횟수는 2개씩 증가 (초기값이 2배씩 늘어나기 때문)			
			for(int j=2*i; j<=10; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void exam03() { // Q18.
		// 변수 i의 값을 1로 선언, i가 5보다 작거나 같을때까지 for문을 실행하고 i의 값을 1 증가
		// i값은 1에서 5까지 총 5회 반복
		for(int i=1; i<=5; i++) {			
			if(i!=5) { // i값이 5가 아닐때(i값 : 1,2,3,4)
				// 변수 l의 값을 i로 선언, l값이 4보다 작거나 같을때까지 for문을 실행후 l의 값을 1 증가
				// 입력받는 i값에 따라 l의 초기값이 변화
				// i값은 증가하며 입력되므로 l의 반복횟수가 감소한다
				for(int l=i; l<=4; l++) {
					System.out.print(" ");
				}
				// 변수 j의 값을 i의 2배수로 선언, j의 값이 1보다 작을때까지 for문을 실행 후 j값을 1 감소
				// 변수 j의 초기값은 i값에 의해 변화 (i값이 1 증가할때 j값은 2개씩 증가한다)	
				// i값이 1 증가할때 j의 반복횟수는 2씩 증가한다
				for(int j=2*i; j>1; j--) {
					System.out.print("*");
				}
				System.out.println(); // for 반복이 종료되면 1줄 진행
			} else if (i==5){ // else로 취급해도 무방
				// 변수 h의 값을 1로 선언, h가 5보다 작거나 같을때까지 for문을 실행후 h의 값을 1 증가
				// h의 값은 1~5까지 총 5회 반복
				for(int h=1; h<=5; h++) {
					// 변수 n의 값을 h로 선언, n값이 1보다 작을때까지 for문을 실행 후 n의 값을 1 감소
					// n의 초기값은 i가 증가함에 따라 변화
					// 입력받은 i값이 곧 반복횟수가 된다
					for(int n=h; n>1; n--) {
						System.out.print(" ");
					}
					// 변수 k의 값을 h의 2배수로 선언, k값이 10보다 작거나 같을때까지 for문을 실행 후 k값을 1 증가
					// k의 초기값은 h의 2배수로 변화 
					// h의 반복마다 k의 초기값은 2씩 증가한다	-> 출력횟수는 2씩 감소				
					for(int k=2*h; k<=10; k++) {
						System.out.print("*");
					}
					System.out.println(); // 반복문이 종료되면 1줄 진행
				}
			}
		}
	}
	public void exam04() { // Q19.
		// 변수 i값을 1로 선언, i값이 5보다 작거나 같을때까지 for문 실행후 i값을 1 증가
		// i값은 1~5까지 총 5회 반복
		for(int i=1; i<=5; i++) {
			// i값이 5가 아닌 모든 경우 (입력받는 i값:1,2,3,4)
			if(i!=5) {
				// 변수 j의 값을 i로 선언, j값이 5보다 작거나 같을때까지 j값을 증가				
				// j의 초기값은 입력받은 i값에 의해 변화
				// i값은 1씩 증가하며 입력되고 j의 출력횟수는 1씩 감소한다
				for(int j=i;j<=5;j++) {
					System.out.print("*");
				}
				// 변수 h의 값을 i의 2배수로 선언, h값이 1보다 클때까지 for문을 실행후 h값을 1 감소
				// 변수 h의 초기값은 입력받은 i값에 의해 변화
				// i값은 1씩 증가하며 입력되고 j의 출력횟수는 2씩 감소한다 
				for(int h=2*i;h>1; h--) {
					System.out.print(" ");
				}
				// 변수 k의 값을 i로 선언, k값이 1보다 클때까지 for문을 실행 후 k값을 1 증가
				// 변수 k의 초기값은 입력받은 i값에 의해 변화
				// i값은 1씩 증가하며 입력되고 k의 출력횟수는 1씩 감소				
				for(int k=i; k<=5; k++) {
					System.out.print("*");
				}
				System.out.println(); // for 반복이 끝나면 1줄 진행
			} else if (i==5){ // else로 취급해도 결과는 같음
				// l의 초기값을 1로 선언, l값이 5보다 작거나 같을때까지 for문을 실행 후 l값을 1 증가
				// l의 값은 1~5까지 총 5회 반복
				for(int l=1; l<=5; l++) {
					// m의 초기값을 l로 선언, m이 1보다 크거나 같을때까지 for문을 실행 후 m값을 1 감소
					// l값은 1씩 증가함에 따라 m의 반복횟수는 1씩 감소한다
					for(int m=l; m>=1;m--) {
						System.out.print("*");
					}
					// 변수 n의 초기값을 l의 2배수로 선언, n이 10보다 작거나 같을때까지 for문을 실행 후 n값을 증가
					// l값이 1씩 증가함에 따라 n의 반복횟수는 2씩 감소
					for(int n=2*l; n<=10; n++) {
						System.out.print(" ");
					}
					// 변수 o의 초기값을 l로 선언, 0가 1보다 크거나 같을때까지 for문을 실행 후 o값을 1씩 감소
					// l값이 1씩 증가함에 따라 o의 반복횟수는 1씩 증가
					for(int o=l; o>=1; o--) {
						System.out.print("*");
					}
					System.out.println(); // for 반복문이 끝나면 1줄 진행한다
				}
			}
		}
	}
	
	public void exam05() { // Q20.
		// i의 값을 1로 선언, i값이 5보다 작거나 같을때까지 for문을 실행 후 i값을 1씩 증가
		for(int i=1; i<=5; i++) {
			if(i!=5) {
				for(int o=i; o>0;o-- ) {
					System.out.print("*");
				}
				for(int p=2*i; p<=10; p++) {
					System.out.print(" ");
				}
				for(int j=i; j>0; j--) {
					System.out.print("*");
				}
				System.out.println();
			} else if(i==5) {
				for(int h=i; h>0; h--) {
					for(int k=h; k>0; k--) {
						System.out.print("*");
					}
					for(int l=2*h; l<=10; l++) {
						System.out.print(" ");
					}
					for(int n=h; n>0; n--) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
		}
	}
	
	public void exam06() {
		for(int i=1; i<=5; i++) {
			if(i!=5) {
				for(int o=i; o>0;o--) {
					System.out.print(" ");
				}
				for(int p=2*i; p<=10; p++) {
					System.out.print("*");
				}
				System.out.println();
			} else if(i==5) {
				for(int h=i; h>0; h--) {
					for(int k=h; k>0; k--) {
						System.out.print(" ");
					}
					for(int l=2*h; l<=10; l++ ) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
		}
	}
	
	public void exam07() { // 홀수값을 입력받는 Q16.
		Scanner sc = new Scanner(System.in);
		System.out.print("홀수를 입력하세요 : ");
		int num = sc.nextInt();
		if(num%2==1) {
			System.out.println("입력받은 정수는 [" + num + "] 입니다");
			int count = (num/2) + 1;
			for(int i=1; i<=count; i++) {
				for(int j=i; j<count; j++) {
					System.out.print(" ");
				}
				for(int h=2*i; h>1; h--) {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println("["+ num + "]을 최대값으로 가지는 모양을 완성하였습니다.");
		} else{
			System.out.println("홀수가 아닙니다");
			System.out.println("프로그램을 종료합니다.");
		}		
	}
}
