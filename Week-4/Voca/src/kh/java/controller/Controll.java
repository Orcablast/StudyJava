package kh.java.controller;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringTokenizer;
import kh.java.view.View;
import kh.java.model.*;

public class Controll {

	// ---------재사용 가능 메소드 및 전역
	// 멤버-------------------------------------------------------------------------------------
	Word word = new Word();
	View view = new View();
	ArrayList<Word> allDB = new ArrayList<Word>(); // 영단어 List
	ArrayList<Word> failDB = new ArrayList<Word>(); // 오답 DB List
	ArrayList<Integer> qIndex = new ArrayList<Integer>();
	ArrayList<Integer> cIndex = new ArrayList<Integer>();
	BufferedReader br;
	BufferedReader failBr;
	BufferedWriter bw;
	BufferedWriter failBw;
	Random r = new Random();
	Scanner sc = new Scanner(System.in);

	public Controll(){ // 단어장 전체 읽어와 리스트에 추가

		try {
			br = new BufferedReader(new FileReader("allDB.txt"));

			readDB(br, allDB);
			System.out.println("단어장 로딩 완료");

			failBr = new BufferedReader(new FileReader("failDB.txt"));

			readDB(failBr, failDB);
			System.out.println("오답노트 로딩 완료");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				failBr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void controlMain() { // 첫 메뉴

		try {
			while (true) {
				int select = view.main();
				switch (select) {
				case 1: // 단어 검색
					search();
					break;
				case 2:// 영단어 등록
					Insertdictionary();
					break;
				case 3:// 테스트
					testMenu();
					break;
				case 4:// 오답 노트
					failMenu();
					break;
				case 5:// 단어 수정 및 삭제
					updateMain();
					break;
				case 0:
					bw = new BufferedWriter(new FileWriter("allDB.txt"));
					saveDB(bw,allDB);
					failBw = new BufferedWriter(new FileWriter("failDB.txt"));
					saveDB(failBw,failDB);
					bw.close();
					failBw.close();
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("오류 발생");
			try {
				bw = new BufferedWriter(new FileWriter("allDB.txt"));
				saveDB(bw,allDB);
				failBw = new BufferedWriter(new FileWriter("failDB.txt"));
				saveDB(failBw,failDB);
				bw.close();
				failBw.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public int searchIndex(String userInput) { // 유저가 입력한 단어 단어장에 있는지 검사 및 결과 리턴 !!!!!!!재사용 가능!!!!!!!!!

		for (int i = 0; i < allDB.size(); i++) {
			if (allDB.get(i).getName().equals(userInput)) { // i번째 객체의 getName값이 userInput과 동일할때
				return i; // i값 리턴
			}
		}
		return -1; // 해당되는 단어를 찾지 못할경우 -1 리턴
	}

	public void saveDB(BufferedWriter bfw, ArrayList<Word> arr) throws IOException { // 수정, 삭제가 끝날시 진행할 DB 저장 메소드
		
		int i = 0;
		for (Word w : arr) { // allDB 내의 모든 Word 객체 검색

			if (i != 0) { // 최초에는 개행처리하지않음.
				bfw.newLine();
			}
			// 검색된 Word 객체의 이름, mean1, mean2를 구분자 / 를 기준으로 FileWrite

			bfw.write(w.getName() + "/" + w.getMean1() + "/" + w.getMean2());
			i++;
		}
	}

	public void readDB(BufferedReader br, ArrayList<Word> arr) throws IOException { // txt를 읽어 ArrayList에 저장하는 메소드

		String str;

		while (true) {
			str = br.readLine();

			if (str == null) {
				break;

			} else {
				StringTokenizer sT = new StringTokenizer(str, "/");

				String name = sT.nextToken();
				String mean1 = sT.nextToken();
				String mean2 = sT.nextToken();

				arr.add(new Word(name, mean1, mean2));
			}
		}
	}
	
	public void updateMain() { // 유저에게 메뉴화면을 출력하고 입력값을 리턴받아 진행

		while (true) {
			int slt = view.updateMain();

			switch (slt) {
			case 1: // 단어 수정
				modifyWord();
				break;
			case 2: // 단어 삭제
				delWord();
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("0~2 사이의 숫자를 입력하세요.");
			}
		}
	}

	public void modifyWord() { // 단어 수정 후 리스트에 저장
		String userInput = view.getName("수정");

		int index = searchIndex(userInput);

		if (index == -1) {
			System.out.println("찾으시는 단어가 없습니다.");

		} else {
			String currentMean1 = allDB.get(index).getMean1(); // 전체 단어가 있는 리스트의 뜻1과 뜻 2
			String currentMean2 = allDB.get(index).getMean2();

			System.out.println("[" + userInput + "] 단어를 수정합니다.");
			String mean1 = view.getMean("현재 내용 : " + currentMean1 + "\t수정  : "); // 단어의 첫번째 뜻

			System.out.println("만약 입력을 중단하시려면 x 를 입력하세요 ↓");
			String mean2 = view.getMean("현재 내용 : " + currentMean2 + "\t수정  : ");

			if (mean2.charAt(0) == 'x') {
				allDB.get(index).setMean1(mean1);

			} else {
				allDB.get(index).setMean1(mean1);
				allDB.get(index).setMean2(mean2);
			}
		}
	}

	public void delWord() { // 단어 삭제 메소드 !!!!!!!재사용 가능!!!!!!!!!
		String userInput = view.getName("삭제"); // 삭제할 단어

		int index = searchIndex(userInput);

		if (index == -1) { // 입력한 단어가 DB에 존재하지 않을때
			System.out.println("찾으시는 단어가 없습니다.");
			return; // 메소드 종료

		} else if (view.delWord(userInput)) { // 유저가 y를 입력해 단어삭제를 진행하는 경우 = true가 리턴될 때
			allDB.remove(index);

		} else { // 유저가 n을 입력하여 단어삭제를 취소한 경우
			return;
		}
	}

	// ---------검색_솔이-------------------------------------------------------------------------------------
	public void search() {

		while (true) {
			int select = view.searchDictionary(); // view에서 영한 검색할지 한영 검색할지
			switch (select) {
			case 1:
				searchEng();
				break;
			case 2:
				searchKor();
				break;
			case 0:
				return;
			}
		}
	}

	public void searchEng() { // 영단어로 뜻 검색
		// 입력받는 화면인 View클래스의 객체 만들기
		String search = view.getName("검색"); // 검색할 단어 입력받기

		for (int i = 0; i < search.length(); i++) {// 영단어 이외의 문자 입력 시
			if (search.charAt(i) < 'A' || search.charAt(i) > 'z') {
				System.out.println("영어만 입력할 수 있습니다.");
				return;
			}
		}

		search = search.toLowerCase();

		boolean find = false; // 단어장에 없는 단어를 검색했을 때 없는단어라고 말해주기위함

		for (int i = 0; i < allDB.size(); i++) {
			if (allDB.get(i).getName().equals(search)) {// 단어장의 단어들 중 내가 입력한것과 일치하는것이 있으면
				System.out.println("단어 : " + allDB.get(i).getName() + "\n첫번째 뜻 : " + allDB.get(i).getMean1()
						+ "\n두번째 뜻 : " + allDB.get(i).getMean2());
				find = true;
			}
		}
		if (find == false) {
			System.out.println("단어장에 없는 단어입니다!");
		}
	}

	public void searchKor() { // 뜻으로 영단어 검색

		String search = view.getName("검색"); // 검색할 단어 입력받기
		boolean find = false; // 단어장에 없는 단어를 검색했을 때 없는단어라고 말해주기위함
		for (int i = 0; i < allDB.size(); i++) {
			// 내가 검색한 뜻이 모든 단어의 mean1 또는 mean2 중에 일치하는게 있으면
			if (allDB.get(i).getMean1().equals(search) || allDB.get(i).getMean2().equals(search)) {
				// 같은 뜻을 가진 단어 모두 출력
				System.out.println("단어 : " + allDB.get(i).getName() + "\n첫번째 뜻 : " + allDB.get(i).getMean1()
						+ "\n두번째 뜻 : " + allDB.get(i).getMean2());
				find = true;
			}
		}
		if (find == false) {
			System.out.println("[" + search + "]의 뜻을 가진 단어가 없습니다!");
		}
	}

	// ---------테스트_예진누나------------------------------------------------------------------------------------

	public void setTest(ArrayList<Word> DB, int qNum) { // 사용자가 입력한 값만큼 사용할 문제의 index를 정하는 메소드
		int index;
		for (int i = 0; i < qNum; i++) {
			index = r.nextInt(DB.size());

			if (qIndex.contains(index)) {
				i--;
				continue;

			} else {
				qIndex.add(index);
			}
		}
	}

	public int doTest(ArrayList<Word> DB, int slt) {
		int score = 0;

		for (int i : qIndex) {

			switch (slt) {
			case 1:
				System.out.print("\n" + DB.get(i).getName() + " : ");
				break;

			case 2:
				System.out.print("\n" + DB.get(i).getMean1() + ", " + DB.get(i).getMean2() + " : ");
				break;
			}

			String ans = sc.nextLine();

			int result = DB.get(i).toString().indexOf(ans);

			if (result == -1) {
				System.out.println("땡!!");
				if (!checkDup(failDB, DB.get(i))) {
					failDB.add(DB.get(i));
				}

			} else {
				System.out.println("정답!!");
				cIndex.add(i);
				score++;
			}
		}

		qIndex.clear();
		return score;
	}

	public void testMenu() { // needCheck
		double score;
		int qNum;
		// 게임선택
		while (true) {
			int select = view.vocaTest(); // view에서 메뉴선택 입력받음.
			switch (select) {
			case 1: // 영한테스트라면

				qNum = view.askQNum("영한");
				setTest(allDB, qNum);

				System.out.println("테스트를 시작합니다.");
				System.out.println("다음 단어를 보고 답을 입력하세요.");

				score = doTest(allDB, 1);

				view.testResult((score / (double) qNum) * 100);

				break;
			case 2: // 한영테스트라면

				qNum = view.askQNum("한영");
				setTest(allDB, qNum);

				System.out.println("테스트를 시작합니다.");
				System.out.println("다음 의미를 보고 단어를 입력하세요.");

				score = doTest(allDB, 2);

				view.testResult((score / (double) qNum) * 100);
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}
		}
	} // main

	public Boolean checkDup(ArrayList<Word> DB, Word w) {

		for (int i = 0; i < DB.size(); i++) {
			if (DB.get(i).toString().equals(w.toString())) {
				return true;
			}
		}

		return false;
	}

	// ---------오답_수민누나-------------------------------------------------------------------------------------

	public void failMenu() {
		while (true) {
			int select = view.failMenu();
			switch (select) {
			case 1:
				readNote();
				break;
			case 2:
				reTest();
				break;
			case 3:
				failDB.clear();
				System.out.println("오답노트가 삭제되었습니다.");
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}
		}
	}

	public void reTest() { // 재작성 필요

		if (failDB.size() == 0) {
			System.out.println("오답노트가 비어있습니다");
			System.out.println("이전 메뉴로 돌아갑니다");
			return;
		}
		System.out.println("테스트를 시작합니다. 다음 영단어를 보고 뜻을 입력하세요.");

		setTest(failDB, failDB.size());

		double score = doTest(failDB, 1);

		view.testResult((score / (double) failDB.size()) * 100);

		if (cIndex.size() == failDB.size()) {
			failDB.clear();
			
		} else {
			
			Collections.sort(cIndex);
			Collections.reverse(cIndex);
			
			for (int i : cIndex) {
				failDB.remove(i);
			}

		}

		cIndex.clear();

	}

	public void readNote() { // 오답노트 넘버링 보고 선택해서 뜻까지 조회

		if (failDB.size() == 0) { // 보여줄 오답이 없을 시
			System.out.println("오답노트에 담긴 단어가 없습니다.\n");
			return;
		} else {// failName(뜻 제외한 단어만 들어있는) 배열에 넣은 오답name 일련화해서 출력
			int i = 1;
			for (Word w : failDB) {
				System.out.println(i + ". " + w.toString());
				i++;
			}
		}
	}

	public void Insertdictionary() {
		while (true) {
			int sel = view.Insertdictionary();
			switch (sel) {
			case 1:
				inputWord();
				break;
			case 0:
				return;
			}
		}
	}

	public void inputWord() { // 영단어 등록
		String nWord;
		boolean bool;
		while (true) {
			bool = true;
			System.out.println("등록할 단어를 입력하세요 : ");
			nWord = sc.next().toLowerCase();
			for (int i = 0; i < allDB.size(); i++) {
				if (nWord.equals(allDB.get(i).getName())) {
					System.out.println("단어가 중복됩니다.다시 입력해주세요");
					bool = false;
					break;
				}

			}
			if (bool) {
				break;
			}
		}

		String name = nWord;
		System.out.print("첫번째 뜻을 입력해주세요 : ");
		String nMean1 = sc.next();

		System.out.print("두번째 뜻을 입력해주세요 : ");
		String nMean2 = sc.next();

		System.out.println(name + "/" + nMean1 + "/" + nMean2 + "가 맞습니까?");
		System.out.print("이대로 등록하시겠습니까?[y/n] : ");
		char ch = sc.next().charAt(0);

		switch (ch) {
		case 'y':
			Word w = new Word(name, nMean1, nMean2);
			allDB.add(w);
			System.out.println("====단어가 등록되었습니다====");
			break;
		case 'n':
			break;
		default:
			System.out.println("잘못된 입력입니다. 형식에 맞춰 입력해주세요! ");
		}

	}

}
