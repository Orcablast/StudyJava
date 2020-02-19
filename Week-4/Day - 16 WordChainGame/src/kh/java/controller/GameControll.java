package kh.java.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

import kh.java.view.GameView;
import kh.java.vo.GameWords;

public class GameControll {
	GameWords words = new GameWords(); // 단어장 배열을 가진 Class 생성
	
	GameView view = new GameView(); // 유저화면 view class 생성

	Random rn = new Random(); // Random 클래스 생성

	char nextChar; // 다음에 입력받을 단어의 첫 글자

	int countWin = 0; // 유저 승리횟수를 지시하는 변수
	int countLose = 0; // 유저 패배횟수를 지시하는 변수

	// 컴퓨터가 출력할 단어의 후보들을 저장하는 List
	ArrayList<String> chainWords = new ArrayList<String>(); 

	// 유저, 컴퓨터가 사용한 단어를 저장하는 List, 해당 단어는 List에 저장된 후 chainWords에서 삭제
	// 단어장에서 제외한 단어들을 게임이 끝난 후 다시 반환해주기 위한 목적
	ArrayList<String> usedWords = new ArrayList<String>(); 

	public void main() { // 게임 메뉴를 진행하는 메소드

		while (true) { // 유저 선택으로 종료하거나, 예외가 발생하지 않을 시 메뉴 반복
			
			try { // InputMismatchException을 처리하기 위한 try~catch
				
				int slt = view.main(); // 유저 입력값을 정수형 변수 slt로 선언
				
				switch (slt) {
				case 1: // 게임 시작
					playGame();
					break;

				case 2: // 전적 보기
					view.showScore(countWin, countLose);

					break;

				case 0: // 프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					return;

				default: // 입력값이 0~2 를 벗어날 때
					System.out.println("0~2를 입력하세요.");
				}
				
			// 유저 입력값이 명시한 자료형과 다를 때 출력할 에러메시지
			} catch (InputMismatchException e) {  
				System.out.println("잘못된 입력입니다.");	
				break;
			}
		}
	}

	public void playGame() { // 끝말잇기를 진행하는 핵심 메소드
		System.out.println("------- 끝말잇기 시~~작! -------");

		nextChar = '0'; // 게임을 새로 시작 할때 nextChar를 '0'으로 초기화

		while (true) { // 유저 승리, 패배가 아닐시 반복

			String userWord = userTurn(); // 유저 입력 문자열 userWord 변수 선언

			if (words.getWords().contains(userWord)) { // 유저가 입력한 단어가 단어장에 있을때

				words.getWords().remove(userWord); // 단어장에서 유저 입력 단어 삭제

				usedWords.add(userWord); // 사용된 단어에 유저 입력 단어 추가

				// 유저 입력 문자열의 마지막 문자를 기록
				char userChar = userWord.charAt(userWord.length() - 1);
				
				// 컴퓨터가 출력할 문자열 변수
				String comWord = comTurnOrNull(userChar);

				if (comWord == null) { // comWord의 값이 null일때 유저 승리

					gameSet();

					countWin++;

					System.out.println("당신의 승리!!");

				} else { // 컴퓨터가 출력한 단어가 있을때의 시퀀스
					view.comTurn(comWord); // 유저 화면에 컴퓨터 단어를 출력 
					
					// 컴퓨터 출력 문자열의 마지막 단어를 nextChar로 선언
					nextChar = comWord.charAt(comWord.length() - 1);
					
					// 컴퓨터가 사용한 단어를 단어장에서 삭제
					words.getWords().remove(comWord);
					// 컴퓨터가 사용한 단어를 사용한 단어에 추가
					usedWords.add(comWord);
					// 후보 단어 배열 clear
					chainWords.clear();
				}

			} else { // 유저가 입력한 단어가 단어장에 없을때 == 패배
				
				gameSet();
				countLose++;
				System.out.println("패배!!");
				break;
			}
		}
	}

	// 컴퓨터의 차례를 진행하는 메소드, return값은 String 혹은 null(출력할수 있는 단어가 없을때 == 패배)
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

	
	// 유저에게 문자열을 입력받아
	// 유저 문자열의 첫 글자가 이전 단어의 마지막 글자를 잇는지 확인하는 논리 메소드
	public String userTurn() { 

		while (true) {
			String userWord = view.userTurn();

			if (nextChar == '0') {
				return userWord;

			} else if (userWord.charAt(0) == nextChar) {
				return userWord;

			} else {
				System.out.println(nextChar + "로 시작하는 단어를 입력하세요.");
				continue;
			}
		}
	}

	
	// 게임이 끝났을 때 사용된 단어들을 단어장 배열로 반환하는 메소드 (반환 후 clear)
	public void gameSet() {
		for (String s : usedWords) {
			words.getWords().add(s);
		}

		usedWords.clear();
	}
	
}
