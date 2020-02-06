package kh.java.run;

import kh.java.vo.TV;
import java.util.Scanner;

public class OOPStart {

	public static void main(String[] args) {
		TV tv = new TV();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("TV 시청 가이드");
			System.out.println("1. 전원  on/off ");
			System.out.println("2. 현재 채널 및 볼륨 확인");
			System.out.println("3. 채널 +1");
			System.out.println("4. 채널 -1");
			System.out.println("5. 볼륨 +1");
			System.out.println("6. 볼륨 -1");
			System.out.println("7. 채널 입력");
			System.out.println("8. 볼륨 입력");

			System.out.print("선택 > ");
			int slt = sc.nextInt();

			if (!tv.power && slt != 1) {
				System.out.println("전원을 켜주세요");
				continue;
			}

			switch (slt) {
			case 1:
				tv.power();
				break;

			case 2:
				System.out.println("채널 : " + tv.channel);
				System.out.println("볼륨 : " + tv.volume);

				break;

			case 3:
				tv.channelUp();
				System.out.println("현재 채널 : " + tv.channel);
				if (tv.channel == 40) {
					System.out.println("투니버스!!");
				}
				break;

			case 4:
				tv.channelDown();
				System.out.println("현재 채널 : " + tv.channel);
				if (tv.channel == 40) {
					System.out.println("투니버스!!");
				}
				break;

			case 5:
				tv.volumeUp();
				System.out.println("현재 볼륨 : " + tv.volume);
				break;

			case 6:
				tv.volumeDown();
				System.out.println("현재 볼륨 : " + tv.volume);
				break;

			case 7:
				System.out.print("채널을 입력하세요 : ");
				int inputChn = sc.nextInt();
				tv.inputChannel(inputChn);
				break;

			case 8:
				System.out.print("볼륨을 입력하세요 : ");
				int inputVlm = sc.nextInt();
				tv.inputVolume(inputVlm);
				System.out.println(tv.volume+"로 볼륨 변경합니다");
				break;
				
			default:
				System.out.println("잘못 입력하셨습니다");

			}
		}

		// TV tv = new TV(); // TV 객체 생성
		// TV tv1 = new TV(); // TV 객체 생성 (새로운 TV)

		// System.out.println(tv.inch);
		// System.out.println(tv.channel);
		// System.out.println(tv.volume);
		// System.out.println(tv.power);

		// tv.power();
		// System.out.println(tv.power);
		// tv.volumeUp();
		// System.out.println(tv.volume);
		//
		// System.out.println(tv1.volume);

	}

}
