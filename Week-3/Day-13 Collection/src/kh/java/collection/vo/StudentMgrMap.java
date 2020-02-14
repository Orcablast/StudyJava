package kh.java.collection.vo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StudentMgrMap {

	HashMap<String, Student> stds = new HashMap<String, Student>();

	Scanner sc = new Scanner(System.in);

	public void main() {

		while (true) {
			System.out.println("\n=========== �л� ���� ���α׷� ===========");
			System.out.println("1. �л� ���");
			System.out.println("2. �л� ���� ��� (��ü)");
			System.out.println("3. �л� ���� ��� (1��)");
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
				modStd();
				break;

			case 5:
				delStd();
				break;

			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;

			default:

				System.out.println("�߸��� �Է��Դϴ�.");

			}

		}

	}

	public void insertStd() {
		System.out.println("�л� ��� --------------");

		String name = "";

		while (true) {
			System.out.print("�л� �̸� : ");
			name = sc.next();
			if (stds.containsKey(name)) {
				System.out.println("�ߺ��� �̸��Դϴ�.");
			} else {
				break;
			}
		}

		System.out.print("�л� ���� : ");
		int age = sc.nextInt();

		sc.nextLine();
		System.out.print("�л� �ּ� : ");
		String addr = sc.nextLine();

		stds.put(name, new Student(name, age, addr));
	}

	public void printAll() {
		System.out.println("�л� ���� ��� ---------------");
		System.out.println("�̸�\t����\t�ּ�");

		Set<String> keys = stds.keySet();

		for (String s : keys) {
			System.out.println(stds.get(s));
		}
	}

	public void printStd() {
		System.out.println("�л� ���� ��� ---------------");
		System.out.print("�˻��� �л� �̸� : ");
		String fName = sc.next();

		if (stds.containsKey(fName)) {
			System.out.println("�̸�\t����\t�ּ�");
			System.out.println(stds.get(fName));
		} else {
			System.out.println("�л��� �����ϴ�.");
		}

	}

	public void modStd() {
		System.out.println("�л� ���� ���� ---------------");
		System.out.print("�˻��� �л� �̸� : ");
		String mName = sc.next();

		if (stds.containsKey(mName)) {
			System.out.print("������ �̸� : ");
			String name = sc.next();

			System.out.print("������ ���� : ");
			int age = sc.nextInt();

			System.out.print("������ �ּ� : ");
			String addr = sc.next();

			stds.remove(mName);
			stds.put(name, new Student(name,age,addr));
			
						
			System.out.println("������ �Ϸ� �Ǿ����ϴ�.");
		} else {
			System.out.println("�л��� �����ϴ�.");
		}
	}
	
	public void delStd() {

		System.out.println("�л� ���� ���� ---------------");
		System.out.print("������ �л� �̸� : ");
		String dName = sc.next();
		
		if(stds.containsKey(dName)) {
			stds.remove(dName);
			System.out.println(dName+"�л��� ������ ���� �Ǿ����ϴ�.");
		} else {
			System.out.println("�л��� �����ϴ�.");
			return;
		}
	}
}
