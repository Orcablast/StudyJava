package kh.java.array;
import java.util.Scanner;

public class Example04 {
	public void exam01() {
		Scanner sc = new Scanner(System.in);
		
		int countNum=0;
		
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String str = sc.next();
		
		str.length();	
		
		char arr [] = new char [str.length()];

		System.out.print("�˻��� ���ڸ� �Է��ϼ��� : ");
		char search = sc.next().charAt(0);
		
		for(int i=0; i<str.length(); i++) {
			arr [i] = str.charAt(i);
			if(arr[i] == search) {
				countNum++;
			}
		}

		System.out.println("�Է��Ͻ� ���ڿ� " + str + "���� \nã���ô� ���� "+search+"�� "+countNum+" �Դϴ�");		

	}
	
	public void exam02() {
		Scanner sc = new Scanner(System.in);
				
		System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
		String Num = sc.next();
		
		char userNum [] = new char[Num.length()];
		char copyNum [] = new char[Num.length()];
		
		for(int i=0; i<Num.length(); i++) {
			
			userNum[i] = Num.charAt(i);
			copyNum[i] = userNum[i];
			
			if(i>=3 && i<=6) {
				
				copyNum[i] = '*';
				
			}
		}		
		
		System.out.println(userNum);
		System.out.println(copyNum);		
	}
	
	public void exam03() {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("�ֹε�� ��ȣ�� �Է��ϼ��� : ");
		String id = sc.next();
		
		char userId [] = new char[id.length()];
		char copyId [] = new char[id.length()];
		
		for(int i=0; i<id.length(); i++) {
			userId[i]=id.charAt(i);
			copyId[i]=userId[i];
			
			if(i>6) {
				copyId[i]='*';
			}
		}
		
		System.out.println(userId);
		System.out.println(copyId);
		
	}
	
	public void exam04() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("Ȧ���� �Է��ϼ��� : ");
			int userInput = sc.nextInt();
			
			if(userInput%2==0) {
				System.out.println("Ȧ���� �ƴմϴ�.");
				break;				
			}
			
			int arr [] = new int[userInput];
			
			System.out.print("[");
			for (int i=0; i<userInput; i++){
				
				if(i > userInput-i) {
					
					arr[i] = --arr[i-1];
					
				} else {
					
					arr[i] = i+1;
					
				}
				
				if(i == userInput-1) {
					System.out.print(arr[i]);
					continue;
				} else {
					System.out.print(arr[i]+", ");					
				}
				
			}
			System.out.print("]\n");
			
			
			System.out.print("�����Ͻðڽ��ϱ� ? [y/n] : ");
			char ans = sc.next().charAt(0);
			
			if(ans=='y') {
				break;
			}
			
		}
		
		System.out.println("���α׷� ����");
		
		
		
	}
	
	public void exam05() { 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("");
		
	}
}
