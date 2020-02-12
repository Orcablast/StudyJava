package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.vo.Student;

public class StudentMgr {
	// �л��迭, ��ĳ��, �ε���
	Scanner sc = new Scanner(System.in);

	Student[] students = new Student[10];

	int index;

	public void main() {

		while (true) {
			System.out.println("======= �л� ���� ���α׷� v1.1 =======");
			System.out.println("1. �л� ���� �Է�");
			System.out.println("2. �л� ���� ��� (��ü)");
			System.out.println("3. �л� ���� ��� (1��)");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("0. ���α׷� ����");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				insertStudent();
				break;
				
			case 2:
				printAllStudent();
				break;
				
			case 3:
				printOneStudent();
				break;
				
			case 4:
				modifyStudent();
				break;
				
			case 5:
				deleteStudent();
				break;
				
			case 0:
				return;
				
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}

	}
	
	public void insertStudent() {
		System.out.println("\n========= �л� ���� �Է� =========");
		System.out.print("�л� �̸� �Է� : ");
		String name = sc.next();
		System.out.print("�л� ���� �Է� : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("�л� �ּ� �Է� : ");
		String addr = sc.nextLine();
		Student stu = new Student(name, age, addr);
		
		/*
		Student stu = new Student();
		�⺻ �����ڸ� ���ؼ� ��ü ���� �� setter�� �̿��� �� ����
		stu.setName(name);
		stu.setAge(age);
		stu.setAddr(addr);
		*/		
		
		students[index] = stu;
		
		index++;
		
	}
	
	public void printAllStudent() {
		System.out.println("\n========= �л� ��ü ���� ��� =========");
		System.out.println("�̸�\t����\t�ּ�");
		
		for(int i=0; i<index; i++) {
			System.out.println(students[i]);
		}
	}
	
	public int searchStd(String name) {
		
		for(int i=0; i<index; i++) {
			if(students[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void printOneStudent() {
		System.out.println("\n========= �л� ���� ���� ��� =========");
		System.out.print("����� �л� �̸� : ");
		int stdNum = searchStd(sc.next());
		
		if(stdNum==-1) {
			System.out.println("�л��� �������� �ʽ��ϴ�.");
			
		} else {
			
			System.out.println("�̸� : "+students[stdNum].getName());
			System.out.println("���� : "+students[stdNum].getAge());
			System.out.println("�ּ� : "+students[stdNum].getAddr());		
			
		}
	}
	
	public void modifyStudent() {
		System.out.println("\n========= �л� ���� ���� ���� =========");
		System.out.print("������ �л� �̸� : ");
		int stdNum = searchStd(sc.next());
		
		if(stdNum==-1) {
			System.out.println("�л��� �������� �ʽ��ϴ�.");
			
		} else {
			
			System.out.print("���� �̸� �Է� : ");
			String mName=sc.next();
			
			System.out.println("���� ���� �Է� : ");
			int mAge = sc.nextInt();
			
			sc.nextLine();
			System.out.println("���� �ּ� �Է� : ");
			String mAddr = sc.nextLine();
			
			students[stdNum].setName(mName);
			students[stdNum].setAge(mAge);
			students[stdNum].setAddr(mAddr);
			
		}		
	}
	
	public void deleteStudent() {
		System.out.println("\n========= �л� ���� ���� =========");
		System.out.print("������ �л� �̸� : ");
		int stdNum = searchStd(sc.next());
		
		if(stdNum==-1) {
			
			System.out.println("�л��� �������� �ʽ��ϴ�.");
			
		} else {
			
			for(int i=stdNum; i<index-1; i++) {
				students[i] = students[i+1];				
			}
			
			students[index-1]=null;
			
			index--;
			
		}		
	}
}
