package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import VO.Word;
import view.updateView;

public class updateWord {

	Word word = new Word();

	updateView view = new updateView();
	
	ArrayList<Word> allDB = new ArrayList<Word>();
	
	BufferedReader br = null;
	
	BufferedWriter bw = null;
	
	public updateWord() {
		
		try {
			br = new BufferedReader(new FileReader("allDB.txt")); 			
			
			String str;
			
			while(true) {
				str = br.readLine();
								
				if(str==null) {
					break;
					
				} else {
					StringTokenizer sT = new StringTokenizer(str,"/");
					
					String name = sT.nextToken();
					String mean1 = sT.nextToken();
					String mean2 = sT.nextToken();
					
					allDB.add(new Word(name,mean1,mean2));
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

	public void updateMain() {

		while (true) {
			int slt = view.updateMain();

			switch (slt) {
			case 1: // �ܾ� ����
				modifyWord();
				break;

			case 2: // �ܾ� ����
				break;

			case 0:
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;

			default:
				System.out.println("0~2 ������ ���ڸ� �Է��ϼ���.");
			}
		}		
	}
	
	public void modifyWord() {
		String userInput = view.getName("����");
		
		int index = searchIndex(userInput);

		if(index==-1) {
			System.out.println("ã���ô� �ܾ �����ϴ�.");
			
		} else {
			System.out.println("["+userInput+"] �ܾ �����մϴ�.");
			String mean1 = view.getMean("���� �� �� : ");
			System.out.println("���� �Է��� �ߴ��Ͻ÷��� x �� �Է��ϼ��� ��");
			String mean2 = view.getMean("���� �� �� : ");
			
			if(mean2.charAt(0)=='x') {
				allDB.get(index).setMean1(mean1);
				
			} else {
				allDB.get(index).setMean1(mean1);
				allDB.get(index).setMean2(mean2);
			}			
			
			
		}		
		
		System.out.println(userInput+"�� �ֳ׿�!");
	}
	
	public int searchIndex(String userInput) {
		
		for(int i=0; i<allDB.size(); i++) {
			if(allDB.get(i).getName().equals(userInput)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void saveDB() {
		for(Word w : allDB) {
			
		}
	}
	
	

}
