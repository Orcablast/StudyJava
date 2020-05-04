package dh.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
			br = new BufferedReader(new FileReader("test.txt"));

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

	public void writeSongs(ArrayList<String> list) {

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("test.txt"));

			for (String str : list) {

				bw.write(str + "\r\n");

			}

		} catch (IOException e) {
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

	public void writeSongs(StringBuffer sb) {
		
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("test.txt"));

			bw.write(sb.toString());

		} catch (IOException e) {
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
