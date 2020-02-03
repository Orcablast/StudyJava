package kh.java.func;
import java.util.Scanner;


public class Example2 { // Chapter 조건문
	public void exam1() {
		Scanner sc = new Scanner(System.in); // Scanner를 약어 sc로 정의
		System.out.println("10을 입력하세요 : "); 
		int inputNumber = sc.nextInt(); // 사용자가 입력한 값을  변수 inputNumber로 선언
		if (inputNumber == 10) { // inputNumber == 10 의 값이 true일때
			System.out.println("참 잘했어요"); // if 조건문이 true 일때 문자열을 출력
		}
	}

	public void exam2() { // 조건문 연습문제 1
		Scanner sc = new Scanner(System.in);
		System.out.println("======== 숫자 구별 프로그램 =========");
		System.out.print("임의의 정수를 입력하세요 : ");
		int inputNumber = sc.nextInt(); 
		if(inputNumber > 0) { // 조건문 inputNumber > 0의 값이 true 이면 중괄호 안의 명령어를 실행
			System.out.printf("당신이 입력한 수 %d은(는) 양수입니다",inputNumber);
		}
		if(inputNumber == 0 ) { // 조건문 inputNumber == 0 의 값이 true 이면 중괄호 안의 명령어를 실행
			System.out.printf("당신이 입력한 수 %d은(는) 0입니다",inputNumber);
		}
		if(inputNumber < 0 ) { // 조건문 inputNumber < 0 의 값이 true 이면 중괄호 안의 명령어를 실행
			System.out.printf("당신이 입력한 수 %d은(는) 음수입니다",inputNumber);
		}
//		System.out.printf(inputNumber>0 ? "당신이 입력한 수 %은(는) 양수입니다":(inputNumber==0 ? "당신이 입력한 수 %d은(는) 0입니다":"당신이 입력한 수 %d은(는) 음수입니다"),inputNumber,inputNumber,inputNumber);
	}
	
	public void exam3() { // 조건문 연습문제 2
		Scanner sc = new Scanner(System.in);
		System.out.println("======== 두수 비교 프로그램 =========");
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		if (num1<num2) { 
			System.out.printf("%d<%d\n두번째 수가 더 큽니다.",num1,num2);
		}
		if (num1==num2) {
			System.out.printf("%d=%d\n두수가 같습니다.",num1,num2);
		}
		if (num1>num2) {
			System.out.printf("%d>%d\n첫번째 수가 더 큽니다.",num1,num2);
		}		
	}
	
	public void exam4() { // 조건문 연습문제 3
		Scanner sc = new Scanner(System.in);
		System.out.println("======== 계산기 프로그램 =========");
		System.out.print("연산자를 입력하세요 (+,-,*,/) : ");
		char operator = sc.next().charAt(0); // 입력한 문자열의 0번째 문자를 char 타입 operator 변수로 선언 
		System.out.print("첫번째 정수를 입력 하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력 하세요 : ");
		int num2 = sc.nextInt();
		
		if (operator == '+') { // 변수 operator의 값과 문자 '+'의 값이 같으면 (true) 중괄호 내의 명령어를 실행
			int sum = num1+num2;
			System.out.printf("%d %c %d = %d",num1,operator,num2,sum);			
		}
		if (operator == '-') { // 변수 operator의 값과 문자 '-'의 값이 같으면 (true) 중괄호 내의 명령어를 실행
			int min = num1-num2;
			System.out.printf("%d %c %d = %d",num1,operator,num2,min);			
		}
		if (operator == '*') { // 변수 operator의 값과 '*'의 값이 같으면 (true) 중괄호 내의 명령어를 실행
			int multi = num1*num2;
			System.out.printf("%d %c %d = %d",num1,operator,num2,multi);			
		}
		if (operator == '/') { // 변수 operator의 값과 '/'의 값이 같으면 (true) 중괄호 내의 명령어를 실행
			double div = (double)num1/num2;
			System.out.printf("%d %c %d = %.6f",num1,operator,num2,div);		
		}
		
		
		
	}
	
	public void exam5() { // 혼자 연습...
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.println(num>=1000 ? "1000보다 큰값이네요":(num>=100 ? "100보다는 큰값이네요":(num>=10 ? "10보다 큰 값이네요":"10보다 작은 값이네요")));
//		if (num>1000) {
//			System.out.println("1000보다 큰 값이네요");
//		}
//		if (num>100) {
//			System.out.println("100보다 큰 값이네요");
//		}
//		if (num>10) {
//			System.out.println("10보다 큰 값이네요");
//		}
//		if (num>1) {
//			System.out.println("1보다 큰 값이네요");
//		}
	}
	
	public void exam6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		if(num%2==0) {
			System.out.println("짝수입니다");
		} else {
			System.out.println("홀수입니다");
		}
//		if(num%2==0) {
//			System.out.println("짝수입니다");
//		} 
//		if(num%2!=0){
//			System.out.println("홀수입니다");
//		}
	}
	
	public void exam7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== 놀이공원 프로그램 ==========");
		System.out.print("입장하실 총 인원은 몇명입니까? : ");
		int numPeople = sc.nextInt(); 
		System.out.print("어른은 몇명입니까? (1인당 15,000원) : ");
		int numMan = sc.nextInt();
		System.out.print("아이는 몇명입니까? (1인당 5,000원) : ");
		int numChild = sc.nextInt(); 
		int money = (numMan*15000)+(numChild*5000); 		
		if(numPeople == (numMan+numChild)) {
			System.out.printf("지불하실 총 금액은 %d원 입니다",money);
		} else {
			System.out.println("인원수가 맞지 않습니다.");			
		}
		
		
	}
	
	public void exam8() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== 퀴즈 프로그램 ==========");
		System.out.println("첫번째 퀴즈");
		System.out.print("사과는 영어로 무엇일까요? (1.Apple 2.스티브 잡스) : ");
		int answerCount = 0;
		int answer1 = sc.nextInt();
		if(answer1==1) {
			answerCount++;
			System.out.println("정답!!!");
		} else {
			System.out.println("땡!!");
		}
		System.out.println("--------------------------------");
		System.out.println("두번째 퀴즈");
		System.out.print("바나나는 길어 길으면 기차 기차는? (1.비싸 2.빨라) : ");
		int answer2= sc.nextInt();			
		if(answer2==2) {
			answerCount++;
			System.out.println("정답!!!");
		} else {
			System.out.println("땡!!");
		}
		System.out.printf("총 %d문제를 맞췄습니다!",answerCount);
		
		
	}
	
	public void exam9() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== 심리테스트 ==========");
		System.out.print("당신은 술을 좋아하십니까? (1.Yes 2.No) : ");
		int answ1 = sc.nextInt();
		if (answ1==1) {
			System.out.print("당신은 담배를 피우십니까? (1.Yes 2.No) : ");
			int answ2 = sc.nextInt();
			if (answ2==1) {
				System.out.println("담배는 건강에 좋지 않습니다");
			} else {
				System.out.println("술은 간에 좋지 않습니다.");
			}
		} else {
			System.out.print("당신은 이성친구가 있습니까? (1.Yes 2.No) : ");
			int answ3 = sc.nextInt();
			if(answ3==1) {
				System.out.println("올 ㅋㅋ");
			} else {
				System.out.println("힘내요 ㅠㅠ");
			}
		} 
	}
}
