package kh.java.test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ImageStream {
	public void test() {
		// quiz.txt 파일의 내용을 읽어오기 위한 보조스트림
		BufferedReader br = null;
		// 이미지 파일로 내보내기 위한 주스트림
		FileOutputStream fos = null;
		
		try {
			// quiz.txt 파일을 읽어오기 위한 주스트림 생성
			FileReader fr = new FileReader("quiz.txt");
			// 속도 증가를 위한 보조스트림 생성
			br = new BufferedReader(fr);
			// 파일에서 한줄 읽어옴
			String str = br.readLine();
			// 16진수를 1개씩 저장하기 위해서 공백을 구분자로 토크나이저 사용
			StringTokenizer sT = new StringTokenizer(str, " ");
			// 잘라낸 데이터를 저장하기 위한 ArrayList 생성 (배열의 사이즈에서 이점)
			ArrayList<Byte> al = new ArrayList<Byte>();

			while (sT.hasMoreTokens()) {
//				// 토큰에서 한개 꺼내옴
//				String st = sT.nextToken();
//				// 꺼내온 16진수 데이터를 10진수 정수로 변경
//				int num = Integer.parseInt(st,16);
//				// byteStream으로 데이터를 내보내기 위해 byte 타입으로 저장
//				byte b = (byte)(num);
//				// ArrayList에 byte 데이터 추가
//				al.add(b);
				
				// 간결화 코드 ->			
				byte b = (byte) (Integer.parseInt(sT.nextToken(), 16));
				al.add(b);
			}

			System.out.println(al.size());
			
			fos = new FileOutputStream("test.gif");
			
			for (byte b : al) {
				fos.write(b);
			}
			
			// Byte[] arr = new Byte[2097152];
			// int i = 0;
			//
			// while (sT.hasMoreTokens()) {
			// byte b = (byte) (Integer.parseInt(sT.nextToken(), 16));
			// arr[i++] = b;
			// }
			//
			// for (Byte b : arr) {
			// fos.write(arr[j]);
			// }

			System.out.println("파일 전송 끝");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				br.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	public void test02() { // BufferdOutput
		// quiz.txt 파일의 내용을 읽어오기 위한 보조스트림
		BufferedReader br = null;
		// 이미지 파일로 내보내기 위한 주스트림
		FileOutputStream fos = null;
		
		BufferedOutputStream bos = null;
		
		try {
			// quiz.txt 파일을 읽어오기 위한 주스트림 생성
			FileReader fr = new FileReader("quiz.txt");
			// 속도 증가를 위한 보조스트림 생성
			br = new BufferedReader(fr);
			// 파일에서 한줄 읽어옴
			String str = br.readLine();
			// 16진수를 1개씩 저장하기 위해서 공백을 구분자로 토크나이저 사용
			StringTokenizer sT = new StringTokenizer(str, " ");
			// 잘라낸 데이터를 저장하기 위한 ArrayList 생성 (배열의 사이즈에서 이점)
			ArrayList<Byte> al = new ArrayList<Byte>();

			while (sT.hasMoreTokens()) {
//				// 토큰에서 한개 꺼내옴
//				String st = sT.nextToken();
//				// 꺼내온 16진수 데이터를 10진수 정수로 변경
//				int num = Integer.parseInt(st,16);
//				// byteStream으로 데이터를 내보내기 위해 byte 타입으로 저장
//				byte b = (byte)(num);
//				// ArrayList에 byte 데이터 추가
//				al.add(b);
				
				// 간결화 코드 ->			
				byte b = (byte) (Integer.parseInt(sT.nextToken(), 16));
				al.add(b);
			}

			System.out.println(al.size());
			
			fos = new FileOutputStream("test.gif");
			
			bos = new BufferedOutputStream(fos);
			
			for (byte b : al) {
				bos.write(b);
			}
			
			// Byte[] arr = new Byte[2097152];
			// int i = 0;
			//
			// while (sT.hasMoreTokens()) {
			// byte b = (byte) (Integer.parseInt(sT.nextToken(), 16));
			// arr[i++] = b;
			// }
			//
			// for (Byte b : arr) {
			// fos.write(arr[j]);
			// }

			System.out.println("파일 전송 끝");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				
				br.close();
				bos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
}
