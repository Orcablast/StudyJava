package VO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Word {
	
	private String name;
	private String mean1;
	private String mean2;
	
	public Word(){
	}
	
	public Word(String name, String mean1, String mean2) {
		this.name = name;
		this.mean1= mean1;
		this.mean2 = mean2;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMean1() {
		return mean1;
	}

	public void setMean1(String mean1) {
		this.mean1 = mean1;
	}

	public String getMean2() {
		return mean2;
	}

	public void setMean2(String mean2) {
		this.mean2 = mean2;
	}

	ArrayList<Word> allDB; // 전역 변수
	
	BufferedReader br = null; // 전역 변수
	
	public void makeDB() {

		ArrayList<Word> allDB = new ArrayList<Word>();
		
		
		try {
			br = new BufferedReader(new FileReader("all.txt")); 			
			
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
		}
		
		
	}
	
	
	

}
