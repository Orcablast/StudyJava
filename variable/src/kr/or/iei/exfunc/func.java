package kr.or.iei.exfunc;

public class func {
	public void exam1() {
		int num1 = 100;
		long num2 = 999999999999L;
		float num3 = 486.520f;
		double num4 = 5697.890123;
		char str1 = 'A';
		String str2 = "Hello JAVA";
		boolean bool = true;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(bool+"\n\n");
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
		String cut1 = "--------------------------------------------------------------------";
		String cut2 = "----------------------------------";
		System.out.printf("이름\t나이\t성별\t지역\t전화번호\t\t이메일\n");
		System.out.println(cut1);
		System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t\n",name1,age1,gender1,address1,phnum1,emailadr1);
		System.out.println(cut2+cut2);
		System.out.println(name2+"\t"+age2+"\t"+gender2+"\t"+address2+"\t"+phnum2+"\t"+emailadr2);
		
	}
	

}
