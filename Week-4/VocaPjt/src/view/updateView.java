package view;
import java.util.Scanner;

import VO.Word;



public class updateView {
	
	Scanner sc = new Scanner(System.in);

	
	public int updateMain() {
		System.out.println("단어 등록 메뉴입니다.");
		System.out.println("1. 단어 수정");
		System.out.println("2. 단어 삭제");
		System.out.println("0. 뒤로 가기");
		
		int select = sc.nextInt();
		
		return select;
	}
	
	public String getName(String msg) {
		System.out.print(msg+" 할 단어 입력 : ");
		String userInput = sc.next();
		
		return userInput;
	}
	
	public String getMean(String msg) {
		sc.nextLine();
		System.out.print(msg);
		String mean = sc.nextLine();
		
		return mean;
	}
}
