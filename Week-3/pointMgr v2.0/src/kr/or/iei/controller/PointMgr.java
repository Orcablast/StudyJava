package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;

public class PointMgr {

	Scanner sc = new Scanner(System.in);

	Silver[] slv = new Silver[10];
	Gold[] gld = new Gold[10];
	Vip[] vip = new Vip[10];

	int sIndex; // Silver ��� �ε���
	int gIndex; // Gold ��� �ε���
	int vIndex; // Vip ��� �ε���

	public void main() {

		while (true) {
			System.out.println("========= ����Ʈ ���� v2.0 =========");
			System.out.printf("Vip : %d \tGold : %d\tSilver : %d\n", vIndex, gIndex, sIndex);
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

				System.out.print("��       ��    : ");
				String name = sc.next();

				if (findMbr(name) != -1) { // ȸ���� ���� �̸��� ������ ȸ�������� �ߴ�
					System.out.println("�ߺ��� ȸ���� �ֽ��ϴ�.");
					continue;
				}

				System.out.print("��       ��    : ");
				String grade = sc.next().toLowerCase(); // ��ҹ��� �Է� �Ǽ��� ���� ����

				System.out.print("���� ����Ʈ : ");
				int point = sc.nextInt();

				insertMbr(name, grade, point);

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
				System.out.print("Ż���� ȸ�� �̸� : ");
				delMbr(findMbr(sc.next()));
				break;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;

			}

		}
	} // main method ����

	public void insertMbr(String name, String grade, int point) { // ȸ������ �޼ҵ�

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
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}

	}

	public void printAll() { // ȸ�� ���� ��ü�� ����ϴ� �޼ҵ�
		System.out.println("�̸�\t���\t���� ����Ʈ\t���ʽ� ����Ʈ");

		for (int i = 0; i < vIndex; i++) {
			System.out.println(vip[i].getName() + "\t" + vip[i].getGrade() + "\t" + vip[i].getPoint() + "\t\t"
					+ vip[i].getBonusP());
		}

		for (int i = 0; i < gIndex; i++) {
			System.out.println(gld[i].getName() + "\t" + gld[i].getGrade() + "\t" + gld[i].getPoint() + "\t\t"
					+ gld[i].getBonusP());
		}

		for (int i = 0; i < sIndex; i++) {
			System.out.println(slv[i].getName() + "\t" + slv[i].getGrade() + "\t" + slv[i].getPoint() + "\t\t"
					+ slv[i].getBonusP());
		}
	}

	public void printMbr() { // �̸��� ���� �˻��Ͽ� �ش� ȸ�������� �˻��ϴ� �޼ҵ�
		System.out.print("����� ȸ�� �̸� : ");
		String name = sc.next();

		int mbrIndex = findMbr(name);

		if (mbrIndex == -1) {
			System.out.println("ȸ���� �����ϴ�.");
			return;

		} else if (mbrIndex - slv.length - gld.length >= 0) {
			mbrIndex -= (slv.length - gld.length);
			System.out.println("��       ��       : " + vip[mbrIndex].getName());
			System.out.println("��       ��       : " + vip[mbrIndex].getGrade());
			System.out.println("����    ����Ʈ : " + vip[mbrIndex].getPoint());
			System.out.println("���ʽ� ����Ʈ : " + vip[mbrIndex].getBonusP());

		} else if (mbrIndex - slv.length >= 0) {
			mbrIndex -= slv.length;
			System.out.println("��       ��       : " + gld[mbrIndex].getName());
			System.out.println("��       ��       : " + gld[mbrIndex].getGrade());
			System.out.println("����    ����Ʈ : " + gld[mbrIndex].getPoint());
			System.out.println("���ʽ� ����Ʈ : " + gld[mbrIndex].getBonusP());

		} else {
			System.out.println("��       ��       : " + slv[mbrIndex].getName());
			System.out.println("��       ��       : " + slv[mbrIndex].getGrade());
			System.out.println("����    ����Ʈ : " + slv[mbrIndex].getPoint());
			System.out.println("���ʽ� ����Ʈ : " + slv[mbrIndex].getBonusP());

		}
	}

	public int findMbr(String name) { // �˻��� ȸ���� index�� return�ϴ� �޼ҵ�

		for (int i = 0; i < sIndex; i++) {
			if (slv[i].getName().equals(name)) {
				return i;
			}
		}

		for (int i = 0; i < gIndex; i++) {
			if (gld[i].getName().equals(name)) {
				return i + slv.length;
			}
		}

		for (int i = 0; i < vIndex; i++) {
			if (vip[i].getName().equals(name)) {
				return i + slv.length + gld.length;
			}
		}

		return -1;
	}

	public void modifyMbr() { // ȸ�� �̸��� ���� ȸ�������� �����ϴ� �޼ҵ�
		System.out.print("������ ȸ�� �̸� : ");

		int mbrIndex = findMbr(sc.next());

		if (mbrIndex == -1) {
			System.out.println("ȸ���� �����ϴ�.");
			return;
		}

		System.out.print("��       ��    : ");
		String name = sc.next();
		System.out.print("��       ��    : ");
		String grade = sc.next().toLowerCase();
		System.out.print("���� ����Ʈ : ");
		int point = sc.nextInt();

		if (mbrIndex - slv.length - gld.length >= 0) { // vip

			if (grade == "vip") {
				mbrIndex -= (slv.length + gld.length);
				vip[mbrIndex].setName(name);
				vip[mbrIndex].setPoint(point);
			} else {
				delMbr(mbrIndex);
				mbrIndex -= (slv.length - gld.length);
				insertMbr(name, grade, point);
			}

		} else if (mbrIndex - slv.length >= 0) {// gold

			if (grade == "gold") {
				mbrIndex -= slv.length;
				gld[mbrIndex].setName(name);
				gld[mbrIndex].setPoint(point);
			} else {
				delMbr(mbrIndex);
				mbrIndex -= slv.length;
				insertMbr(name, grade, point);
			}

		} else { // silver

			if (grade == "silver") {
				gld[mbrIndex].setName(name);
				gld[mbrIndex].setPoint(point);
			} else {
				delMbr(mbrIndex);
				insertMbr(name, grade, point);
			}

		}

		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}

	public void delMbr(int num) { // ȸ�� �̸��� ���� ȸ�������� �����ϴ� �޼ҵ�

		int mbrIndex = num;

		if (mbrIndex == -1) {
			System.out.println("ȸ���� �����ϴ�.");
			return;

		} else if (mbrIndex - slv.length - gld.length >= 0) {
			mbrIndex -= (slv.length - gld.length);

			for (int i = mbrIndex; i < vIndex - 1; i++) {
				vip[i] = vip[i + 1];
			}

			vip[--vIndex] = null;
			;

		} else if (mbrIndex - slv.length >= 0) {
			mbrIndex -= slv.length;

			for (int i = mbrIndex; i < gIndex - 1; i++) {
				gld[i] = gld[i + 1];
			}

			gld[--gIndex] = null;

		} else {

			for (int i = mbrIndex; i < sIndex - 1; i++) {
				slv[i] = slv[i + 1];
			}

			slv[--sIndex] = null;
		}

		//
		// if (mbrIndex == -1) {
		// System.out.println("ȸ���� �����ϴ�.");
		// } else {
		//
		// for (int i = mbrIndex; i < sIndex - 1; i++) {
		// slv[i].setName(slv[i + 1].getName());
		// slv[i].setGrade(slv[i + 1].getGrade());
		// slv[i].setPoint(slv[i + 1].getPoint());
		// }
		//
		// sIndex--;
		//
		// slv[sIndex].setName(null);
		// slv[sIndex].setGrade(null);
		// slv[sIndex].setPoint(0);
		//
		// }
	}

}
