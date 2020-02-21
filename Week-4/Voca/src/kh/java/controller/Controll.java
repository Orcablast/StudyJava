package kh.java.controller;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import kh.java.view.View;
import kh.java.model.*;
import kh.java.view.*;;

public class Controll {

	// ---------���� ���� �޼ҵ� �� ����
	// ���-------------------------------------------------------------------------------------
	Word word = new Word();
	View view = new View();
	ArrayList<Word> allDB = new ArrayList<Word>(); // ���ܾ� List
	ArrayList<Word> failDB = new ArrayList<Word>(); // ���� DB List
	ArrayList<Integer> qIndex = new ArrayList<Integer>();
	BufferedReader br;
	BufferedReader failBr;
	BufferedWriter bw;
	Random r = new Random();
	Scanner sc = new Scanner(System.in);

	public Controll() { // �ܾ��� ��ü �о�� ����Ʈ�� �߰�

		try {
			br = new BufferedReader(new FileReader("allDB.txt"));

			readDB(br, allDB);
			System.out.println("�ܾ��� �ε� �Ϸ�");

			failBr = new BufferedReader(new FileReader("failDB.txt"));

			readDB(failBr, failDB);
			System.out.println("�����Ʈ �ε� �Ϸ�");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				failBr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void controlMain() { // ù �޴�

		try {
			while (true) {
				int select = view.main();
				switch (select) {
				case 1: // �ܾ� �˻�
					search();
					break;
				case 2:// ���ܾ� ���
					Insertdictionary();
					break;
				case 3:// �׽�Ʈ
					testMenu();
					break;
				case 4:// ���� ��Ʈ
					failMenu();
					break;
				case 5:// �ܾ� ���� �� ����
					updateMain();
					break;
				case 0:
					saveDB(allDB, "allDB");
					saveDB(failDB, "failDB");
					return;
				}
			}
		} catch (Exception e) {

			try {
				saveDB(allDB, "allDB");
				saveDB(failDB, "failDB");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public int searchIndex(String userInput) { // ������ �Է��� �ܾ� �ܾ��忡 �ִ��� �˻� �� ��� ���� !!!!!!!���� ����!!!!!!!!!

		for (int i = 0; i < allDB.size(); i++) {
			if (allDB.get(i).getName().equals(userInput)) { // i��° ��ü�� getName���� userInput�� �����Ҷ�
				return i; // i�� ����
			}
		}
		return -1; // �ش�Ǵ� �ܾ ã�� ���Ұ�� -1 ����
	}

	public void saveDB(ArrayList<Word> arr, String fileName) throws IOException { // ����, ������ ������ ������ DB ���� �޼ҵ�

		bw = new BufferedWriter(new FileWriter(fileName + ".txt")); // allDB.txt�� �����ϴ� BufferWriter ����
		int i = 0;
		for (Word w : allDB) { // allDB ���� ��� Word ��ü �˻�

			if (i != 0) { // ���ʿ��� ����ó����������.
				bw.newLine();
			}
			// �˻��� Word ��ü�� �̸�, mean1, mean2�� ������ / �� �������� FileWrite

			bw.write(w.getName() + "/" + w.getMean1() + "/" + w.getMean2());
			i++;
		}
	}

	public void readDB(BufferedReader br, ArrayList<Word> arr) throws IOException { // txt�� �о� ArrayList�� �����ϴ� �޼ҵ�

		String str;

		while (true) {
			str = br.readLine();

			if (str == null) {
				break;

			} else {
				StringTokenizer sT = new StringTokenizer(str, "/");

				String name = sT.nextToken();
				String mean1 = sT.nextToken();
				String mean2 = sT.nextToken();

				arr.add(new Word(name, mean1, mean2));
			}
		}
	}

	// ---------���� ��
	// ����_��������-------------------------------------------------------------------------------------

	public void updateMain() { // �������� �޴�ȭ���� ����ϰ� �Է°��� ���Ϲ޾� ����

		while (true) {
			int slt = view.updateMain();

			switch (slt) {
			case 1: // �ܾ� ����
				modifyWord();
				break;
			case 2: // �ܾ� ����
				delWord();
				break;
			case 0:
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;
			default:
				System.out.println("0~2 ������ ���ڸ� �Է��ϼ���.");
			}
		}
	}

	public void modifyWord() { // �ܾ� ���� �� ����Ʈ�� ����
		String userInput = view.getName("����");

		int index = searchIndex(userInput);

		if (index == -1) {
			System.out.println("ã���ô� �ܾ �����ϴ�.");

		} else {
			String currentMean1 = allDB.get(index).getMean1(); // ��ü �ܾ �ִ� ����Ʈ�� ��1�� �� 2
			String currentMean2 = allDB.get(index).getMean2();

			System.out.println("[" + userInput + "] �ܾ �����մϴ�.");
			String mean1 = view.getMean("���� ���� : " + currentMean1 + "\t����  : "); // �ܾ��� ù��° ��

			System.out.println("���� �Է��� �ߴ��Ͻ÷��� x �� �Է��ϼ��� ��");
			String mean2 = view.getMean("���� ���� : " + currentMean2 + "\t����  : ");

			if (mean2.charAt(0) == 'x') {
				allDB.get(index).setMean1(mean1);

			} else {
				allDB.get(index).setMean1(mean1);
				allDB.get(index).setMean2(mean2);
			}
		}
	}

	public void delWord() { // �ܾ� ���� �޼ҵ� !!!!!!!���� ����!!!!!!!!!
		String userInput = view.getName("����"); // ������ �ܾ�

		int index = searchIndex(userInput);

		if (index == -1) { // �Է��� �ܾ DB�� �������� ������
			System.out.println("ã���ô� �ܾ �����ϴ�.");
			return; // �޼ҵ� ����

		} else if (view.delWord(userInput)) { // ������ y�� �Է��� �ܾ������ �����ϴ� ��� = true�� ���ϵ� ��
			allDB.remove(index);

		} else { // ������ n�� �Է��Ͽ� �ܾ������ ����� ���
			return;
		}
	}

	// ---------�˻�_����-------------------------------------------------------------------------------------
	public void search() {

		while (true) {
			int select = view.searchDictionary(); // view���� ���� �˻����� �ѿ� �˻�����
			switch (select) {
			case 1:
				searchEng();
				break;
			case 2:
				searchKor();
				break;
			case 0:
				return;
			}
		}
	}

	public void searchEng() { // ���ܾ�� �� �˻�
		// �Է¹޴� ȭ���� ViewŬ������ ��ü �����
		String search = view.getName("�˻�"); // �˻��� �ܾ� �Է¹ޱ�

		for (int i = 0; i < search.length(); i++) {// ���ܾ� �̿��� ���� �Է� ��
			if (search.charAt(i) < 'A' || search.charAt(i) > 'z') {
				System.out.println("��� �Է��� �� �ֽ��ϴ�.");
				return;
			}
		}

		search = search.toLowerCase();

		boolean find = false; // �ܾ��忡 ���� �ܾ �˻����� �� ���´ܾ��� �����ֱ�����

		for (int i = 0; i < allDB.size(); i++) {
			if (allDB.get(i).getName().equals(search)) {// �ܾ����� �ܾ�� �� ���� �Է��ѰͰ� ��ġ�ϴ°��� ������
				System.out.println("�ܾ� : " + allDB.get(i).getName() + "\nù��° �� : " + allDB.get(i).getMean1()
						+ "\n�ι�° �� : " + allDB.get(i).getMean2());
				find = true;
			}
		}
		if (find == false) {
			System.out.println("�ܾ��忡 ���� �ܾ��Դϴ�!");
		}
	}

	public void searchKor() { // ������ ���ܾ� �˻�

		String search = view.getName("�˻�"); // �˻��� �ܾ� �Է¹ޱ�
		boolean find = false; // �ܾ��忡 ���� �ܾ �˻����� �� ���´ܾ��� �����ֱ�����
		for (int i = 0; i < allDB.size(); i++) {
			// ���� �˻��� ���� ��� �ܾ��� mean1 �Ǵ� mean2 �߿� ��ġ�ϴ°� ������
			if (allDB.get(i).getMean1().equals(search) || allDB.get(i).getMean2().equals(search)) {
				// ���� ���� ���� �ܾ� ��� ���
				System.out.println("�ܾ� : " + allDB.get(i).getName() + "\nù��° �� : " + allDB.get(i).getMean1()
						+ "\n�ι�° �� : " + allDB.get(i).getMean2());
				find = true;
			}
		}
		if (find == false) {
			System.out.println("[" + search + "]�� ���� ���� �ܾ �����ϴ�!");
		}
	}

	// ---------�׽�Ʈ_��������-------------------------------------------------------------------------------------

	public void setTest(int qNum) { // ����ڰ� �Է��� ����ŭ ����� ������ index�� ���ϴ� �޼ҵ�
		int index;
		for (int i = 0; i < qNum; i++) {
			index = r.nextInt(allDB.size());

			if (qIndex.contains(index)) {
				i--;
				continue;

			} else {
				qIndex.add(index);
			}
		}
	}

	public int doTest() {
		int score = 0;

		for (int i : qIndex) {
			System.out.print("\n" + allDB.get(i).getName() + " : ");
			String ans = sc.nextLine();

			int result = allDB.get(i).toString().indexOf(ans);

			if (result == -1) {
				System.out.println("��!!");
				failDB.add(allDB.get(i));
			} else {
				System.out.println("����!!");
				score++;
			}
		}

		return score;
	}

	public void testMenu() { // needCheck
		double score;
		int qNum;
		// ���Ӽ���
		while (true) {
			int select = view.vocaTest(); // view���� �޴����� �Է¹���.
			switch (select) {
			case 1: // �����׽�Ʈ���

				qNum = view.askQNum("����");
				setTest(qNum);

				System.out.println("�׽�Ʈ�� �����մϴ�.");
				System.out.println("���� �ܾ ���� ���� �Է��ϼ���.");

				score = doTest();

				view.testResult((score / (double) qNum) * 100);

				break;
			case 2: // �ѿ��׽�Ʈ���

				qNum = view.askQNum("�ѿ�");
				setTest(qNum);

				System.out.println("�׽�Ʈ�� �����մϴ�.");
				System.out.println("���� �ǹ̸� ���� �ܾ �Է��ϼ���.");

				score = doTest();

				view.testResult((score / (double) qNum) * 100);

			case 0:
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;
			}
		}
	} // main

	public void clearDupInDB(ArrayList<Word> DB) {	
		
		for(int i=0; i<DB.size(); i++) {
			for(int j=i+1; j<failDB.size(); j++) {
				if(DB.get(i).toString().equals(DB.get(j).toString())) {
					failDB.remove(j);					
					j--;
				}
			}
		}

	}

	// ---------����_���δ���-------------------------------------------------------------------------------------

	public void failMenu() {
		while (true) {
			int select = view.failMenu();
			switch (select) {
			case 1:
				readNote();
				break;
			case 2:
				reTest();
				break;
			case 3:
				clearNote();
				break;
			case 4:
				return;
			}
		}
	}

	public void reTest() { // ���ۼ� �ʿ�

		view.reTest();

		char agree = sc.next().toLowerCase().charAt(0); // ����� ���� �Է�
		sc.nextLine();

		switch (agree) {
		case 'n': // ����� ��ġ ���� �� ����
			System.out.println("���� �޴��� ���ư��ϴ�.\n");
			return;
		case 'y': // ����� ���� ��
			if (failDB.size() == 0) {
				System.out.println("�����Ʈ�� �ܾ �����ϴ�!");
				return;
			}
			System.out.println("�׽�Ʈ�� �����մϴ�. ���� ���ܾ ���� ���� �Է��ϼ���.");
			// System.out.println(failName.size());
			System.out.println(failDB.size());
			System.out.println();
			// int size = failName.size();
			// for (int i = 0; i < size; i++) {

			// System.out.println(failName.get(i)); // ����(�� ������) ���ܾ �ε��� �ٿ��� ���
			System.out.print("�� : ");
			String ans = sc.nextLine(); // �� �Է¹���.

			// StringTokenizer sT = new StringTokenizer(failDB.get(question), "/"); //�� ������
			// ���ܾ� 3���� ��ū���� �����ֱ�
			// sT.nextToken();
			// String mean1 = sT.nextToken(); //��1 ���
			// String mean2 = sT.nextToken(); //��2 ���

			// if (failDB.get(i).getMean1().equals(ans) ||
			// failDB.get(i).getMean2().equals(ans)) {
			System.out.println("����!"); // '�Է¹��� �� '�� '������ ��'�� �ϳ��� ������ "����"
			// failName.remove(i); // �ܾ� ����ִ� �迭���� �������ֱ�
			// failDB.remove(i); // ���� ��
			// } else {
			// System.out.println("Ʋ�Ƚ��ϴ�!");
			// }
			//
			// }
		}
	}

	public void clearNote() { // �����Ʈ ����ִ� �޼ҵ�
	}

	public void readNote() { // �����Ʈ �ѹ��� ���� �����ؼ� ����� ��ȸ
		//
		// if (failName.size() == 0) { // ������ ������ ���� ��
		// System.out.println("�����Ʈ�� ��� �ܾ �����ϴ�.\n");
		// } else { // failName(�� ������ �ܾ ����ִ�) �迭�� ���� ����name �Ϸ�ȭ�ؼ� ���
		// for (int i = 0; i < failName.size(); i++) {
		// System.out.println((i + 1) + ". " + (failName.get(i)));
		// }
		//
		// view.readNote(); // viewŬ������ readNote �޼ҵ� ����
		// int select = sc.nextInt(); // ��ȸ�ϰ� ���� ���� ��ȣ ����
		// System.out.println("�ܾ� : " + failDB.get(select - 1).getName() + " ù��° �� : "
		// + failDB.get(select - 1).getMean1() + " �ι�° �� : " + failDB.get(select -
		// 1).getMean2()); // �� ������ ���ܾ�
		// // ����ִ� �迭����
		// // ������ ���� ���
		// System.out.println();
		// }

	}

	public void Insertdictionary() {
		while (true) {
			int sel = view.Insertdictionary();
			switch (sel) {
			case 1:
				inputWord();
				break;
			case 0:
				return;
			}
		}
	}

	public void inputWord() { // ���ܾ� ���
		String nWord;
		boolean bool;
		while (true) {
			bool = true;
			System.out.println("����� �ܾ �Է��ϼ��� : ");
			nWord = sc.next().toLowerCase();
			for (int i = 0; i < allDB.size(); i++) {
				if (nWord.equals(allDB.get(i).getName())) {
					System.out.println("�ܾ �ߺ��˴ϴ�.�ٽ� �Է����ּ���");
					bool = false;
					break;
				}

			}
			if (bool) {
				break;
			}
		}

		String name = nWord;
		System.out.print("ù��° ���� �Է����ּ��� : ");
		String nMean1 = sc.next();

		System.out.print("�ι�° ���� �Է����ּ��� : ");
		String nMean2 = sc.next();

		System.out.println(name + "/" + nMean1 + "/" + nMean2 + "�� �½��ϱ�?");
		System.out.print("�̴�� ����Ͻðڽ��ϱ�?[y/n] : ");
		char ch = sc.next().charAt(0);

		switch (ch) {
		case 'y':
			Word w = new Word(name, nMean1, nMean2);
			allDB.add(w);
			System.out.println("====�ܾ ��ϵǾ����ϴ�====");
			break;
		case 'n':
			break;
		default:
			System.out.println("�߸��� �Է��Դϴ�. ���Ŀ� ���� �Է����ּ���! ");
		}

	}

}
