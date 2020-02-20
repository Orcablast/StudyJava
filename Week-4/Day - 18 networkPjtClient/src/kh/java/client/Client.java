package kh.java.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	Scanner sc = new Scanner(System.in);
	
	public void main() {
		// 은영씨 192.168.10.5
		
		System.out.print("서버 아이피 : ");
		
		String serverIP =sc.next();
		sc.nextLine();
		int portNumber = 60000;
		
		try {
			// 서버에 접속 요청
			Socket socket = new Socket(serverIP,portNumber);
			
			// 주스트림 생성
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			// 보조스트림 생성
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			
			while(true) {
				String serverMsg = dis.readUTF();
				System.out.println("server > "+serverMsg);
				
				System.out.print("client > ");
				String msg = sc.nextLine();
				
				
				dos.writeUTF(msg);
				if(msg.charAt(0)=='x') {
					break;
				}
			}
			
			dis.close();
			dos.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
