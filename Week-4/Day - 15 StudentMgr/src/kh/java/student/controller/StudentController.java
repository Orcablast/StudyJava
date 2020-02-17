package kh.java.student.controller;

import java.util.ArrayList;

import kh.java.student.model.vo.Student;
import kh.java.student.view.StudentView;

public class StudentController {

	StudentView view = new StudentView();

	ArrayList<Student> students = new ArrayList<Student>();

	public void main() {

		while (true) {
			int select = view.main();

			switch (select) {
			case 1: // 학생 등록
				insertStudent();
				break;

			case 2: // 학생 출력 (전체)
				view.printAllStudent(students);
				break;

			case 3: // 학생 출력 (1명)
				printOneStudent();
				break;

			case 4: // 학생 정보 수정
				modifyStudent();
				break;

			case 5: // 학생 정보 삭제
				deleteStudent();
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");

			}
		}
	}

	private void modifyStudent() {
		String name = view.getName("수정");
		
		int index = searchStudent(name);
		
		if(index == -1) {
			view.printMsg("학생이 없습니다.");
			
		} else {
			Student s = view.modifyStudent();
			students.set(index, s);
		}
	}

	private void printOneStudent() {
		String name = view.getName("검색");
		
		int index = searchStudent(name);
		
		if(index == -1) {
			view.printMsg("학생이 없습니다.");
			
		} else {
			
			view.printOneStudent(students.get(index));
		}
		
		
		
		
	}

	public void insertStudent() {
		Student s = view.insertStudent();
		
		students.add(s);		
	}
	
	public int searchStudent(String name) {
		
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getName().equals(name)) {
				return i;
			}			
		}		
		
		return -1;
	}
	
	public void deleteStudent() {
		String name = view.getName("삭제");
		int index = searchStudent(name);
		
		if(index == -1) {
			view.printMsg("해당하는 학생이 없습니다.");
		} else {
			students.remove(index);
		}		
	}
	
}
