package kr.or.iei.point;

public class Vip extends Silver {
	// ������
	public Vip() {}
	
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getBonusP() {
		return getPoint()*0.07; // point�� ���� ������ �Ұ��Ͽ� getter ���
	}

}
