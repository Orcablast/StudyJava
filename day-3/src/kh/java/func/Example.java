package kh.java.func;
import java.util.Scanner;

public class Example {
	public void exam1() {
		// ���� ������ ���� 1��
		int a = 10;
		int b= 10;
		System.out.println(a);
		System.out.println(a++); // ������� �� a ���� 1 ����
		System.out.println(a);
		
		System.out.println(b);
		System.out.println(++b); // 
		System.out.println(b);
	}
	
	public void exam2() {
		// ���� ������ ���� 2��
		int a = 10;
		int b = (a--)+2; // ������ ��� ��ģ �� a���� 1 ����
		System.out.println(a);
		System.out.println(b);
	}
	
	public void exam3() {
		int a = 10;
		int b = 10;
		int c;		
		c = (a++) + (++b) + a; // c = (10) + (11) + 11, a++�� ������ 1�� ���� (a++)+(++b) �� ���� �Ŀ� ����, ���� + a �� �̷�������� 11�� �ȴ�.		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	public void exam4() {
		int a = 10;
		int b = 10;
		int c;
		c = (a++) + ((++b) *a); // c= (10) + ((11)*11) -> a++�� 10�� ����� �Ŀ� a���� 1 �������� 2�׿� ���Ǵ� a�� 11�� �ȴ�. 
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
				
	}
	
	public void exam5() {
		char w1 = 'a';
		char w2 = 'A';
		System.out.println(w1);
		System.out.println(w2);
		System.out.println((char)(w2^32)); // w2�� xor ����	
		
	}
	
	public void exam6() {
		int a = 1100;
		int b = a>>1; // ��Ʈ�� �������� 1�� �̵��ϸ� ������ ���� �ȴ�. �ݴ��� ��� 2��
		System.out.println(b);
	}
	
	public void exam7() {// ������ �������� 1
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° �� �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° �� �Է� : ");
		int num2 = sc.nextInt();
		System.out.println("========= ��� =========");
		int sum = num1 + num2;
		int min = num1 - num2;
		int multi = num1 * num2;
		double div = (double)num1/num2;
		System.out.println("�� ���� ���� �� : "+sum);
		System.out.println("�� ���� �� �� : "+min);
		System.out.println("�� ���� ���� �� : "+multi);
		System.out.printf("�� ���� ���� �� : %.2f",div);	
	
		
	}

	public void exam8() { // �������� 2��
		int a = 40, b = 20;
		a += b;
		System.out.printf("a�� ��: %d, b�� �� %d \n",a,b);
		a -= b;
		System.out.printf("a�� ��: %d, b�� �� %d \n",a,b);
		b *= a;
		System.out.printf("a�� ��: %d, b�� �� %d \n",a,b);
		b /= a;
		System.out.printf("a�� ��: %d, b�� �� %d \n",a,b);
	}
	
	public void exam9() { // �������� 3��
		int a = 10, b = 20, c = 30, d = 40;
		boolean result1, result2;
		result1 = ((a<20 && b>10) && (c == 20 || d == 40)); // ((true && true) && (false || true) -> true && false  -> flase
		// ((true && !true) || (true && !true)) -> ((true && false) || (true && false)) -> false || false -> false
		result2 = ((a == 10 && b != 2 * 10) || (c == 30 && d != 40)); 
		System.out.printf("ù��° ����� : %b \n", result1);
		System.out.printf("�ι�° ����� : %b \n", result2);
		
	}
	
	public void exam10() { // �������� 4��
		Scanner sc = new Scanner(System.in);		
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		// age ���� 19 ���� ū�� ���Ͽ� true �̸� �����Դϴ�, false �̸� �̼������Դϴ�
		System.out.println(age>19 ? "�����Դϴ�. �������!" : "�̼����ڴ� ����Ұ��Դϴ�");
	}
	
	public void exam11() { // �������� 5-1��
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� �Է� : ");
		int kor = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int eng = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int math = sc.nextInt(); 
		int sum = kor+eng+math;  
		double avg = sum/3.0; // ���� Ÿ�� sum�� �Ǽ� 3.0���� ������ double Ÿ�� avg�� ����
		System.out.println("�հ� : "+sum);
		System.out.printf("��� : %.2f\n",avg); 
		System.out.println(avg>=60 ? "�հ�!" : "���հ�!");		
		
	}
	
	public void exam12() { // �������� 5-2��
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt(); 
		int check = num%2; // num ���� 2�� ���� ������ ���� check ������ �ʱ�ȭ
		// check ���� 0 ���� ���Ͽ� true�̸� ¦��!, false�̸� Ȧ��! �� ���
		System.out.println(check == 0 ? "¦��!" : "Ȧ��!");
	}
}
