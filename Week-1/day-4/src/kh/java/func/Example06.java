package kh.java.func;
import java.util.Scanner;

public class Example06 {
	public void exam01() { // pattern 10.
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ��(row)�� ����Ͻðڽ��ϱ�? : ");
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
	
	public void exam02() {
		
	}

}
