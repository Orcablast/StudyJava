package kh.java.vo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameWords {
	
	private ArrayList<String> words = new ArrayList<String>();
	
	// �⺻ ������ 
	// text.txt�� �ܾ���� �о� words �迭�� ����
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
			System.out.println("word.txt ������ ã���� �����ϴ�.");
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
	
	// Ÿ Ŭ�������� words �迭�� ȣ���ϴ� �޼ҵ�
	public ArrayList<String> getWords(){
		return words;
	}
	
}
