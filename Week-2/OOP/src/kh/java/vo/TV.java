package kh.java.vo;

public class TV {
	// ũ��, ����, ä��, ���� 4�� ����
	// ����, ä��, ���� ���
	private int inch;
	private boolean power;
	private int channel;
	private int volume;
//	private int arr[];
	
	// �⺻������
	public TV() {}
	
	// �Ű����� �ִ� ������
//	public TV(int inch, boolean power, int channel, int volume, int arr[]) {
	public TV(int inch, boolean power, int channel, int volume) {
		this.inch=inch;
		this.power=power;
		this.channel=channel;
		this.volume=volume;
//		this.arr=arr;
	}
	
	
	public TV(int inch) {
		this.inch=inch;				
	}
	
	public TV(int inch, int Channel) {
		
	}
	
	public boolean getPower() {
		return power;
	}
	
	public int getInch() {
		return inch;
	}
	
	public int getChannel() {
		return channel;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void setPower(boolean power) {
		this.power= power;
	}
	
	public void setInch(int inch) {
		this.inch=inch;
	}
	
	public void setVolumn(int volume) {
		this.volume=volume;		
	}
	
	public void setChannel(int channel) {
		this.channel=channel;
	}
	
	
//	
//	
//	public void power() {
//		System.out.println("���� ���");
//		power = !power;
//		if (power) {
//			System.out.println("������ �������ϴ�");
//		} else {
//			System.out.println("������ �������ϴ�");
//		}
//	}
//
//	public void channelUp() {
//		System.out.println("ä�� ��ȣ ����");
//		channel++;
//	}
//
//	public void channelDown() {
//		System.out.println("ä�� ��ȣ ����");
//		channel--;
//	}
//
//	public void volumeUp() {
//		System.out.println("���� ����");
//		volume++;
//	}
//
//	public void volumeDown() {
//		System.out.println("���� ����");
//		volume--;
//	}
//
//	public void inputChannel(int input) {
//		channel = input;
//		System.out.println(channel+"�� �̵��մϴ�");
//		return;
//	}
//	
//	public int inputVolume(int input) {
//		return volume=input;
//	}

}
