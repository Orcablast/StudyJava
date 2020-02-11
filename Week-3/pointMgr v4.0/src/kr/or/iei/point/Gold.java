package kr.or.iei.point;

public class Gold extends Grade { // Silver�� ����Ŭ������ ������ ���� Ŭ���� Gold

	public Gold() { // ���� Ŭ���� Gold�� �⺻ ������
		super();
	}
	
	public Gold(String name, String grade, int point) { // ���� Ŭ���� Gold�� �Ű����� ������
		super(name, grade, point); // Gold Ŭ������ �Ű������� ���� Ŭ���� �Ű����� ������ �̿�
	}
	
	@Override // ������ �ּ� �������̵�
	public double getBonus() { // ���� Ŭ������ getBonus �޼ҵ带 �������̵�
		return getPoint()*0.05; // return���� ������ 0.05�� �������̵�
	}
}
