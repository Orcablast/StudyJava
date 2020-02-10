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

	int sIndex, gIndex, vIndex; // �� ��ü�迭�� index���� ���������� ����, default = 0
	int grd; // �˻��ϴ� ȸ���� ����� �Ǻ��ϴ� ���� 1.silver 2.gold 3.vip, default = 0

	public void main() { // main ���� �޼ҵ�

		while (true) { // �޴��� �ݺ����� ��Ű�� ���� ���ѷ���
			
			// �Ź� grd�� ���� 0���� �ʱ�ȭ, �� �޼ҵ忡�� ������ ���� �ʱ�ȭ���ֱ� ����
			// �ٸ� �޼ҵ忡 ���� ���� ������ �ʴ´ٸ� 0���� �����ǰ� switch������ ã�� ȸ���� ������ �ǹ���
			grd = 0; 

			System.out.println("=================== ȸ������ ���α׷� v3.0 ===================");
			System.out.printf("Silver : %d\tGold : %d\tVip:%d\t\n", sIndex, gIndex, vIndex); // �� �ε����� ���� ������ Ȯ���ϱ� ���� ��¹�
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ������ ��� (��ü)");
			System.out.println("3. ȸ������ ��� (1��)");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. ȸ��Ż��");
			System.out.print("���� > ");

			int slt = sc.nextInt(); // �޴��� ������ ������ �Է¹޾� ���� slt�� ����

			switch (slt) { // ����ڰ� �Է��� ���� slt��  ���� ���� switch ����
			case 1: // ȸ������ ������, slt�� �Է°��� 1�� ��

				System.out.println("ȸ�� ������ �����մϴ�.");
				System.out.print("��   �� : ");
				String name = sc.next(); // ����ڰ� �Է��� ���ڿ��� ���� name���� ����

				if (findMbr(name) != -1) { // findMbr �޼ҵ带 ����ڰ� �Է��� name�� �Ű������� �����Ͽ� �ߺ��Ǵ� ȸ���� �ִ��� Ȯ��
					System.out.println("�ߺ��Ǵ� ȸ���� �ֽ��ϴ�.");
					continue; // �ߺ��� �˸��� ��¹��� �����ϰ� �޴����� ������ ȸ��
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
			slv[sIndex++] = new Silver(name, grade, point); // slv ��ü�迭�� sIndex��°�� �� �Ű������� ���� ���ο� ��ü�� �����ϰ� sIndex���� 1 ����
			break; // switch ������ ������ �޴����� ������ ���ư�

		case "gold": // ����ڰ� grade���� gold�� �Է����� ���
			gld[gIndex++] = new Gold(name, grade, point); // gld ��ü�迭�� gIndex��°�� �� �Ű������� ���� ���ο� ��ü�� �����ϰ� gIndex���� 1 ����
			break;

		case "vip": // ����ڰ� grade���� vip�� �Է����� ���
			vip[vIndex++] = new Vip(name, grade, point); // vip ��ü�迭�� vIndex��°�� �� �Ű������� ���� ���ο� ��ü�� �����ϰ� vIndex���� 1����
			break;

		default: // ����ڰ� grade���� silver, gold, vip �̿��� ���� �Է����� ���, ��ü�� �����ϰ� �ʰ� �޴����� ������ ����
			System.out.println("����� �߸� �Է��ϼ̽��ϴ�.");
			return;
		}
	}

	public void printAll() { // ��ü ȸ�������� ����ϴ� �޼ҵ�
		System.out.printf("�̸�\t���\t���� ����Ʈ\t���ʽ� ����Ʈ\n"); // ��ü�� �� ���� �׸��� �����ϴ� ��¹�
		for (int i = 0; i < sIndex; i++) { // i���� 0���� �����Ͽ� sIndex������ ���������� ���๮�� �ݺ� �� i���� 1�� ����
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", slv[i].getName(), slv[i].getGrade(), slv[i].getPoint(),
					slv[i].getBonus());
		}
		for (int i = 0; i < gIndex; i++) { // i���� 0���� �����Ͽ� gIndex������ ���������� ���๮�� �ݺ� �� i���� 1�� ����
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", gld[i].getName(), gld[i].getGrade(), gld[i].getPoint(),
					gld[i].getBonus());
		}
		for (int i = 0; i < vIndex; i++) { // i���� 0���� �����Ͽ� vIndex������ ���������� ���๮�� �ݺ� �� i���� 1�� ����
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", vip[i].getName(), vip[i].getGrade(), vip[i].getPoint(),
					vip[i].getBonus());
		}
	}

	public void printMbr() { // ����ڰ� �Է��� ���ڿ��� ��ġ�ϴ� ȸ���� ã�� ȸ�������� ����ϴ� �޼ҵ�
		System.out.print("����� ȸ���� �̸� : "); 
		String name = sc.next(); // ����ڰ� �Է��� ���� ���ڿ� ���� name���� ����

		int indexMbr = findMbr(name); // ���ڿ� ���� name�� �Ű��� findMbr �޼ҵ带 ����, ������� ������ ���� indexMbr�� ����

		System.out.printf("�̸�\t���\t���� ����Ʈ\t���ʽ� ����Ʈ\n");
		switch (grd) { // findMbr���� ������ grd���� �������� switch�� ����
		case 1: // silver ����� ���
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", slv[indexMbr].getName(), slv[indexMbr].getGrade(),
					slv[indexMbr].getPoint(), slv[indexMbr].getBonus());
			break;

		case 2: // gold ����� ���
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", gld[indexMbr].getName(), gld[indexMbr].getGrade(),
					gld[indexMbr].getPoint(), gld[indexMbr].getBonus());
			break;

		case 3: // vip ����� ���
			System.out.printf("%s\t%s\t%d\t\t%.2f\n", vip[indexMbr].getName(), vip[indexMbr].getGrade(),
					vip[indexMbr].getPoint(), vip[indexMbr].getBonus());
			break;

		default: // findMbr���� grd���� ���� �������� ���� ��� == �Է��� �̸��� ��ġ�ϴ� ȸ���� ���� ���
			System.out.println("ȸ���� �����ϴ�.");
		}

	}

	public int findMbr(String name) { // �Ű����� name�� �������� ��ġ�ϴ� ȸ���� grd���� �����ϰ� �ش� ��ü�迭�� index���� return�ϴ� �޼ҵ�

		for (int i = 0; i < sIndex; i++) { // i���� 0���� �����Ͽ� sIndex���� ���������� �ݺ� �� i���� 1����
			if (slv[i].getName().equals(name)) { // slv ��ü�迭�� i��° name���� �Ű����� name�� ������ ��
				grd = 1; // grd���� 1�� ����, slv ��ü�迭�� �������� �ǹ�
				return i; // return�ϴ� i���� �ش� ��ü�迭�� �Ű����� name�� ������ ȸ���� ���°�� �ִ��� �����Ѵ�
			}
		}

		for (int i = 0; i < gIndex; i++) { // i���� 0���� �����Ͽ� gIndex���� ���������� �ݺ� �� i���� 1 ����
			if (gld[i].getName().equals(name)) { // gld ��ü�迭�� i��° name���� �Ű����� name�� ������ ��
				grd = 2; // grd���� 2�� ����, gld ��ü�迭�� �������� �ǹ�
				return i; // return�ϴ� i���� �ش� ��ü�迭�� �Ű����� name�� ������ ȸ���� ���°�� �ִ��� �����Ѵ�
			}
		}

		for (int i = 0; i < vIndex; i++) { // i���� 0���� �����Ͽ� vIndex���� ���������� �ݺ� �� i���� 1 ����
			if (vip[i].getName().equals(name)) { // vip ��ü�迭�� i��° name���� �Ű����� name�� ���� ��
				grd = 3; // grd���� 3���� ����, vip ��ü�迭�� �������� �ǹ�
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
		if (indexMbr ==-1) { // �Է��� ���ڿ��� ������ ȸ���� ���� ��� ��� �޼ҵ带 ���� 
			System.out.println("ȸ���� �����ϴ�.");
			return;
		}		

		System.out.print("�̸� : ");
		String name = sc.next(); // ����ڰ� �Է��� ���ڿ��� ���� name���� ���� -> ������ �̸�
		
		System.out.print("��� : ");
		String grade = sc.next().toLowerCase(); // ����ڰ� �Է��� ���ڿ��� grade�� ���� -> ������ ���
		
		System.out.print("����Ʈ : ");
		int point = sc.nextInt(); // ����ڰ� �Է��� ������ point�� ���� -> ������ ����Ʈ
		
		
		

		switch (grd) { // findMbr���� ������ grd���� �������� ������ ��ü�迭�� ������ switch��
		case 1: // findMbr�� ���� ��ġ�� ȸ���� slv ��ü�迭�� ���� ���
			if(grade=="silver") { // ȸ���� slv ��ü�迭�� ������, ����ڰ� ������ ����� silver�� ��� -> name�� point���� ����
				slv[indexMbr].setName(name); // slv ��ü�迭�� indexMbr��° ��ü�� name���� �Ű����� name���� ����
				slv[indexMbr].setPoint(point); // slv ��ü�迭�� indexMbr��° ��ü�� point���� �Ű����� point�� ����
			} else { // ȸ���� slv ��ü�迭�� ������, ����ڰ� ������ ����� silver�� �ƴ� ��� -> slv ��ü�迭���� �ش� ��ü ����, ���� �Է��� �Ű������� ȸ������ �޼ҵ� ����
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
	
	
	// ���ڿ� name�� �Ű������� �Ͽ� ȸ�������� �����ϴ� �޼ҵ�
	// findMbr�� ���� �ش� ��ü�� ��� ��ü�迭�� ��ġ�ϴ� Ȯ���Ͽ� 
	// ��ü�迭�� ��ĭ�� �մ��� ������ ��ü�� null������ ó��
	public void delMbr(String name) { 

		int indexMbr = findMbr(name); // �Ű����� name���� findMbr �޼ҵ带 ������ ������� ������ ���� indexMbr�� ����

		switch (grd) { // findMbr���� �����ϴ� grd���� �������� �ϴ� switch����
		case 1: // �Ű����� name�� ��ġ�ϴ� ��ü�� slv ��ü�迭�� �����ϴ� ���
			for (int i = 0; i < sIndex - 1; i++) { // i���� 0���� �����Ͽ� sIndex���� ���������� �ݺ����� �� i���� 1 ����
				slv[i] = slv[i + 1]; // slv ��ü�迭�� i��°�� i+1��° ���� ���� -> ��ĭ�� ���ٴ� ����
			}
			slv[--sIndex] = null; // slv ��ü�迭�� sIndex�� �ش��ϴ� ���� null�� �����ϰ� sIndex���� 1 ����
			
			break;

		case 2:
			for (int i = 0; i < gIndex - 1; i++) {
				gld[i] = gld[i + 1];
			}
			gld[--gIndex] = null;
			break;

		case 3:
			for (int i = 0; i < vIndex - 1; i++) {
				vip[i] = vip[i + 1];
			}
			vip[--vIndex] = null;
			break;

		default: // findMbr���� grd���� ������ �ʾ��� ��� -> ��ġ�ϴ� ��ü�� �������� ����
			System.out.println("ȸ���� �����ϴ�.");
		}
	}

}
