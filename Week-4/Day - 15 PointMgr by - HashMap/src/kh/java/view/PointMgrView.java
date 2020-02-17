package kh.java.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.vo.Vvip;

public class PointMgrView {

	Scanner sc = new Scanner(System.in);

	public int main() {

		while (true) {
			System.out.println("========== ȸ�� ���� ���α׷� v7.1 ==========");
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ������ ��� (��ü)");
			System.out.println("3. ȸ������ ��� (1��)");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. ȸ��Ż��");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� > ");

			int slt = sc.nextInt();

			return slt;
		}
	}

	public Grade insertMbr() {

		while (true) {
			System.out.println("ȸ�������� �����մϴ�.");
			System.out.print("�̸� : ");
			String name = sc.next();

			System.out.print("��� : ");
			String grade = sc.next();

			System.out.print("����Ʈ : ");
			int point = sc.nextInt();

			Grade g = switchGradeOrNull(name, grade, point);

			if (g == null) {
				System.out.println("����� �߸� �Է��ϼ̽��ϴ�.");
				continue;
			} else {
				return g;
			}
		}
	}

	public Grade switchGradeOrNull(String name, String grade, int point) {

		switch (grade) {
		case "silver":
			return new Silver(name, grade, point);

		case "gold":
			return new Gold(name, grade, point);

		case "vip":
			return new Vip(name, grade, point);

		case "vvip":
			return new Vvip(name, grade, point);

		default:
			return null;
		}
	}

	public void printAllMbr(HashMap<String, Grade> mbrs) {

		Set<String> keys = mbrs.keySet();

		System.out.println("���\t�̸�\t����Ʈ\t���ʽ� ����Ʈ");

		for (String key : keys) {
			System.out.println(mbrs.get(key));
			;
		}
	}

	public String getName(String msg) {
		System.out.print(msg + "�� �̸��� �Է��ϼ��� : ");
		String name = sc.next();

		return name;
	}

	public Grade modifyMbr() {
		System.out.print("������ �̸� : ");
		String name = sc.next();
		System.out.print("������ ��� : ");
		String grade = sc.next();
		System.out.print("������ ����Ʈ : ");
		int point = sc.nextInt();		
		
		return switchGradeOrNull(name, grade, point);
	}
}
