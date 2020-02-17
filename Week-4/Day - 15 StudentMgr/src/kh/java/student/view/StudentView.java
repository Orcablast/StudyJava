package kh.java.student.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.student.model.vo.Student;

public class StudentView {
	Scanner sc = new Scanner(System.in);
	
	public int main() {

		while (true) {
			System.out.println("--------- �л� ���� ���α׷� ---------");
			System.out.println("1. �л� ���");
			System.out.println("2. �л����� ��� (��ü)");
			System.out.println("3. �л����� ��� (1��)");
			System.out.println("4. �л����� ����");
			System.out.println("5. �л����� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� > ");

			int select = sc.nextInt();

			return select;
		}
	}
	
	public Student insertStudent() {
		System.out.println("--------- �л� ���� �Է� ---------");
		System.out.print("�л� �̸� : ");
		String name = sc.next();
		System.out.print("�л� ���� : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("�л� �ּ� : ");
		String addr = sc.nextLine();
		
		Student s = new Student(name, age, addr);
		
		return s;
	}
	
	public void printAllStudent(ArrayList<Student> students) {
		System.out.println("--------- �л� ���� ��� ---------");
		System.out.println("�̸�\t����\t�ּ�");
		
		for(Student s : students) {
			System.out.println(s);		
		}		
	}
	
	public String getName(String msg) {
		System.out.print(msg + "�� �л��� �̸� : ");
		return sc.next();
	}
	
	public void printOneStudent(Student s) {
		System.out.println("�̸� : " + s.getName());
		System.out.println("���� : " + s.getAge());
		System.out.println("�ּ� : " + s.getAddr());
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public Student modifyStudent() {
		System.out.print("������ �̸� : ");
		String name = sc.next();
		System.out.print("������ ���� : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		System.out.print("������ �ּ� : "); 
		String addr = sc.nextLine();
		
		Student s = new Student(name, age, addr);
		
		return s;
	}
	

}
