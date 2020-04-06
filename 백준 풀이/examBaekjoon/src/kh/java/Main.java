package kh.java;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuffer sb = new StringBuffer();
		StringTokenizer sT = new StringTokenizer(br.readLine()," ");
		int a=Integer.parseInt(sT.nextToken()), b=Integer.parseInt(sT.nextToken());
		
		while(a!=0 || b!=0) {
			sb.append(a+b).append("\n");
			sT = new StringTokenizer(br.readLine()," ");
			
			a = Integer.parseInt(sT.nextToken());
			b = Integer.parseInt(sT.nextToken());
		}
		
		
		
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
		
	}
}
