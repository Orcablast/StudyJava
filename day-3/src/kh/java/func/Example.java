package kh.java.func;
import java.util.Scanner;

public class Example {
	public void exam1() {
		// 증감 연산자 예제 1번
		int a = 10;
		int b= 10;
		System.out.println(a);
		System.out.println(a++); // 선행출력 후 a 값을 1 증가
		System.out.println(a);
		
		System.out.println(b);
		System.out.println(++b); // 
		System.out.println(b);
	}
	
	public void exam2() {
		// 증감 연산자 예제 2번
		int a = 10;
		int b = (a--)+2; // 연산을 모두 마친 후 a값을 1 감소
		System.out.println(a);
		System.out.println(b);
	}
	
	public void exam3() {
		int a = 10;
		int b = 10;
		int c;		
		c = (a++) + (++b) + a; // c = (10) + (11) + 11, a++의 증가는 1차 연산 (a++)+(++b) 이 끝난 후에 수행, 따라서 + a 가 이루어질때는 11이 된다.		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	public void exam4() {
		int a = 10;
		int b = 10;
		int c;
		c = (a++) + ((++b) *a); // c= (10) + ((11)*11) -> a++는 10을 기록한 후에 a값을 1 증가시켜 2항에 사용되는 a는 11이 된다. 
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
				
	}
	
	public void exam5() {
		char w1 = 'a';
		char w2 = 'A';
		System.out.println(w1);
		System.out.println(w2);
		System.out.println((char)(w2^32)); // w2의 xor 연산	
		
	}
	
	public void exam6() {
		int a = 1100;
		int b = a>>1; // 비트를 우측으로 1씩 이동하면 절반의 값이 된다. 반대의 경우 2배
		System.out.println(b);
	}
	
	public void exam7() {// 연산자 연습문제 1
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("========= 결과 =========");
		int sum = num1 + num2;
		int min = num1 - num2;
		int multi = num1 * num2;
		double div = (double)num1/num2;
		System.out.println("두 수를 더한 수 : "+sum);
		System.out.println("두 수를 뺀 수 : "+min);
		System.out.println("두 수를 곱한 수 : "+multi);
		System.out.printf("두 수를 나눈 수 : %.2f",div);	
	
		
	}

	public void exam8() { // 연습문제 2번
		int a = 40, b = 20;
		a += b;
		System.out.printf("a의 값: %d, b의 값 %d \n",a,b);
		a -= b;
		System.out.printf("a의 값: %d, b의 값 %d \n",a,b);
		b *= a;
		System.out.printf("a의 값: %d, b의 값 %d \n",a,b);
		b /= a;
		System.out.printf("a의 값: %d, b의 값 %d \n",a,b);
	}
	
	public void exam9() { // 연습문제 3번
		int a = 10, b = 20, c = 30, d = 40;
		boolean result1, result2;
		result1 = ((a<20 && b>10) && (c == 20 || d == 40)); // ((true && true) && (false || true) -> true && false  -> flase
		// ((true && !true) || (true && !true)) -> ((true && false) || (true && false)) -> false || false -> false
		result2 = ((a == 10 && b != 2 * 10) || (c == 30 && d != 40)); 
		System.out.printf("첫번째 결과값 : %b \n", result1);
		System.out.printf("두번째 결과값 : %b \n", result2);
		
	}
	
	public void exam10() { // 연습문제 4번
		Scanner sc = new Scanner(System.in);		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		// age 값이 19 보다 큰지 비교하여 true 이면 성인입니다, false 이면 미성년자입니다
		System.out.println(age>19 ? "성인입니다. 어서오세요!" : "미성년자는 입장불가입니다");
	}
	
	public void exam11() { // 연습문제 5-1번
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int math = sc.nextInt(); 
		int sum = kor+eng+math;  
		double avg = sum/3.0; // 정수 타입 sum을 실수 3.0으로 나누어 double 타입 avg로 저장
		System.out.println("합계 : "+sum);
		System.out.printf("평균 : %.2f\n",avg); 
		System.out.println(avg>=60 ? "합격!" : "불합격!");		
		
	}
	
	public void exam12() { // 연습문제 5-2번
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt(); 
		int check = num%2; // num 값을 2로 나눈 나머지 값을 check 변수로 초기화
		// check 값이 0 인지 비교하여 true이면 짝수!, false이면 홀수! 를 출력
		System.out.println(check == 0 ? "짝수!" : "홀수!");
	}
}
