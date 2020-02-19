package kh.java.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

import kh.java.view.GameView;
import kh.java.vo.GameWords;

public class GameControll {
	GameWords words = new GameWords(); // �ܾ��� �迭�� ���� Class ����
	
	GameView view = new GameView(); // ����ȭ�� view class ����

	Random rn = new Random(); // Random Ŭ���� ����

	char nextChar; // ������ �Է¹��� �ܾ��� ù ����

	int countWin = 0; // ���� �¸�Ƚ���� �����ϴ� ����
	int countLose = 0; // ���� �й�Ƚ���� �����ϴ� ����

	// ��ǻ�Ͱ� ����� �ܾ��� �ĺ����� �����ϴ� List
	ArrayList<String> chainWords = new ArrayList<String>(); 

	// ����, ��ǻ�Ͱ� ����� �ܾ �����ϴ� List, �ش� �ܾ�� List�� ����� �� chainWords���� ����
	// �ܾ��忡�� ������ �ܾ���� ������ ���� �� �ٽ� ��ȯ���ֱ� ���� ����
	ArrayList<String> usedWords = new ArrayList<String>(); 

	public void main() { // ���� �޴��� �����ϴ� �޼ҵ�

		while (true) { // ���� �������� �����ϰų�, ���ܰ� �߻����� ���� �� �޴� �ݺ�
			
			try { // InputMismatchException�� ó���ϱ� ���� try~catch
				
				int slt = view.main(); // ���� �Է°��� ������ ���� slt�� ����
				
				switch (slt) {
				case 1: // ���� ����
					playGame();
					break;

				case 2: // ���� ����
					view.showScore(countWin, countLose);

					break;

				case 0: // ���α׷� ����
					System.out.println("���α׷��� �����մϴ�.");
					return;

				default: // �Է°��� 0~2 �� ��� ��
					System.out.println("0~2�� �Է��ϼ���.");
				}
				
			// ���� �Է°��� ����� �ڷ����� �ٸ� �� ����� �����޽���
			} catch (InputMismatchException e) {  
				System.out.println("�߸��� �Է��Դϴ�.");	
				break;
			}
		}
	}

	public void playGame() { // �����ձ⸦ �����ϴ� �ٽ� �޼ҵ�
		System.out.println("------- �����ձ� ��~~��! -------");

		nextChar = '0'; // ������ ���� ���� �Ҷ� nextChar�� '0'���� �ʱ�ȭ

		while (true) { // ���� �¸�, �й谡 �ƴҽ� �ݺ�

			String userWord = userTurn(); // ���� �Է� ���ڿ� userWord ���� ����

			if (words.getWords().contains(userWord)) { // ������ �Է��� �ܾ �ܾ��忡 ������

				words.getWords().remove(userWord); // �ܾ��忡�� ���� �Է� �ܾ� ����

				usedWords.add(userWord); // ���� �ܾ ���� �Է� �ܾ� �߰�

				// ���� �Է� ���ڿ��� ������ ���ڸ� ���
				char userChar = userWord.charAt(userWord.length() - 1);
				
				// ��ǻ�Ͱ� ����� ���ڿ� ����
				String comWord = comTurnOrNull(userChar);

				if (comWord == null) { // comWord�� ���� null�϶� ���� �¸�

					gameSet();

					countWin++;

					System.out.println("����� �¸�!!");

				} else { // ��ǻ�Ͱ� ����� �ܾ �������� ������
					view.comTurn(comWord); // ���� ȭ�鿡 ��ǻ�� �ܾ ��� 
					
					// ��ǻ�� ��� ���ڿ��� ������ �ܾ nextChar�� ����
					nextChar = comWord.charAt(comWord.length() - 1);
					
					// ��ǻ�Ͱ� ����� �ܾ �ܾ��忡�� ����
					words.getWords().remove(comWord);
					// ��ǻ�Ͱ� ����� �ܾ ����� �ܾ �߰�
					usedWords.add(comWord);
					// �ĺ� �ܾ� �迭 clear
					chainWords.clear();
				}

			} else { // ������ �Է��� �ܾ �ܾ��忡 ������ == �й�
				
				gameSet();
				countLose++;
				System.out.println("�й�!!");
				break;
			}
		}
	}

	// ��ǻ���� ���ʸ� �����ϴ� �޼ҵ�, return���� String Ȥ�� null(����Ҽ� �ִ� �ܾ ������ == �й�)
	public String comTurnOrNull(char userChar) { 
		
		for (String s : words.getWords()) {
			if (s.charAt(0) == userChar) {
				chainWords.add(s);
			}
		}

		if (chainWords.size() == 0) {
			return null;

		} else {
			int rnNum = rn.nextInt(chainWords.size());

			return chainWords.get(rnNum);
		}
	}

	
	// �������� ���ڿ��� �Է¹޾�
	// ���� ���ڿ��� ù ���ڰ� ���� �ܾ��� ������ ���ڸ� �մ��� Ȯ���ϴ� �� �޼ҵ�
	public String userTurn() { 

		while (true) {
			String userWord = view.userTurn();

			if (nextChar == '0') {
				return userWord;

			} else if (userWord.charAt(0) == nextChar) {
				return userWord;

			} else {
				System.out.println(nextChar + "�� �����ϴ� �ܾ �Է��ϼ���.");
				continue;
			}
		}
	}

	
	// ������ ������ �� ���� �ܾ���� �ܾ��� �迭�� ��ȯ�ϴ� �޼ҵ� (��ȯ �� clear)
	public void gameSet() {
		for (String s : usedWords) {
			words.getWords().add(s);
		}

		usedWords.clear();
	}
	
}
