package kh.java.func;
import java.util.Scanner;

public class Example06 {
	public void exam01() { // pattern 10.
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 행(row)를 출력하시겠습니까? : ");
		int row = sc.nextInt();
		for(int i=1; i<=row; i++) {
			for(int j=i; j<row; j++) {
				System.out.print(" ");
			}
			for(int h=1; h<=5; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void exam02() { // pattern 11.
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 행(row)를 출력하시겠습니까? :");
		int row = sc.nextInt();
		for(int i=1; i<=row; i++) {
			for(int j=i; j>1; j--) {
				System.out.print(" ");
			}
			for(int h=1; h<=5; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void exam03() { // pattern 15.
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 행(row)를 출력하시겠습니까? :");
		int row = sc.nextInt();
		for(int i=1; i<=row; i++) {
			if(i==1) {
				System.out.println("*");
			} else if (i!=5) {
				System.out.print("*");
				for(int j=i; j>2; j--) {
					System.out.print(" ");
				}				
				System.out.print("*");
				System.out.println();
			} else {
				for(int h=i; h>0; h--) {
					System.out.print("*");
				}
			}			
		}		
	}
	
	public void exam04() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 행(row)를 출력하시겠습니까? :");
		int row = sc.nextInt();
		for(int i=1; i<=row; i++) {
			if(i!=5) {
				for(int j=i; j<5; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
				for(int h=i; h>0; h--) {
					System.out.print(" ");
				}
				System.out.println("*");								
			} else if(i==5) {
				for() {
					
				}
				
			}
			System.out.println();
		}
	}
	

}
