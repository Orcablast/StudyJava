package kh.java.controller;

import java.util.Scanner;

import kh.java.vo.Books;
import kh.java.vo.Economics;
import kh.java.vo.EduBook;
import kh.java.vo.NAndE;

public class Controll {
	Scanner sc = new Scanner(System.in);

	// Books[] to = new Books[90];
	// int tIndex;

	NAndE[] ne = new NAndE[30];
	int nIndex;

	Economics[] eco = new Economics[30];
	int cIndex;

	EduBook[] edu = new EduBook[30];
	int dIndex;

	Books[] cart = new Books[30];
	int ctIndex;

	int point; // ȸ���� point�� ����� ����

	public Controll() {
		ne[nIndex++] = new NAndE("���̾� ��ȭ���� ����\t\t", "�����ó� ���̰�", "���빮��", 13320, 8);
		ne[nIndex++] = new NAndE("82��� ������\t\t", "������\t", "����Ҽ�", 11000, 5);
		ne[nIndex++] = new NAndE("���� ���� ���� �ߴ�\t\t", "�����\t", "������", 14850, 6);
		ne[nIndex++] = new NAndE("���� ���� �ʸ� ����\t\t", "������\t", "��", 9000, 9);

		eco[cIndex++] = new Economics("���ǰ���\t\t\t", "�� �ٸ���\t", "����", 16200, 7);
		eco[cIndex++] = new Economics("1�޷��� ������� ����\t\t", "�ٸ��Ͻ� ���̺��", "����", 14850, 2);
		eco[cIndex++] = new Economics("�̴ϸ� ������\t\t", "������\t", "����", 13500, 4);

		edu[dIndex++] = new EduBook("2020 �ó��� ����ó����� �ʱ�\t", "���\t", "���輭", 27900, 1);
		edu[dIndex++] = new EduBook("EBS ����Ư�� ����+��뼳�� ��Ʈ\t", "�ѱ�������۰���", "�ڽ���", 19530, 3);
		edu[dIndex++] = new EduBook("The Python\t\t", "������\t", "BOOKK", 22000, 1);

	}

	public void main() {
		while (true) {
			System.out.println("======== ���� 24 ========");
			System.out.println("1. ����");
			System.out.println("2. �մ�");
			System.out.print("���� > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				staff();
				break;

			case 2:
				customer();
				break;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	public void staff() {

		while (true) {
			System.out.println("===== ���� �޴� =====");
			System.out.println("1. ���� ���");
			System.out.println("2. ���� ��Ȳ");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� ����");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1: // ���� ���
				insertBook();
				break;

			case 2: // ���� ��Ȳ
				printBook();
				break;

			case 3: // ���� ����
				modBook();
				break;

			case 4: // ���� ����
				deleteBook();
				break;

			case 0: // �ڷΰ���
				System.out.println("�������� �̵��մϴ�");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

		}

	}

	public void customer() {

		while (true) {

			System.out.println("===== �մ� �޴� =====");
			System.out.println("1. �����ϱ�");
			System.out.println("2. ��ٱ���");
			System.out.println("3. ����Ʈ ����");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� > ");
			int slt = sc.nextInt();

			switch (slt) {
			case 1: // �����ϱ�
				shoppingBook();
				break;

			case 2: // ��ٱ���
				showCart();
				break;

			case 3: // ����Ʈ ����
				showPoint();
				break;

			case 0: // �ڷΰ���
				System.out.println("�������� �̵��մϴ�");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			}
		}
	}

	public void insertBook() {

		while (true) {

			System.out.println("======== ���� ��� ī�װ� ========");
			System.out.println("1. �Ҽ� or ������");
			System.out.println("2. ����");
			System.out.println("3. �н���");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� > ");
			int slt = sc.nextInt();

			if (slt == 0) {
				return;

			} else {
				System.out.println("����� ������ ������ �Է����ּ���.");

				sc.nextLine();
				System.out.print("���� �̸� : ");
				String name = sc.nextLine();

				System.out.print("���ڸ� : ");
				String writer = sc.nextLine();

				System.out.print("�帣 : ");
				String genre = sc.next();

				System.out.print("���� : ");
				int price = sc.nextInt();

				System.out.print("���� : ");
				int stock = sc.nextInt();

				switch (slt) {
				case 1: // �Ҽ� or ������ ne �迭
					ne[nIndex++] = new NAndE(name, writer, genre, price, stock);
					return;

				case 2: // ���� eco �迭
					eco[cIndex++] = new Economics(name, writer, genre, price, stock);
					return;

				case 3: // �н��� edu �迭
					edu[dIndex++] = new EduBook(name, writer, genre, price, stock);
					return;

				default:
					System.out.println("���� �޴��� �̵��մϴ�");
					return;
				}
			}
		}
	}

	public void modBook() {

		while (true) {

			System.out.println("======== ���� ���� ī�װ� ========");
			System.out.println("1. �Ҽ� or ������");
			System.out.println("2. ����");
			System.out.println("3. �н���");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� >");
			int num1 = sc.nextInt();

			int num2;

			int index = 0;

			switch (num1) {
			case 1:
				printNE();
				System.out.print("������ ������ no.�� �Է��ϼ��� : ");
				num2 = sc.nextInt() - 1;
				modDetail(ne, num2);
				break;

			case 2:
				printEco();
				System.out.print("������ ������ no.�� �Է��ϼ��� : ");
				num2 = sc.nextInt() - 1;
				modDetail(eco, num2);
				break;

			case 3:
				printEdu();
				System.out.print("������ ������ no.�� �Է��ϼ��� : ");
				num2 = sc.nextInt() - 1;
				modDetail(edu, num2);
				break;

			case 0:
				System.out.println("���� �޴��� �̵��մϴ�.");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

		}
	}

	public void modDetail(Books[] book, int index) {

		while (true) {
			System.out.println("[" + book[index].getName() + "]�� �����ϼ̽��ϴ�.");
			System.out.println("������ �����Ͻðڽ��ϱ� ?");
			System.out.println("1. ���� �̸�");
			System.out.println("2. ���� ����");
			System.out.println("3. ���� �帣");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� ����");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� > ");

			int slt = sc.nextInt();

			switch (slt) {
			case 1:
				sc.nextLine();
				System.out.println("���� ������: " + book[index].getName());
				System.out.print("������ �������� �Է��ϼ��� : ");
				book[index].setName(sc.nextLine());
				break;

			case 2:
				System.out.println("���� ����: " + book[index].getWriter());
				System.out.print("������ ���ڸ��� �Է��ϼ��� : ");
				book[index].setWriter(sc.next());
				break;

			case 3:
				sc.nextLine();
				System.out.println("���� �帣: " + book[index].getGenre());
				System.out.print("������ �帣�� �Է��ϼ��� : ");
				book[index].setGenre(sc.nextLine());
				break;

			case 4:
				System.out.println("���� ���� : " + book[index].getPrice());
				System.out.print("������ ������ �Է��ϼ��� : ");
				book[index].setPrice(sc.nextInt());
				break;

			case 5:
				System.out.println("���� ���� : " + book[index].getStock());
				System.out.print("������ ������ �Է��ϼ��� : ");
				book[index].setStock(sc.nextInt());
				break;

			case 0:
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;
			}

			System.out.println("������ �Ϸ�Ǿ����ϴ�.");

		}

	}

	public void deleteBook() {
		while (true) {
			System.out.println("===== ���� ���� =====");
			System.out.println("1. �Ҽ�/������");
			System.out.println("2. ����");
			System.out.println("3. �н���");
			System.out.println("0. �ڷΰ���");
			System.out.print("������ ������ ī�װ��� �����ϼ��� : ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				printNE();
				nIndex = deleteBook(ne, nIndex);
				break;

			case 2:
				printEco();
				cIndex = deleteBook(eco, cIndex);
				break;

			case 3:
				printEdu();
				dIndex = deleteBook(edu, dIndex);
				break;

			case 0:
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

		}
	}

	public int deleteBook(Books[] product, int index) {
		System.out.print("������ ��ǰ�� No�� �Է��ϼ��� : ");
		int selIndex = sc.nextInt() - 1;
		System.out.println("[" + ne[selIndex].getName() + "]�� �����ϼ̽��ϴ�.");
		System.out.print("[" + ne[selIndex].getName() + "]�� �����Ͻðڽ��ϱ�? [y/n]");
		char ch = sc.next().charAt(0);
		if (ch == 'y') {
			for (int i = selIndex; i < index - 1; i++) {
				product[i] = product[i + 1];
				product[index--] = null;
			}
		} else {
			System.out.println("���� ���");
		}
		return index;
	}

	public void printNE() {
		System.out.println("===== �Ҽ�/������ =====");
		System.out.println("no.\t������\t\t\t\t����\t\t����\t����\t�帣");
		for (int i = 0; i < nIndex; i++) {
			System.out.println((i + 1) + "\t" + ne[i].getName() + "\t" + ne[i].getWriter() + "\t" + ne[i].getPrice()
					+ "\t" + ne[i].getStock() + "\t" + ne[i].getGenre());

		}
	}

	public void printEco() {
		System.out.println("===== ���� =====");
		System.out.println("no.\t������\t\t\t\t����\t\t����\t����");
		for (int i = 0; i < cIndex; i++) {
			System.out.println((i + 1) + "\t" + eco[i].getName() + "\t" + eco[i].getWriter() + "\t" + eco[i].getPrice()
					+ "\t" + eco[i].getStock() + "\t");
		}
	}

	public void printEdu() {
		System.out.println("===== �н��� =====");
		System.out.println("no.\t������\t\t\t\t����\t\t����\t����");
		for (int i = 0; i < dIndex; i++) {
			System.out.println((i + 1) + "\t" + edu[i].getName() + "\t" + edu[i].getWriter() + "\t" + edu[i].getPrice()
					+ "\t" + edu[i].getStock() + "\t");
		}

	}

	public void showCart() {

		while (true) {

			int totalPrice = 0;
			System.out.println("===== ���� ��ٱ��� =====");
			System.out.println("no.\t������\t\t\t\t����\t\t\t����\t����\t�帣");

			for (int i = 0; i < ctIndex; i++) {
				System.out.println((i + 1) + "\t" + cart[i].getName() + "\t" + cart[i].getWriter() + "\t"
						+ cart[i].getGenre() + "\t" + cart[i].getPrice() + "\t" + cart[i].getStock());
				totalPrice += cart[i].getPrice();
			}

			System.out.println("�հ� �ݾ� : " + totalPrice + "��");

			System.out.print("�̴�� ���� �Ͻðڽ��ϱ�? [y/n] : ");
			char ans = sc.next().charAt(0);

			switch (ans) {
			case 'y':
				System.out.println(totalPrice + "���� �����ϼ̽��ϴ�.");
				System.out.println("���� ����Ʈ : " + (totalPrice * 0.05));
				point += totalPrice * 0.05;

				for (int i = 0; i < ctIndex; i++) {
					cart[i] = null;
				}

				ctIndex = 0;

				return;

			case 'n':
				System.out.println("��ٱ��ϸ� ���ðڽ��ϱ�? [y/n]");
				char ans2 = sc.next().charAt(0);

				if (ans2 == 'y') {

					clearCart();
					System.out.println("��ٱ��ϸ� ������ϴ�.");

					for (int i = 0; i < ctIndex; i++) {
						cart[i] = null;
					}

					ctIndex = 0;
					return;
				} else {
					System.out.println("���� �޴��� ���ư��ϴ�.");
					return;
				}

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;
			}
		}
	}

	public void clearCart() {

		for (int i = ctIndex - 1; i >= 0; i--) {
			String name = cart[i].getName();

			for (int j = 0; j < nIndex; j++) {
				int crnt = ne[j].getStock();
				if (ne[j].getName().equals(name)) {
					ne[j].setStock(crnt + 1);
				}
			}

			for (int j = 0; j < cIndex; j++) {
				int crnt = eco[j].getStock();
				if (eco[j].getName().equals(name)) {
					eco[j].setStock(crnt + 1);
				}
			}

			for (int j = 0; j < dIndex; j++) {
				int crnt = edu[j].getStock();
				if (edu[j].getName().equals(name)) {
					edu[j].setStock(crnt + 1);
				}
			}
		}
	}

	private void shoppingBook() {

		int index;

		while (true) {
			System.out.println("=======�����ϱ� =======");
			System.out.println("� ������ å�� ã���ʴϱ�?");
			System.out.println("1. �Ҽ�/������");
			System.out.println("2. ����");
			System.out.println("3. �н���");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� > ");
			int sel = sc.nextInt();

			switch (sel) {
			case 1:
				printNE();
				System.out.println("���� �Ͻ� å�� no.�� �Է��ϼ��� : ");
				index = sc.nextInt();
				if (index <= 0 || index > nIndex) {
					System.out.println("�ش��ϴ� å�� �����ϴ�.");
					continue;
				}
				if (ne[index - 1].getStock() == 0) {
					System.out.println("���� ��� �����ϴ�.");
				} else {
					int temp = ne[index - 1].getStock();
					cart[ctIndex++] = new Books(ne[index - 1].getName(), ne[index - 1].getWriter(),
							ne[index - 1].getGenre(), ne[index - 1].getPrice(), 1);

					ne[index - 1].setStock(temp - 1);
					cart[ctIndex - 1].setStock(1);

					System.out.println("��ٱ��Ͽ� å 1���� ��ҽ��ϴ�.");
				}
				return;

			case 2:
				printEco();
				System.out.println("���� �Ͻ� å�� no.�� �Է��ϼ��� : ");
				index = sc.nextInt();
				if (index <= 0 || index > cIndex) {
					System.out.println("�ش��ϴ� å�� �����ϴ�.");
					continue;
				}
				if (eco[index - 1].getStock() == 0) {
					System.out.println("���� ��� �����ϴ�.");
				} else {
					int temp = eco[index - 1].getStock();

					cart[ctIndex++] = new Books(eco[index - 1].getName(), eco[index - 1].getWriter(),
							eco[index - 1].getGenre(), eco[index - 1].getPrice(), 1);

					eco[index - 1].setStock(temp - 1);
					System.out.println("��ٱ��Ͽ� å 1���� ��ҽ��ϴ�.");
				}
				return;

			case 3:
				printEdu();
				System.out.println("�����Ͻ� å�� no.�� �Է��ϼ��� : ");
				index = sc.nextInt();
				if (index <= 0 || index > dIndex) {
					System.out.println("�ش��ϴ� å�� �����ϴ�.");
					continue;
				}
				if (edu[index - 1].getStock() == 0) {
					System.out.println("���� ��� �����ϴ�.");
				} else {
					int temp = edu[index - 1].getStock();
					cart[ctIndex++] = new Books(edu[index - 1].getName(), edu[index - 1].getWriter(),
							edu[index - 1].getGenre(), edu[index - 1].getPrice(), 1);
					cart[ctIndex - 1].setStock(1);
					edu[index - 1].setStock(temp - 1);
				}

				return;
			case 0:
				return;

			}
		}

	}

	public void showPoint() {

		while (true) {
			System.out.println("====== ����Ʈ ����======");
			System.out.println("����Ʈ ���� : " + point);
			return;
		}
	}

	public void printBook() {
		while (true) {
			System.out.println("===== ���� ��Ȳ =====");
			System.out.println("1. �Ҽ�/������");
			System.out.println("2. ����");
			System.out.println("3. �н���");
			System.out.println("0. �ڷΰ���");
			System.out.print("�Է� > ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				printNE();
				break;
			case 2:
				printEco();
				break;
			case 3:
				printEdu();
				break;
			case 0:
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

			}
		}
	}
}
