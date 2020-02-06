package kh.java.vo;

public class TV {
	// 크기, 전원, 채널, 볼륨 4개 변수
	// 전원, 채널, 볼륨 기능
	public int inch = 120;
	public boolean power = false;
	public int channel = 1;
	public int volume = 0;

	public void power() {
		System.out.println("전원 기능");
		power = !power;
		if (power) {
			System.out.println("전원이 켜졌습니다");
		} else {
			System.out.println("전원이 꺼졌습니다");
		}
	}

	public void channelUp() {
		System.out.println("채널 번호 증가");
		channel++;
	}

	public void channelDown() {
		System.out.println("채널 번호 감소");
		channel--;
	}

	public void volumeUp() {
		System.out.println("볼륨 증가");
		volume++;
	}

	public void volumeDown() {
		System.out.println("볼륨 감소");
		volume--;
	}

	public void inputChannel(int input) {
		channel = input;
		System.out.println(channel+"로 이동합니다");
		return;
	}
	
	public int inputVolume(int input) {
		return volume=input;
	}

}
