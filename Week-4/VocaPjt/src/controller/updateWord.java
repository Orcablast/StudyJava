package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import VO.Word;
import view.updateView;

public class updateWord {

	Word word = new Word(); // 테스트용 객체 생성, 삭제되어야함

	updateView view = new updateView(); // 테스트용 객체 생성, 삭제되어야함

	ArrayList<Word> allDB = new ArrayList<Word>(); // 테스트용 객체 생성, 삭제되어야함

	BufferedReader br = null; // 테스트용 객체 생성, 삭제되어야함

	BufferedWriter bw = null; // 테스트용 객체 생성, 삭제되어야함
	
	Random rn = new Random();

	public updateWord() { // 테스트용 기본생성자, 삭제되어야함

		try {
			br = new BufferedReader(new FileReader("allDB.txt"));

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

					allDB.add(new Word(name, mean1, mean2));
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
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

	public void modifyWord() { // 단어 수정 메소드
		String userInput = view.getName("수정");

		int index = searchIndex(userInput);

		if (index == -1) {
			System.out.println("찾으시는 단어가 없습니다.");

		} else {
			String currentMean1 = allDB.get(index).getMean1();
			String currentMean2 = allDB.get(index).getMean2();
			
			System.out.println("[" + userInput + "] 단어를 수정합니다.");	
			String mean1 = view.getMean("현재 내용 : "+currentMean1+"\t수정  : ");
			
			System.out.println("만약 입력을 중단하시려면 x 를 입력하세요 ↓");
			String mean2 = view.getMean("현재 내용 : "+currentMean2+"\t수정  : ");

			if (mean2.charAt(0) == 'x') {
				allDB.get(index).setMean1(mean1);
				saveDB();

			} else {
				allDB.get(index).setMean1(mean1);
				allDB.get(index).setMean2(mean2);
				saveDB();
			}
		}
	}

	public int searchIndex(String userInput) { // 유저가 입력한 단어명을 매개변수로 index값을 return

		for (int i = 0; i < allDB.size(); i++) {
			
			if (allDB.get(i).getName().equals(userInput)) { // i번째 객체의 getName값이 userInput과 동일할때
				return i; // i값 리턴
			}
		}

		return -1; // 해당되는 단어를 찾지 못할경우 -1 리턴
	}

	public void saveDB() { // 수정, 삭제가 끝날시 진행할 DB 저장 메소드

		try {
			bw = new BufferedWriter(new FileWriter("allDB.txt")); // allDB.txt에 저장하는 BufferWriter 생성

			for (Word w : allDB) { // allDB 내의 모든 Word 객체 검색
				
				// 검색된 Word 객체의 이름, mean1, mean2를 구분자 / 를 기준으로 FileWrite
				bw.write(w.getName() + "/" + w.getMean1() + "/" + w.getMean2()+"\r\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void delWord() { // 단어 삭제 메소드
		String userInput = view.getName("삭제");

		int index = searchIndex(userInput);

		if (index == -1) { // 입력한 단어가 DB에 존재하지 않을때
			System.out.println("찾으시는 단어가 없습니다.");
			return; // 메소드 종료
			
		} else if (view.delWord(userInput)) { // 유저가 y를 입력해 단어삭제를 진행하는 경우
			allDB.remove(index);
			saveDB();

		} else { // 유저가 n을 입력하여 단어삭제를 취소한 경우
			return;
		}

	}
	
	public void showRandomWord() {
		
		while(true) { // 사용자가 그만두기를 입력하지 않으면 루프
			Word randomWord = allDB.get(rn.nextInt(allDB.size()));
			
			view.showRandomWord(randomWord); // randomWord를 사용자화면에 출력
			
			if(view.askNextRandom()) { // 그만둘지를 사용자에게 질문하여 false를 return 받았을때
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}
		}
	}

}
