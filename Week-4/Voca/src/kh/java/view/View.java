package kh.java.view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import kh.java.model.Word;

public class View {
	
	//---------���� �޴� �� ���� ���� �޼ҵ�------------------------------------------------------------------------------------
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	
	public int main() { //���� ó�� �޴�
		System.out.println("=====���� �ܾ� ����=====");
		System.out.println("1.�ܾ� �˻�");
		System.out.println("2.���ܾ� ���");
		System.out.println("3.�׽�Ʈ ����");
		System.out.println("4.���� ��Ʈ");
		System.out.println("5.�ܾ� ����");
		System.out.println("0.���α׷� ����");
		System.out.print("���� > ");
		int selMenu = sc.nextInt();
		
		return selMenu;
	}
	
	public String getName(String msg) { // ����ڿ��� ����, ���� �� �ܾ���� �Է¹޾� ����
		System.out.print(msg + " �� �ܾ� �Է� : ");
		String userInput = sc.next();
		sc.nextLine(); // enter buffer ����
		return userInput;
	}
	
	
	//---------�˻�_����-------------------------------------------------------------------------------------
		
	public int searchDictionary() { // �˻�_���Ѱ˻� or �ѿ��˻�
		System.out.println("1.���Ѱ˻�");
		System.out.println("2.�ѿ��˻�");
		System.out.println("0.�ڷ� ����");
		System.out.print("���� > ");
		int select = sc.nextInt();
		
		return select;
	}
	

	//---------���� �� ����_��������-------------------------------------------------------------------------------------
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

	public String getMean(String msg) { // ����ڿ��� ������ �ܾ� ������ �Է¹޾� ����
		System.out.print(msg);
		String mean = sc.nextLine(); //new ���� �Է��ϰ� ����

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


	//---------�׽�Ʈ_��������-------------------------------------------------------------------------------------
		
	
	public int vocaTest() {				//�޴����� �޾Ƽ� ���ڸ���.
		System.out.println("---- �ܾ� �׽�Ʈ ----");	
		System.out.println("1.���� �׽�Ʈ");
		System.out.println("2.�ѿ� �׽�Ʈ");
		System.out.println("0.�ڷΰ���");
		System.out.print("���� > ");
		int select = sc.nextInt();
		return select;
	}
	
	public int askQNum(String msg) {
		System.out.println("---- "+msg+" �׽�Ʈ ----");
		System.out.print("���� ������ �Է��ϼ��� : ");
		int qNum = sc.nextInt();
		sc.nextLine();
		return qNum;
	}
	
	public void testResult(double score) {
		System.out.println("\n�׽�Ʈ�� ����Ǿ����ϴ�");
		
		if (score == 0) {
			System.out.println("����!! �����ϼ���!!!");
		} else {
			System.out.printf("�׽�Ʈ ��� : %.2f",score);
		}		
	}

	//---------����_���δ���-------------------------------------------------------------------------------------
	
	public int failMenu() {
		System.out.println("===== �����Ʈ =====");
		System.out.println("1. ���� ����");
		System.out.println("2. �����");
		System.out.println("3. �����Ʈ ����");
		System.out.println("0. �ڷ�");
		System.out.print("���� > ");
		int select = sc.nextInt();
		return select;
	}



	// ---------�ܾ� ���_����-------------------------------------------------------------------------------------

	public int  Insertdictionary() {
		System.out.println("1. �ܾ��Է�");
		System.out.println("0. �ڷΰ���");
		System.out.print("���� > ");
		int sel=sc.nextInt();
		return sel;
		
		}
	
	public char inputWord() {
		String nWord;
		System.out.println("����� �ܾ �Է��ϼ���");
		nWord = sc.next();
		nWord=nWord.toLowerCase();
		String name = nWord;
		System.out.println("ù��° ���� �Է����ּ��� ");
		String nMean1 = sc.next();

		String mean1 = nMean1;
		System.out.println("�ι�° ���� �Է����ּ���");
		String nMean2 = sc.next();
		String mean2 = nMean2;
		System.out.println(name+"/"+mean1+"/"+mean2+"�� �½��ϱ�?");
		System.out.println("�̴�� ����Ͻðڽ��ϱ�?[y/n]");
		char ch=sc.next().charAt(0);
		return ch;
		}
}