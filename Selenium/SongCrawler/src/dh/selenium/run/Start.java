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
			System.out.println("1. 검색");
			System.out.println("2. 중복제거");
			System.out.println("3. 쿼리문 생성");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");

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
				System.out.println("종료합니다.");
				sc.close();
				return;

			default:
				System.out.println("잘못된 입력");

			}
		}
	}

}
