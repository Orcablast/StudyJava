package kh.java.controller;

import java.util.HashMap;
import java.util.Set;

import kh.java.view.PointMgrView;
import kh.java.vo.Grade;

public class PointMgr {

	PointMgrView view = new PointMgrView();

	HashMap<String, Grade> mbrs = new HashMap<String, Grade>();

	public void main() {

		while (true) {

			int slt = view.main();

			switch (slt) {
			case 1:
				insertMbr();
				break;

			case 2:
				view.printAllMbr(mbrs);
				break;

			case 3:
				printMbr();
				break;

			case 4:
				modifyMbr();
				break;

			case 5:
				deleteMbr();
				break;

			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	public void insertMbr() {
		Grade g = view.insertMbr();

		if (mbrs.containsKey(g.getName())) {
			System.out.println("�ߺ��Ǵ� ȸ���� �ֽ��ϴ�.");
			return;
		} else {
			mbrs.put(g.getName(), g);
		}
	}

	public void printMbr() {
		String name = view.getName("�˻�");

		if (mbrs.containsKey(name)) {
			System.out.println(mbrs.get(name).getName() + "���� ȸ�������� ����մϴ�.");
			System.out.println("ȸ�� ��� : " + mbrs.get(name).getGrade());
			System.out.println("���� ����Ʈ : " + mbrs.get(name).getPoint());
			System.out.println("���ʽ� ����Ʈ : " + mbrs.get(name).getBonus());

		} else {

			System.out.println("ȸ���� �����ϴ�.");
		}
	}

	public void modifyMbr() {
		String name = view.getName("����");
		
		if(mbrs.containsKey(name)) {
			
			Grade g = view.modifyMbr();
			
			if(g==null) {
				System.out.println("�߸��� ȸ�� ����Դϴ�.");
				
			} else if (mbrs.containsKey(g.getName())) {
				System.out.println("�ߺ��Ǵ� ȸ���� �ֽ��ϴ�.");
				
			} else {
				mbrs.remove(name);
				mbrs.put(g.getName(), g);
			}	
			
		} else {
			System.out.println("ȸ�� ������ �����ϴ�.");			
		}		
	}
	
	public void deleteMbr() {
		String name = view.getName("����");
		
		mbrs.remove(name);		
	}

}
