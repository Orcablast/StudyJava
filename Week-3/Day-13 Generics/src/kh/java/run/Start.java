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
		
		
		
		
		
//		//hp�� 1000�� Tiger ��ü�� �ּҸ� t�� ����
//		Tiger t = new Tiger(1000);
//		Bear b = new Bear(2000);
//		
//			
//		// AnimalMgr�������� �Ű����� Ÿ���� Object
//		// �������� ���� Tiger��ü�� �ּҰ� Object Ÿ�� ������ ����
//		AnimalMgr am1 = new AnimalMgr(t);
//		AnimalMgr am2 = new AnimalMgr(b);
//		
//		// ���� am1�� data ������ �ִ� ���� ������
//		// getData()�� �ڷ����� Object
//		// �ּҴ� Tiger ��ü�� �ּҰ� �������
//		Object obj1 = am1.getData();
//		Object obj2 = am2.getData();
//		
//		// �ش簴ü�� Tiger ��ü������ �ڷ����� Object�̹Ƿ� getHp() �޼ҵ� ȣ�� �Ұ�
//		// obj.getHp(); X
//		// -> �ٿ� ĳ������ ���� �ڷ����� Tiger�� ����ȯ
//		((Tiger)obj1).getHp();
//		((Bear)obj2).getHp();
		
		
		
		// generics ����
//		AnimalMgr2<Tiger> a1 = new AnimalMgr2<Tiger>(t);
//		AnimalMgr2<Bear> b1 = new AnimalMgr2<Bear>(b);
//		
//		a1.getData().getHp();
//		b1.getData().getHp();
//		
		
		
	}

}
