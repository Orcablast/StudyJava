package dh.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class txtFunc {

	public String getKeyword() {
		BufferedReader br = null;

		String keyword = "";

		try {
			br = new BufferedReader(new FileReader("keyword.txt"));
						
			keyword = br.readLine();
			System.out.println(keyword);

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

		return keyword;
	}

	public void setKeyword(String keyword) {
		BufferedReader br = null;
		BufferedWriter bw = null;

		StringBuffer sb = null;

		try {
			br = new BufferedReader(new FileReader("keyword.txt"));
			sb = new StringBuffer();

			String str;

			while (true) {
				str = br.readLine();

				if (str == null) {
					break;
				}

				if (!str.equals(keyword)) {
					sb.append(str + "\r\n");
				}
			}

			bw = new BufferedWriter(new FileWriter("keyword.txt"));

			bw.write(sb.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public ArrayList<String> readSongs() {

		ArrayList<String> list = new ArrayList<String>();

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("songsRawData.txt"));

			String str = "";

			while (true) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				list.add(str);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	public StringBuffer writeSongs(ArrayList<String> list, StringBuffer sb) {

		for(String str : list) {
			sb.append(str+"\r\n");
		}
		
		return sb;
	}

	public void writeSongs(StringBuffer sb,BufferedWriter bw) {
		

		try {

			bw.write(sb.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cleanDups() {
		BufferedWriter bw = null;
		
		try {
			
			ArrayList<String> list = new txtFunc().readSongs();				
			
			HashSet<String> set = new HashSet<String>();
			int dups = 0;
			
			System.out.println("贸府 傈 Volume : "+list.size());
			
			for(String str : list) {
				if(!set.add(str)) {
					dups++;
				}
			}
			
			System.out.println("吝汗等 Volume : " + dups);
			System.out.println("贸府 饶 Volume : "+set.size());
			bw = new BufferedWriter(new FileWriter("cleanSongs.txt"));
			
			Iterator<String> iter = set.iterator();
			
			while(iter.hasNext()) {
				bw.write(iter.next());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
