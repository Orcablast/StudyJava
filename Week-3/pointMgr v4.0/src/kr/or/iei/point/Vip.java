package kr.or.iei.point;

public class Vip extends Grade{ // Gold Ŭ������ ����Ŭ������ ������ ����Ŭ���� Vip
	
	public Vip() { // ����Ŭ���� Vip�� �⺻������
		super();
	}
	
	public Vip(String name, String grade, int point) { // Vip�� �Ű����� ������
		super(name, grade, point); // ����Ŭ������ �Ű����� �����ڿ� ���� �Ű������� ����
	}
	
	@Override // ������ �ּ� �������̵�
	public double getBonus() { // ���� Ŭ������ getBonus �޼ҵ带 �������̵�
		return getPoint()*0.07; // getBonus�� ���갪�� 0.07�� ����
	}

}
