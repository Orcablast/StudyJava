package kh.java.wrap;

public class Wrap {
	
	public void wrapTest() {
		// 기본형
		// boolean, char, byte, short, int , long, float, double
		// java.lang 패키지에 포함
		
		Boolean bool= new Boolean(true);
		
		Character ch = new Character('a');
		
		Byte bNum = new Byte((byte)1);
		
		Short sNum = new Short((short)1);
		
		Integer iNum = new Integer(4);
		
		Long lNum = new Long(8L);
		
		Float fNum = new Float(0.5f);
		
		Double dNum = new Double(0.77);
		
		
	}
	
	public void wrapExam() {

		Integer num = new Integer(10);
		
		int n = num.intValue();
		System.out.println(n);
		
		Double dd = new Double(3.14);
		double d = dd.doubleValue();
		
		System.out.println(d);
		
		// auto boxing
		Integer num1 = 100;
		// auto unboxing
		System.out.println(num1);
		
		
		// 문자열 -> 기본 자료형
		
		String data = "999";
		int num3 = Integer.parseInt(data);
		
		String data1 = "3.14";
		double num4 = Double.parseDouble(data1);
		
		String data3 = "ABCD";
		char ch1 = data3.charAt(0);
		char ch2 = data3.charAt(1);
				
	
		
		// 기본 자료형 -> 문자열
		
		int num5 = 999;
		
		// Integer 이용
		
		String data4 = Integer.valueOf(num5).toString();
		String data5 = String.valueOf(num5);
		
		double num6 = 3.14;
		
		String data6 = Double.valueOf(num6).toString();
		String data7 = String.valueOf(num6);
		
		char ch3 = 'a';
		
		String data8 = String.valueOf(ch3);
		String data9 = Character.valueOf(ch3).toString();
		
		
		
				
		
	}

}
