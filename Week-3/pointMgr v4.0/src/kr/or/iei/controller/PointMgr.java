package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Grade;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;
import kr.or.iei.point.Vvip;

public class PointMgr {

	Scanner sc = new Scanner(System.in); // Scanner ��� sc�� ����

	Grade mbrs[] = new Grade[30]; // 3�� ��ü�迭�� 1���� ��ü�迭�� ����

	int index; // 3�� ��ü�迭�� index�� 1�� ������ ����

	public void main() { // main ���� �޼ҵ�

		while (true) { // �޴��� �ݺ����� ��Ű�� ���� ���ѷ���

			System.out.println("=================== ȸ������ ���α׷� v4.0 ===================");
			System.out.printf("�� ȸ���� : %d\n", index); // �� �ε����� ���� ������ Ȯ���ϱ� ���� ��¹�
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ������ ��� (��ü)");
			System.out.println("3. ȸ������ ��� (1��)");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. ȸ��Ż��");
			System.out.print("���� > ");

			int slt = sc.nextInt(); // �޴��� ������ ������ �Է¹޾� ���� slt�� ����

			switch (slt) { // ����ڰ� �Է��� ���� slt�� ���� ���� switch ����
			case 1: // ȸ������ ������, slt�� �Է°��� 1�� ��

				System.out.println("ȸ�� ������ �����մϴ�.");
				System.out.print("��   �� : ");
				String name = sc.next().toLowerCase(); // ����ڰ� �Է��� ���ڿ��� ���� name���� ����

				if (findMbr(name) != -1) { // findMbr �޼ҵ带 ����ڰ� �Է��� name�� �Ű������� �����Ͽ� �ߺ��Ǵ� ȸ���� �ִ��� Ȯ��
					System.out.println("�ߺ��Ǵ� ȸ���� �ֽ��ϴ�.");
					break; // �ߺ��� �˸��� ��¹��� �����ϰ� �޴����� ������ ȸ��
				} // findMbr(name)�� ���� -1�̸� if���� �������� ������ ����

				System.out.print("��   �� : ");
				String grade = sc.next().toLowerCase(); // ����ڰ� �Է��� ���ڿ��� ���� grade�� ����, �ҹ��ڷ� ����

				System.out.print("����Ʈ : "); // ����ڰ� �Է��� ������ ���� point�� ����
				int point = sc.nextInt();

				insertMbr(name, grade, point); // ȸ�������� �����ϴ� �޼ҵ�. �������� �Է��� �Ű����� name, grade, point�� ����
				break; // ȸ������ �������� ������ switch ������ �������� �޴����� ������ ȸ��

			case 2: // ��ü ȸ�������� ����ϴ� ������, slt�� �Է°��� 2�϶�

				printAll(); // ��ü ȸ�������� ����ϴ� �޼ҵ�
				break; // �������� ������ switch���� �������� �޴����� ������ ȸ��

			case 3: // �̸��� �Է¹޾� ��ġ�ϴ� 1���� ȸ�������� ����ϴ� ������
				printMbr(); // ȸ�� 1���� ������ ����ϴ� �޼ҵ�
				break; // �������� ������ switch���� �������� �޴����� ������ ȸ��

			case 4: // �̸��� �Է¹޾� ��ġ�ϴ� 1���� ȸ�������� �����ϴ� ������, ��ǻ� ���� or ����+�߰�
				modMbr(); // ȸ���� ���������� �����ϴ� �޼ҵ�
				break; // �������� ������ switch���� �������� �޴����� ������ ȸ��

			case 5: // �̸��� �Է¹޾� ��ġ�ϴ� 1���� ȸ�������� �����ϰ� ��ü�迭�� ��迭�ϴ� ������
				System.out.print("Ż���� ȸ���� �̸� :"); // Ż���� ȸ���� �̸��� ���� ��¹�
				delMbr(sc.next()); // ����ڰ� �Է��� ���ڿ��� �Ű������� ȸ��Ż�� �޼ҵ带 ����
				break; // �������� ������ switch���� �������� �޴����� ������ ȸ��

			default: // ����ڰ� 1~5 �̿��� ���� �Է�������
				System.out.println("�߸� �Է��ϼ̽��ϴ�."); // �߸� �Է����� �˸��� ��¹�
				continue; // �޴����� ������ ȸ�� (�����)
			}
		} // ���� �޴� while�� ��������
	}

	public void insertMbr(String name, String grade, int point) { // ���ڿ��� ������ �Ű������� ��� ��ü�� �����Ͽ� �ش� ��ü�迭�� �߰��ϴ� �޼ҵ�

		switch (grade) { // ����ڰ� �Է��� ���ڿ� grade�� �������� �ϴ� switch ����
		case "silver": // ����ڰ� grade���� silver�� �Է����� ���
			mbrs[index++] = new Silver(name, grade, point); // slv ��ü�迭�� sIndex��°�� �� �Ű������� ���� ���ο� ��ü�� �����ϰ� sIndex���� 1
													// ����
			break; // switch ������ ������ �޴����� ������ ���ư�

		case "gold": // ����ڰ� grade���� gold�� �Է����� ���
			mbrs[index++] = new Gold(name, grade, point); // gld ��ü�迭�� gIndex��°�� �� �Ű������� ���� ���ο� ��ü�� �����ϰ� gIndex���� 1 ����
	
			break;

		case "vip": // ����ڰ� grade���� vip�� �Է����� ���
			mbrs[index++] = new Vip(name, grade, point); // vip ��ü�迭�� vIndex��°�� �� �Ű������� ���� ���ο� ��ü�� �����ϰ� vIndex���� 1����
		
			break;
			
		case "vvip":
			mbrs[index++] = new Vvip(name, grade, point); // Vvip ��ü�迭�� vIndex��°�� �� �Ű������� ���� ���ο� ��ü�� �����ϰ� vIndex���� 1����
		
			break;			

		default: // ����ڰ� grade���� silver, gold, vip �̿��� ���� �Է����� ���, ��ü�� �����ϰ� �ʰ� �޴����� ������ ����
			System.out.println("����� �߸� �Է��ϼ̽��ϴ�.");
			return;
		}
	}

	public void printAll() { // ��ü ȸ�������� ����ϴ� �޼ҵ�
		System.out.printf("�̸�\t���\t���� ����Ʈ\t���ʽ� ����Ʈ\n"); // ��ü�� �� ���� �׸��� �����ϴ� ��¹�
		for (int i = 0; i < index; i++) { // i���� 0���� �����Ͽ� sIndex������ ���������� ���๮�� �ݺ� �� i���� 1�� ����
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", mbrs[i].getName(), mbrs[i].getGrade(), mbrs[i].getPoint(),
					mbrs[i].getBonus());
		}
	}

	public void printMbr() { // ����ڰ� �Է��� ���ڿ��� ��ġ�ϴ� ȸ���� ã�� ȸ�������� ����ϴ� �޼ҵ�
		System.out.print("����� ȸ���� �̸� : ");
		String name = sc.next(); // ����ڰ� �Է��� ���� ���ڿ� ���� name���� ����

		int indexMbr = findMbr(name); // ���ڿ� ���� name�� �Ű��� findMbr �޼ҵ带 ����, ������� ������ ���� indexMbr�� ����

		if (indexMbr == -1) {
			System.out.println("ȸ���� �����ϴ�.");
			return;
		}

		System.out.printf("�̸�\t���\t���� ����Ʈ\t���ʽ� ����Ʈ\n");
		System.out.printf("%s\t%s\t%d\t\t%.2f\n", mbrs[indexMbr].getName(), mbrs[indexMbr].getGrade(),
				mbrs[indexMbr].getPoint(), mbrs[indexMbr].getBonus());

	}

	public int findMbr(String name) { // �Ű����� name�� �������� ��ġ�ϴ� ȸ���� index���� return�ϴ� �޼ҵ�

		for (int i = 0; i < index; i++) { // i���� 0���� �����Ͽ� index���� ���������� �ݺ� �� i���� 1����
			if (mbrs[i].getName().equals(name)) { // mbrs ��ü�迭�� i��° name���� �Ű����� name�� ������ ��
				return i; // return�ϴ� i���� �ش� ��ü�迭�� �Ű����� name�� ������ ȸ���� ���°�� �ִ��� �����Ѵ�
			}
		}

		// ���� for�������� return���� �ʾҴٸ� ��� ��ü�迭���� �ش� �Ű������� ������ name���� �������� �����Ƿ�
		// �Է��� name�� ������ ȸ���� ������ �ǹ�
		return -1; // ȸ���� ������ �����ϴ� return��
	}

	public void modMbr() { // ȸ���� ������ �����ϴ� �޼ҵ�
		System.out.print("������ ȸ���� �̸� : ");
		String mName = sc.next(); // ����ڰ� �Է��� ���ڿ��� ���� mName���� ����

		int indexMbr = findMbr(mName); // mName�� �Ű������� �Ͽ� findMbr�� �����ϰ� ������� indexMbr���� ����
		if (indexMbr == -1) { // �Է��� ���ڿ��� ������ ȸ���� ���� ��� ��� �޼ҵ带 ����
			System.out.println("ȸ���� �����ϴ�.");
			return;
		}

		System.out.print("�̸� : ");
		String name = sc.next(); // ����ڰ� �Է��� ���ڿ��� ���� name���� ���� -> ������ �̸�

		System.out.print("��� : ");
		String grade = sc.next().toLowerCase(); // ����ڰ� �Է��� ���ڿ��� grade�� ���� -> ������ ���

		System.out.print("����Ʈ : ");
		int point = sc.nextInt(); // ����ڰ� �Է��� ������ point�� ���� -> ������ ����Ʈ

		if (mbrs[indexMbr].getGrade().equals(grade)) { // ȸ���� ������ grade�� ���� grade�� ���� ���
			mbrs[indexMbr].setName(name); // mbrs ��ü�迭�� indexMbr��° ��ü�� name���� �Ű����� name���� ����
			mbrs[indexMbr].setPoint(point); // mbrs ��ü�迭�� indexMbr��° ��ü�� point���� �Ű����� point�� ����
		} else { // ������ grade�� ���� grade�� �ٸ� ���
			delMbr(mName);
			insertMbr(name, grade, point);
		}

	}

	// ���ڿ� name�� �Ű������� �Ͽ� ȸ�������� �����ϴ� �޼ҵ�
	// findMbr�� ���� �ش� ��ü�� ��� ��ü�迭�� ��ġ�ϴ� Ȯ���Ͽ�
	// ��ü�迭�� ��ĭ�� �մ��� ������ ��ü�� null������ ó��
	public void delMbr(String name) {

		int indexMbr = findMbr(name); // �Ű����� name���� findMbr �޼ҵ带 ������ ������� ������ ���� indexMbr�� ����

		if (indexMbr == -1) {
			System.out.println("ȸ���� �����ϴ�.");
			return;
		}

		for (int i = indexMbr; i < index - 1; i++) { // i���� 0���� �����Ͽ� sIndex���� ���������� �ݺ����� �� i���� 1 ����
			mbrs[i] = mbrs[i + 1]; // slv ��ü�迭�� i��°�� i+1��° ���� ���� -> ��ĭ�� ���ٴ� ����
		}
		mbrs[index--] = null; // slv ��ü�迭�� sIndex�� �ش��ϴ� ���� null�� �����ϰ� sIndex���� 1 ����

	}
}
