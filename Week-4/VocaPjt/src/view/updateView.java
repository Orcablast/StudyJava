package view;


import java.util.Scanner;

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
}
