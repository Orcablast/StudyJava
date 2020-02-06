package kh.java.run;

import kh.java.vo.TV;
import java.util.Scanner;

public class OOPStart {

	public static void main(String[] args) {
		TV tv = new TV();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("TV ��û ���̵�");
			System.out.println("1. ����  on/off ");
			System.out.println("2. ���� ä�� �� ���� Ȯ��");
			System.out.println("3. ä�� +1");
			System.out.println("4. ä�� -1");
			System.out.println("5. ���� +1");
			System.out.println("6. ���� -1");
			System.out.println("7. ä�� �Է�");
			System.out.println("8. ���� �Է�");

			System.out.print("���� > ");
			int slt = sc.nextInt();

			if (!tv.power && slt != 1) {
				System.out.println("������ ���ּ���");
				continue;
			}

			switch (slt) {
			case 1:
				tv.power();
				break;

			case 2:
				System.out.println("ä�� : " + tv.channel);
				System.out.println("���� : " + tv.volume);

				break;

			case 3:
				tv.channelUp();
				System.out.println("���� ä�� : " + tv.channel);
				if (tv.channel == 40) {
					System.out.println("���Ϲ���!!");
				}
				break;

			case 4:
				tv.channelDown();
				System.out.println("���� ä�� : " + tv.channel);
				if (tv.channel == 40) {
					System.out.println("���Ϲ���!!");
				}
				break;

			case 5:
				tv.volumeUp();
				System.out.println("���� ���� : " + tv.volume);
				break;

			case 6:
				tv.volumeDown();
				System.out.println("���� ���� : " + tv.volume);
				break;

			case 7:
				System.out.print("ä���� �Է��ϼ��� : ");
				int inputChn = sc.nextInt();
				tv.inputChannel(inputChn);
				break;

			case 8:
				System.out.print("������ �Է��ϼ��� : ");
				int inputVlm = sc.nextInt();
				tv.inputVolume(inputVlm);
				System.out.println(tv.volume+"�� ���� �����մϴ�");
				break;
				
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�");

			}
		}

		// TV tv = new TV(); // TV ��ü ����
		// TV tv1 = new TV(); // TV ��ü ���� (���ο� TV)

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
