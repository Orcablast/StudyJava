package kh.java.test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {

	public void bufferTest() {
		StringBuffer sb = new StringBuffer();

		// ����� ���ڿ��� ���� ���
		System.out.println(sb.length());

		// ���� ���ڿ� ���� �߰�
		sb.append("�ȳ��Ͻÿ� ");
		System.out.println(sb.length());
		sb.append("�߰�");
		System.out.println(sb.length());

		// 3�� �ڸ��� ���ڿ� ����
		sb.insert(3, "oo");
		System.out.println(sb);

		// 0~3���� ���ڿ� ����
		sb.replace(0, 3, "hi");
		System.out.println(sb);

		// ���ڿ� backword ����
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
		String str = "�̵���/30/��õ";
		StringTokenizer st = new StringTokenizer(str, "/");

		// // �����ִ� ��ū�� ��
		// System.out.println(st.countTokens());
		//
		// // token�� 1�� ������
		// System.out.println(st.nextToken());
		//
		// // �����ִ� ��ū�� ��
		// System.out.println(st.countTokens());
		// System.out.println(st.nextToken());
		// System.out.println(st.countTokens());
		// System.out.println(st.nextToken());

		// // �����ִ� ��ū�� �ִ��� Ȯ�� -> true or false
		// while(st.hasMoreTokens()) {
		// System.out.println(st.nextToken());
		// }

	}

	// String str = "J a v a P r o g r a m";
	// ��� ���ڿ��� ��������� token ó���Ͽ�
	// 1. char[]�� �����Ͽ� ���
	// 2. �빮�ڷ� ��ȯ�Ͽ� ���ڿ� ���� �� ���

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

		System.out.println("< char �迭�� ����մϴ�. >");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = st.nextToken().charAt(0);
			System.out.print(arr[i]);
		}
		System.out.println();

		
		System.out.println("< char �迭�� �빮�ڷ� ����մϴ�. >");

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
		System.out.println(Math.abs(-20)); // ���밪 ����
		
		System.out.println(Math.ceil(3.14)); // �Ҽ��� �ø�
		
		System.out.println(Math.floor(3.9)); // �Ҽ��� ����
		
		System.out.println(Math.round(3.5)); // �ݿø�
		
		System.out.println(Math.random()); // 0.0 ~ 1.0 ������ �����ǰ� ����
		
		System.out.println(Math.max(1, 2)); // �� �� ū �� ����
		
		System.out.println(Math.min(2, 1)); // �� �� ���� �� ����
		
		System.out.println((int)(Math.random()*10)+1); // 1~10 ������ �����ǰ� ���
		
		
		
	}
}
