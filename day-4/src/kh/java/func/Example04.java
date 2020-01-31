package kh.java.func;
import java.util.Scanner;

public class Example04 {
	public void exam01() {
		for (int i = 2; i<=9; i++) {
			for(int j = 1; j<=9; j++) {
				System.out.printf("%d * %d = %d\t",i,j,(i*j));
			}
			System.out.printf("\n");
		}
	}
	
	public void exam02() { // 연습문제 02 review 필수
		for(int i = 1; i<=9; i++) {
			for(int j = 2; j<=9; j++) {
				System.out.printf("%d * %d = %d\t",j,i,(i*j));
			}
			System.out.printf("\n");
		}
	}
	
//	public void exam03() {
//		System.out.println("Q1.");
//		for(int i = 1; i<=5; i++) {
//			System.out.print("*");
//		}
//		System.out.println("Q2.");
//		for(int i = 1; i<=5; i++) {
//			System.out.print("*");
//			System.out.println();
//		}
//		System.out.println("Q3.");
//		for(int i = 1; i<=5; i++) {
//			for(int j = 1; j<=5; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println("Q4.");
//		for(int i = 1; i<=5; i++) {
//			for(int j = 1; j<=5; j++) {
//				System.out.print(i);
//			}
//			System.out.println();
//		}
//		System.out.println("Q5.");
//		for(int i=1; i<=5; i++) {	
//			int num = 0;
//			for(int j=1; j<=5; j++) {
//				num++;
//				System.out.print(num);
//			}
//			System.out.println();
//		}
//		System.out.println("Q6.");
//		for(int i=0; i<=4; i++) {
//			int num = i;
//			for(int j=1; j<=5; j++) {
//				num++;
//				System.out.print(num);
//			}
//			System.out.println();
//		}
//		System.out.println("Q7.");
//		for(int i=4; i>=0; i--) {
//			int num = i;
//			for(int j=1; j<=5; j++) {
//				num++;
//				System.out.print(num);
//			}
//			System.out.println();
//		}
//		System.out.println("Q8.");
//		for(int i=1; i<=5; i++) {
//			for(int j=1; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println("Q9.");
//		for(int i=5; i>0; i--) {
//			for(int j=1; j<=i; j++ ) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println("Q10.");
//		for(int i=1; i<=5; i++) {
//			for(int j=6; j>i; j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//			for(int h=1; h<=i; h++) {
//				System.out.print(" ");
//			}		
//		}
//		System.out.println("Q11.");
//		for(int i=1; i<=5; i++) {
//			for(int j=5; (j-i)>=1; j--) {
//				System.out.print("1");				
//			}
//			for(int h=1; h<=i; h++) {
//				System.out.print("2");
//			}
//			System.out.println();			
//		}
//		System.out.println("Q12.");
//		for(int i=1; i<=10; i++) {
//			if(i <= 5) { 
//				for(int j =1; j<i; j++) {
//					System.out.print("*");					
//				}
//				System.out.println();
//			} else {
//				for(int h=10; h>=i ; h--) {
//					System.out.print("*");
//				}
//				System.out.println();
//			}
//		}
//		System.out.println("Q13.");
//		for(int i = 1; i<=9; i++) {
//			if(i <= 5) {
//				for(int j=5; j>=i; j-- ) {
//					System.out.print("*");
//				}
//				System.out.println();
//			} else {
//				for(int h=5; h<=i; h++) {
//					System.out.print("*");
//				}
//				System.out.println();
//			}
//		}				
//	}
	public void exam04() { // 자습문제 01
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int n = sc.nextInt();		
		for(int i = 1; i<=n; i++) {
			if(i!=n) {
				for(int j=i; j>0;j--) {
					System.out.print("1");
				}
				System.out.println();
			} else if (i==n) {
				for(int h=n;h>0 ; h--) {
					for(int k=h; k>0; k--) {
						System.out.print("2");
					}
					System.out.println();
				}
			}
		}				
	}
	
	public void exam05() { // 자습문제 02
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			if(i!=n) {
				for(int j=i; j<=n ; j++ ) {
					System.out.print("1");
				}
				System.out.println();
			} else if(i==n) {
				for(int h=i; h>0 ; h--) {
					for(int k=n; k>=h; k--) {
						System.out.print("2");
					}
					System.out.println();
				}
			}
			
		}
	}
	
//	public void exam06() { // Q8. 재풀이
//		for(int i=1; i<=5; i++) {
//			for(int j=5; j>=i; j--) {
//				System.out.print("*");				
//			}
//			System.out.println();
//		}
//	}
	
//	public void exam07() { // Q9. 재풀이.....인데 왜 Q8.?? ㅠㅠㅠ
//		for(int i=1; i<=5; i++) {
//			for(int j=i; j<=5 ; j++) {
//				System.out.print("*");				
//			}
//			System.out.println();			
//		}
//	}
	
//	public void exam08() { // Q9. 재풀이
//		for(int i=1; i<=5; i++) {
//			for(int j=i; j>0; j-- ) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//	}
}
	
