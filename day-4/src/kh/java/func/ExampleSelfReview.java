package kh.java.func;

public class ExampleSelfReview {
	public void exam01() {
		for(int i = 1; i<=5 ;i++) {
			System.out.print("*");
		}
	}
	
	public void exam02() {
		for(int i=1; i<=5; i++) {
			System.out.print("*");
			System.out.println();
		}
	}
	
	public void exam03() {
		for(int i=1; i<=5; i++) {
			for(int h=1; h<=5; h++) {
				System.out.print("*");
			}
			System.out.println();			
		}
	}
	
	public void exam04() {
		for(int i=1; i<=5; i++) {
			for(int h=1; h<=5; h++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public void exam05() {
		for(int i=1; i<=5; i++) {
			for(int h=1; h<=5; h++) {
				System.out.print(h);
			}
			System.out.println();
		}
	}
	
	public void exam06() {
		for(int i=1; i<=5; i++) {
			for(int h=0; h<=4; h++) {
				System.out.print(i+h);
			}
			System.out.println();
		}
	}
	
	public void exam07() {
		for(int i=5; i>0; i--) {
			for(int h=0; h<5; h++) {
				System.out.print(i+h);
			}
			System.out.println();
		}
	}
	
	public void exam08() {
		for(int i=1; i<=5; i++) {
			for(int h=i; h>0; h--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void exam09() {
		for(int i=1; i<=5; i++) {
			for(int h=i; h<=5; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void exam10() {
		for(int i=1; i<=5; i++) {
			for(int k=i; k>1 ; k--) {
				System.out.print(" ");
			}
			for(int h=i; h<=5; h++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
//	public void exam11() {
//		for(int i=1; i<=5; i++) {
//			for(int j=i; j<=4; j++) {
//				System.out.print(" ");
//			}
//			for(int h=i; h) {
//				
//			}
//			System.out.println();
//		}
//	}
}
