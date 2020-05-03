package dh.selenium.run;

import java.io.FileNotFoundException;
import java.io.IOException;

import dh.selenium.crawlbot.songCrawler;

public class Start {

	public static void main(String[] args) {
		
		try {
			new songCrawler().main();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
