package kh.java.view;

import java.util.Scanner;

public class View {

	Scanner sc = new Scanner(System.in);

	public int viewMain() {

		System.out.println("\n======= ȸ�� ���� ���α׷� v1.1 =======");
		System.out.println("1. ȸ������");
		System.out.println("2. ȸ������ ��� (��ü)");
		System.out.println("3. ȸ������ ��� (1��)");
		System.out.println("4. ȸ������ ����");
		System.out.println("5. ȸ��Ż��");
		System.out.println("0. ���α׷� ����");
		System.out.print("���� > ");

		return sc.nextInt();

	}
	
	public String inputInfo(String msg) {
		
		System.out.print(msg);		
		return sc.next();
	}


}
