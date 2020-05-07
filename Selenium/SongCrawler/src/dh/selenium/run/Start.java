package dh.selenium.run;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import dh.selenium.crawlbot.songCrawler;
import dh.txt.txtFunc;

public class Start {

	public static void main(String[] args) {
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("songsRawData.txt",true));
			new songCrawler().main(bw);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		
	}

}
