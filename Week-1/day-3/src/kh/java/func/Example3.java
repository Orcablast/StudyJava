package kh.java.func;
import java.util.Scanner;

public class Example3 { // if ~ else if ��������
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~3 ���� ���� �Է��ϼ��� : ");
		int num = sc.nextInt();
		if(num==1) {
			System.out.println("One");
		} else if(num==2) {
			System.out.println("Two");
		} else if(num==3) {
			System.out.println("Three");			
		} else {
			System.out.println("�߸��� ���Դϴ�.");
		}
	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=========== ��/�ҹ��� ��ȯ ���α׷� ===========");
		System.out.print("���� �Է� : ");
		char ch = sc.next().charAt(0); // �Է¹��� ���ڿ��� 0��° ���ڸ� charŸ�� ���� ch�� ����
		System.out.println("==== ��� ====");
		if (ch>=65 && ch<=90) { // �ƽ�Ű �ڵ�� �빮���� ���� ch �������� ���ϴ��� ��, �Ѵ� true�� ��ɾ� ����, �ϳ��� false�� else if�� �̵�
			System.out.println("�빮�ڸ� �Է��Ͽ����ϴ�.");			
			System.out.printf("�ҹ��ڷ� ��ȯ : %c",ch^32);			
		} else if (ch>=97 && ch<=122) { // �ƽ�Ű �ڵ�� �ҹ����� ���� ch �������� ���ϴ��� ��, �Ѵ� true�� ��ɾ� ����, �ϳ��� false�� else�� �̵�
			System.out.println("�ҹ��ڸ� �Է��Ͽ����ϴ�.");
			System.out.printf("�빮�ڷ� ��ȯ : %c",ch^32);
		} else { // ���� �� ���ǹ��� ������ �ʴ� char ���� ���� �빮��, �ҹ��ڰ� �ƴϹǷ� �Ʒ��� ���� ���
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �����ڸ� �Է����ּ���.");
		}
		
		
	}
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		System.out.println("===== ��� =====");		
		if (num==0) { // num�� ���� 0�̸� �Ʒ� ��ɾ� ��� 
			System.out.printf("[%d]��(��) ����� ����� �ƴմϴ�.",num);
		} else if ((num%3==0) && (num%4==0)) {
			System.out.printf("[%d]��(��) 3�� ����鼭 4�� ����Դϴ�.",num);
		} else if (num%3==0) {
			System.out.printf("[%d]��(��) 3�� ����Դϴ�.",num);
		} else if (num%4==0) {
			System.out.printf("[%d]��(��) 4�� ����Դϴ�.",num);
		} else {
			System.out.printf("[%d]��(��) 3�� ����� 4�� ����� �ƴմϴ�.",num);
		}
	}
}
