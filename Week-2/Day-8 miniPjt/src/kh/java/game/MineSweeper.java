package kh.java.game;

import java.util.Scanner;

import java.util.Random;

public class MineSweeper {
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	int gameNum;
	int mineNum;
	int winNum;

	boolean boom = false; // ������ ���ڸ� ��Ҵ��� �� ����

	boolean win = false; // ������ �¸��ߴ��� �� ����

	int blankCount; // ������ ���� ����

	public void main() { // ���� �޴�
		while (true) {

			blankCount = 0;

			boom = false;

			System.out.println("====== ���� ã�� ======");
			System.out.println("1. ���̵� : ���� (5x5)");
			System.out.println("2. ���̵� : �߰� (7x7)");
			System.out.println("3. ���̵� : ����� (10x10)");
			System.out.println("4. Ŀ���� ���̵�");
			System.out.println("5. ���� ����");
			System.out.println("6. ���� ������");
			System.out.println("===================");
			System.out.print("���� : ");
			int inputSlt = sc.nextInt();

			switch (inputSlt) {
			case 1:

				gameNum = 5;
				mineNum = 5;
				winNum = 5;

				int easy[][] = new int[gameNum][gameNum]; // ���ڰ� �ִ� �迭 ����

				putMine(easy);

				while (!boom ) {

					blankCount = 0;

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

//					showCurrent(easy); // ȭ�� ��� �޼ҵ�, �׽�Ʈ��

					showScreen(easy);

					userSelect(easy);

					winCount(easy);

					if (blankCount >= (gameNum * gameNum) - winNum) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						showScreen(easy);
						System.out.println("�¸��ϼ̽��ϴ�!!");
						delay(2000);
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}

				}

				continue;

			case 2:

				gameNum = 7;
				mineNum = 10;
				winNum = 10;

				int mid[][] = new int[gameNum][gameNum]; // ���ڰ� �ִ� �迭 ����

				putMine(mid);

				while (!boom) {

					blankCount = 0;

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

//					showCurrent(mid); // ȭ�� ��� �޼ҵ�, �׽�Ʈ��

					showScreen(mid);

					userSelect(mid);

					winCount(mid);

					if (blankCount >= (gameNum * gameNum) - winNum) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						showScreen(mid);
						System.out.println("�¸��ϼ̽��ϴ�!!");
						delay(2000);
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}
				}

				continue;

			case 3:

				gameNum = 10;
				mineNum = 25;

				int dif[][] = new int[gameNum][gameNum]; // ���ڰ� �ִ� �迭 ����

				putMine(dif);

				while (!boom) {

					blankCount = 0;

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

//					showCurrent(dif); // ȭ�� ��� �޼ҵ�, �׽�Ʈ��

					showScreen(dif);

					userSelect(dif);

					winCount(dif);

					if (blankCount >= (gameNum * gameNum) - winNum) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						showScreen(dif);
						System.out.println("�¸��ϼ̽��ϴ�!!");
						delay(2000);
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}
				}
				continue;

			case 4:
				System.out.print("����x���� ���̸� ���ϼ��� : ");
				gameNum = userSelectNum(sc.nextInt());
				System.out.print("���� ������ �Է��ϼ��� : ");
				mineNum = userSelectNum(sc.nextInt());
				winNum = mineNum;

				int custom[][] = new int[gameNum][gameNum]; // ���ڰ� �ִ� �迭 ����

				putMine(custom);

				while (!boom) {

					blankCount = 0;

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

//					showCurrent(custom); // ȭ�� ��� �޼ҵ�, �׽�Ʈ��

					showScreen(custom);

					userSelect(custom);

					winCount(custom);

					if (blankCount >= (gameNum * gameNum) - winNum) {
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						showScreen(custom);
						System.out.println("�¸��ϼ̽��ϴ�!!");
						delay(2000);
						System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						break;
					}
				}

				continue;

			case 5:
				System.out.println("���ڷ� ǥ�õ� ������ ���ڰ� ������ ������ �й��մϴ�");
				System.out.println("���� �ش� ������ ���ڰ� ���ٸ� �ֺ� 8ĭ ��  ������ ������ ǥ���ϰ�");
				System.out.println("�ش� ���� �ֺ� 8ĭ�� ���� ������ �ع��մϴ�");
				System.out.println("��� ���������� �ع�Ǹ� �¸��մϴ�");
				System.out.println("������ ��� �÷����Ͻ÷��� �ƹ�Ű�� �Է����ּ���");
				if(sc.hasNext()) {
					sc.next();
					continue;
				}
			case 6:
				System.out.println("������ �����մϴ�. Bye~");
				return;

			default: // �޴� �̿��� ������ �Է����� ���
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			}
		}
	}

	public void putMine(int arr[][]) { // �迭�� ���ڸ� ��ġ�ϴ� �������� , ���ڴ� -1

		while (mineNum != 0) {
			int randomRow = rn.nextInt(gameNum - 1);
			int randomColumn = rn.nextInt(gameNum - 1);

			if (arr[randomRow][randomColumn] != -1) {
				arr[randomRow][randomColumn] = -1; // ���ڰ� -1
				mineNum--;
			}

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

				mineCount = 0;

				switch (arr[i][j]) {
				case -1:
				case 0:
					if (k < 10) {
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

					if (mineCount == 0) {
						System.out.print("    ");
					} else {
						System.out.print("  " + mineCount + " ");
					}
					k++;
					break;
				}
			}
			System.out.println();
		} // 2�� for�� �������
	}

	public void userSelect(int arr[][]) { // ����ڰ� �Է��� ���� �ش��ϴ� �迭�� ���ڰ� �ִ��� Ȯ��
		int userNum;

		while (true) {
			System.out.println("���ڸ� �����ϼ���! (1~" + (gameNum * gameNum) + ")");
			userNum = sc.nextInt();

			if (userNum < 0 || userNum > (gameNum * gameNum)) {
				System.out.println("�߸��� �Է��Դϴ�!");
				continue;
			} else {

				int row = 0;
				int column = 0;

				for (int i = 0; (i < gameNum) && userNum != 0; i++) {
					row = i;
					for (int j = 0; (j < gameNum) && userNum != 0; j++) {
						column = j;
						userNum--;
					}
				}

				if (arr[row][column] == -1) {

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("���� ����!!");
					System.out.println("���� ����!!");
					System.out.println("���� ����!!");
					delay(1500);

					System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

					boom = true;
					return;

				} else if (arr[row][column] == 0) {
					arr[row][column] = 2;
					check2(arr, row, column);
					return;

				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�");
				}
			}
		}
	}

	public int check(int arr[][], int row, int column) { // �ֺ� 8ĭ�� ���� ������ ī��Ʈ �Ͽ� int������ return
		int mineCount = 0;

		for (int r = row - 1; r <= row + 1; r++) {

			if (r < 0 || r > gameNum - 1) {

				continue;

			} else {

				for (int c = column - 1; c <= column + 1; c++) {

					if (c < 0 || c > gameNum - 1) {

						continue;
					}

					if (arr[r][c] == -1) {
						mineCount++;
					}
				}
			}
		}

		return mineCount;
	}

	public void check2(int arr[][], int row, int column) { // �ֺ� ������ �ڵ����� �����ϴ� ���� check ���� Ȱ��
		for (int r = row - 1; r <= row + 1; r++) {

			if (r < 0 || r > gameNum - 1) {

				continue;

			} else {

				for (int c = column - 1; c <= column + 1; c++) {

					if (c < 0 || c > gameNum - 1) {

						continue;
					}

					if (arr[r][c] == 0) {
						arr[r][c] = 2;
					}
				}
			}
		}
	}

	public int userSelectNum(int num) { // 0 ������ ���ڸ� �Է������� ���Է��� �䱸
		while (num < 1) {
			System.out.println("�ٽ� �Է��ϼ���.");
			num = sc.nextInt();
		}
		return num;
	}

	public void winCount(int arr[][]) { // �¸� ������ ���ꤷ���������� �� ���� ����

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 2) {
					blankCount++;
				}
			}
		}

	}
	
	public void delay(int time) { // ������ Ÿ��
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
