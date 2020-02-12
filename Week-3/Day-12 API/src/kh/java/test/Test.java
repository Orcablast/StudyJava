package kh.java.test;

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
		
		System.out.println((int)(Math.random()*10)+1); // 1~10 범위의 임의의값 출력
		
		
		
	}
}
