package kh.java.wrap;

import java.util.Scanner;

public class Exam implements Calc {
	Scanner sc = new Scanner(System.in);

	@Override
	public void start() {

		while (true) {
			System.out.print("ù��° ���� �Է� : ");
			String num1 = sc.next();

			System.out.print("�ι�° ���� �Է� : ");
			String num2 = sc.next();

			System.out.print("������ �Է� [+, -, *, /] : ");
			char slt = sc.next().charAt(0);
			
			System.out.print("["+num1+" "+slt+" "+num2+"] = ");
			
			switch (slt) {
			case '+':
				System.out.println(add(num1, num2));
				return;

			case '-':
				System.out.println(sub(num1, num2));
				return;

			case '*':
				System.out.println(multi(num1, num2));
				return;

			case '/':
				System.out.println(div(num1, num2));
				return;

			default:
				System.out.println("�Է� error!! �ٽ� �Է��ϼ���. ");
				continue;
			}
		}
	}

	@Override
	public int add(String num1, String num2) {
		return (Integer.parseInt(num1)+Integer.parseInt(num2));
	}

	@Override
	public int sub(String num1, String num2) {
		return (Integer.parseInt(num1)-Integer.parseInt(num2));
	}

	@Override
	public int multi(String num1, String num2) {
		return (Integer.parseInt(num1)*Integer.parseInt(num2));
	}

	@Override
	public double div(String num1, String num2) {
		return (Double.valueOf(num1)/Double.valueOf(num2));
	}

}
