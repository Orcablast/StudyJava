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
		int minus = num1-num2;
		int multi = num1 * num2; 
		int div = num1/num2;
		int etc = num1%num2;
		System.out.println("���ϱ� ��� : " + sum);
		System.out.println("���� ��� : " + minus);
		System.out.println("���ϱ� ��� : " + multi);
		System.out.println("������ �� : " + div);
		System.out.println("������ ������ : " + etc);

	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� �Է� : " );
		double width = sc.nextDouble();
		System.out.print("���� ���� �Է� : " );
		double height = sc.nextDouble();
		double surface = width*height; // ������ ���ϴ� ����
		double circ = (width+height)*2; // �ѷ��� ���ϴ� ����
		System.out.println("======= ��� =======");
		System.out.println("���� : " + surface);
		System.out.println("�ѷ� : " + circ);
		
	}
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);		
		System.out.print("����ܾ� �Է� : ");
		String word = sc.next();
		System.out.println("ù��° ���� : "+word.charAt(0)); // ���� word�� ����� char 0���� ���
		System.out.println("�ι�° ���� : "+word.charAt(1)); // ���� word�� ����� char 1���� ���
		System.out.println("����° ���� : "+word.charAt(2)); // ���� word�� ����� char 2���� ���
		
	}
	

}
