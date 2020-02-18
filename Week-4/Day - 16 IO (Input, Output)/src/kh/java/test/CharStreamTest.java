package kh.java.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamTest {

	Scanner sc = new Scanner(System.in);

	public void primaryStream() {
		FileWriter fw = null;
		
		System.out.print("������ ���� �� : ");
		String fileName = sc.next();
		sc.nextLine();
		
		try {
			fw = new FileWriter(fileName);
			System.out.println("["+fileName+"]�� ����� ������ �Է��ϼ���.");
			System.out.println("exit�� �Է��Ͻø� ����˴ϴ�.");
			
			int lineNum = 1;
			
			while(true) {
				System.out.print((lineNum++) +" : ");
				String str = sc.nextLine()+"\r\n";
				
				if(str.equals("exit\r\n")) {
					System.out.println("�Է��� �����մϴ�.");
					break;
					
				} else {
					fw.write(str);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				fw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void subStream() {
		BufferedWriter bw = null;
		
		System.out.print("������ ���ϸ� �Է� : ");
		String fileName = sc.next();
		
		sc.nextLine();
		
		try {
			
			bw = new BufferedWriter(new FileWriter(fileName));
			
			System.out.println("["+fileName+"] �� ����� ������ �Է��ϼ���.");
			System.out.println("exit�� �Է��Ͻø� ����˴ϴ�.");
			
			int lineNum = 1;
			
			while(true) {
				System.out.println((lineNum++)+" : ");
				String str = sc.nextLine();
				
				if(str.equals("exit")) {
					System.out.println("�Է��� �����մϴ�.");
					break;
				} else {
					bw.write(str);
					bw.newLine();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void reader() {
		System.out.print("load�� ���� �� �Է� : ");
		String fileName = sc.next();
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(fileName));
			
			int lineNum = 1;
			
			while(true) {
				String str = br.readLine();
				
				if(str==null) {
					System.out.println("������ �������ϴ�.");
					break;
					
				} else {
					System.out.println((lineNum++) + " : " + str);
				}
			}
			
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
	}
}
