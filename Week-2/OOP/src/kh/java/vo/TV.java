package kh.java.vo;

public class TV {
	// 크기, 전원, 채널, 볼륨 4개 변수
	// 전원, 채널, 볼륨 기능
	private int inch;
	private boolean power;
	private int channel;
	private int volume;
//	private int arr[];
	
	// 기본생성자
	public TV() {}
	
	// 매개변수 있는 생성자
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
//		System.out.println("전원 기능");
//		power = !power;
//		if (power) {
//			System.out.println("전원이 켜졌습니다");
//		} else {
//			System.out.println("전원이 꺼졌습니다");
//		}
//	}
//
//	public void channelUp() {
//		System.out.println("채널 번호 증가");
//		channel++;
//	}
//
//	public void channelDown() {
//		System.out.println("채널 번호 감소");
//		channel--;
//	}
//
//	public void volumeUp() {
//		System.out.println("볼륨 증가");
//		volume++;
//	}
//
//	public void volumeDown() {
//		System.out.println("볼륨 감소");
//		volume--;
//	}
//
//	public void inputChannel(int input) {
//		channel = input;
//		System.out.println(channel+"로 이동합니다");
//		return;
//	}
//	
//	public int inputVolume(int input) {
//		return volume=input;
//	}

}
