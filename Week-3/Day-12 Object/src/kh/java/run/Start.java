package kh.java.run;

import kh.java.test.Test1;

public class Start {
	public static void main(String[] args) {

		Test1 t1 = new Test1();
		// Test1 Ŭ������ clone() �޼ҵ��� ����Ÿ���� Object
		// �������� �θ�Ÿ�� ���۷��� �ڽ�Ÿ�� ��ü�� ����
		Test1 t2 = (Test1) t1.clone();

		// String�� �񱳽� ����ߴ� equals
		// heap ������ �������� ���Ҷ� ���
		String str1 = new String("Hello");
		String str2 = new String("Hello");

		if (str1.equals(str2)) {
			
			System.out.println("�����ϴ�.");
			
		} else {
			
			System.out.println("�ٸ��ϴ�.");
		}
	}
}
