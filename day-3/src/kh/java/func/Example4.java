package kh.java.func;

import java.util.Scanner;

public class Example4 {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~3������ �� �Է� : ");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			System.out.println("1�� �Է�");
			break;
		case 2:
			System.out.println("2�� �Է�");
			break;
		case 3:
			System.out.println("3�� �Է�");
			break;
		default:
			System.out.println("�߸� �Է�");
		}
	}

	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ϼ��� �˰���� ���� �Է��ϼ��� : ");
		int inputNum = sc.nextInt();
		switch (inputNum) {
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 : 
			System.out.printf("%d������ 31�ϱ��� �ֽ��ϴ�.",inputNum);
			break;
		case 4 :
		case 6 :
		case 9 :
		case 11 : 
			System.out.printf("%d������ 30�ϱ��� �ֽ��ϴ�.",inputNum);
			break;
		case 2 : 
			System.out.printf("%d������ 28�ϱ��� �ֽ��ϴ�.",inputNum);
			break;
		default :
			System.out.println("1~12 ������ ���� �Է����ּ���.");
		}

	}

	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� (A,B,C,D,F) : ");
		char grade = sc.next().charAt(0);
		switch (grade) {
		case 'A':
			System.out.println("�����ϼ̽��ϴ�. ���б��� 100%  ���� �ص帮�ڽ��ϴ�!");
			break;
		case 'B':
			System.out.println("�ƽ�����. ���б��� 50%  ���� �ص帮�ڽ��ϴ�.");
			break;
		case 'C':
			System.out.println("���б��� �ٶ�ø� �� �� ������ ���ּ���.");
			break;
		case 'D':
			System.out.println("ũ��......");
			break;
		case 'F':
			System.out.println("�л� ����Դϴ�!!");
			break;
		default:
			System.out.println("������ ���� �Է��ϼ���.");
		}

	}
	
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=========== ���� ���α׷� ===========");
		System.out.print("�����ڸ� �Է��ϼ��� (+,-,*,/) : ");
		char oper = sc.next().charAt(0);
		System.out.print("ù��° ������ �Է��ϼ��� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ������ �Է��ϼ��� : ");
		int num2 = sc.nextInt();
		int sum = num1+num2;
		int min = num1-num2;
		int multi = num1*num2;
		double div = (double)num1/num2;
		
		switch(oper){
		case '+' :
			System.out.printf("%d%c%d=%d",num1,oper,num2,sum);
			break;
		case '-' :
			System.out.printf("%d%c%d=%d",num1,oper,num2,min);
			break;
		case '*' :
			System.out.printf("%d%c%d=%d",num1,oper,num2,multi);
			break;
		case '/' :
			System.out.printf("%d%c%d=%.6f",num1,oper,num2,div);
			break;			
		}
		
		
		
	}
	
	
	public void exam5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int score = sc.nextInt();		
		if(score<=100 && score>=0) {
			int grade = score/10;
			switch(grade) {			
			case 10 : 
				System.out.printf("%d�� ==> A ���",score);
				break;
			case 9 : 
				System.out.printf("%d�� ==> A ���",score);
				break;
			case 8 :
				System.out.printf("%d�� ==> B ���",score);
				break;
			case 7 :
				System.out.printf("%d�� ==> C ���",score);
				break;
			case 6 :
				System.out.printf("%d�� ==> D ���",score);
				break;
			default : 
				System.out.printf("%d�� ==> F 0���",score);
			}
		} else {
			System.out.println("0~100 ������ ���� �Է��ϼ���.");
		}
		
	}
	
	
	
}
