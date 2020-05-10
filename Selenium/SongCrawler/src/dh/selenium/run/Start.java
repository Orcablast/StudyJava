package dh.selenium.run;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import dh.selenium.crawlbot.songCrawler;
import dh.txt.txtFunc;

public class Start {

	public static void main(String[] args) {
		txtFunc txtFunc = new txtFunc();
		songCrawler crawler = new songCrawler();
		
		
		Scanner sc = new Scanner(System.in);


		while (true) {
			System.out.println("1. �˻�");
			System.out.println("2. �ߺ�����");
			System.out.println("3. ������ ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� > ");

			switch (sc.nextInt()) {
			case 1:
				try {
					crawler.main();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 2:
				txtFunc.cleanDups();
				txtFunc.writeAlbum();
				txtFunc.writeArtist();
				break;

			case 3:				
				
				txtFunc.writeSongQuerys();
				break;

			case 0:
				System.out.println("�����մϴ�.");
				sc.close();
				return;

			default:
				System.out.println("�߸��� �Է�");

			}
		}
	}

}
