package kh.java.controll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import kh.java.view.View;
import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.vo.Vvip;

public class Controll {

	View view = new View();

	ArrayList<Grade> mbrs = new ArrayList<Grade>();

	public Controll() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("memberDB.txt"));

			StringTokenizer sT;

			String detail;

			String name, grade;

			int point;

			while (true) {

				detail = br.readLine();

				if (detail == null) {
					break;

				} else {
					sT = new StringTokenizer(detail, "/");

					name = sT.nextToken();

					grade = sT.nextToken();

					point = Integer.parseInt(sT.nextToken());

					switchGrade(name, grade, point, mbrs.size());
				}
			}
			
			System.out.println("ȸ�� ���� �ε��� �Ϸ�Ǿ����ϴ�.");
			
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void main() {

		while (true) {

			switch (view.viewMain()) {
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
				deleteMbr();
				break;

			case 0:
				saveMbrs();
				System.out.println("���α׷��� �����մϴ�.");
				return;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;

			}
		}
	}

	public void saveMbrs() {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("memberDB.txt"));
			
			for(Grade g : mbrs) {
				bw.write(g.getName()+"/"+g.getGrade()+"/"+g.getPoint());
				
			}
			
			System.out.println("ȸ�� ���� ������ �Ϸ�Ǿ����ϴ�.");
			
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertMbr() {
		String name = view.inputInfo("��  �� : ");

		if (searchIndex(name) != -1) {
			System.out.println("�ߺ��Ǵ� ȸ���� �ֽ��ϴ�.");
			System.out.println("���� �޴��� ���ư��ϴ�.");
			return;
		} else {
			String grade = view.inputInfo("��  �� : ").toLowerCase();
			int point = Integer.parseInt(view.inputInfo("����Ʈ : "));

			switchGrade(name, grade, point, mbrs.size());

			System.out.println(name + "���� ȸ������� �Ϸ�Ǿ����ϴ�");

		}
	}

	public void switchGrade(String name, String grade, int point, int index) {

		switch (grade) {

		case "silver":
			mbrs.add(index, new Silver(name, grade, point));
			break;

		case "gold":
			mbrs.add(index, new Gold(name, grade, point));
			break;

		case "vip":
			mbrs.add(index, new Vip(name, grade, point));
			break;

		case "vvip":
			mbrs.add(index, new Vvip(name, grade, point));
			break;

		default:
			System.out.println("�߸��� ����Դϴ�.");
			System.out.println("ó�� ȭ������ ���ư��ϴ�.");
			return;
		}
	}

	public void printAll() {
		System.out.println("\n���\t�̸�\t��������Ʈ\t\t���ʽ�����Ʈ");

		for (Grade g : mbrs) {
			System.out.println(g);
		}
	}

	public int searchIndex(String name) {

		for (int i = 0; i < mbrs.size(); i++) {
			if (mbrs.get(i).getName().equals(name)) {
				return i;
			}
		}

		return -1;
	}

	public void printMbr() {
		System.out.println("\n------- ȸ�� �˻� ------");

		int index = searchIndex(view.inputInfo("�˻��� ȸ���� : "));

		System.out.println("\n���\t�̸�\t��������Ʈ\t\t���ʽ�����Ʈ");
		System.out.println(mbrs.get(index));
	}

	public void modMbr() {
		System.out.println("\n------- ȸ������ ���� ------");

		int index = searchIndex(view.inputInfo("������ ȸ���� : "));

		if (index == -1) {
			System.out.println("������ ȸ���� �����ϴ�.");
			return;

		} else {
			String name = view.inputInfo("������ �̸� : ");
			String grade = view.inputInfo("������ ��� : ");
			int point = Integer.parseInt(view.inputInfo("������ ����Ʈ : "));

			if (mbrs.get(index).getGrade().equals(grade)) {
				mbrs.get(index).setName(name);
				mbrs.get(index).setPoint(point);

			} else {
				mbrs.remove(index);
				switchGrade(name, grade, point, index);
			}

		}

	}

	public void deleteMbr() {
		System.out.println("\n------- ȸ�� ���� ------");

		String name = view.inputInfo("������ ȸ���� : ");

		int index = searchIndex(name);

		if (index == -1) {
			System.out.println("ã���ô� ȸ���� �����ϴ�.");
			System.out.println("���� �޴��� ���ư��ϴ�.");
		} else {

			char answer = view.inputInfo("[" + name + "] ȸ���� ���� �����Ͻðڽ��ϱ�? [y/n] : ").charAt(0);

			switch (answer) {
			case 'y':
				mbrs.remove(index);
				System.out.println("[" + name + "] ���� �����Ǿ����ϴ�.");
				break;

			case 'n':
				System.out.println("������ ����մϴ�.");
				break;

			}
		}
	}
}
