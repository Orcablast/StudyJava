package kh.java.function;
import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù�� ° ���� �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι� ° ���� �Է� : ");
		int num2 = sc.nextInt();
		System.out.println("======= ��� =======");
		int sum = num1+num2;
		System.out.println("���ϱ� ��� : " + sum);
		int minus = num1-num2;
		System.out.println("���� ��� : " + minus);
		int multi = num1 * num2; 
		System.out.println("���ϱ� ��� : " + multi);
		int div = num1/num2;
		System.out.println("������ �� : " + div);
		int etc = num1%num2;
		System.out.println("������ ������ : " + etc);

	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� �Է� : " );
		double width = sc.nextDouble();
		System.out.print("���� ���� �Է� : " );
		double height = sc.nextDouble();
		System.out.println("======= ��� =======");
		double surface = width*height;
		System.out.println("���� : " + surface);
		double circ = (width+height)*2;
		System.out.println("�ѷ� : " + circ);
		
	}
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);		
		System.out.print("����ܾ� �Է� : ");
		String word = sc.next();
		System.out.println("ù��° ���� : "+word.charAt(0));
		System.out.println("�ι�° ���� : "+word.charAt(1));
		System.out.println("����° ���� : "+word.charAt(2));
		
	}
	

}
