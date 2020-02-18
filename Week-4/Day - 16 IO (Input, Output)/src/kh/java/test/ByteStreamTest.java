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
		System.out.print("������ ���ϸ� �Է� : ");
		String fileName = sc.next();

		sc.nextLine();

		try {
			fos = new FileOutputStream(fileName);
			System.out.println("["+fileName+"] ���Ͽ� ������ �Է��ϼ���.");
			System.out.println("exit�� �Է��Ͻø� ����˴ϴ�.");
			
			int lineNumber = 1;
			
			while(true) {
				System.out.print((lineNumber++)+" : ");
				String str = sc.nextLine()+"\r\n";
				
				if(str.equals("exit\r\n")) {
					System.out.println("�Է��� �����մϴ�!");
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
		
		System.out.print("������ ���ϸ� �Է� : ");
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
					System.out.println("�Է��� �����մϴ�!");
					break;
					
				} else {					
					dos.writeChars(str); // Byte ��ȯ ���̵� ���� ����
				}				
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {				
				dos.close(); // ����!!!!!!!!!!!!!!!!
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
