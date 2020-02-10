package kr.or.iei.controller;

import java.util.Scanner;
import kr.or.iei.point.Silver;

public class PointMgr {
	
	Scanner sc = new Scanner(System.in);
	Silver[] svs = new Silver[30];
	
	int index;

	public void main() {

		while (true) {
			System.out.println("========= Silver ����Ʈ ���� v1.0 =========");
			System.out.println("���� ȸ�� �� : "+index);
			System.out.println("1. ȸ�� ����");
			System.out.println("2. ȸ������ ��� (��ü)");
			System.out.println("3. ȸ������ ��� (1��)");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. ȸ�� Ż��");
			System.out.print("���� > ");

			int slt = sc.nextInt();

			switch (slt) {
			case 1: // ȸ������
				System.out.println("ȸ�������� �����մϴ�.");			
				
				insertMbr();
				
				break;
				
			case 2: // ȸ������ ��� (��ü)
				
				printAll();
				break;

			case 3: // ȸ������ ��� (1��)
				
				printMbr();				
				break;

			case 4: // ȸ������ ����
				modifyMbr();
				break;

			case 5: // ȸ�� Ż��
				delMbr();
				break;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;

			}

		}
	} // main method ����
	
	
	public void insertMbr() { // ȸ������ �޼ҵ�
		System.out.print("��       ��    : ");
		String name = sc.next();
		
		if(findMbr(name)!=-1) { // ȸ���� ���� �̸��� ������ ȸ�������� �ߴ�
			System.out.println("�ߺ��� ȸ���� �ֽ��ϴ�.");
			return;
		}
		
		System.out.print("��       ��    : ");
		String grade = sc.next();
		System.out.print("���� ����Ʈ : ");
		int point = sc.nextInt();
		
		
		Silver sv = new Silver(name, grade, point);
		
		svs[index] = sv; // ���ο� ��ü sv�� ��ü�迭 svs index��°�� ����
		index++;		
	}
	
	public void printAll() { // ȸ�� ���� ��ü�� ����ϴ� �޼ҵ�
		System.out.println("�̸�\t���\t���� ����Ʈ\t���ʽ� ����Ʈ");
		
		for(int i=0; i<index; i++) {
			System.out.println(svs[i].getName()+"\t"+svs[i].getGrade()+"\t"+svs[i].getPoint()+"\t\t"+svs[i].getBonusP());
		}
	}
	
	public void printMbr() { // �̸��� ���� �˻��Ͽ� �ش� ȸ�������� �˻��ϴ� �޼ҵ�
		System.out.print("����� ȸ�� �̸� : ");
		String name = sc.next();
		
		int mbrIndex = findMbr(name);
		
		if(mbrIndex==-1) {
			System.out.println("ȸ���� �����ϴ�.");
			return;
		} else {
			System.out.println("��       ��       : "+svs[mbrIndex].getName());			
			System.out.println("��       ��       : "+svs[mbrIndex].getGrade());
			System.out.println("����    ����Ʈ : "+svs[mbrIndex].getPoint());	
			System.out.println("���ʽ� ����Ʈ : "+svs[mbrIndex].getBonusP());		
		}
		
	}
	
	public int findMbr(String name) { // �˻��� ȸ���� index�� return�ϴ� �޼ҵ�
		for(int i=0; i<index; i++) {
			if(svs[i].getName().equals(name)) { 
				return i; 
			}
		}		
		return -1;
	}
	
	public void modifyMbr() { // ȸ�� �̸��� ���� ȸ�������� �����ϴ� �޼ҵ�
		System.out.print("������ ȸ�� �̸� : ");
		
		int mbrIndex = findMbr(sc.next());

		System.out.print("��       ��    : ");
		svs[mbrIndex].setName(sc.next());
		System.out.print("��       ��    : ");
		svs[mbrIndex].setGrade(sc.next());
		System.out.print("���� ����Ʈ : ");
		svs[mbrIndex].setPoint(sc.nextInt());
		
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}
	
	public void delMbr() { // ȸ�� �̸��� ���� ȸ�������� �����ϴ� �޼ҵ�
		System.out.print("Ż���� ȸ�� �̸� : ");
		
		int mbrIndex = findMbr(sc.next());
		
		if(mbrIndex == -1) {
			System.out.println("ȸ���� �����ϴ�.");
		} else {
			
			for(int i=mbrIndex; i<index-1; i++) {
				svs[i].setName(svs[i+1].getName());
				svs[i].setGrade(svs[i+1].getGrade());
				svs[i].setPoint(svs[i+1].getPoint());
			}			

			index--;			
			
			svs[index].setName(null);
			svs[index].setGrade(null);
			svs[index].setPoint(0);
			
		}		
	}
	
	
}
