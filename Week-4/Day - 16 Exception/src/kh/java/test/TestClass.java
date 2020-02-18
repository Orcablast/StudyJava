package kh.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestClass {

	Scanner sc = new Scanner(System.in);

	public void exam01() {
		System.out.println("������ ���α׷�");
		System.out.print("1��° ���� : ");
		int num1 = sc.nextInt();

		System.out.print("2��° ���� : ");
		int num2 = sc.nextInt();

		int result = num1 / num2;

		double div = num1 / (double) (num2);

		System.out.println("��� : " + result);

		// try { // try ~ catch ����
		// int result = num1/num2;
		//
		// double div = num1/(double)(num2);
		//
		// System.out.println("��� : "+result);
		// } catch(Exception e) {
		// System.out.println("0���δ� ���� �� �����ϴ�.");
		// }
	}

	public void start() {
		int choice = 0;
		exam02();

		try {
			choice = sc.nextInt();
			exam03(choice);

		} catch (Exception e) {

			System.out.println("���ڸ� �Է��ϼ���");
			return;

		} finally {

			System.out.println("���α׷��� ����˴ϴ�.");
		}

	}

	public void exam02() {
		System.out.println("���");
		System.out.println("1. ������ ����");
		System.out.println("2. �������� ����?");
		System.out.println("3. �ȿ͵�.. ũ��..");
		System.out.print("�Է� : ");

	}

	public void exam03(int choice) {

		switch (choice) {
		case 1:
			System.out.println("�����̿���.");
			break;

		case 2:
			System.out.println("�����̿���.");
			break;

		case 3:
			System.out.println("�����̿���.");
			break;

		default:
			System.out.println("1~3���� �����ϼ���.");
			break;
		}
	}

	public void exam04() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("text.txt");
	}

	public void exam05() {
		try {
			exam04();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void div(int num1, int num2) {
		if (num2 == 0) {

			try {
				throw new ExceptionTest2("0���� ���� �� �����ϴ�.");

			} catch (ExceptionTest2 e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(num1 / num2);
	}

	public void exam06() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("text.txt");

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			try {

				fis.close();

			} catch (IOException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void exam07() {
		
		try(FileInputStream fis = new FileInputStream("text.txt")){
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		
	
}
