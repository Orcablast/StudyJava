package kh.java.vo;

public class TV {
	// ũ��, ����, ä��, ���� 4�� ����
	// ����, ä��, ���� ���
	public int inch = 120;
	public boolean power = false;
	public int channel = 1;
	public int volume = 0;

	public void power() {
		System.out.println("���� ���");
		power = !power;
		if (power) {
			System.out.println("������ �������ϴ�");
		} else {
			System.out.println("������ �������ϴ�");
		}
	}

	public void channelUp() {
		System.out.println("ä�� ��ȣ ����");
		channel++;
	}

	public void channelDown() {
		System.out.println("ä�� ��ȣ ����");
		channel--;
	}

	public void volumeUp() {
		System.out.println("���� ����");
		volume++;
	}

	public void volumeDown() {
		System.out.println("���� ����");
		volume--;
	}

	public void inputChannel(int input) {
		channel = input;
		System.out.println(channel+"�� �̵��մϴ�");
		return;
	}
	
	public int inputVolume(int input) {
		return volume=input;
	}

}
