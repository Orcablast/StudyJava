package view;
import java.util.Scanner;

import VO.Word;



public class updateView {
	
	Scanner sc = new Scanner(System.in);

	
	public int updateMain() {
		System.out.println("�ܾ� ��� �޴��Դϴ�.");
		System.out.println("1. �ܾ� ����");
		System.out.println("2. �ܾ� ����");
		System.out.println("0. �ڷ� ����");
		
		int select = sc.nextInt();
		
		return select;
	}
	
	public String getName(String msg) {
		System.out.print(msg+" �� �ܾ� �Է� : ");
		String userInput = sc.next();
		
		return userInput;
	}
	
	public String getMean(String msg) {
		sc.nextLine();
		System.out.print(msg);
		String mean = sc.nextLine();
		
		return mean;
	}
}
