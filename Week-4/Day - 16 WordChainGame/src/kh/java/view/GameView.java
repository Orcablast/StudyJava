package kh.java.view;

import java.util.Scanner;

public class GameView {
	
	Scanner sc = new Scanner(System.in);
	
	public int main() {
		System.out.println("============ ���� �ձ� ���� ============");
		System.out.println("1. ���� ����");
		System.out.println("2. ���� ����");
		System.out.println("0. ���α׷� ����");
		System.out.print("���� > ");
		
		int slt= sc.nextInt();
		
				
		return slt;
	}
	
	public String userTurn() {
		System.out.print("���� �Է� : ");
		
		String str = sc.next();
		
		return str;
	}
	
	public void comTurn(String msg) {
		System.out.println("��ǻ�� ���� : " + msg);		
	}
	
}
