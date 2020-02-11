package kh.java.controller;

import java.util.Scanner;

import kh.java.vo.Drink;
import kh.java.vo.InstantFood;
import kh.java.vo.Items;
import kh.java.vo.Medicine;
import kh.java.vo.Snack;

public class ConMgr {
	Scanner sc = new Scanner(System.in);

	Drink[] d = new Drink[10];
	int dIndex;

	InstantFood[] iFood = new InstantFood[10];
	int iIndex;

	Snack[] s = new Snack[10];
	int sIndex;

	Medicine[] m = new Medicine[10];
	int mIndex;

	Items[] etc = new Items[10];
	int eIndex;

	// ��ٱ���

	Items[] cart = new Items[10];
	int cIndex;

	public ConMgr() {
		d[dIndex++] = new Drink("��������Ʈ", 100, 2000, false, 550, 300);

		d[dIndex++] = new Drink("���� ��ũ", 30, 1500, false, 300, 150);

		d[dIndex++] = new Drink("ȯŸ", 60, 1300, false, 120, 65);

		d[dIndex++] = new Drink("Ŭ����", 30, 3000, true, 350, 200);

		iFood[iIndex++] = new InstantFood("ġŲ ���ö�", 3, 3500, false, "2020-02-13", 1150);

		iFood[iIndex++] = new InstantFood("���ô� ���ö�", 2, 4000, false, "2020-02-12", 980);

		iFood[iIndex++] = new InstantFood("��� ���ö�", 1, 3800, false, "2020-02-13", 1020);

		s[sIndex++] = new Snack("��īĨ", 10, 1500, false, 360, 50);

		s[sIndex++] = new Snack("Ȩ����", 5, 1000, false, 270, 60);

		s[sIndex++] = new Snack("��Ĩ", 4, 1300, false, 330, 40);

		m[mIndex++] = new Medicine("�Ժ���", 5, 5000, false, "2020-07-30");

		m[mIndex++] = new Medicine("Ÿ�̷���", 3, 6000, false, "2020-06-30");

		etc[eIndex++] = new Items("������", 20, 4500, true);

		etc[eIndex++] = new Items("����", 18, 4500, true);

		etc[eIndex++] = new Items("���", 12, 2000, false);

		etc[eIndex++] = new Items("����ũ", 3, 1000, false);

	}

	public void main() {

		while (true) {
			System.out.println("===== DS 25 =====");
			System.out.println("1. ����");
			System.out.println("2. �մ�");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				staff();
				break;

			case 2:
				client();
				break;

			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;
			}

		}
	}

	public void staff() {

		while (true) {
			System.out.println("--- ������ ���Ͻʽÿ� �޸� ---");
			System.out.println("1. �� ��ǰ ���");
			System.out.println("2. ���� ��� ��Ȳ");
			System.out.println("3. ��� ����");
			System.out.println("4. ��ǰ ����");
			System.out.println("0. �ڷ� ����");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				insertItem();
				break;

			case 2:
				printDrink();
				printSnack();
				printIFood();
				printMedi();
				printEtc();
				break;

			case 3:
				updateItem();
				break;

			case 4:
				delItem();
				break;

			case 0:
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			} // staff while ��������
		}
	}

	public void insertItem() {

		while (true) {
			System.out.println("------ ��ǰ ��� ------");
			System.out.println("1. ���� ���");
			System.out.println("2. �Ｎ ��ǰ ���");
			System.out.println("3. ���� ���");
			System.out.println("4. �Ǿ�ǰ ���");
			System.out.println("5. ��Ÿ��ǰ ���");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� > ");

			int slt = sc.nextInt();

			if (slt == 0) {
				return;
			} else if (0 < slt && slt < 6) {
				int kcal;
				int amount;
				int weight;
				String expired;
				System.out.print("����� ��ǰ�� : ");
				sc.nextLine();
				String name = sc.nextLine();

				System.out.print("����� ��ǰ�� ���� : ");
				int price = sc.nextInt();

				System.out.print("������ �Է��ϼ��� : ");
				int stock = sc.nextInt();

				System.out.println("���θ� ������ �����մϱ�? [y/n]");
				char ch = sc.next().charAt(0);

				boolean adult = (ch == 'y' ? true : false);

				switch (slt) {
				case 1:
					System.out.println("���Ḧ ����մϴ�.");
					System.out.print("����� ��ǰ�� �뷮(ml) : ");
					amount = sc.nextInt();
					System.out.print("����� ��ǰ�� Į�θ�(kcal) : ");
					kcal = sc.nextInt();

					d[dIndex++] = new Drink(name, stock, price, adult, amount, kcal);

					break;

				case 2:
					System.out.print("����� ��ǰ�� ������� (yyyy-mm-dd) : ");
					expired = sc.next();

					System.out.print("����� ��ǰ�� Į�θ�(kcal) : ");
					kcal = sc.nextInt();

					iFood[iIndex++] = new InstantFood(name, stock, price, adult, expired, kcal);
					break;

				case 3: // Snack
					System.out.print("����� ��ǰ�� Į�θ�(kcal) : ");
					kcal = sc.nextInt();

					System.out.print("����� ��ǰ�� ����(g) : ");
					weight = sc.nextInt();

					s[sIndex++] = new Snack(name, stock, price, adult, kcal, weight);

					break;

				case 4: // Medicine

					System.out.print("����� ��ǰ�� ������� (yyyy-mm-dd) : ");
					expired = sc.next();

					m[mIndex++] = new Medicine(name, stock, price, adult, expired);

					break;

				case 5: // etc

					etc[eIndex++] = new Items(name, stock, price, adult);

					break;

				}

			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

			System.out.println("��ǰ�� ���������� ����߽��ϴ�.");

		} // insertItem while�� ��������

	}

	public void printDrink() { // ���� ��Ȳ ���
		System.out.println("===== ���� =====");
		System.out.println("no.\t��ǰ��\t\t���\t����\t���ο���\tĮ�θ�\t�뷮");

		for (int i = 0; i < dIndex; i++) {
			System.out.println((i + 1) + "\t" + d[i].getName() + "\t\t" + d[i].getStock() + "\t" + d[i].getPrice()
					+ "\t" + (d[i].getAdult() ? "O" : "X") + "\t" + d[i].getKcal() + "\t" + d[i].getAmount());
		}
	}

	public void printIFood() {
		System.out.println("===== �Ｎ ��ǰ =====");
		System.out.println("no.\t��ǰ��\t\t���\t����\t���ο���\tĮ�θ�\t�������");

		for (int i = 0; i < iIndex; i++) {
			System.out.println((i + 1) + "\t" + iFood[i].getName() + "\t" + iFood[i].getStock() + "\t"
					+ iFood[i].getPrice() + "\t" + (iFood[i].getAdult() ? "O" : "X") + "\t" + iFood[i].getKcal() + "\t"
					+ iFood[i].getExpired());
		}
	}

	public void printSnack() {
		System.out.println("===== ������ =====");
		System.out.println("no.\t��ǰ��\t\t���\t����\t���ο���\tĮ�θ�\t����");

		for (int i = 0; i < sIndex; i++) {
			System.out.println((i + 1) + "\t" + s[i].getName() + "\t\t" + s[i].getStock() + "\t" + s[i].getPrice()
					+ "\t" + (s[i].getAdult() ? "O" : "X") + "\t" + s[i].getKcal() + "\t" + s[i].getWeight());
		}
	}

	public void printMedi() {
		System.out.println("===== �Ǿ�ǰ�� =====");
		System.out.println("no.\t��ǰ��\t\t���\t����\t���ο���\t�������");

		for (int i = 0; i < mIndex; i++) {
			System.out.println((i + 1) + "\t" + m[i].getName() + "\t\t" + m[i].getStock() + "\t" + m[i].getPrice()
					+ "\t" + (m[i].getAdult() ? "O" : "X") + "\t" + m[i].getExpired());
		}
	}

	public void printEtc() {
		System.out.println("===== ��Ÿ ��ǰ =====");
		System.out.println("no.\t��ǰ��\t\t���\t����\t���ο���");

		for (int i = 0; i < eIndex; i++) {
			System.out.println((i + 1) + "\t" + etc[i].getName() + "\t\t" + etc[i].getStock() + "\t" + etc[i].getPrice()
					+ "\t" + (etc[i].getAdult() ? "O" : "X"));
		}
	}

	public void updateItem() {
		while (true) {
			System.out.println("====== ��� ���� ======");
			System.out.println("1. ����");
			System.out.println("2. �Ｎ��ǰ");
			System.out.println("3. ������");
			System.out.println("4. �Ǿ�ǰ");
			System.out.println("5. ��Ÿ��ǰ");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				printDrink();
				updateItem(d);
				break;

			case 2:
				printIFood();
				updateItem(iFood);
				break;

			case 3:
				printSnack();
				updateItem(s);
				break;

			case 4:
				printMedi();
				updateItem(m);
				break;

			case 5:
				printEtc();
				updateItem(s);
				break;

			case 0:
				System.out.println("���� �޴��� �̵��մϴ�.");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			}

		}

	}

	public void updateItem(Items[] item) {
		System.out.print("��� ������ ��ǰ�� no.�� �������ּ��� > ");
		int slt = sc.nextInt() - 1;

		System.out.println("[" + item[slt].getName() + "] �����ϼ̽��ϴ�.");

		System.out.println("���� ��� : " + item[slt].getStock());
		System.out.print("���� ��� : ");
		int input = sc.nextInt();

		item[slt].setStock(input);

		System.out.println("[" + item[slt].getName() + "] �� ��� [" + item[slt].getStock() + "] ���� �����մϴ�");

	}

	public void delItem() {
		while (true) {
			System.out.println("===== ��ǰ ���� =====");
			System.out.println("1. ����");
			System.out.println("2. �Ｎ��ǰ");
			System.out.println("3. ����");
			System.out.println("4. �Ǿ�ǰ");
			System.out.println("5. ��Ÿ");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				printDrink();
				dIndex = delItem(d, dIndex);
				break;

			case 2:
				printIFood();
				iIndex = delItem(iFood, iIndex);
				break;

			case 3:
				printSnack();
				sIndex = delItem(s, sIndex);
				break;

			case 4:
				printMedi();
				mIndex = delItem(m, mIndex);
				break;

			case 5:
				printEtc();
				eIndex = delItem(etc, eIndex);
				break;

			case 0:
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			}

		}

	}

	public int delItem(Items[] item, int index) {
		System.out.print("������ ��ǰ�� no.�� �Է��ϼ��� > ");
		int slt = sc.nextInt() - 1;

		System.out.println("[" + item[slt].getName() + "] �����ϼ̽��ϴ�.");
		System.out.print("���� �����Ͻðڽ��ϱ�? [y/n] : ");
		char ch = sc.next().charAt(0);

		switch (ch) {
		case 'y':
			for (int i = slt; i < index - 1; i++) {
				item[i] = item[i + 1];
			}
			System.out.println("��ǰ�� �����߽��ϴ�.");
			return --index;

		case 'n':
			System.out.println("���� �޴��� ���ư��ϴ�.");
			break;

		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}

		return index;
	}

	public void client() {
		System.out.println("������� ȣ����");

		while (true) {
			System.out.println("1. �����ϱ�");
			System.out.println("2. ��ٱ��� ����");
			System.out.println("0. �ڷΰ���");
			System.out.println("���� > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				shopping();
				break;

			case 2:
				showCart();
				break;

			case 0:
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}


	public void shopping() {

		while (true) {
			System.out.println("====== �����ϱ� ======");
			System.out.println("1. ����");
			System.out.println("2. �Ｎ��ǰ");
			System.out.println("3. ����");
			System.out.println("4. �Ǿ�ǰ");
			System.out.println("5. ��Ÿ ��ǰ");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				printDrink();
				buy(d);
				break;

			case 2: // �Ｎ��ǰ
				printIFood();
				buy(iFood);
				break;

			case 3: // ����
				printSnack();
				buy(s);
				break;

			case 4: // �Ǿ�ǰ
				printMedi();
				buy(m);
				break;

			case 5: // ��Ÿ
				printEtc();
				buy(etc);
				break;

			case 0:
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

		}

	}

	public void buy(Items[] item) {
		System.out.print("������ ��ǰ ��ȣ �Է� : ");
		int index = sc.nextInt() - 1;

		System.out.print("������ ���� �Է� :");
		int amount = sc.nextInt();

		if (item[index].getStock() < amount) {
			System.out.println("��� �����մϴ�.");
			System.out.println("�������� ���ư��ϴ�.");
			return;
		}

		System.out.println("[" + item[index].getName() + "] ��ǰ " + amount + "���� �����ϼ̽��ϴ�.");
		System.out.print("��ٱ��Ͽ� �����ðڽ��ϱ�? [y/n] : ");
		char ans = sc.next().charAt(0);

		switch (ans) {
		case 'y':
			String name = item[index].getName();
			int price = item[index].getPrice();
			int stock = amount;
			boolean adult = item[index].getAdult();
			
			cart[cIndex++] = new Items(name, stock, price, adult);
			
			item[index].setStock(item[index].getStock()-amount);
			
			break;

		case 'n':
			System.out.println("���Ÿ� ����ϰڽ��ϴ�.");
			return;

		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");

		}

	}

	private void showCart() {
		
		int totalPrice = 0;
		
		System.out.println("======= ���� ��ٱ��� ========");
		System.out.println("��ǰ��\t����\t����");
		for(int i=0; i<cIndex; i++) {
			System.out.println(cart[i].getName()+"\t"+cart[i].getPrice()+"\t"+cart[i].getStock());
			totalPrice += cart[i].getStock()*cart[i].getPrice();
		}
		System.out.println("�� ���Ű��� : " + totalPrice+"�� �Դϴ�");
	}

	
}
