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
		System.out.println("���� ������ �����߽��ϴ�.");
		
		while(true) {
			System.out.println("Ŭ���̾�Ʈ ��� ��");

			makeNums();
			
			System.out.println("���� ���� -> " + nums.get(0) + " " + nums.get(1) + " " + nums.get(2));

			Socket user = server.accept();

			System.out.println("������ �����߽��ϴ�.");
			
			System.out.println("�߱� ���� ����~!");
					
			DataOutputStream out = new DataOutputStream(user.getOutputStream());
			
			DataInputStream in = new DataInputStream(user.getInputStream());
			
			userNums = new ArrayList<Integer>();
			
			while(true) {
				out.writeUTF("�� ���� �Է��� �ּ��� (ex: 1 2 3)");
				
				for(int i=0; i<3; i++) {
					userNums.add(in.readInt());
				}
				
				int ball = 0;
				int strike = 0;
							
				System.out.print("������ �Է��� �� -> ");
				
				for(int i=0; i<nums.size(); i++) {
					
					System.out.print(userNums.get(i)+" ");
					
					if(nums.get(i) == userNums.get(i)) {
						strike++;
						
					} else if(nums.contains(userNums.get(i))) {
						ball++;
					}
				}
				System.out.println();
				
				System.out.print(strike+" ��Ʈ����ũ\t");
				out.writeInt(strike);
				System.out.print(ball+" ��\n");
				out.writeInt(ball);
				
				if(strike==3) {
					System.out.println("������ �¸��Ͽ����ϴ�.");
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

	public void makeNums() { // ���� �����~

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
	
