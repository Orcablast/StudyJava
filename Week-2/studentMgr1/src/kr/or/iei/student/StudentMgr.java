package kr.or.iei.student;

import java.util.Scanner;

public class StudentMgr {

	String names[] = new String[10]; // 이름을 저장할 배열
	int ages[] = new int[10]; // 나이를 저장할 배열
	String addrs[] = new String[10]; // 주소 저장할 배열
	int index; // 전역변수는 0

	Scanner sc = new Scanner(System.in);

	public void main() {
		while (true) {
			System.out.println("======== 학생 관리 프로그램v1.0 ========");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 정보 조회(전체)");
			System.out.println("3. 학생 정보 조회(1명)");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				insertStd();
				break;

			case 2:
				printAllStd();
				break;

			case 3:
				printOneStd();
				break;

			case 4:
				modifyStd();				
				break;

			case 5:
				deleteStd();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("다시 입력해주세요");

			}

		}

	}

	public void insertStd() { // 학생의 정보를 입력받아 배열에 저장하는 메소드
		System.out.println("\n======= 학생 정보 입력 =======");

		System.out.print("이름 입력 : ");
		String name = sc.next(); // 입력받은 문자열을 변수 name 변수로 선언

		System.out.print("나이 입력 : ");
		int age = sc.nextInt(); // 입력받은 정수를 변수 age로 선언

		sc.nextLine(); // 개행처리 문자 제거용, 이후 입력될 sc.nextLine();의 버퍼

		System.out.print("주소 입력 : ");
		String addr = sc.nextLine(); // 입력받은 문자열을 변수 addr로 선언

		names[index] = name; // names 배열 index번째에 name 변수값을 저장
		ages[index] = age; // ages 배열 index번째에 age 변수값을 저장
		addrs[index] = addr; // addrs 배열 index번째에 addr 변수값을 저장

		index++; // 학생의 정보 저장이 끝나면 index를 1 증가

		System.out.println("학생 정보 등록 성공!");
	}

	public void printAllStd() { // 학생 전체의 정보를 출력하는 메소드

		System.out.println("\n========== 학생 전체 정보 출력 ==========");
		System.out.println("이름\t나이\t주소");

		for (int i = 0; i < index; i++) { // i값은 0에서 시작하여 index 미만까지 반복, index=0 은 해당되지않음
			System.out.println(names[i] + "\t" + ages[i] + "\t" + addrs[i]);
		}
	}

	public void printOneStd() {

		System.out.println("\n========== 학생 정보 출력 ========== ");

		int searchIndex = searchStd("조회");
		
		if (searchIndex != -1) {
			System.out.println("이름 : " + names[searchIndex]);
			System.out.println("나이 : " + ages[searchIndex]);
			System.out.println("주소 : " + addrs[searchIndex]);
		}
	}

	public void modifyStd() {
		System.out.println("\n========== 학생 정보 수정 ==========");
		
		int searchIndex = searchStd("수정");
		
		if(searchIndex != -1) {
			
			System.out.print("학생의 이름을 입력 : ");			
			String name = sc.next();
			
			System.out.print("수정할 나이 입력 : ");
			int age = sc.nextInt();
			
			System.out.print("수정할 주소 입력 : ");
			sc.nextLine();
			
			String addr = sc.nextLine();
			
			names[searchIndex]= name;
			ages[searchIndex]= age;
			addrs[searchIndex]= addr;			
		}			
	}

	public int searchStd(String msg) {
		System.out.print(msg+"할 학생 이름 입력 : ");
		String name=sc.next();
		
		
		for(int i=0; i<index; i++) {
			if(names[i].equals(name)) {
				return i;
			}			
		}		
		
		System.out.println("학생 정보가 없습니다."); 
	
		return -1;		
	}

	public void deleteStd() {
		System.out.println("\n========== 학생 정보 삭제 ===========");
		int searchIndex = searchStd("삭제");
		
		if(searchIndex != -1) {
			for(int i = searchIndex; i<index-1; i++) {
				
				names[i] = names[i+1];
				ages[i] = ages[i+1];
				addrs[i] = addrs[i+1];				
			}
			
			names[index-1] = null;
			ages[index-1] = 0;
			addrs[index-1] =null;
			index--;
			
			
		}		
	}	
}

