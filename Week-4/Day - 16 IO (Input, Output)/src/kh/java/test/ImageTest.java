package kh.java.test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ImageTest {
	Scanner sc = new Scanner(System.in);

	public void exam() {
		BufferedOutputStream bos = null;

		BufferedReader br = null;

		try {
			FileReader fr = new FileReader("quiz.txt");

			br = new BufferedReader(fr);

			String str = br.readLine();

			StringTokenizer sT = new StringTokenizer(str, " ");

			ArrayList<Byte> al = new ArrayList<Byte>();

			while (sT.hasMoreTokens()) {
				Byte b = (byte) (Integer.parseInt(sT.nextToken(), 16));

				al.add(b);
			}

			System.out.println(al.size());

			FileOutputStream fos = new FileOutputStream("test.gif");

			bos = new BufferedOutputStream(fos);

			for (Byte b : al) {
				bos.write(b);
			}
			
			System.out.println("완료!");

		} catch (FileNotFoundException e) { // 1번
			e.printStackTrace();
			
		} catch (IOException e) { // 2번
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
