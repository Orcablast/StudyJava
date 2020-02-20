package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import VO.Word;
import view.updateView;

public class updateWord {

	Word word = new Word(); // �׽�Ʈ�� ��ü ����, �����Ǿ����

	updateView view = new updateView(); // �׽�Ʈ�� ��ü ����, �����Ǿ����

	ArrayList<Word> allDB = new ArrayList<Word>(); // �׽�Ʈ�� ��ü ����, �����Ǿ����

	BufferedReader br = null; // �׽�Ʈ�� ��ü ����, �����Ǿ����

	BufferedWriter bw = null; // �׽�Ʈ�� ��ü ����, �����Ǿ����
	
	Random rn = new Random();

	public updateWord() { // �׽�Ʈ�� �⺻������, �����Ǿ����

		try {
			br = new BufferedReader(new FileReader("allDB.txt"));

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

					allDB.add(new Word(name, mean1, mean2));
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

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

	public void modifyWord() { // �ܾ� ���� �޼ҵ�
		String userInput = view.getName("����");

		int index = searchIndex(userInput);

		if (index == -1) {
			System.out.println("ã���ô� �ܾ �����ϴ�.");

		} else {
			String currentMean1 = allDB.get(index).getMean1();
			String currentMean2 = allDB.get(index).getMean2();
			
			System.out.println("[" + userInput + "] �ܾ �����մϴ�.");	
			String mean1 = view.getMean("���� ���� : "+currentMean1+"\t����  : ");
			
			System.out.println("���� �Է��� �ߴ��Ͻ÷��� x �� �Է��ϼ��� ��");
			String mean2 = view.getMean("���� ���� : "+currentMean2+"\t����  : ");

			if (mean2.charAt(0) == 'x') {
				allDB.get(index).setMean1(mean1);
				saveDB();

			} else {
				allDB.get(index).setMean1(mean1);
				allDB.get(index).setMean2(mean2);
				saveDB();
			}
		}
	}

	public int searchIndex(String userInput) { // ������ �Է��� �ܾ���� �Ű������� index���� return

		for (int i = 0; i < allDB.size(); i++) {
			
			if (allDB.get(i).getName().equals(userInput)) { // i��° ��ü�� getName���� userInput�� �����Ҷ�
				return i; // i�� ����
			}
		}

		return -1; // �ش�Ǵ� �ܾ ã�� ���Ұ�� -1 ����
	}

	public void saveDB() { // ����, ������ ������ ������ DB ���� �޼ҵ�

		try {
			bw = new BufferedWriter(new FileWriter("allDB.txt")); // allDB.txt�� �����ϴ� BufferWriter ����

			for (Word w : allDB) { // allDB ���� ��� Word ��ü �˻�
				
				// �˻��� Word ��ü�� �̸�, mean1, mean2�� ������ / �� �������� FileWrite
				bw.write(w.getName() + "/" + w.getMean1() + "/" + w.getMean2()+"\r\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void delWord() { // �ܾ� ���� �޼ҵ�
		String userInput = view.getName("����");

		int index = searchIndex(userInput);

		if (index == -1) { // �Է��� �ܾ DB�� �������� ������
			System.out.println("ã���ô� �ܾ �����ϴ�.");
			return; // �޼ҵ� ����
			
		} else if (view.delWord(userInput)) { // ������ y�� �Է��� �ܾ������ �����ϴ� ���
			allDB.remove(index);
			saveDB();

		} else { // ������ n�� �Է��Ͽ� �ܾ������ ����� ���
			return;
		}

	}
	
	public void showRandomWord() {
		
		while(true) { // ����ڰ� �׸��α⸦ �Է����� ������ ����
			Word randomWord = allDB.get(rn.nextInt(allDB.size()));
			
			view.showRandomWord(randomWord); // randomWord�� �����ȭ�鿡 ���
			
			if(view.askNextRandom()) { // �׸������� ����ڿ��� �����Ͽ� false�� return �޾�����
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;
			}
		}
	}

}
