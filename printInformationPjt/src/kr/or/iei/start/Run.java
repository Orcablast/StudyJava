package kr.or.iei.start;
import kr.or.iei.vo.Information; 
//다른 패키지에 있는 Information 클래스를 현재 클래스로 import
public class Run {

	public static void main(String[] args) {
		Information im = new Information();
		//Information 클래스를 im 이라는 약어로 Object(?)를 생성
		im.printInfo();
		//im 내의 printInfo 메소드 실행
	}

}
