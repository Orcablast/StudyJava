package kh.java;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			
			String str = br.readLine();
			StringTokenizer sT = new StringTokenizer(str, " ");
			
			int h = Integer.parseInt(sT.nextToken());
			int m = Integer.parseInt(sT.nextToken());			
						
			if (m<45){
				h = (h==0 ? 23 : h);
				m += (60-45);
			} else {
				m -= 45;
			}
			
			System.out.println(h+" "+m);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
