package dh.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class txtFunc {

	

	public String getKeyword() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		String keyword = "";
		
		try {
			br = new BufferedReader(new FileReader("keyword.txt"));

			keyword = br.readLine();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				br.close();
				br = null;
				
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		}

		return keyword;
	}
	
	public void setKeyword(String keyword) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		StringBuffer sb = null;		
		
		try {
			br = new BufferedReader(new FileReader("keyword.txt"));
//			bw = new BufferedWriter(new FileWriter("keyword.txt"));
			sb = new StringBuffer();

			String str;
			
			while(true) {
				str = br.readLine();
				
				if(str==null) {
					break;
				}
				
				
				if(!str.equals(keyword)) {
					sb.append(str);
				}
				
				
			}
			System.out.println(sb);
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
//				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
		
	}

}
