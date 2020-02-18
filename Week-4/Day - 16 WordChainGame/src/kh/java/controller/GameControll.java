package kh.java.controller;

import java.util.ArrayList;
import java.util.Random;

import kh.java.view.GameView;
import kh.java.vo.GameWords;

public class GameControll {
	GameWords words = new GameWords();
	GameView view = new GameView();

	Random rn = new Random();

	char nextChar;

	ArrayList<String> chainWords = new ArrayList<String>();

	public void main() {

		while (true) {

				int slt = view.main();
				switch (slt) {
				case 1:
					playGame();
					break;

				case 2:
					if (words.getWords().contains("����")) {
						System.out.println("������ �ֳ׿�!");
					}

					break;

				case 0:
					System.out.println("���α׷��� �����մϴ�.");
					return;

				default:
					System.out.println("����Ʈ ����");
				}
		}
	}

	public void playGame() {
		System.out.println("------- �����ձ� ��~~��! -------");

		nextChar = '0';

		while (true) {

			String userWord = userTurn();

			if (words.getWords().contains(userWord)) {

				char userChar = userWord.charAt(userWord.length() - 1);

				for (String s : words.getWords()) {
					if (s.charAt(0) == userChar) {
						chainWords.add(s);
					}
				}

				String comWord = comTurnOrNull();

				if (comWord == null) {
					System.out.println("����� �¸�!!");

				} else {
					view.comTurn(comWord);

					nextChar = comWord.charAt(comWord.length() - 1);
					
					chainWords.clear();
				}
				
			} else {
				System.out.println("�й�!!");
				break;
			}
		}
	}

	public String comTurnOrNull() {

		if (chainWords.size() == 0) {
			return null;

		} else {
			int rnNum = rn.nextInt(chainWords.size());

			return chainWords.get(rnNum);
		}
	}

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
}
