package kr.or.iei.exfunc;

public class func {
	public void exam1() {
		int num1 = 100; // num1 변수의 값을 100으로 선언
		long num2 = 999999999999L; // num2 변수의 값을 999999999999로 선언
		float num3 = 486.520f; // num3 변수의 값을 486.520 로 선언
		double num4 = 5697.890123; // num4 변수의 값을 5697.890123 로 선언
		char str1 = 'A'; // str1 변수의 값을 문자 A로 선언
		String str2 = "Hello JAVA"; // str2 변수의 값을 문자열 HELLO JAVA로 선언
		boolean bool = true; // bool 변수의 값을 논리값 true로 선언
		System.out.println(num1); // 변수 num1에 저장된 정수을 출력
		System.out.println(num2); // 변수 num2에 저장된 정수을 출력
		System.out.println(num3); // 변수 num3에 저장된 실수를 출력
		System.out.println(num4); // 변수 num4에 저장된 실수를 출력
		System.out.println(str1); // 변수 str1에 저장된 문자를 출력
		System.out.println(str2); // 변수 str2에 저장된 문자열을 출력
		System.out.println(bool+"\n\n"); // 변수 bool에 저장된 값을 출력하고 행을 2개 개행
	}
	
	public void exam2() {
		String name1 = "이도형";
		String name2 = "장수빈";
		int age1 = 30;
		int age2 = 30;
		char gender1 = '남';
		char gender2 = '여';
		String address1 = "부천";
		String address2 = "서울";
		String phnum1 = "01071175271";
		String phnum2 = "01093636623";
		String emailadr1 = "dbro0423@gmail.com";
		String emailadr2 = "bloodred15@naver.com";
		System.out.printf("이름\t나이\t성별\t지역\t전화번호\t\t이메일\n");
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
