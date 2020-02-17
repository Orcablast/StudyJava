package kh.java.controller;

import java.util.ArrayList;

import kh.java.view.PointMgrView;
import kh.java.vo.Grade;

public class PointMgrControll {

	PointMgrView view = new PointMgrView();

	ArrayList<Grade> mbrs = new ArrayList<Grade>();

	public void main() {
		
		while(true) {
			int select = view.main();
			
			switch (select) {
			case 1: // ȸ������
				
				insertMbr(view.insertMbr());
				break;

			case 2: // ȸ������ ��� (��ü)
				view.printAllMbr(mbrs);
				break;

			case 3: // ȸ������ ��� (1��)
				printMbr();
				break;

			case 4: // ȸ������ ����
				modifyMbr();
				break;

			case 5:
				deleteMbr();
				break;

			case 0:
				view.printMsg("���α׷��� �����մϴ�.");
				return;

			default:
				view.printMsg("�߸��� �Է��Դϴ�.");

			}
		}		
	}

	public void insertMbr(Grade g) {
		if(searchMbr(g.getName())==-1) {
			mbrs.add(g);
		} else {
			view.printMsg("�̸��� �ߺ��Ǵ� ȸ���� �ֽ��ϴ�.");
		}		
	}

	public void printMbr() {
		String name = view.getName("����");
		int index = searchMbr(name);
		
		if(index==-1) {
			view.printMsg("ȸ���� �����ϴ�.");
			return;		
			
		} else {
			System.out.println(mbrs.get(index).getName()+"���� ȸ������");
			System.out.println("��� : "+mbrs.get(index).getGrade());
			System.out.println("����Ʈ : "+mbrs.get(index).getPoint());
			System.out.println("���ʽ� ����Ʈ : "+mbrs.get(index).getBonus());
			
		}
		
	}

	public int searchMbr(String name) {

		for (int i = 0; i < mbrs.size(); i++) {
			if (mbrs.get(i).getName().equals(name)) {
				return i;
			}
		}

		return -1;
	}
	
	public void modifyMbr() {
		String name = view.getName("����");
		int index = searchMbr(name);
		
		if(index==-1) {
			view.printMsg("ȸ���� �����ϴ�.");
			return;
		} else {
			Grade g = view.modifyMbr();
			
			mbrs.set(index, g);
		}		
		
	}
	
	public void deleteMbr() {
		String name = view.getName("����");
		int index = searchMbr(name);
		
		if(index==-1) {
			view.printMsg("ȸ���� �����ϴ�.");
			return;
		} else {
			mbrs.remove(index);
		}	
	}

}
