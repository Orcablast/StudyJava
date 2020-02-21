package kh.java.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Server {
	
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();

	ArrayList<Integer> nums;
	ArrayList<Integer> userNums;
	

	public void main() throws Exception {
		
		ServerSocket server = new ServerSocket(60000);
		System.out.println("서버 소켓을 생성했습니다.");
		
		while(true) {
			System.out.println("클라이언트 대기 중");

			makeNums();
			
			System.out.println("서버 숫자 -> " + nums.get(0) + " " + nums.get(1) + " " + nums.get(2));

			Socket user = server.accept();

			System.out.println("유저가 접속했습니다.");
			
			System.out.println("야구 게임 시작~!");
					
			DataOutputStream out = new DataOutputStream(user.getOutputStream());
			
			DataInputStream in = new DataInputStream(user.getInputStream());
			
			userNums = new ArrayList<Integer>();
			
			while(true) {
				out.writeUTF("세 수를 입력해 주세요 (ex: 1 2 3)");
				
				for(int i=0; i<3; i++) {
					userNums.add(in.readInt());
				}
				
				int ball = 0;
				int strike = 0;
							
				System.out.print("유저가 입력한 수 -> ");
				
				for(int i=0; i<nums.size(); i++) {
					
					System.out.print(userNums.get(i)+" ");
					
					if(nums.get(i) == userNums.get(i)) {
						strike++;
						
					} else if(nums.contains(userNums.get(i))) {
						ball++;
					}
				}
				System.out.println();
				
				System.out.print(strike+" 스트라이크\t");
				out.writeInt(strike);
				System.out.print(ball+" 볼\n");
				out.writeInt(ball);
				
				if(strike==3) {
					System.out.println("유저가 승리하였습니다.");
					break;
					
				} else {
					userNums.clear();
				}
			}
			
			in.close();
			out.close();		
			user.close();
						
		}
		
		
	}

	public void makeNums() { // 숫자 만들기~

		nums = new ArrayList<Integer>();

		int newNum = rn.nextInt(10);
		while (nums.size() < 3) {

			if (!nums.contains(newNum)) {

				nums.add(newNum);

			} else {

				newNum = rn.nextInt(10);
			}
		}
	}
}
	
