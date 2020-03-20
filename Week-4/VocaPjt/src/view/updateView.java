package view;


import java.util.Scanner;

import VO.Word;

public class updateView {

	Scanner sc = new Scanner(System.in);

	public int updateMain() { // ����ڿ��� ������ ������ �޴�, ���ڸ� �Է����� ��� Exception throws
		System.out.println("���� ���� �޴��Դϴ�.");
		System.out.println("1. �ܾ� ����");
		System.out.println("2. �ܾ� ����");
		System.out.println("0. �ڷ� ����");
		System.out.print("���� > ");

		int select = sc.nextInt();
		sc.nextLine(); // enter buffer ����

		return select;
	}

	public String getName(String msg) { // ����ڿ��� ����, ���� �� �ܾ���� �Է¹޾� ����
		System.out.print(msg + " �� �ܾ� �Է� : ");
		String userInput = sc.next();
		sc.nextLine(); // enter buffer ����
		return userInput;
	}

	public String getMean(String msg) { // ����ڿ��� ������ �ܾ� ������ �Է¹޾� ����
		System.out.print(msg);
		String mean = sc.nextLine();

		return mean;
	}

	public Boolean delWord(String userInput) { // ����ڿ��� userInput �ܾ ���� �������� Ȯ���Ͽ� Boolean ����

		while (true) { // ���� ���θ� y,n���� ����ڰ� �亯�Ҷ����� ����

			System.out.print("[" + userInput + "] �ܾ ���� �����Ͻðڽ��ϱ�? [y/n] : ");

			char userAns = sc.next().charAt(0);

			if (userAns == 'y') { // ����ڰ� y�� �Է��� ��� -> true ����
				System.out.println("[" + userInput + "] �ܾ �����մϴ�");
				return true;

			} else if (userAns == 'n') { // ����ڰ� n�� �Է��� ��� -> false ����
				System.out.println("�ܾ� ������ �ߴ��մϴ�.");
				return false;

			} else { // ����ڰ� y�� n �̿��� ���� �Է����� ���
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
	
	public void showRandomWord(Word randomWord) {
		
		System.out.println("\n�ܾ�� : "+randomWord.getName());
		System.out.println("�ǹ� : ");
		System.out.print("1. "+randomWord.getMean1()+"\n");
		
		if(randomWord.getMean2()==null) {
			return;
		} else {
			System.out.print("2. "+randomWord.getMean2()+"\n");
		}
	}
	
	public boolean askNextRandom() {
		
		System.out.println("\n���� �ܾ ���ðڽ��ϱ�?");
		System.out.println("�׸����÷��� x, ��� ���÷��� �ƹ�Ű�� �Է��ϼ���.");
		
		char userAnswer = sc.next().charAt(0);
		
		if(userAnswer=='x') {
			return true;
			
		} else {
			return false;
		}
		
	}
}