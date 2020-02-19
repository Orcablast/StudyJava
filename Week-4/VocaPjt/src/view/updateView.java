package view;


import java.util.Scanner;

public class updateView {

	Scanner sc = new Scanner(System.in);

	public int updateMain() { // 사용자에게 보여줄 선택지 메뉴, 문자를 입력했을 경우 Exception throws
		System.out.println("사전 관리 메뉴입니다.");
		System.out.println("1. 단어 수정");
		System.out.println("2. 단어 삭제");
		System.out.println("0. 뒤로 가기");
		System.out.print("선택 > ");

		int select = sc.nextInt();
		sc.nextLine(); // enter buffer 비우기

		return select;
	}

	public String getName(String msg) { // 사용자에게 삭제, 수정 할 단어명을 입력받아 리턴
		System.out.print(msg + " 할 단어 입력 : ");
		String userInput = sc.next();
		sc.nextLine(); // enter buffer 비우기
		return userInput;
	}

	public String getMean(String msg) { // 사용자에게 수정할 단어 내용을 입력받아 리턴
		System.out.print(msg);
		String mean = sc.nextLine();

		return mean;
	}

	public Boolean delWord(String userInput) { // 사용자에게 userInput 단어를 정말 삭제할지 확인하여 Boolean 리턴

		while (true) { // 삭제 여부를 y,n으로 사용자가 답변할때까지 루프

			System.out.print("[" + userInput + "] 단어를 정말 삭제하시겠습니까? [y/n] : ");

			char userAns = sc.next().charAt(0);

			if (userAns == 'y') { // 사용자가 y를 입력할 경우 -> true 리턴
				System.out.println("[" + userInput + "] 단어를 삭제합니다");
				return true;

			} else if (userAns == 'n') { // 사용자가 n을 입력할 경우 -> false 리턴
				System.out.println("단어 삭제를 중단합니다.");
				return false;

			} else { // 사용자가 y나 n 이외의 값을 입력했을 경우
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
