package kr.or.iei.point;

public class Gold extends Silver{
	// grade ����, name ����, point ����
	// getter, setter ��� �Ϸ�
	
	public Gold() {
		super();
	}
	
	public Gold(String name, String grade, int point) {		
		super(name, grade, point); // �θ� �����ڿ� �Ű������� ����, �ݵ�� ������ ù�ٿ� ��ġ		
		
	}
	
	@Override
	public double getBonusP() {
		return 0.05*getPoint(); // point�� ���� ������ �Ұ��Ͽ� getter ���
	}
}
