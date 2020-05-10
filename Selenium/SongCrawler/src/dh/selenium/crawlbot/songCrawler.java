package dh.selenium.crawlbot;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dh.txt.txtFunc;

public class songCrawler {

	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";

	private WebDriver driver;
	private WebElement webElement;
	private java.util.List<WebElement> webElements;
	private WebDriverWait wait;
	private StringBuffer sb;
	private String genre;
	private String baseUrl = "https://www.melon.com/";

	public void main() throws IOException {

		genre = getGenre();

		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 1);

		BufferedWriter bw = null;

		String keyword = new txtFunc().getKeyword();

		while (keyword != null) {

			sb = new StringBuffer();
			mainSearch(keyword);

			switchLinkTab();

			while (true) {
				int pageNum = 0;

				while (pageNum == 0) {

					try {
						pageNum = wait.until(ExpectedConditions
								.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"pageObjNavgation\"]/div/span/a")))
								.size();

					} catch (Exception e) {
						System.out.println("pageNum 색인불가 재검색");
						continue;
					}
					break;
				}

				for (int i = 1; i <= pageNum + 1; i++) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					while (true) {
						try {
							webElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
									By.xpath("//*[@id=\"frm_defaultList\"]/div/table/tbody/tr")));

						} catch (Exception e) {
							try {
								Thread.sleep(300);
								continue;
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

						break;
					}

					for (WebElement w : webElements) {

						if (w.getAttribute("class").equals("no_result")) {
							break;
						}
						getSongDesc(w);
					}

					if (i != pageNum + 1) {
						driver.findElement(By.xpath("//*[@id=\"pageObjNavgation\"]/div/span/a[" + i + "]")).click();
					}
				}

				try {
					Thread.sleep(500);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				while (true) {
					try {
						webElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
								By.xpath("//*[@id=\"frm_defaultList\"]/div/table/tbody/tr")));

					} catch (Exception e) {
						try {
							Thread.sleep(300);
							continue;
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

					break;
				}

				for (WebElement w : webElements) {

					if (w.getAttribute("class").equals("no_result")) {
						break;
					}
					getSongDesc(w);
				}

				if (nextPagesLoad() == -1) {
					break;
				}
			}

			try {
				bw = new BufferedWriter(new FileWriter("songsRawData.txt", true));
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} finally {
				try {
					bw.write(sb.toString());
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println(keyword + "검색 완료");

			new txtFunc().setKeyword(keyword);
			keyword = new txtFunc().getKeyword();
		}
	}

	public int nextPagesLoad() {

		webElement = null;

		while (webElement == null) {
			try {
				webElement = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[@id=\"pageObjNavgation\"]/div/a[3]")));

			} catch (Exception e) {
				System.out.println("다음 페이지 버튼 비활성화");
				continue;
			}
			break;
		}

		if (webElement.getAttribute("class").contains("disabled")) {
			System.out.println(webElement.getAttribute("class"));
			return -1;
		} else {
			webElement.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		}

	}

	public void getSongDesc(WebElement w) throws IOException {

		String title = w.findElement(By.xpath("./td[3]/div/div/a[2]")).getText();

		String artist = new StringTokenizer(
				w.findElement(By.xpath("//*[@id=\"artistName\"]/span/a")).getAttribute("title"), " - ").nextToken();

		String album = w.findElement(By.xpath("./td[5]/div/div/a")).getAttribute("title");
		String albumName = album.substring(0, album.indexOf(" - "));

		String likes = w.findElement(By.xpath("./td[6]/div/button/span[2]")).getText();
		StringTokenizer sT = new StringTokenizer(likes, ",");
		int likeCnt = getLikeCnt(sT);
		System.out.println(title + "^" + artist + "^" + albumName + "^" + likeCnt);
		sb.append(title + "^" + artist + "^" + albumName + "^" + likeCnt + "^" + genre + "\r\n");

	}

	public int getLikeCnt(StringTokenizer sT) {
		String str = "";

		while (sT.hasMoreTokens()) {
			str += sT.nextToken();
		}

		return Integer.parseInt(str);
	}

	public void mainSearch(String keyword) {
		driver.get(baseUrl);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webElement = driver.findElement(By.id("top_search"));
		webElement.sendKeys(keyword + Keys.ENTER);

	}

	public void switchLinkTab() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/div[1]/div[2]/ul/li[3]/a"));
		webElement.click();

	}

	public String getGenre() {

		Scanner sc = new Scanner(System.in);

		System.out.println("1. 국내가요");
		System.out.println("2. 해외가요");
		System.out.print("선택 > ");

		String genre = null;

		while (genre == null) {

			switch (sc.nextInt()) {
			case 1:
				genre = "kpop";
				break;

			case 2:
				genre = "pop";
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
				
		sc.close();

		return genre;
	}

}
