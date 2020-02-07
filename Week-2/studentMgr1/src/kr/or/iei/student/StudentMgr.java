package kr.or.iei.student;

import java.util.Scanner;

public class StudentMgr {

	String names[] = new String[10]; // �̸��� ������ �迭
	int ages[] = new int[10]; // ���̸� ������ �迭
	String addrs[] = new String[10]; // �ּ� ������ �迭
	int index; // ���������� 0

	Scanner sc = new Scanner(System.in);

	public void main() {
		while (true) {
			System.out.println("======== �л� ���� ���α׷�v1.0 ========");
			System.out.println("1. �л� ���");
			System.out.println("2. �л� ���� ��ȸ(��ü)");
			System.out.println("3. �л� ���� ��ȸ(1��)");
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
				System.out.println("���α׷��� �����մϴ�.");
				return;

			default:
				System.out.println("�ٽ� �Է����ּ���");

			}

		}

	}

	public void insertStd() { // �л��� ������ �Է¹޾� �迭�� �����ϴ� �޼ҵ�
		System.out.println("\n======= �л� ���� �Է� =======");

		System.out.print("�̸� �Է� : ");
		String name = sc.next(); // �Է¹��� ���ڿ��� ���� name ������ ����

		System.out.print("���� �Է� : ");
		int age = sc.nextInt(); // �Է¹��� ������ ���� age�� ����

		sc.nextLine(); // ����ó�� ���� ���ſ�, ���� �Էµ� sc.nextLine();�� ����

		System.out.print("�ּ� �Է� : ");
		String addr = sc.nextLine(); // �Է¹��� ���ڿ��� ���� addr�� ����

		names[index] = name; // names �迭 index��°�� name �������� ����
		ages[index] = age; // ages �迭 index��°�� age �������� ����
		addrs[index] = addr; // addrs �迭 index��°�� addr �������� ����

		index++; // �л��� ���� ������ ������ index�� 1 ����

		System.out.println("�л� ���� ��� ����!");
	}

	public void printAllStd() { // �л� ��ü�� ������ ����ϴ� �޼ҵ�

		System.out.println("\n========== �л� ��ü ���� ��� ==========");
		System.out.println("�̸�\t����\t�ּ�");

		for (int i = 0; i < index; i++) { // i���� 0���� �����Ͽ� index �̸����� �ݺ�, index=0 �� �ش��������
			System.out.println(names[i] + "\t" + ages[i] + "\t" + addrs[i]);
		}
	}

	public void printOneStd() {

		System.out.println("\n========== �л� ���� ��� ========== ");

		int searchIndex = searchStd("��ȸ");
		
		if (searchIndex != -1) {
			System.out.println("�̸� : " + names[searchIndex]);
			System.out.println("���� : " + ages[searchIndex]);
			System.out.println("�ּ� : " + addrs[searchIndex]);
		}
	}

	public void modifyStd() {
		System.out.println("\n========== �л� ���� ���� ==========");
		
		int searchIndex = searchStd("����");
		
		if(searchIndex != -1) {
			
			System.out.print("�л��� �̸��� �Է� : ");			
			String name = sc.next();
			
			System.out.print("������ ���� �Է� : ");
			int age = sc.nextInt();
			
			System.out.print("������ �ּ� �Է� : ");
			sc.nextLine();
			
			String addr = sc.nextLine();
			
			names[searchIndex]= name;
			ages[searchIndex]= age;
			addrs[searchIndex]= addr;			
		}			
	}

	public int searchStd(String msg) {
		System.out.print(msg+"�� �л� �̸� �Է� : ");
		String name=sc.next();
		
		
		for(int i=0; i<index; i++) {
			if(names[i].equals(name)) {
				return i;
			}			
		}		
		
		System.out.println("�л� ������ �����ϴ�."); 
	
		return -1;		
	}

	public void deleteStd() {
		System.out.println("\n========== �л� ���� ���� ===========");
		int searchIndex = searchStd("����");
		
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

