package kh.java.view;

import java.util.Scanner;

public class GameView {

	Scanner sc = new Scanner(System.in);

	// �������� �޴��� �����ְ� ���ð��� �Է¹޾� return
	public int main(){

		System.out.println("============ ���� �ձ� ���� ============");
		System.out.println("1. ���� ����");
		System.out.println("2. ���� ����");
		System.out.println("0. ���α׷� ����");
		System.out.print("���� > ");

		int slt = sc.nextInt();

		return slt;
	}
	
	// �������� �ܾ �Է¹޾� return
	public String userTurn() {
		System.out.print("���� �Է� : ");

		String str = sc.next();

		return str;
	}

	// ��ǻ�Ͱ� ����� �ܾ �������� �����ִ� �޼ҵ�
	public void comTurn(String msg) {
		System.out.println("��ǻ�� ���� : " + msg);
	}

	// ���� ������ ����ϴ� �޼ҵ�
	public void showScore(int countWin, int countLose) {
		System.out.println("�¸� Ƚ�� : " + countWin);
		System.out.println("�й� Ƚ�� : " + countLose);
	}

}
