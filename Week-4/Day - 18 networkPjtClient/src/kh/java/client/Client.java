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
		// ������ 192.168.10.5
		
		System.out.print("���� ������ : ");
		
		String serverIP =sc.next();
		sc.nextLine();
		int portNumber = 60000;
		
		try {
			// ������ ���� ��û
			Socket socket = new Socket(serverIP,portNumber);
			
			// �ֽ�Ʈ�� ����
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			// ������Ʈ�� ����
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
