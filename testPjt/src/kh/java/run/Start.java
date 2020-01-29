package kh.java.run;
import kh.java.func.PrintMsg; //다른 패키지의 PrintMsg 클래스를 import
public class Start {

	public static void main(String[] args) {
		PrintMsg pm = new PrintMsg(); //PrintMsg 클래스를 pm으로 정의
		pm.test2(); // pm내의 test2 메소드 실행
	}

}
