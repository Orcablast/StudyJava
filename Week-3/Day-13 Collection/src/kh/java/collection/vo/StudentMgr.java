package kh.java.collection.vo;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMgr {

	ArrayList<Student> students = new ArrayList<Student>();

	Scanner sc = new Scanner(System.in);

	public void main() {

		while (true) {
			System.out.println("\n============= �л� ���� ���α׷� =============");
			System.out.println("1. �л� ���");
			System.out.println("2. �л� ���� ��ü���");
			System.out.println("3. �л� ���� 1�����");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� > ");
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
				System.out.println("���α׷��� �����մϴ�.");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;
			}

		}

	}

	public void insertStd() {
		System.out.println("\n======== �л� ���� �Է� ========");
		
		System.out.print("�л� �̸� : ");
		String name = sc.next();		
		
		System.out.print("�л� ���� : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		System.out.print("�л� �ּ� : ");
		String addr = sc.nextLine();
		
		Student std = new Student(name, age, addr);
		
		students.add(std);
		
	}
	
	
	public void printStd() {
		System.out.println("\n======== �л� ���� ��� ========");
		
		System.out.print("����� �л��� �̸� : ");
		String fName = sc.next();
		
		int index = searchStd(fName);
		
		System.out.println("�̸�\t����\t�ּ�");
		
		if(index != -1) {
			System.out.println(students.get(index).toString());
			
		} else {
			System.out.println("�л��� �����ϴ�.");
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
		System.out.println("\n======== �л� ���� ���� ========");		

		System.out.print("������ �л��� �̸� : ");
		String mName = sc.next();
		
		int index = searchStd(mName);
		
		if (index==-1) {
			System.out.println("�л��� �����ϴ�.");
			return;
		} else {

			System.out.print("������ �̸� : ");
			String name = sc.next();
			
			System.out.print("������ ���� : ");
			int age = sc.nextInt();
			
			sc.nextLine();
			System.out.print("������ �ּ� : ");
			String addr = sc.nextLine();
			
			// �ڵ� ���ٷ� �ȵǳ�??
			students.get(index).setName(name);
			students.get(index).setAge(age);
			students.get(index).setAddr(addr);
			
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			
		}
		
	}
	
	public void delStd() {
		System.out.println("\n======== �л� ���� ���� ========");	
		System.out.print("������ �л� �̸� : ");
		String dName = sc.next();
		
		int index = searchStd(dName);
		
		if(index==-1) {
			System.out.println("�л��� �����ϴ�.");
			return;
		} else {
			students.remove(index);
			System.out.println("==== "+dName+" �л��� ������ �����Ǿ����ϴ�. ====");
		}		
	}
	
	
	public void printAll() {
		if(students.isEmpty()) {
			System.out.println("�л� ������ �����ϴ�.");
			return;
		} else {
			System.out.println("\n======== �л� ���� ��� ========");	
			System.out.println("no.\t�̸�\t����\t�ּ�");
			
			
			// for each ��
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
