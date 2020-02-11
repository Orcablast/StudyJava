package kr.or.iei.point;

public class Silver {
	
	private String name; // ���ڿ� ������� name
	private String grade; // ���ڿ� ������� grade
	private int point; // ���� ������� point
	
	public Silver() {} // �⺻ ������
	
	public Silver(String name, String grade, int point) { // �Ű����� ������
		this.name=name; // ������� name�� �Ű����� name���� ����
		this.grade=grade; // ������� grade�� �Ű����� grade���� ����
		this.point=point; // ������� point�� �Ű����� point���� ����
	}
	
	
	// getter
	public String getName() { // String Ÿ�� ������� name�� ��ȯ�ϴ� �޼ҵ�
		return name; 
	}
	
	public String getGrade() { // String Ÿ�� ������� grade�� ��ȯ�ϴ� �޼ҵ�
		return grade;
	}
	
	public int getPoint() { // int Ÿ�� ������� point�� ��ȯ�ϴ� �޼ҵ�
		return point;
	}
	
	public double getBonus() { // int Ÿ�� ������� point�� �����Ͽ� double Ÿ�� �ڷ����� ��ȯ�ϴ� �޼ҵ�
		return point*0.02;
	}
	
	// setter	
	public void setName(String name) { // ������� name�� �Ű����� name���� ����
		this.name = name;
	}
	
	public void setGrade(String grade) { // ������� grade�� �Ű����� grade���� ����
		this.grade = grade;
	}
	
	public void setPoint(int point) { // ������� point�� �Ű����� point���� ����
		this.point = point;
	}
	
}
