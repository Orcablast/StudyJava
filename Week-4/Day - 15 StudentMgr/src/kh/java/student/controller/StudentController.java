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
			case 1: // �л� ���
				insertStudent();
				break;

			case 2: // �л� ��� (��ü)
				view.printAllStudent(students);
				break;

			case 3: // �л� ��� (1��)
				printOneStudent();
				break;

			case 4: // �л� ���� ����
				modifyStudent();
				break;

			case 5: // �л� ���� ����
				deleteStudent();
				break;

			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			}
		}
	}

	private void modifyStudent() {
		String name = view.getName("����");
		
		int index = searchStudent(name);
		
		if(index == -1) {
			view.printMsg("�л��� �����ϴ�.");
			
		} else {
			Student s = view.modifyStudent();
			students.set(index, s);
		}
	}

	private void printOneStudent() {
		String name = view.getName("�˻�");
		
		int index = searchStudent(name);
		
		if(index == -1) {
			view.printMsg("�л��� �����ϴ�.");
			
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
		String name = view.getName("����");
		int index = searchStudent(name);
		
		if(index == -1) {
			view.printMsg("�ش��ϴ� �л��� �����ϴ�.");
		} else {
			students.remove(index);
		}		
	}
	
}
