package kh.java.server;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	public void main() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			// PORT 번호 저장
			// 포트번호 범위 0~65535 (0~1000는 예약번호로 사용불가)
			// 1. 서버의 소켓 객체 생성
			ServerSocket server = new ServerSocket(60000);
			
			// 2. 클라이언트의 접속 요청을 기다림
			// 3. 요청이 오면 수락
			System.out.println("클라이언트를 기다린당");
						
			// 4. 클라이언트 정보를 저장
			Socket client = server.accept();
			
			System.out.println("클라이언트 접속");
						
			// 5. 클라이언트 정보를 통해서 OutputStream 생성
			OutputStream out = client.getOutputStream();
			
			// 6. 클라이언트 정보를 통해서 InputStream 생성
			InputStream in = client.getInputStream();
			
			DataOutputStream dos = new DataOutputStream(out);
			DataInputStream dis = new DataInputStream(in);
			
			System.out.print("Server > ");
			String msg = sc.nextLine();
			
			// 클라이언트에 메세지 전송
			dos.writeUTF(msg);
			
			// 클라이언트에 메세지를 받아서 변수에 저장
			String clientMsg = dis.readUTF();
			
			System.out.println("client > "+clientMsg);
			
			
			// 자원 반환 후 종료
			dis.close();
			dos.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
public void main02() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			ServerSocket server = new ServerSocket(60000);
			
			System.out.println("클라이언트를 기다린당");
						
			Socket client = server.accept();
			
			System.out.println("클라이언트 접속");
						
			OutputStream out = client.getOutputStream();
			
			InputStream in = client.getInputStream();
			
			DataOutputStream dos = new DataOutputStream(out);
			DataInputStream dis = new DataInputStream(in);
			
			while(true) {
				System.out.print("Server > ");
				String msg = sc.nextLine();
				
				dos.writeUTF(msg);
				
				String clientMsg = dis.readUTF();
				if(clientMsg.charAt(0)=='x'){
					System.out.println("사용자가 접속을 종료했습니다.");
					break;
				} else {
					System.out.println("client > "+clientMsg);
					
				}
			}
					
			
			
			
			
			dis.close();
			dos.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
	}

}
