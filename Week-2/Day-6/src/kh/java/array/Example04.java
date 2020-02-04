package kh.java.array;
import java.util.Scanner;

public class Example04 {
	public void exam01() {
		Scanner sc = new Scanner(System.in);
		
		int countNum=0;
		
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.next();
		
		str.length();	
		
		char arr [] = new char [str.length()];

		System.out.print("검색할 문자를 입력하세요 : ");
		char search = sc.next().charAt(0);
		
		for(int i=0; i<str.length(); i++) {
			arr [i] = str.charAt(i);
			if(arr[i] == search) {
				countNum++;
			}
		}

		System.out.println("입력하신 문자열 " + str + "에서 \n찾으시는 문자 "+search+"는 "+countNum+" 입니다");		

	}
	
	public void exam02() {
		Scanner sc = new Scanner(System.in);
				
		System.out.print("전화번호를 입력하세요 : ");
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
	
		System.out.print("주민등록 번호를 입력하세요 : ");
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
			
			System.out.print("홀수를 입력하세요 : ");
			int userInput = sc.nextInt();
			
			if(userInput%2==0) {
				System.out.println("홀수가 아닙니다.");
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
			
			
			System.out.print("종료하시겠습니까 ? [y/n] : ");
			char ans = sc.next().charAt(0);
			
			if(ans=='y') {
				break;
			}
			
		}
		
		System.out.println("프로그램 종료");
		
		
		
	}
	
	public void exam05() { 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("");
		
	}
}
