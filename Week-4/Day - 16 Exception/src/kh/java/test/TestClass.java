package kh.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestClass {

	Scanner sc = new Scanner(System.in);

	public void exam01() {
		System.out.println("나눗셈 프로그램");
		System.out.print("1번째 숫자 : ");
		int num1 = sc.nextInt();

		System.out.print("2번째 숫자 : ");
		int num2 = sc.nextInt();

		int result = num1 / num2;

		double div = num1 / (double) (num2);

		System.out.println("결과 : " + result);

		// try { // try ~ catch 구문
		// int result = num1/num2;
		//
		// double div = num1/(double)(num2);
		//
		// System.out.println("결과 : "+result);
		// } catch(Exception e) {
		// System.out.println("0으로는 나눌 수 없습니다.");
		// }
	}

	public void start() {
		int choice = 0;
		exam02();

		try {
			choice = sc.nextInt();
			exam03(choice);

		} catch (Exception e) {

			System.out.println("숫자만 입력하세욧");
			return;

		} finally {

			System.out.println("프로그램이 종료됩니다.");
		}

	}

	public void exam02() {
		System.out.println("골라");
		System.out.println("1. 정지엽 지각");
		System.out.println("2. 언제오는 거죠?");
		System.out.println("3. 안와도.. 크흠..");
		System.out.print("입력 : ");

	}

	public void exam03(int choice) {

		switch (choice) {
		case 1:
			System.out.println("지각이에요.");
			break;

		case 2:
			System.out.println("지각이에요.");
			break;

		case 3:
			System.out.println("지각이에요.");
			break;

		default:
			System.out.println("1~3에서 선택하세요.");
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
				throw new ExceptionTest2("0으로 나눌 수 없습니다.");

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
