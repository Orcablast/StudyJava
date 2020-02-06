package kh.java.game;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import java.util.Random;

public class MineSweeper {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	int gameNum;
	int mineNum;

	public void main() { // ���� �޴�
		while (true) {
			System.out.println("====== ���� ã�� ======");
			System.out.println("1. ���̵� : ���� (5x5)");
			System.out.println("2. ���̵� : �߰� (10x10)");
			System.out.println("3. ���̵� : ����� (15x15)");
			System.out.println("4. Ŀ���� ���̵�");
			System.out.println("5. ���� ������");
			System.out.println("===================");
			System.out.print("���� : ");
			int inputSlt = sc.nextInt();

			switch (inputSlt) {
			case 1:
				// gameDif = 5;
				// newGame(gameDif);

				gameNum = 5;
				mineNum = 5;

				int back[][] = new int[gameNum][gameNum]; // ���ڰ� �ִ� �迭 ����
				int front[][] = new int[gameNum][gameNum]; // �������� ������ �迭

				boolean boom= false; // ������ ���ڸ� ��Ҵ��� �� ���� 

				putMine(back);
				
				while(!boom) { // ������ ���ڸ� ���������� �ݺ�

					showCurrent(back); // ȭ�� ��� �޼ҵ�
				}
				
				showScreen(back);

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

	public void putMine(int arr[][]) { // �迭�� ���ڸ� ��ġ�ϴ� �������� , ���ڴ� -1

		while (mineNum != 0) {
			arr[rn.nextInt(5)][rn.nextInt(5)] = -1; // ���ڰ� -1
			mineNum--;
		}

	}

	public void showCurrent(int arr[][]) { // ���� ��ġ�� ��ũ���� ǥ��, �׽�Ʈ��
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void showScreen(int arr[][]) { // ����� ȭ��
		int k = 1;
		
		int mineCount;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				
				mineCount=0;
				
				switch(arr[i][j]) {
				case -1:
				case 0:
					if(k<10) {
						System.out.print("[");
						System.out.print("0" + k++);
						System.out.print("]");
					} else {
						System.out.print("[");
						System.out.print(k++);
						System.out.print("]");
					}
					break;
					
				case 2:
					mineCount = check(arr, i, j);
					
					if(mineCount==0) {
						System.out.print("    ");
					} else {
						System.out.print("  " + mineCount + " " );
					}
					k++;
					break;					
				}
				
//				if (arr[i][j] < 1 && k < 10) { // �ʱ���� �� k�� 10 �̸� �� ��
//					System.out.print("[");
//					System.out.print("0" + k++);
//					System.out.print("]");
//
//				} else if (arr[i][j] < 1) { // �ʱ����
//					System.out.print("[");
//					System.out.print(k++);
//					System.out.print("]");
//				} else if (arr[i][j] == 2) { // ������� (�迭�� 2)
//					k++;
//					System.out.print("  " + check(arr, i, j) + " " );
//				} else if (arr[i][j] == 0) {
//					k++;
//					System.out.print("[  ]");
//
//				}
			}
			System.out.println();
		}
	}
	
	
	public void userSelect() {
		int userNum=(gameNum*gameNum);
		
		while(true) {
			System.out.println("���ڸ� �����ϼ���! (1~"+(gameNum*gameNum)+")");
			userNum = sc.nextInt();
			
			if(userNum<0 || userNum > (gameNum*gameNum)) {
				System.out.println("�߸��� �Է��Դϴ�!");
			} else {
				
				
			}
			
		}
		
	}
	
	public int check(int arr[][], int row, int column) {
		int mineCount = 0;
		
		
		for(int r=row-1; r<=row+1; r++ ) {
			
			if(r<0 || r>gameNum-1) {
				
				continue;
				
			} else {
				
				for(int c=column-1; c<=column+1; c++) {
					
					if(c<0 || c>gameNum-1) {
						
						continue;
					}					
					
					if(arr[r][c]==-1) {
						mineCount++;
					}					
				}
			}
		}
		
		
		
		return mineCount;
		
// 		// ���ʿ� ������ Boundary ����
//		if (row == 0 && column == 0) { // row 0, column 0 -> �»�
//		
//		} else if (row == 0 && column == gameNum - 1) { // row 0, column 4 -> ���
//
//		} else if (row == gameNum - 1 && column == 0) { // row 4, column 0 -> ����
//
//		} else if (row == gameNum - 1 && column == gameNum - 1) { // row 4, column 4 -> ����
//
//		} else if (row == 0 && (column != 0 || column != gameNum - 1)) { // row 0, ù��°��
//
//		} else if (row == gameNum - 1 && (column != gameNum - 1 || column != 0)) { // row 4, ��������
//
//		} else if (column == 0 && (row != 0 || row != gameNum - 1)) { // column 0, ���� ù°��
//
//		} else if (column == gameNum - 1 && (row != 0 || row != gameNum - 1)) {
//
//		}
	}

	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
