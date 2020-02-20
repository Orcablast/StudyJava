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
			// PORT ��ȣ ����
			// ��Ʈ��ȣ ���� 0~65535 (0~1000�� �����ȣ�� ���Ұ�)
			// 1. ������ ���� ��ü ����
			ServerSocket server = new ServerSocket(60000);
			
			// 2. Ŭ���̾�Ʈ�� ���� ��û�� ��ٸ�
			// 3. ��û�� ���� ����
			System.out.println("Ŭ���̾�Ʈ�� ��ٸ���");
						
			// 4. Ŭ���̾�Ʈ ������ ����
			Socket client = server.accept();
			
			System.out.println("Ŭ���̾�Ʈ ����");
						
			// 5. Ŭ���̾�Ʈ ������ ���ؼ� OutputStream ����
			OutputStream out = client.getOutputStream();
			
			// 6. Ŭ���̾�Ʈ ������ ���ؼ� InputStream ����
			InputStream in = client.getInputStream();
			
			DataOutputStream dos = new DataOutputStream(out);
			DataInputStream dis = new DataInputStream(in);
			
			System.out.print("Server > ");
			String msg = sc.nextLine();
			
			// Ŭ���̾�Ʈ�� �޼��� ����
			dos.writeUTF(msg);
			
			// Ŭ���̾�Ʈ�� �޼����� �޾Ƽ� ������ ����
			String clientMsg = dis.readUTF();
			
			System.out.println("client > "+clientMsg);
			
			
			// �ڿ� ��ȯ �� ����
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
			
			System.out.println("Ŭ���̾�Ʈ�� ��ٸ���");
						
			Socket client = server.accept();
			
			System.out.println("Ŭ���̾�Ʈ ����");
						
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
					System.out.println("����ڰ� ������ �����߽��ϴ�.");
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
