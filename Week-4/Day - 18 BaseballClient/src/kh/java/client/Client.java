package kh.java.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Integer> userNums;
		
	public void main() throws Exception{
		
		userNums = new ArrayList<Integer>();
		
		String serverIP = "127.0.0.1";
		
		int serverPort = 60000;
		
		Socket server = new Socket(serverIP,serverPort);
		
		System.out.println("������ ���� �Ǿ����ϴ�.");
		System.out.println("�߱����� ����~!");

		DataInputStream in = new DataInputStream(server.getInputStream());
		DataOutputStream out = new DataOutputStream(server.getOutputStream());
		
		while(true) {			
			System.out.println(in.readUTF());
			System.out.print("--> ");
			
			for(int i=0; i<3; i++) {
				out.writeInt(sc.nextInt());
			}
			
			int strike = in.readInt();
			int ball = in.readInt();
			
			System.out.println("��� : "+strike+" ��Ʈ����ũ\t"+ball+" ��");
			
			if(strike == 3) {
				System.out.println("3 ��Ʈ����ũ�� ����� �¸��Դϴ�!!");
				break;
			}
		}
		
		System.out.println("���α׷��� �����մϴ�.");
		
		in.close();
		out.close();
		
	}
}
