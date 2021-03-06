package kh.java.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {

	public void bufferTest() {
		StringBuffer sb = new StringBuffer();

		// 저장된 문자열의 길이 출력
		System.out.println(sb.length());

		// 현재 문자열 끝에 추가
		sb.append("안녕하시오 ");
		System.out.println(sb.length());
		sb.append("추가");
		System.out.println(sb.length());

		// 3번 자리에 문자열 삽입
		sb.insert(3, "oo");
		System.out.println(sb);

		// 0~3까지 문자열 변경
		sb.replace(0, 3, "hi");
		System.out.println(sb);

		// 문자열 backword 진행
		sb.reverse();
		System.out.println(sb);
		sb.reverse();

		sb.delete(2, 5);
		System.out.println(sb);

		sb.delete(0, sb.length());
		System.out.println(sb.length());

		System.out.println(sb.capacity());

		sb.setLength(5);
		System.out.println(sb);

	}

	public void tokenTest() {
		String str = "이도형/30/부천";
		StringTokenizer st = new StringTokenizer(str, "/");

		// // 남아있는 토큰의 수
		// System.out.println(st.countTokens());
		//
		// // token을 1개 꺼내옴
		// System.out.println(st.nextToken());
		//
		// // 남아있는 토큰의 수
		// System.out.println(st.countTokens());
		// System.out.println(st.nextToken());
		// System.out.println(st.countTokens());
		// System.out.println(st.nextToken());

		// // 남아있는 토큰이 있는지 확인 -> true or false
		// while(st.hasMoreTokens()) {
		// System.out.println(st.nextToken());
		// }

	}

	// String str = "J a v a P r o g r a m";
	// 상기 문자열을 공백단위로 token 처리하여
	// 1. char[]에 저장하여 출력
	// 2. 대문자로 변환하여 문자열 저장 후 출력

	public void exam01() {

		String str = "J a v a P r o g r a m";
		System.out.println(str);
		StringTokenizer st = new StringTokenizer(str, " ");

		char arr[] = new char[st.countTokens()];

		// int index = 0;
		//
		//
		// while(st.hasMoreTokens()) {
		// arr[index++] = st.nextToken().charAt(0);
		// }

		System.out.println("< char 배열을 출력합니다. >");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken().charAt(0);
			System.out.print(arr[i]);
		}
		System.out.println();

		System.out.println("< char 배열을 대문자로 출력합니다. >");

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 90) {

				sb.append((char) (arr[i] ^ 32));

			} else {

				sb.append(arr[i]);
			}
		}

		String str2 = sb.toString();

		System.out.println(str2);

	}

	public void mathTest() {
		System.out.println(Math.abs(-20)); // 절대값 리턴

		System.out.println(Math.ceil(3.14)); // 소숫점 올림

		System.out.println(Math.floor(3.9)); // 소숫점 버림

		System.out.println(Math.round(3.5)); // 반올림

		System.out.println(Math.random()); // 0.0 ~ 1.0 범위의 임의의값 추출

		System.out.println(Math.max(1, 2)); // 비교 후 큰 값 리턴

		System.out.println(Math.min(2, 1)); // 비교 후 작은 값 리턴

		System.out.println((int) (Math.random() * 10) + 1); // 1~10 범위의 임의의값 출력

	}

	public void calenderTest() {

		// GregorianCalendar 객체 생성
		Calendar today = Calendar.getInstance();

		System.out.println(today.get(Calendar.YEAR)); // 현재 연도 출력

		System.out.println(today.get(Calendar.MONTH) + 1); // 현재 월 출력

		System.out.println(today.get(Calendar.DATE)); // 현재 일 출력

		System.out.println(today.get(Calendar.AM_PM)); // 오전=0, 오후=1 출력

		System.out.println(today.get(Calendar.HOUR)); // 현재 시간 출력

		System.out.println(today.get(Calendar.MINUTE)); // 현재 분 출력

		System.out.println(today.get(Calendar.SECOND)); // 현재 초 출력

		System.out.println(today.get(Calendar.DAY_OF_WEEK)); // 현재 요일 출력 1== 일요일, 7== 토요일

		today.set(Calendar.YEAR, 2050); // 연도 수정

		System.out.println(today.get(Calendar.YEAR)); // 현재 연도 출력

		System.out.println(today.get(Calendar.DAY_OF_WEEK)); // 현재 요일 출력 1== 일요일, 7== 토요일

		// 현재 시간을 표현하는 메소드
		// 1970년 1월 1일 09시 00분 00초 ~ 현재 시간을 ms 단위로 계산
		System.out.println(today.getTimeInMillis());

	}

	public void calenderTest2() { // d-day 계산법

		// GregorianCalendar 객체 생성
		Calendar day1 = Calendar.getInstance();
		Calendar day2 = Calendar.getInstance();

		day2.set(Calendar.YEAR, 2021);

		long day11 = day1.getTimeInMillis();
		long day22 = day2.getTimeInMillis();

		long day = day22 - day11;

		System.out.println(day / 1000 / 60 / 60 / 24);

	}

	public void dateTest() {
		
		Date date1 = new Date();

		Calendar today = Calendar.getInstance();
		today.set(Calendar.YEAR, 2021);
		
		long testDate = today.getTimeInMillis();
		
		Date date2 = new Date(testDate);
		
		System.out.println(date1);
		System.out.println(date2); 
	
	}
	
	public void dateFormatTest() {
		Date today = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd\nHH:mm:ss");
		
		String today1= sdf1.format(today);
		
		String today2= sdf2.format(today);
		
		System.out.println(today1);
		System.out.println(today2);
		
		
		
		
	}
	

	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		String str = sc.next();
		
		int num = Integer.parseInt(str);
		
		
		
//		
//		// 문자열 길이 측정
//		char[] arr = new char[str.length()];
//		
//		int num = 0;
//		
//		
//		int index = 1;
//		
//		for(int i=0; i<str.length(); i++) {
//			
//			char ch = str.charAt(i);
//			
//			if(ch>47 && ch<58) {
//				arr[i]=str.charAt(i);
//			} else {
//				System.out.println("숫자가 아닙니다.");
//				return;
//			}			
//		}
//				
//		for(int i=arr.length-1; i>=0; i--) {
//			num += (arr[i]-48)*index;
////			num += (arr[i]-48)*Math.pow(10, i);
//			index= index*10;
//		}
//		
//		System.out.println(num);
//		
//		int index= str.length()-1;
//		for(int i=0; i<str.length(); i++) {
//			
//			if(str.charAt(i)>47 && str.charAt(i)<58) {
//				num += (str.charAt(i)-48)*Math.pow(10, index--);
//			} else {
//				System.out.println("숫자가 아닙니다.");
//				return;
//			}			
//		}
//		
//
		System.out.println(num);
		
		
		
	}
	
}
