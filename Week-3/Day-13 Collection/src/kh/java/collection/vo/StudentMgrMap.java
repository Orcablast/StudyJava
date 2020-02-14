package kh.java.collection.vo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StudentMgrMap {

	HashMap<String, Student> stds = new HashMap<String, Student>();

	Scanner sc = new Scanner(System.in);

	public void main() {

		while (true) {
			System.out.println("\n=========== 학생 관리 프로그램 ===========");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 정보 출력 (전체)");
			System.out.println("3. 학생 정보 출력 (1명)");
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
				printAll();
				break;

			case 3:
				printStd();
				break;

			case 4:
				modStd();
				break;

			case 5:
				delStd();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:

				System.out.println("잘못된 입력입니다.");

			}

		}

	}

	public void insertStd() {
		System.out.println("학생 등록 --------------");

		String name = "";

		while (true) {
			System.out.print("학생 이름 : ");
			name = sc.next();
			if (stds.containsKey(name)) {
				System.out.println("중복된 이름입니다.");
			} else {
				break;
			}
		}

		System.out.print("학생 나이 : ");
		int age = sc.nextInt();

		sc.nextLine();
		System.out.print("학생 주소 : ");
		String addr = sc.nextLine();

		stds.put(name, new Student(name, age, addr));
	}

	public void printAll() {
		System.out.println("학생 정보 출력 ---------------");
		System.out.println("이름\t나이\t주소");

		Set<String> keys = stds.keySet();

		for (String s : keys) {
			System.out.println(stds.get(s));
		}
	}

	public void printStd() {
		System.out.println("학생 정보 출력 ---------------");
		System.out.print("검색할 학생 이름 : ");
		String fName = sc.next();

		if (stds.containsKey(fName)) {
			System.out.println("이름\t나이\t주소");
			System.out.println(stds.get(fName));
		} else {
			System.out.println("학생이 없습니다.");
		}

	}

	public void modStd() {
		System.out.println("학생 정보 수정 ---------------");
		System.out.print("검색할 학생 이름 : ");
		String mName = sc.next();

		if (stds.containsKey(mName)) {
			System.out.print("수정할 이름 : ");
			String name = sc.next();

			System.out.print("수정할 나이 : ");
			int age = sc.nextInt();

			System.out.print("수정할 주소 : ");
			String addr = sc.next();

			stds.remove(mName);
			stds.put(name, new Student(name,age,addr));
			
						
			System.out.println("수정이 완료 되었습니다.");
		} else {
			System.out.println("학생이 없습니다.");
		}
	}
	
	public void delStd() {

		System.out.println("학생 정보 삭제 ---------------");
		System.out.print("삭제할 학생 이름 : ");
		String dName = sc.next();
		
		if(stds.containsKey(dName)) {
			stds.remove(dName);
			System.out.println(dName+"학생의 정보가 삭제 되었습니다.");
		} else {
			System.out.println("학생이 없습니다.");
			return;
		}
	}
}
