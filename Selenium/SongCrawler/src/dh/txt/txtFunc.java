package dh.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public class txtFunc {
	
	public HashMap<String, Integer> readAlbum(){
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("album.txt"));
			
			String str = br.readLine();
			
			while(str != null) {
				System.out.println(str);				
				StringTokenizer sT = new StringTokenizer(str,"^");
				map.put(sT.nextToken()+"^"+sT.nextToken(), Integer.parseInt(sT.nextToken()));
				
				str = br.readLine();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
				
		
		return map;
	}
	
			
	public void writeAlbum() {
		
		BufferedWriter bw = null;
		
		ArrayList<String> list = readSongs();
		HashSet<String> set = new HashSet<String>();
		
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		
		int index = 1;
		
		int imgCnt = 0;
		for(String str : list) {
			StringTokenizer sT = new StringTokenizer(str,"^");
			sT.nextToken();
			
			String artist = sT.nextToken();
			String albumName = sT.nextToken();
			
			if(set.add(albumName+artist)) {
				sb1.append(albumName+"^"+artist+"^"+(index++) +"\r\n");
				
				File img = new File("albumImg/"+artist+"-"+albumName+".jpg");
				
				String albumPath = "null";
				
				if(img.exists()) {
					System.out.println(albumName+"찾음");
					albumPath = artist+"-"+albumName+".jpg";
					sb2.append("insert into album values (seq_album_no.nextval,'"+artist+"','"+albumName+"','"+albumPath+"');\r\n");
					imgCnt++;
					
				} else {
					sb2.append("insert into album values (seq_album_no.nextval,'"+artist+"','"+albumName+"',null);\r\n");
				}
				
			}
			
		}
			
		
		
		
		try {
			bw = new BufferedWriter(new FileWriter("album.txt"));
			bw.write(sb1.toString());
			
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
		

		try {
			bw = new BufferedWriter(new FileWriter("albumSQL.txt"));
			bw.write(sb2.toString());
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
		
		
		System.out.println(imgCnt+"건의 앨범자켓 확인");
		System.out.println(set.size()+"건의 앨범목록 기록완료");
		
	}
	
	
	
	public void writeSongQuerys() {
		
		Random rnd = new Random();
		ArrayList<String> list = readSongs();
		HashMap<String, Integer> map = readAlbum();
		
		BufferedWriter bw = null;
		StringBuffer sb = new StringBuffer();
		
		for(String str : list) {
			StringTokenizer sT = new StringTokenizer(str,"^");
			
			String title = sT.nextToken();
			String artist = sT.nextToken();
			String albumName = sT.nextToken();				
			String likeCnt = sT.nextToken();
			String genre = sT.nextToken();
			
			sb.append("insert into song values(seq_song_no.nextval,'"+title+"','"+artist+"','"+genre+"',"+map.get(albumName+"^"+artist)+","+0+","+likeCnt+",'"+title+"','"+(rnd.nextInt(20)+1)+"',"+1+"); \r\n");
			
		}		
		
		try {
			bw = new BufferedWriter(new FileWriter("songSQL.txt"));
			bw.write(sb.toString());
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
		
		System.out.println(list.size()+"건의 곡 정보 생성 완료");
		
	}

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
			
			System.out.println("처리 전 Volume : "+list.size());
			
			for(String str : list) {
				if(!set.add(str)) {
					dups++;
				}
			}
			
			System.out.println("중복된 Volume : " + dups);
			System.out.println("처리 후 Volume : "+set.size());
			bw = new BufferedWriter(new FileWriter("songsRawData.txt"));
			
			Iterator<String> iter = set.iterator();
			
			while(iter.hasNext()) {
				bw.write(iter.next()+"\r\n");
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
