package kh.java.array;

import java.util.Scanner;
import java.util.Random;

public class Lotto {
	public void exam01() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();

		while (true) {

			int userNum[] = new int[6];
			int comNum[] = new int[6];
			int countNum = 0;

			System.out.println("=========== �ζ� ���α׷� ===========");
			for (int i = 0; i < userNum.length; i++) {

				int inputNum;

				System.out.print((i + 1) + "��° ��ȣ �Է� (1~45) : ");
				inputNum = sc.nextInt();

				if (inputNum > 45 || inputNum < 1) {
					System.out.println("�߸� �Է��ϼ̽��ϴ�");
					i--;
					continue;
				}

				boolean dup = false;

				for (int j = i; j >= 0; j--) {
					if (i == 0) {
						break;
					} else if (inputNum == userNum[j]) {
						System.out.println("�̹� �ߺ��� ��ȣ�Դϴ�. �ٽ� �Է����ּ���.");
						dup = true;
						break;
					}
				}

				if (dup == true) {
					i--;
					continue;

				} else {
					userNum[i] = inputNum;
					comNum[i] = rn.nextInt(45) + 1;
					for (int j = i; j > 0; j--) {
						if (comNum[j - 1] == comNum[i]) {
							System.out.println("��ǻ�� ������");
							comNum[i] = rn.nextInt(45) + 1;
							j = i;
						}
					}
				}
			}

			for (int i = 0; i < userNum.length; i++) {
				for (int j = 0; j < userNum.length; j++) {
					int temp;
					if (userNum[i] == comNum[j]) {
						countNum++;
					}
					if (userNum[i] < userNum[j]) {
						temp = userNum[i];
						userNum[i] = userNum[j];
						userNum[j] = temp;
					}
					if (comNum[i] < comNum[j]) {
						temp = comNum[i];
						comNum[i] = comNum[j];
						comNum[j] = temp;
					}
				}
			}

			System.out.println("����� ��ȣ");
			for (int i = 0; i < userNum.length; i++) {
				if (i == userNum.length - 1) {
					System.out.print(userNum[i] + "\n");
					break;
				}
				System.out.print(userNum[i] + " ");
			}

			System.out.println("��ǻ�� ��ȣ");
			for (int i = 0; i < comNum.length; i++) {
				if (i == comNum.length - 1) {
					System.out.print(comNum[i] + "\n");
					break;
				}
				System.out.print(comNum[i] + " ");
			}

			System.out.print("���� ���� : " + countNum + "\n");

			switch (countNum) {
			case 0:
			case 1:
			case 2:
				System.out.println("��!!!");
				break;
			case 3:
				System.out.println("5��!!!");
				break;
			case 4:
				System.out.println("4��!!!");
				break;
			case 5:
				System.out.println("3��!!!");
				break;
			case 6:
				System.out.println("1��!!!");
				break;
			}

			break;
		}
	}

	public void exam02() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();

		int userNum[] = new int[6];
		int comNum[] = new int[6];
		int countToWin = 1; // 1����� �ݺ��� Ƚ�� 
		
		boolean win = false;

		System.out.println("================= �ζ� ���α׷� =================");

		for (int i = 0; i < userNum.length; i++) {

			System.out.print((i + 1) + "��° ��ȣ �Է� : ");
			int userInput = sc.nextInt();

			if (userInput > 46 || userInput <= 0) { // �Է´ܰ迡�� �߸��� ���ڸ� �Է����� ���

				System.out.println("�߸� �Է��ϼ̽��ϴ� ");
				i--;
				continue;
			}

			for (int j = i; j > 0; j--) {

				if (userNum[j - 1] == userInput) {
					System.out.println("�ߺ��� ��ȣ�Դϴ�");

					System.out.print((i + 1) + "��° ��ȣ �Է� : ");
					userInput = sc.nextInt();
					j++;

				}
			}

			userNum[i] = userInput;

		}

		while (!win) {
			int countNum = 0;
			
			int temp;
			
			for (int i = 0; i < comNum.length; i++) {

				for (int j = i; j > 0; j--) {
					
					comNum[i] = rn.nextInt(45) + 1;					

					if (comNum[i] == comNum[j - 1]) {
						j=i;
					}
				}

				for (int j = 0; j < comNum.length; j++) {
					
					if (userNum[i] == comNum[j]) {
						countNum++;
					} else if (userNum[i] < userNum[j]) {
						temp = userNum[j];
						userNum[j] = userNum[i];
						userNum[i] = temp;
					}else if (comNum[i] < comNum[j]) {
						temp = comNum[j];
						comNum[j] = comNum[i];
						comNum[i] = temp;
								
					}
				}				
			}
			
			System.out.printf("============ %dȸ�� ============",countToWin);

			System.out.println("����� ��ȣ");
			for(int i=0; i<userNum.length; i++) {
				System.out.print(userNum[i]+"  ");
			}
			System.out.println();
			
			System.out.println("��ǻ�� ��ȣ");
			for(int i=0; i<userNum.length; i++) {
				System.out.print(comNum[i]+"  ");
			}
			System.out.println();
			
			System.out.print("���� ���� : " + countNum);
			
			switch (countNum) {
			case 0:
			case 1:
			case 2:
				System.out.println("��!!!");
				break;
			case 3:
				System.out.println("5��!");
				break;
			case 4:
				System.out.println("4��!!");
				break;
			case 5:
				System.out.println("3��!!");
				break;
			case 6:
				System.out.println("1��!! �����մϴ�!!!");
				win = true;
			}
			win = true;
		} // 1���Ͻ� while ����
	}
	
	public void exam03() {
		
	}
}