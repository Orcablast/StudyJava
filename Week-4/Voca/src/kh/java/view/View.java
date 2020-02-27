package kh.java.view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import kh.java.model.Word;

public class View {
	
	//---------메인 메뉴 및 재사용 가능 메소드------------------------------------------------------------------------------------
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	
	public int main() { //가장 처음 메뉴
		System.out.println("=====영어 단어 사전=====");
		System.out.println("1.단어 검색");
		System.out.println("2.영단어 등록");
		System.out.println("3.테스트 보기");
		System.out.println("4.오답 노트");
		System.out.println("5.단어 수정");
		System.out.println("0.프로그램 종료");
		System.out.print("선택 > ");
		int selMenu = sc.nextInt();
		
		return selMenu;
	}
	
	public String getName(String msg) { // 사용자에게 삭제, 수정 할 단어명을 입력받아 리턴
		System.out.print(msg + " 할 단어 입력 : ");
		String userInput = sc.next();
		sc.nextLine(); // enter buffer 비우기
		return userInput;
	}
	
	
	//---------검색_솔이-------------------------------------------------------------------------------------
		
	public int searchDictionary() { // 검색_영한검색 or 한영검색
		System.out.println("1.영한검색");
		System.out.println("2.한영검색");
		System.out.println("0.뒤로 가기");
		System.out.print("선택 > ");
		int select = sc.nextInt();
		
		return select;
	}
	

	//---------수정 및 삭제_도형이형-------------------------------------------------------------------------------------
	public int updateMain() { // 사용자에게 보여줄 선택지 메뉴, 문자를 입력했을 경우 Exception throws
		System.out.println("사전 관리 메뉴입니다.");
		System.out.println("1. 단어 수정");
		System.out.println("2. 단어 삭제");
		System.out.println("0. 뒤로 가기");
		System.out.print("선택 > ");

		int select = sc.nextInt();
		sc.nextLine(); // enter buffer 비우기

		return select;
	}

	public String getMean(String msg) { // 사용자에게 수정할 단어 내용을 입력받아 리턴
		System.out.print(msg);
		String mean = sc.nextLine(); //new 뜻을 입력하고 리턴

		return mean;
	}

	public Boolean delWord(String userInput) { // 사용자에게 userInput 단어를 정말 삭제할지 확인하여 Boolean 리턴

		while (true) { // 삭제 여부를 y,n으로 사용자가 답변할때까지 루프

			System.out.print("[" + userInput + "] 단어를 정말 삭제하시겠습니까? [y/n] : ");

			char userAns = sc.next().charAt(0);

			if (userAns == 'y') { // 사용자가 y를 입력할 경우 -> true 리턴
				System.out.println("[" + userInput + "] 단어를 삭제합니다");
				return true;

			} else if (userAns == 'n') { // 사용자가 n을 입력할 경우 -> false 리턴
				System.out.println("단어 삭제를 중단합니다.");
				return false;

			} else { // 사용자가 y나 n 이외의 값을 입력했을 경우
				System.out.println("잘못된 입력입니다.");
			}
		}
	}


	//---------테스트_예진누나-------------------------------------------------------------------------------------
		
	
	public int vocaTest() {				//메뉴선택 받아서 숫자리턴.
		System.out.println("---- 단어 테스트 ----");	
		System.out.println("1.영한 테스트");
		System.out.println("2.한영 테스트");
		System.out.println("0.뒤로가기");
		System.out.print("선택 > ");
		int select = sc.nextInt();
		return select;
	}
	
	public int askQNum(String msg) {
		System.out.println("---- "+msg+" 테스트 ----");
		System.out.print("문제 갯수를 입력하세요 : ");
		int qNum = sc.nextInt();
		sc.nextLine();
		return qNum;
	}
	
	public void testResult(double score) {
		System.out.println("\n테스트가 종료되었습니다");
		
		if (score == 0) {
			System.out.println("빵점!! 공부하세요!!!");
		} else {
			System.out.printf("테스트 결과 : %.2f",score);
		}		
	}

	//---------오답_수민누나-------------------------------------------------------------------------------------
	
	public int failMenu() {
		System.out.println("===== 오답노트 =====");
		System.out.println("1. 오답 보기");
		System.out.println("2. 재시험");
		System.out.println("3. 오답노트 비우기");
		System.out.println("0. 뒤로");
		System.out.print("선택 > ");
		int select = sc.nextInt();
		return select;
	}



	// ---------단어 등록_지현-------------------------------------------------------------------------------------

	public int  Insertdictionary() {
		System.out.println("1. 단어입력");
		System.out.println("0. 뒤로가기");
		System.out.print("선택 > ");
		int sel=sc.nextInt();
		return sel;
		
		}
	
	public char inputWord() {
		String nWord;
		System.out.println("등록할 단어를 입력하세요");
		nWord = sc.next();
		nWord=nWord.toLowerCase();
		String name = nWord;
		System.out.println("첫번째 뜻을 입력해주세요 ");
		String nMean1 = sc.next();

		String mean1 = nMean1;
		System.out.println("두번째 뜻을 입력해주세요");
		String nMean2 = sc.next();
		String mean2 = nMean2;
		System.out.println(name+"/"+mean1+"/"+mean2+"가 맞습니까?");
		System.out.println("이대로 등록하시겠습니까?[y/n]");
		char ch=sc.next().charAt(0);
		return ch;
		}
}