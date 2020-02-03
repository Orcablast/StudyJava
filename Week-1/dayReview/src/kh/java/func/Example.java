package kh.java.func;
import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("주소 : ");
		String addr = sc.next();
		System.out.print("키 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게 : ");
		double weight = sc.nextDouble();
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		System.out.printf("이름은 %d 나이는 %d살 주소는 %s\n키는%d 몸무게는 %.1f 성별은 %c성",name,age,addr,(int)height,weight,gender);
	}

}
