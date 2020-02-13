package kh.java.run;

import kh.java.test.Animal;
import kh.java.test.AnimalMgr2;
import kh.java.test.Bear;
import kh.java.test.Tiger;

public class Start {
	public static void main(String[] args) {
			
		
		
		AnimalMgr2<Animal> am1 = new AnimalMgr2<Animal>(new Animal());
		AnimalMgr2<Tiger> am2 = new AnimalMgr2<Tiger>(new Tiger());
//		AnimalMgr2<Bear> am3 = new AnimalMgr2<Bear>(new Bear());
		
		
		
		
		
//		//hp가 1000인 Tiger 객체의 주소를 t로 선언
//		Tiger t = new Tiger(1000);
//		Bear b = new Bear(2000);
//		
//			
//		// AnimalMgr생성자의 매개변수 타입은 Object
//		// 다형성에 의해 Tiger객체의 주소가 Object 타입 변수에 저장
//		AnimalMgr am1 = new AnimalMgr(t);
//		AnimalMgr am2 = new AnimalMgr(b);
//		
//		// 현재 am1에 data 변수에 있는 값을 가져옴
//		// getData()의 자료형은 Object
//		// 주소는 Tiger 객체의 주소가 들어있음
//		Object obj1 = am1.getData();
//		Object obj2 = am2.getData();
//		
//		// 해당객체는 Tiger 객체이지만 자료형이 Object이므로 getHp() 메소드 호출 불가
//		// obj.getHp(); X
//		// -> 다운 캐스팅을 통해 자료형을 Tiger로 형변환
//		((Tiger)obj1).getHp();
//		((Bear)obj2).getHp();
		
		
		
		// generics 적용
//		AnimalMgr2<Tiger> a1 = new AnimalMgr2<Tiger>(t);
//		AnimalMgr2<Bear> b1 = new AnimalMgr2<Bear>(b);
//		
//		a1.getData().getHp();
//		b1.getData().getHp();
//		
		
		
	}

}
