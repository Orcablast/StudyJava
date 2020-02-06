package kh.java.func;
import java.util.Scanner;
import java.util.Random;


public class BaskinRobbins {
	public void main() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("==== 배스킨 라빈스 ====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 > ");
			int slt = sc.nextInt();
			
			switch(slt) {
			case 1:				
				StartGame();				
				break;
			case 2:
				Score();
				break;
			case 3:
				return;
				
			}
		}
	}
	
	public void StartGame() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		
		int num = 0;
		
		System.out.println("<<< Game Start >>>");
		
		while(true) {
			System.out.println("<<< your Trun >>>");
			System.out.print("Input Number : ");			
			int userNum = sc.nextInt();
			
//			for(int i=0; i<=userNum; i++) {
//				System.out.println(++num + "!");
//				
//				if(num==31) {
//					System.out.println("패배!!");
//					return;
//				}
//			}
			
			printCount(userNum, num);
			
			System.out.println("<<< Computer Turn >>>");
			int comNum = rn.nextInt(3)+1;
			
//			for(int i=0; i<comNum; i++) {
//				
//				System.out.println(++num+"!");	
//				
//				if(num==31) {
//					System.out.println("승리!!");
//					return;
//				}			
//			}			
			
			printCount(comNum,num);
			
		}
		
	}
	
	public void printCount(int count, int printNumber) {
		for(int i=0; i<count; i++) {
			System.out.println(++printNumber+"!");
		}
	}
	
	public void Score() {
		
	}
}
