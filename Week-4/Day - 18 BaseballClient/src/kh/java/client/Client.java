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
		
		System.out.println("서버에 접속 되었습니다.");
		System.out.println("야구게임 시작~!");

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
			
			System.out.println("결과 : "+strike+" 스트라이크\t"+ball+" 볼");
			
			if(strike == 3) {
				System.out.println("3 스트라이크로 당신의 승리입니다!!");
				break;
			}
		}
		
		System.out.println("프로그램을 종료합니다.");
		
		in.close();
		out.close();
		
	}
}
