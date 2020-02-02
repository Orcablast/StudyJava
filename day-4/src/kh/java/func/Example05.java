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
	public void exam04() {
		for(int i=1; i<=5; i++) {
			if(i!=5) {
				for(int j=i;j<=5;j++) {
					System.out.print("*");
				}
				for(int h=2*i;h>1; h--) {
					System.out.print(" ");
				}
				for(int k=i; k<=5; k++) {
					System.out.print("*");
				}
				System.out.println();
			} else if (i==5){
				for(int l=1; l<=5; l++) {
					for(int m=l; m>=1;m--) {
						System.out.print("*");
					}
					for(int n=2*l; n<=10; n++) {
						System.out.print(" ");
					}
					for(int o=l; o>=1; o--) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
		}
	}
	
	public void exam05() {
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
}
