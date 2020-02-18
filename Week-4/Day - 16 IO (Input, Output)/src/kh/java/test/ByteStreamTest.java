package kh.java.test;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamTest {

	Scanner sc = new Scanner(System.in);

	public void primaryStream() {
		FileOutputStream fos = null;
		System.out.print("저장할 파일명 입력 : ");
		String fileName = sc.next();

		sc.nextLine();

		try {
			fos = new FileOutputStream(fileName);
			System.out.println("["+fileName+"] 파일에 내용을 입력하세요.");
			System.out.println("exit를 입력하시면 종료됩니다.");
			
			int lineNumber = 1;
			
			while(true) {
				System.out.print((lineNumber++)+" : ");
				String str = sc.nextLine()+"\r\n";
				
				if(str.equals("exit\r\n")) {
					System.out.println("입력을 종료합니다!");
					break;
					
				} else {
					
					fos.write(str.getBytes());
				}				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {				
				fos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void subStream() {
		DataOutputStream dos = null;
		
		System.out.print("저장할 파일명 입력 : ");
		String fileName = sc.next();
		sc.nextLine();
		
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			
			dos = new DataOutputStream(fos);
			
			int lineNumber = 1;
			
			while(true) {
				System.out.print((lineNumber++)+" : ");
				String str = sc.nextLine();
				
				if(str.equals("exit")) {
					System.out.println("입력을 종료합니다!");
					break;
					
				} else {					
					dos.writeChars(str); // Byte 변환 없이도 전송 가능
				}				
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {				
				dos.close(); // 질문!!!!!!!!!!!!!!!!
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
