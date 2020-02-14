package kh.java.controll;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.vo.Vvip;

public class PointMgr {

	Scanner sc = new Scanner(System.in);

	ArrayList<Grade> mbrs = new ArrayList<Grade>();

	public void main() {

		while (true) {
			System.out.println("============ ȸ������ ���α׷� v5.0 ============");
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ������ ��� (��ü)");
			System.out.println("3. ȸ������ ��� (����)");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. ȸ�� Ż��");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� > ");

			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				insertMbr();
				break;

			case 2:
				printAll();
				break;

			case 3:
				printMbr();
				break;

			case 4:
				modMbr();
				break;

			case 5:
				delMbr();
				break;

			case 0:
				return;

			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				continue;

			}
		}
	}

	public void insertMbr() {

		System.out.println("--------- ȸ�� ���� ---------");
		System.out.print("ȸ�� �̸� : ");
		String name = sc.next();

		if (searchIndex(name) != -1) {
			System.out.println("�ߺ��Ǵ� ȸ���� �ֽ��ϴ�.");
			return;
		}

		System.out.print("ȸ�� ��� : ");
		String grade = sc.next().toLowerCase();

		System.out.print("ȸ�� ����Ʈ : ");
		int point = sc.nextInt();

		switch (grade) {
		case "silver":
			mbrs.add(new Silver(grade, name, point));
			break;

		case "gold":
			mbrs.add(new Gold(grade, name, point));
			break;

		case "vip":
			mbrs.add(new Vip(grade, name, point));
			break;

		case "vvip":
			mbrs.add(new Vvip(grade, name, point));
			break;

		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			return;
		}

	}

	public int searchIndex(String name) {

		for (int i = 0; i < mbrs.size(); i++) {
			if (mbrs.get(i).getName().equals(name)) {
				return i;
			}
		}

		// �߰��� �������;��ϴ� ������ ��� for each�� ��ȿ����
		// for each�� ȿ������ ��� = �迭�� ��� ��ü�� ������ Ȯ���� ���
		// for(Grade g : mbrs) {
		// if(g.getName().equals(name)) {
		// return mbrs.indexOf(g);
		// }
		// }

		return -1;
	}

	public void printMbr() {

		System.out.println("--------- ȸ�� ���� ��� ---------");
		System.out.print("����� ȸ�� �̸� : ");
		String fName = sc.next();

		int index = searchIndex(fName);

		if (index == -1) {
			System.out.println("ȸ���� �����ϴ�.");
			return;
		} else {
			System.out.println("ȸ�����\t�̸�\t����Ʈ\t���ʽ� ����Ʈ");
			System.out.print(mbrs.get(index).toString());

		}

	}

	public void printAll() {
		System.out.println("ȸ�����\t�̸�\t����Ʈ\t���ʽ� ����Ʈ");
		for (int i = 0; i < mbrs.size(); i++) {
			System.out.print(mbrs.get(i).toString());
		}
	}

	public void delMbr() {
		System.out.println("--------- ȸ�� ���� ���� ---------");
		System.out.print("������ ȸ���� �̸��� �Է��ϼ��� : ");
		String name = sc.next();

		int index = searchIndex(name);

		if (index == -1) {
			System.out.println("ȸ���� �����ϴ�.");
			return;
		} else {
			System.out.print(name + "���� ȸ�������� �����Ͻðڽ��ϱ�? [y/n] :");
			char ans = sc.next().charAt(0);

			if (ans == 'y') {
				mbrs.remove(index);
				System.out.println(name + "���� ȸ�������� �����Ǿ����ϴ�.");
			} else {
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;
			}
		}
	}

	public void modMbr() {
		System.out.println("--------- ȸ�� ���� ���� ---------");
		System.out.print("������ ȸ���� �̸��� �Է��ϼ��� : ");

		String mName = sc.next();

		int index = searchIndex(mName);

		if (index == -1) {
			System.out.println("ȸ���� �����ϴ�.");
			return;
			
		} else {
			System.out.println("������ ������ �Է����ּ���!");
			System.out.print("���� �̸� : "+mbrs.get(index).getName()+"\t���� : ");
			String name = sc.next();
			System.out.print("���� ��� : "+mbrs.get(index).getGrade()+"\t���� : ");
			String grade = sc.next().toLowerCase();
			System.out.print("���� �̸� : "+mbrs.get(index).getPoint()+"\t���� : ");
			int point = sc.nextInt();
			
			mbrs.remove(index);

			switch (grade) {
			case "silver":				
				mbrs.add(index, new Silver(grade, name, point));
				break;

			case "gold":
				mbrs.add(index, new Gold(grade, name, point));
				break;

			case "vip":
				mbrs.add(index, new Vip(grade, name, point));
				break;

			case "vvip":
				mbrs.add(index, new Vvip(grade, name, point));
				break;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				return;
			}
			
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}
	}

}
