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
			dayOfWeek = "일요일";
			break;

		case 2:
			dayOfWeek = "월요일";
			break;

		case 3:
			dayOfWeek = "화요일";
			break;

		case 4:
			dayOfWeek = "수요일";
			break;

		case 5:
			dayOfWeek = "목요일";
			break;

		case 6:
			dayOfWeek = "금요일";
			break;

		case 7:
			dayOfWeek = "일요일";
			break;
		}

		System.out.println(year + "년 " + month + "월 " + date + "일 " + dayOfWeek);

	}

	public void exam02() {

		Scanner sc = new Scanner(System.in); // Scanner 클래스를 약어 sc로 선언

		Calendar today = Calendar.getInstance(); // Calendar 클래스의 새 인스턴스를 today로 선언

		long now = today.getTimeInMillis();

		System.out.println("====================== D-Day 계산기 ======================");
		System.out.print("D-Day [년도] 입력 : ");
		int userYear = sc.nextInt();

		System.out.print("D-Day [월] 입력 : ");
		int userMonth = sc.nextInt() - 1;

		System.out.print("D-Day [일] 입력 : ");
		int userDate = sc.nextInt();

		printDate(today, "오늘");
		
		today.set(Calendar.YEAR, userYear);
		today.set(Calendar.MONTH, userMonth);
		today.set(Calendar.DATE, userDate);
		
		printDate(today, "D-Day");

		long user = today.getTimeInMillis();
		

		int left = (int)Math.floor((user - now) / 1000 / 60 / 60 / 24.0);

		if (left == 0) {
			System.out.println("D-Day입니다.");
		} else if (left > 0) {
			System.out.println(left + "일 남았습니다.");
		} else if (left < 0) {
			System.out.println(-left + "일 지났습니다.");
		}
	}
	
	public void printDate(Calendar today, String msg) {		
		System.out.println(msg + " 날짜 : " + today.get(Calendar.YEAR) + "년 " + (today.get(Calendar.MONTH) + 1) + "월 " + today.get(Calendar.DATE) + "일");
	}
	
	
	
	
}


