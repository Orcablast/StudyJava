package kh.java.test;

import java.util.Calendar;
import java.util.Scanner;

public class exam {

	public void exam01() {
		Calendar today = Calendar.getInstance();

		int year = today.get(Calendar.YEAR);

		int month = today.get(Calendar.MONTH) + 1;

		int date = today.get(Calendar.DATE);

		int day = today.get(Calendar.DAY_OF_WEEK);

		String dayOfWeek = "";

		switch (day) {
		case 1:
			dayOfWeek = "�Ͽ���";
			break;

		case 2:
			dayOfWeek = "������";
			break;

		case 3:
			dayOfWeek = "ȭ����";
			break;

		case 4:
			dayOfWeek = "������";
			break;

		case 5:
			dayOfWeek = "�����";
			break;

		case 6:
			dayOfWeek = "�ݿ���";
			break;

		case 7:
			dayOfWeek = "�Ͽ���";
			break;
		}

		System.out.println(year + "�� " + month + "�� " + date + "�� " + dayOfWeek);

	}

	public void exam02() {

		Scanner sc = new Scanner(System.in); // Scanner Ŭ������ ��� sc�� ����

		Calendar today = Calendar.getInstance(); // Calendar Ŭ������ �� �ν��Ͻ��� today�� ����

		long now = today.getTimeInMillis();

		System.out.println("====================== D-Day ���� ======================");
		System.out.print("D-Day [�⵵] �Է� : ");
		int userYear = sc.nextInt();

		System.out.print("D-Day [��] �Է� : ");
		int userMonth = sc.nextInt() - 1;

		System.out.print("D-Day [��] �Է� : ");
		int userDate = sc.nextInt();

		printDate(today, "����");
		
		today.set(Calendar.YEAR, userYear);
		today.set(Calendar.MONTH, userMonth);
		today.set(Calendar.DATE, userDate);
		
		printDate(today, "D-Day");

		long user = today.getTimeInMillis();
		

		int left = (int)Math.floor((user - now) / 1000 / 60 / 60 / 24.0);

		if (left == 0) {
			System.out.println("D-Day�Դϴ�.");
		} else if (left > 0) {
			System.out.println(left + "�� ���ҽ��ϴ�.");
		} else if (left < 0) {
			System.out.println(-left + "�� �������ϴ�.");
		}
	}
	
	public void printDate(Calendar today, String msg) {		
		System.out.println(msg + " ��¥ : " + today.get(Calendar.YEAR) + "�� " + (today.get(Calendar.MONTH) + 1) + "�� " + today.get(Calendar.DATE) + "��");
	}
	
	
	
	
}


