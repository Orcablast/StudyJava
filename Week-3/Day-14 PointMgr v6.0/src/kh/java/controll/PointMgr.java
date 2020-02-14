package kh.java.controll;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.vo.Vvip;

public class PointMgr {

	Scanner sc = new Scanner(System.in);

	HashMap<String, Grade> mbrs = new HashMap<String, Grade>();

	public void main() {

		while (true) {
			System.out.println("========================== ȸ������ ���α׷� v6.0 ==========================");
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ������ ��� (��ü)");
			System.out.println("3. ȸ������ ��� (1��)");
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
				System.out.println("���α׷��� �����մϴ�.");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	public void insertMbr() {
		System.out.println("=========== ȸ�� ���� ===========");
		System.out.print("�̸� : ");
		String name = sc.next();

		if (mbrs.containsKey(name)) {
			System.out.println("�ߺ��� ȸ���� �ֽ��ϴ�.");
		} else {

			System.out.print("��� : ");
			String grade = sc.next().toLowerCase();
			System.out.print("����Ʈ : ");
			int point = sc.nextInt();

			switch (grade) {
			case "silver":
				mbrs.put(name, new Silver(grade, name, point));
				System.out.println(mbrs.get(name).getName() + "���� ȸ�������� �Ϸ�Ǿ����ϴ�.");
				break;

			case "gold":
				mbrs.put(name, new Gold(grade, name, point));
				System.out.println(mbrs.get(name).getName() + "���� ȸ�������� �Ϸ�Ǿ����ϴ�.");
				break;

			case "vip":
				mbrs.put(name, new Vip(grade, name, point));
				System.out.println(mbrs.get(name).getName() + "���� ȸ�������� �Ϸ�Ǿ����ϴ�.");
				break;

			case "vvip":

				mbrs.put(name, new Vvip(grade, name, point));
				System.out.println(mbrs.get(name).getName() + "���� ȸ�������� �Ϸ�Ǿ����ϴ�.");
				break;

			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}

		}
	}

	public void printMbr() {

		System.out.println("=========== ȸ�� ���� ��� ===========");
		System.out.print("�˻��� �̸� : ");
		String fName = sc.next();

		if (mbrs.containsKey(fName)) {
			System.out.println("���\t�̸�\t����Ʈ\t���ʽ� ����Ʈ");
			System.out.println(mbrs.get(fName).toString());
		} else {
			System.out.println("ȸ���� �����ϴ�.");
		}

	}

	public void printAll() {
		System.out.println("=========== ȸ�� ���� ��� ===========");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ� ����Ʈ");

		Set<String> keys = mbrs.keySet();

		for (String s : keys) {
			System.out.println(mbrs.get(s).toString());
		}

	}

	public void modMbr() {
		System.out.println("=========== ȸ�� ���� ���� ===========");
		System.out.print("������ �̸� : ");
		String mName = sc.next();

		if (mbrs.containsKey(mName)) {
			System.out.println(mName + "���� ���� ������ �����մϴ�.");
			System.out.print("������ �̸� : ");
			String name = sc.next();

			System.out.print("������ ��� : ");
			String grade = sc.next().toLowerCase();

			System.out.print("������ ����Ʈ : ");
			int point = sc.nextInt();

			mbrs.remove(mName);

			switch (grade) {
			case "silver":
				mbrs.put(name, new Silver(grade, name, point));
				break;

			case "gold":
				mbrs.put(name, new Gold(grade, name, point));
				break;

			case "vip":
				mbrs.put(name, new Vip(grade, name, point));
				break;

			case "vvip":

				mbrs.put(name, new Vvip(grade, name, point));
				break;

			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}

		} else {
			System.out.println("ȸ���� �����ϴ�.");
		}

	}
	
	public void delMbr() {
		System.out.println("=========== ȸ�� ���� ���� ===========");
		System.out.print("������ �̸� : ");
		String dName = sc.next();
		
		if(mbrs.containsKey(dName)) {
			mbrs.remove(dName);
			System.out.println(dName+"���� ȸ�������� �����Ǿ����ϴ�.");
		} else {
			System.out.println("ȸ���� �����ϴ�.");
		}
		
		
	}
}
