package kh.java.func;

public class PrintMsg {
	public void printHello() {
		System.out.println("HELLO");
	}
	public void test() {
		System.out.println(1+1); // ���� + ���� = ���� 2
		System.out.println(1.1+1.1); //�Ǽ� + �Ǽ� = �Ǽ� 2.2
		System.out.println('1'+'1'); // ���� + ���� = ���� 98 (ASCII code)
		System.out.println("1"+" 1"); // ���ڿ� + ���ڿ� = ���ڿ�
	}
	public void test2() {
		System.out.println(1+1.1); // ���� + �Ǽ� = �Ǽ� 2.1
		System.out.println(1+'1'); // ���� + ���� = ����
		System.out.println(1.1+'1'); // �Ǽ� + ���� = �Ǽ�
		System.out.println("HI"+1); // ���ڿ� + ���� = ���ڿ� HI1
	}
}
