package kh.java.vo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameWords {
	
	private ArrayList<String> words = new ArrayList<String>();
	
	// 기본 생성자 
	// text.txt의 단어들을 읽어 words 배열에 저장
	public GameWords() {
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader("C:\\Users\\user1\\Desktop\\words.txt"));
			
			while(true) {				
				String str = br.readLine();
				
				if(str==null) {
					break;
					
				} else {
					words.add(str);
				}				
			}
							
		} catch (FileNotFoundException e) {
			System.out.println("word.txt 파일을 찾을수 없습니다.");
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
	
	// 타 클래스에서 words 배열을 호출하는 메소드
	public ArrayList<String> getWords(){
		return words;
	}
	
}
