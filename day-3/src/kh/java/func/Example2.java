package kh.java.func;
import java.util.Scanner;


public class Example2 { // Chapter ���ǹ�
	public void exam1() {
		Scanner sc = new Scanner(System.in); // Scanner�� ��� sc�� ����
		System.out.println("10�� �Է��ϼ��� : "); 
		int inputNumber = sc.nextInt(); // ����ڰ� �Է��� ����  ���� inputNumber�� ����
		if (inputNumber == 10) { // inputNumber == 10 �� ���� true�϶�
			System.out.println("�� ���߾��"); // if ���ǹ��� true �϶� ���ڿ��� ���
		}
	}

	public void exam2() { // ���ǹ� �������� 1
		Scanner sc = new Scanner(System.in);
		System.out.println("======== ���� ���� ���α׷� =========");
		System.out.print("������ ������ �Է��ϼ��� : ");
		int inputNumber = sc.nextInt(); 
		if(inputNumber > 0) { // ���ǹ� inputNumber > 0�� ���� true �̸� �߰�ȣ ���� ��ɾ ����
			System.out.printf("����� �Է��� �� %d��(��) ����Դϴ�",inputNumber);
		}
		if(inputNumber == 0 ) { // ���ǹ� inputNumber == 0 �� ���� true �̸� �߰�ȣ ���� ��ɾ ����
			System.out.printf("����� �Է��� �� %d��(��) 0�Դϴ�",inputNumber);
		}
		if(inputNumber < 0 ) { // ���ǹ� inputNumber < 0 �� ���� true �̸� �߰�ȣ ���� ��ɾ ����
			System.out.printf("����� �Է��� �� %d��(��) �����Դϴ�",inputNumber);
		}
//		System.out.printf(inputNumber>0 ? "����� �Է��� �� %��(��) ����Դϴ�":(inputNumber==0 ? "����� �Է��� �� %d��(��) 0�Դϴ�":"����� �Է��� �� %d��(��) �����Դϴ�"),inputNumber,inputNumber,inputNumber);
	}
	
	public void exam3() { // ���ǹ� �������� 2
		Scanner sc = new Scanner(System.in);
		System.out.println("======== �μ� �� ���α׷� =========");
		System.out.print("ù��° ������ �Է��ϼ��� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ������ �Է��ϼ��� : ");
		int num2 = sc.nextInt();
		if (num1<num2) { 
			System.out.printf("%d<%d\n�ι�° ���� �� Ů�ϴ�.",num1,num2);
		}
		if (num1==num2) {
			System.out.printf("%d=%d\n�μ��� �����ϴ�.",num1,num2);
		}
		if (num1>num2) {
			System.out.printf("%d>%d\nù��° ���� �� Ů�ϴ�.",num1,num2);
		}		
	}
	
	public void exam4() { // ���ǹ� �������� 3
		Scanner sc = new Scanner(System.in);
		System.out.println("======== ���� ���α׷� =========");
		System.out.print("�����ڸ� �Է��ϼ��� (+,-,*,/) : ");
		char operator = sc.next().charAt(0); // �Է��� ���ڿ��� 0��° ���ڸ� char Ÿ�� operator ������ ���� 
		System.out.print("ù��° ������ �Է� �ϼ��� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ������ �Է� �ϼ��� : ");
		int num2 = sc.nextInt();
		
		if (operator == '+') { // ���� operator�� ���� ���� '+'�� ���� ������ (true) �߰�ȣ ���� ��ɾ ����
			int sum = num1+num2;
			System.out.printf("%d %c %d = %d",num1,operator,num2,sum);			
		}
		if (operator == '-') { // ���� operator�� ���� ���� '-'�� ���� ������ (true) �߰�ȣ ���� ��ɾ ����
			int min = num1-num2;
			System.out.printf("%d %c %d = %d",num1,operator,num2,min);			
		}
		if (operator == '*') { // ���� operator�� ���� '*'�� ���� ������ (true) �߰�ȣ ���� ��ɾ ����
			int multi = num1*num2;
			System.out.printf("%d %c %d = %d",num1,operator,num2,multi);			
		}
		if (operator == '/') { // ���� operator�� ���� '/'�� ���� ������ (true) �߰�ȣ ���� ��ɾ ����
			double div = (double)num1/num2;
			System.out.printf("%d %c %d = %.6f",num1,operator,num2,div);		
		}
		
		
		
	}
	
	public void exam5() { // ȥ�� ����...
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		System.out.println(num>=1000 ? "1000���� ū���̳׿�":(num>=100 ? "100���ٴ� ū���̳׿�":(num>=10 ? "10���� ū ���̳׿�":"10���� ���� ���̳׿�")));
//		if (num>1000) {
//			System.out.println("1000���� ū ���̳׿�");
//		}
//		if (num>100) {
//			System.out.println("100���� ū ���̳׿�");
//		}
//		if (num>10) {
//			System.out.println("10���� ū ���̳׿�");
//		}
//		if (num>1) {
//			System.out.println("1���� ū ���̳׿�");
//		}
	}
	
	public void exam6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		if(num%2==0) {
			System.out.println("¦���Դϴ�");
		} else {
			System.out.println("Ȧ���Դϴ�");
		}
//		if(num%2==0) {
//			System.out.println("¦���Դϴ�");
//		} 
//		if(num%2!=0){
//			System.out.println("Ȧ���Դϴ�");
//		}
	}
	
	public void exam7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== ���̰��� ���α׷� ==========");
		System.out.print("�����Ͻ� �� �ο��� ����Դϱ�? : ");
		int numPeople = sc.nextInt(); 
		System.out.print("��� ����Դϱ�? (1�δ� 15,000��) : ");
		int numMan = sc.nextInt();
		System.out.print("���̴� ����Դϱ�? (1�δ� 5,000��) : ");
		int numChild = sc.nextInt(); 
		int money = (numMan*15000)+(numChild*5000); 		
		if(numPeople == (numMan+numChild)) {
			System.out.printf("�����Ͻ� �� �ݾ��� %d�� �Դϴ�",money);
		} else {
			System.out.println("�ο����� ���� �ʽ��ϴ�.");			
		}
		
		
	}
	
	public void exam8() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== ���� ���α׷� ==========");
		System.out.println("ù��° ����");
		System.out.print("����� ����� �����ϱ��? (1.Apple 2.��Ƽ�� �⽺) : ");
		int answerCount = 0;
		int answer1 = sc.nextInt();
		if(answer1==1) {
			answerCount++;
			System.out.println("����!!!");
		} else {
			System.out.println("��!!");
		}
		System.out.println("--------------------------------");
		System.out.println("�ι�° ����");
		System.out.print("�ٳ����� ��� ������ ���� ������? (1.��� 2.����) : ");
		int answer2= sc.nextInt();			
		if(answer2==2) {
			answerCount++;
			System.out.println("����!!!");
		} else {
			System.out.println("��!!");
		}
		System.out.printf("�� %d������ ������ϴ�!",answerCount);
		
		
	}
	
	public void exam9() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== �ɸ��׽�Ʈ ==========");
		System.out.print("����� ���� �����Ͻʴϱ�? (1.Yes 2.No) : ");
		int answ1 = sc.nextInt();
		if (answ1==1) {
			System.out.print("����� ��踦 �ǿ�ʴϱ�? (1.Yes 2.No) : ");
			int answ2 = sc.nextInt();
			if (answ2==1) {
				System.out.println("���� �ǰ��� ���� �ʽ��ϴ�");
			} else {
				System.out.println("���� ���� ���� �ʽ��ϴ�.");
			}
		} else {
			System.out.print("����� �̼�ģ���� �ֽ��ϱ�? (1.Yes 2.No) : ");
			int answ3 = sc.nextInt();
			if(answ3==1) {
				System.out.println("�� ����");
			} else {
				System.out.println("������ �Ф�");
			}
		} 
	}
}
