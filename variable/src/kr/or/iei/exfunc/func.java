package kr.or.iei.exfunc;

public class func {
	public void exam1() {
		int num1 = 100; // num1 ������ ���� 100���� ����
		long num2 = 999999999999L; // num2 ������ ���� 999999999999�� ����
		float num3 = 486.520f; // num3 ������ ���� 486.520 �� ����
		double num4 = 5697.890123; // num4 ������ ���� 5697.890123 �� ����
		char str1 = 'A'; // str1 ������ ���� ���� A�� ����
		String str2 = "Hello JAVA"; // str2 ������ ���� ���ڿ� HELLO JAVA�� ����
		boolean bool = true; // bool ������ ���� ���� true�� ����
		System.out.println(num1); // ���� num1�� ����� ������ ���
		System.out.println(num2); // ���� num2�� ����� ������ ���
		System.out.println(num3); // ���� num3�� ����� �Ǽ��� ���
		System.out.println(num4); // ���� num4�� ����� �Ǽ��� ���
		System.out.println(str1); // ���� str1�� ����� ���ڸ� ���
		System.out.println(str2); // ���� str2�� ����� ���ڿ��� ���
		System.out.println(bool+"\n\n"); // ���� bool�� ����� ���� ����ϰ� ���� 2�� ����
	}
	
	public void exam2() {
		String name1 = "�̵���";
		String name2 = "�����";
		int age1 = 30;
		int age2 = 30;
		char gender1 = '��';
		char gender2 = '��';
		String address1 = "��õ";
		String address2 = "����";
		String phnum1 = "01071175271";
		String phnum2 = "01093636623";
		String emailadr1 = "dbro0423@gmail.com";
		String emailadr2 = "bloodred15@naver.com";
		System.out.printf("�̸�\t����\t����\t����\t��ȭ��ȣ\t\t�̸���\n");
		for (int i=1; i<24; i++) {
			System.out.print("---");
		}
		System.out.printf("\n%s\t%s\t%s\t%s\t%s\t%s\t\n",name1,age1,gender1,address1,phnum1,emailadr1);
		for (int i=1; i<24; i++) {
			System.out.print("---");
		}
		
		System.out.println("\n"+name2+"\t"+age2+"\t"+gender2+"\t"+address2+"\t"+phnum2+"\t"+emailadr2);
		
	}
	

}
