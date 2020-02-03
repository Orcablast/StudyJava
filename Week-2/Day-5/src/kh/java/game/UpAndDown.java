package kh.java.game;

import java.util.Scanner;
import java.util.Random;

public class UpAndDown {
	public void exam01() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int bestScore = 1000;
		int keepPlay = 0;
		while (keepPlay == 0) {
			System.out.println("==== Up & Down Game ====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("���� >");
			int selectMenu = sc.nextInt();
			switch (selectMenu) {
			case 1:
				System.out.println("<< Game Start >>");
				int playScore = 1;
				int comNum = rn.nextInt(99) + 1;
				int userNum;
				while (true) {
					System.out.print(playScore + "ȸ�� ��ȣ �Է� : ");
					userNum = sc.nextInt();
					if (userNum < 1 || userNum > 99) {
						System.out.println("�Է¹��� ���� (1~99 ������ ���� �Է��ϼ���)");
					}
					if (userNum > comNum) {
						playScore++;
						System.out.println("<< DOWN >>");
					} else if (userNum < comNum) {
						playScore++;
						System.out.println("<< UP >>");
					} else if (userNum == comNum) {
						System.out.println("<< ���� >>");
						if (playScore < bestScore) {
							bestScore = playScore;
						}
						break;
					} else {
						System.out.println("�Է¹��� ���� (1~99 ������ ���� �Է��ϼ���");
					}
				}
				break;
			case 2:
				if (bestScore == 1000) {
					System.out.println("���� ����� �����ϴ�");
					break;
				} else {
					System.out.println("���� �ְ� ����� " + bestScore + "ȸ �Դϴ�.");
					break;
				}
			case 3:
				keepPlay++;
				System.out.println("=========== ���α׷��� �����մϴ� ===========");
				break;
			default:
				System.out.println("1~3������ ���� �Է��ϼ���.");
			}
		}
	}

	public void exam02() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int keepPlay = 0;
		int scrWin = 0;
		int scrLose = 0;
		while (keepPlay == 0) {
			System.out.println("===== Baskin&Robbins 31 Game");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("���� > ");
			int selectMenu = sc.nextInt();
			int userNum;
			int gameNum = 0;
			int gameSet = 0; // 0�� ������ ���������� ����, 1�� ������ ���� ����
			switch (selectMenu) {
			case 1:
				System.out.println("<< Game Start >>");
				while (gameSet == 0) {
					System.out.println("<< Your Turn >>");
					System.out.print("Input Number (1~3) :");
					userNum = sc.nextInt();
					int comNum = rn.nextInt(3) + 1;
					for (int i = 1; i <= userNum && gameSet == 0; i++) {
						gameNum++;
						System.out.println(gameNum + "!");
						if (gameNum == 31) {
							gameSet++;
							scrLose++;
							System.out.println("����� �й� �Ф�");
							break;
						}
					}
					System.out.println("<< Computer Turn >>");
					for (int j = 1; j <= comNum && gameSet == 0; j++) {
						gameNum++;
						System.out.println(gameNum + "!");
						if (gameNum == 31) {
							gameSet++;
							scrWin++;
							System.out.println("����� �¸�!!");
							break;
						}
					}
				}
				break;
			case 2:
				System.out.println("<< ����� ���� >>");
				System.out.println("WIN : " + scrWin);
				System.out.println("LOSE : " + scrLose);
				break;
			case 3:
				System.out.println("���α׷��� �����մϴ�.");
				keepPlay++;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�");
			}
		}
	}

	public void exam03() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int userMoney = 10000; // ������ �⺻ �ڱ� 10000��
		int scrWin = 0; // ������ �¸� Ƚ��
		int scrLose = 0; // ������ �й� Ƚ��
		int scrDraw = 0; // ������ ��� Ƚ��
		int programOn = 0; // ���α׷��� �����ϴ� ����, 0 != ���� ����
		while (programOn == 0) {
			System.out.println("===== Dice Game =====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("���� > ");
			int selectMenu = sc.nextInt(); // �޴��� �����ϴ� ���� = ���� �Է°�
			int keepPlay = 0; // ������ ��� �������� �����ϴ� ����, 0 != �޴��� ���ư�
			switch (selectMenu) { // ������ �Է��� selectMenu ������ ���ͷ������� �б�
			case 1:
				while (keepPlay == 0) { // ������ ��� �������� �����ϴ� ���� (0 == ���ѷ��� , 0 != �޴��� ���ư�) 
					if (userMoney == 0) { // ������ �ܾ��� ������ ���ѷ����� �����ϵ��� keepPlay���� 1 ����
						System.out.println("�ܾ��� �����ϴ�.");
						keepPlay++; 
						break;
					}
					System.out.println("<< Game Start >>"); 
					int userSum = 0; // ������ �ֻ��� �� ��, �ʱ�ȭ 0
					int userD; // ������ �ֻ��� ���, for������ �ݺ��� ��
					char userBetAns; // ������ ������ �������� �����ϴ� ����
					int betSet = 0; // ���� ������ ������ �����ϴ� ����, 0�� �ƴϸ� ���� Ż��
					for (int i = 1; i <= 3; i++) {
						userD = rn.nextInt(6) + 1;
						userSum += userD;
						System.out.println(i + "��° �ֻ��� �� : " + userD);
					}
					System.out.println("�� �ֻ��� �� ��  : " + userSum);
					while (betSet == 0) {
						System.out.print("���� �Ͻðڽ��ϱ�? [y/n] : ");
						userBetAns = sc.next().charAt(0);
						int userBet;
						if (userBetAns == 'y') {
							System.out.println("���� �� ������ : " + userMoney);
							System.out.print("�󸶸� �����Ͻðڽ��ϱ�? : ");
							userBet = sc.nextInt();
							int comSum = 0;
							int comD;
							for (int j = 1; j <= 3; j++) {
								comD = rn.nextInt(6) + 1;
								System.out.println("��ǻ�� " + j + "��° �ֻ��� �� : " + comD);
								comSum += comD;
							}
							System.out.println("��ǻ�� �ֻ��� �� �� : " + comSum);
							System.out.println("<< ��� >>");
							System.out.println("���� �ֻ��� ��       : " + userSum);
							System.out.println("��ǻ���� �ֻ��� �� : " + comSum);
							if (userSum == comSum) {
								scrDraw++;
								System.out.println("�����ϴ�........");
							} else if (userSum > comSum) {
								scrWin++;
								System.out.println("�¸�!!!!");
								System.out.println("�������� " + userBet + "�� �����߽��ϴ�.");
								userMoney += userBet;
								System.out.println("���� ������ : " + userMoney);
							} else {
								scrLose++;
								System.out.println("�й�...");
								System.out.println("�������� " + userBet + "�� �����߽��ϴ�.");
								userMoney -= userBet;
								if (userMoney == 0) {
									betSet++;
									System.out.println("���� Bye~~~");
								}
								System.out.println("���� ������ : " + userMoney);
							}
						} else if (userBetAns == 'n') {
							keepPlay++;
							System.out.println("�޴��� ���ư��ϴ�.");
							System.out.println();
							break;
						} else {
							System.out.println("y �Ǵ� n�� �Է��ϼ���.");
						}
						while (betSet == 0) {
							System.out.print("�ѹ� �� �Ͻðڽ��ϱ�? [y/n] : ");
							char userAns = sc.next().charAt(0);
							switch (userAns) {
							case 'y':
								betSet++;
								break;
							case 'n':
								betSet++;
								keepPlay++;
								System.out.println("�޴��� ���ư��ϴ�.");
								System.out.println();
								break;
							default:
								System.out.println("�߸� �Է��ϼ̽��ϴ�.");
								System.out.println();
							}
						}
					}
				} // keepPlay while ���� ����
				break;
			case 2:
				System.out.println("Win  : " + scrWin);
				System.out.println("Lose : " + scrLose);
				System.out.println("Draw : " + scrDraw);
				System.out.println("�� ������ : " + userMoney);
				break;
			case 3:
				programOn++;
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}
	}
}
