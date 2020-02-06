package kh.java.func;

public class Exam {
//	public char changeChar(char input) {
//		int result = input^32; 
//		return (char)result;
//	}
	
	public char changeChar(char input) {
		return (char)(input^32);
	}
	
	public void exam01() {
		char a = 98;
		int b = 'b';
		System.out.printf("%d",a);
		
	}
	
	public void testFunction(int num) {
		num = 100;		
	}
	
	public void testFunction2(int arr[]) { // arr[] 주소값을 받음
		arr[2] = 100;
	}
}
