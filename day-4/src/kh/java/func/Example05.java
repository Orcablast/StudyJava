package kh.java.func;

public class Example05 {
	public void exam01() {
		for(int i =1; i<=5; i++) {
			for(int j=i; j<=4; j++) {
				System.out.print(" ");
			}
			for(int h=2*i; h>1; h--) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
	
	public void exam02() {
		for(int i=1; i<=5; i++) {
			for(int h=i; h>1; h--) {
				System.out.print(" ");				
			}
			for(int j=2*i; j<=10; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void exam03() {
		for(int i=1; i<=5; i++) {
			if(i!=5) {
				for(int l=i; l<=4; l++) {
					System.out.print(" ");
				}
				for(int j=2*i; j>1; j--) {
					System.out.print("*");
				}
				System.out.println();
			} else if (i==5){
				for(int h=1; h<=5; h++) {
					for(int n=h; n>1; n--) {
						System.out.print(" ");
					}
					for(int k=2*h; k<=10; k++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
		}
	}
}
