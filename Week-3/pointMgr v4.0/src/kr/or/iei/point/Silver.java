package kr.or.iei.point;

public class Silver extends Grade {
	
	public Silver() {
		super();
	} // �⺻ ������
	
	public Silver(String name, String grade, int point) { // �Ű����� ������
		super(name,grade,point);
	}
	
	@Override
	public double getBonus() { // int Ÿ�� ������� point�� �����Ͽ� double Ÿ�� �ڷ����� ��ȯ�ϴ� �޼ҵ�
		return getPoint()*0.02;
	}
	
}
