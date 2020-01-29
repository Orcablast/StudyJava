package com.khmarket.run;
import com.khmarket.vo.Goods; //다른 패키지의 Goods class를 import
public class Start {

	public static void main(String[] args) {
		Goods li = new Goods(); // Goods class를 li로 정의함
		li.printList(); // li 내의 printList 메소드를 실행
	}

}
