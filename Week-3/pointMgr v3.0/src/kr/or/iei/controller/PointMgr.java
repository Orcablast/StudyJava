package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;

public class PointMgr {

	Scanner sc = new Scanner(System.in); // Scanner ��� sc�� ����

	Silver[] slv = new Silver[30]; // Silver ��ü�迭 ��� slv
	Gold[] gld = new Gold[30]; // Gold ��ü�迭 ��� gld
	Vip[] vip = new Vip[30]; // Vip ��ü�迭 ��� vip

	int sIndex, gIndex, vIndex;
	int grd; // �˻��ϴ� ȸ���� ����� �Ǻ��ϴ� ���� 1.silver 2.gold 3.vip, default:0

	public void main() {

		while (true) {
			grd = 0;

			System.out.println("=================== ȸ������ ���α׷� v3.0 ===================");
			System.out.printf("Silver : %d\tGold : %d\tVip:%d\t\n", sIndex, gIndex, vIndex);
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ������ ��� (��ü)");
			System.out.println("3. ȸ������ ��� (1��)");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. ȸ��Ż��");
			System.out.print("���� > ");

			int slt = sc.nextInt();

			switch (slt) {
			case 1:

				System.out.println("ȸ�� ������ �����մϴ�.");
				System.out.print("��   �� : ");
				String name = sc.next();

				if (findMbr(name) != -1) {
					System.out.println("�ߺ��Ǵ� ȸ���� �ֽ��ϴ�.");
					continue;
				}

				System.out.print("��   �� : ");
				String grade = sc.next().toLowerCase();

				System.out.print("����Ʈ : ");
				int point = sc.nextInt();

				insertMbr(name, grade, point);

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
				System.out.print("Ż���� ȸ���� �̸� :");
				delMbr(sc.next());
				break;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;
			}
		} // ���� �޴� while�� ��������
	}

	public void insertMbr(String name, String grade, int point) {

		switch (grade) {
		case "silver":
			slv[sIndex++] = new Silver(name, grade, point);
			break;

		case "gold":
			gld[gIndex++] = new Gold(name, grade, point);
			break;

		case "vip":
			vip[vIndex++] = new Vip(name, grade, point);
			break;

		default:
			System.out.println("����� �߸� �Է��ϼ̽��ϴ�.");
			return;
		}
	}

	public void printAll() {
		System.out.printf("�̸�\t���\t���� ����Ʈ\t���ʽ� ����Ʈ\n");
		for (int i = 0; i < sIndex; i++) {
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", slv[i].getName(), slv[i].getGrade(), slv[i].getPoint(),
					slv[i].getBonus());
		}
		for (int i = 0; i < gIndex; i++) {
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", gld[i].getName(), gld[i].getGrade(), gld[i].getPoint(),
					gld[i].getBonus());
		}
		for (int i = 0; i < vIndex; i++) {
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", vip[i].getName(), vip[i].getGrade(), vip[i].getPoint(),
					vip[i].getBonus());
		}
	}

	public void printMbr() {
		System.out.print("����� ȸ���� �̸� : ");
		String name = sc.next();

		int indexMbr = findMbr(name);

		// if (indexMbr == -1) {
		// System.out.println("ȸ���� �����ϴ�.");
		// return;
		// }

		System.out.printf("�̸�\t���\t���� ����Ʈ\t���ʽ� ����Ʈ\n");
		switch (grd) {
		case 1: // silver ����� ���
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", slv[indexMbr].getName(), slv[indexMbr].getGrade(),
					slv[indexMbr].getPoint(), slv[indexMbr].getBonus());
			break;

		case 2:
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", gld[indexMbr].getName(), gld[indexMbr].getGrade(),
					gld[indexMbr].getPoint(), gld[indexMbr].getBonus());
			break;

		case 3:
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", vip[indexMbr].getName(), vip[indexMbr].getGrade(),
					vip[indexMbr].getPoint(), vip[indexMbr].getBonus());
			break;

		default:
			System.out.println("ȸ���� �����ϴ�.");
		}

	}

	public int findMbr(String name) { // Ư�� �̸��� �Ű������� �˻�

		for (int i = 0; i < sIndex; i++) { // silver �˻�
			if (slv[i].getName().equals(name)) {
				grd = 1;
				return i;
			}
		}

		for (int i = 0; i < gIndex; i++) { // gold �˻�
			if (gld[i].getName().equals(name)) {
				grd = 2;
				return i;
			}
		}

		for (int i = 0; i < vIndex; i++) { // vip �˻�
			if (vip[i].getName().equals(name)) {
				grd = 3;
				return i;
			}
		}

		return -1;
	}

	public void modMbr() {
		System.out.print("������ ȸ���� �̸� : ");
		String mName = sc.next();
		
		int indexMbr = findMbr(mName);		
		if (indexMbr ==-1) {
			System.out.println("ȸ���� �����ϴ�.");
		}		

		System.out.print("�̸� : ");
		String name = sc.next();
		
		System.out.print("��� : ");
		String grade = sc.next().toLowerCase();
		
		System.out.print("����Ʈ : ");
		int point = sc.nextInt();
		
		
		

		switch (grd) {
		case 1:
			if(grade=="silver") {
				slv[indexMbr].setName(name);
				slv[indexMbr].setPoint(point);
			} else {
				delMbr(name);
				insertMbr(name,grade,point);
			}			
			break;

		case 2:
			if(grade=="gold") {
				gld[indexMbr].setName(name);
				gld[indexMbr].setPoint(point);
			} else {
				delMbr(name);
				insertMbr(name,grade,point);
			}
			break;

		case 3:
			if(grade=="vip") {
				vip[indexMbr].setName(name);
				vip[indexMbr].setPoint(point);
			} else {
				delMbr(name);
				insertMbr(name,grade,point);
			}
			break;

		default:
			System.out.println("ȸ���� �����ϴ�.");
		}

	}

	public void delMbr(String name) {

		int indexMbr = findMbr(name);

		switch (grd) {
		case 1:
			for (int i = 0; i < sIndex - 1; i++) {
				slv[i] = slv[i + 1];
			}
			sIndex--;
			break;

		case 2:
			for (int i = 0; i < gIndex - 1; i++) {
				gld[i] = gld[i + 1];
			}
			gIndex--;
			break;

		case 3:
			for (int i = 0; i < vIndex - 1; i++) {
				vip[i] = vip[i + 1];
			}
			vIndex--;
			break;

		default:
			System.out.println("ȸ���� �����ϴ�.");
		}
	}

}
