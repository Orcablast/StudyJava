package kh.java.game;

import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
	
	int gameNum;
	int mineNum;
	
	int game[][];
	
	public void main() { // ���� �޴�
		while (true) {
			System.out.println("====== ���� ã�� ======");
			System.out.println("1. ���̵� : ���� (5x5)");
			System.out.println("2. ���̵� : �߰� (10x10)");
			System.out.println("3. ���̵� : ����� (15x15)");
			System.out.println("4. Ŀ���� ���̵�");
			System.out.println("5. ���� ������");
			System.out.println("===================");
			System.out.println("���� : ");
			int inputSlt = sc.nextInt();


			switch (inputSlt) {
			case 1:
				// gameDif = 5;
				// newGame(gameDif);
				
				gameNum = 5;
				mineNum = 5;
				
				int back[][] = new int[gameNum][gameNum]; // ���ڰ� �ִ� �迭 ����
				int front[][] = new int[gameNum][gameNum]; // �������� ������ �迭
								
				putMine(back);
				
				showCurrent(back); // ȭ�� ��� �޼ҵ�
				
				continue;

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
				return;

			default: // �޴� �̿��� ������ �Է����� ���
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			}
		}

	}

	public void newGame() {
		int back[][] = new int[gameNum][gameNum];
		int front[][] = new int[gameNum][gameNum];

	}
	
	
	
	public void putMine(int arr[][]) {
		
		while(mineNum!=0) {
			arr[rn.nextInt(5)][rn.nextInt(5)] = -1;
			mineNum--;
		}
		
	}

	
	
	public void showCurrent(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
