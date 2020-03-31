package kh.java;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		
		int count = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=1; i<=count; i++) {
			for(int h=i; h<count; h++) {
				sb.append(" ");
			}
			for(int j=i; j>0; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
		
	}
}
