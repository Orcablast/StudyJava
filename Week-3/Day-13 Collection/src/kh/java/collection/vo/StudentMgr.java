package kh.java.collection.vo;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMgr {

	ArrayList<Student> students = new ArrayList<Student>();

	Scanner sc = new Scanner(System.in);

	public void main() {

		while (true) {
			System.out.println("\n============= 학생 관리 프로그램 =============");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 정보 전체출력");
			System.out.println("3. 학생 정보 1명출력");
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
				modifyStd();
				break;

			case 5:
				delStd();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}

		}

	}

	public void insertStd() {
		System.out.println("\n======== 학생 정보 입력 ========");
		
		System.out.print("학생 이름 : ");
		String name = sc.next();		
		
		System.out.print("학생 나이 : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		System.out.print("학생 주소 : ");
		String addr = sc.nextLine();
		
		Student std = new Student(name, age, addr);
		
		students.add(std);
		
	}
	
	
	public void printStd() {
		System.out.println("\n======== 학생 정보 출력 ========");
		
		System.out.print("출력할 학생의 이름 : ");
		String fName = sc.next();
		
		int index = searchStd(fName);
		
		System.out.println("이름\t나이\t주소");
		
		if(index != -1) {
			System.out.println(students.get(index).toString());
			
		} else {
			System.out.println("학생이 없습니다.");
		}
		
	}
	
	public int searchStd(String name) {
		

		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getName().equals(name)) {
				return i;			
			}
		}
		
		return -1;
	}
	
	public void modifyStd() {
		System.out.println("\n======== 학생 정보 수정 ========");		

		System.out.print("수정할 학생의 이름 : ");
		String mName = sc.next();
		
		int index = searchStd(mName);
		
		if (index==-1) {
			System.out.println("학생이 없습니다.");
			return;
		} else {

			System.out.print("수정할 이름 : ");
			String name = sc.next();
			
			System.out.print("수정할 나이 : ");
			int age = sc.nextInt();
			
			sc.nextLine();
			System.out.print("수정할 주소 : ");
			String addr = sc.nextLine();
			
			// 코드 한줄로 안되나??
			students.get(index).setName(name);
			students.get(index).setAge(age);
			students.get(index).setAddr(addr);
			
			System.out.println("수정이 완료되었습니다.");
			
		}
		
	}
	
	public void delStd() {
		System.out.println("\n======== 학생 정보 수정 ========");	
		System.out.print("삭제할 학생 이름 : ");
		String dName = sc.next();
		
		int index = searchStd(dName);
		
		if(index==-1) {
			System.out.println("학생이 없습니다.");
			return;
		} else {
			students.remove(index);
			System.out.println("==== "+dName+" 학생의 정보가 삭제되었습니다. ====");
		}		
	}
	
	
	public void printAll() {
		if(students.isEmpty()) {
			System.out.println("학생 정보가 없습니다.");
			return;
		} else {
			System.out.println("\n======== 학생 정보 출력 ========");	
			System.out.println("no.\t이름\t나이\t주소");
			
			
			// for each 문
			for(Student s : students) {
				int index = (students.indexOf(s)+1);
				System.out.println((index<10 ? "0":"")+index+"\t"+s);
			}
			
			
//			for(int i=0; i<students.size(); i++) {
//				System.out.println((i<10 ? "0":"")+(i+1)+"\t"+(students.get(i).toString()));			
//			}
		}
		
		
		
	}

}
