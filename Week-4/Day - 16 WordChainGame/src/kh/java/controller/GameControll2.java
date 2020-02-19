package kh.java.controller;

import java.util.ArrayList;
import java.util.Random;

import kh.java.view.GameView;
import kh.java.vo.GameWords;

public class GameControll2 {
	Random rn = new Random();

	GameView view = new GameView();
	GameWords words = new GameWords();

	ArrayList<String> comWords = new ArrayList<String>();
	ArrayList<String> usedWords = new ArrayList<String>();

	int win;
	int lose;

	char next = '0';
	
	public void main() {

		while (true) {
			int slt = view.main();

			switch (slt) {
			case 1:
				gamePlay();
				break;

			case 2:
				break;

			case 0:
				break;

			default:
				System.out.println("0~2 사이의 수를 입력하세요.");
			}
		}
	}
	
	public void gamePlay() {
		
	}
	
	public void comTurn() {
		
	}
	
	public void userTurn() {
		String userWord = view.userTurn();
		
		if(words.getWords().contains(userWord)) {
			
		} else {
			
			lose++;
			System.out.println("패배!!");
		}
		
	}
}
