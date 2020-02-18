package kh.java.vo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameWords {
	
	private ArrayList<String> words = new ArrayList<String>();

	public GameWords() {
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader("words.txt"));
			
			while(true) {				
				String str = br.readLine();
				
				if(str==null) {
					System.out.println("Words 로딩 완료");
					break;
				} else {
					words.add(str);
				}				
			}
							
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public ArrayList<String> getWords(){
		return words;
	}
	
}
