package dh.selenium.crawlbot;

import java.awt.List;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;

public class songCrawler {

	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";

	private WebDriver driver;
	private WebElement webElement;
	private java.util.List<WebElement> webElements;
	private WebDriverWait wait;
	private BufferedWriter bw;
	private JavascriptExecutor js;
	private StringBuffer sb = new StringBuffer();

	private String baseUrl = "https://www.melon.com/";

	public void main() throws IOException {
//		String keyword = null;
//		String genre = null;
//		while (true) {
//			try {
////				genre = getGenre();
//
//			} catch (InputMismatchException e) {
//				System.out.println("�߸��� �Է��Դϴ�.");
//
//			}
//
//			if (keyword != null && genre != null) {
//				break;
//			} else {
//				System.out.println("�߸��� �Է��Դϴ�.");
//			}
//
//		}

		String keyword = getKeyword();

		bw = new BufferedWriter(new FileWriter(keyword+".txt"));

		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 1);
		js = (JavascriptExecutor) driver;

		mainSearch(keyword);
		switchLinkTab();

		while (true) {
			int pageNum = 0;
			
			while(pageNum == 0) {
				
				try {
					pageNum = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"pageObjNavgation\"]/div/span/a"))).size();
					
				} catch (Exception e) {
					System.out.println("pageNum ���κҰ� ��˻�");
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

					if(w.getAttribute("class").equals("no_result")) {
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
				

				if(w.getAttribute("class").equals("no_result")) {
					break;
				}
				getSongDesc(w);
			}

			bw.write(sb.toString());
			if (nextPagesLoad() == -1) {
				break;
			}
		}

		bw.close();
		System.out.println("�˻� �Ϸ�");
	}

	public int nextPagesLoad() {
		
		webElement = null;
		
		while(webElement == null) {
			try {
				webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"pageObjNavgation\"]/div/a[3]")));

			} catch (Exception e) {
				System.out.println("���� ������ ��ư ��Ȱ��ȭ");
				continue;
			}
			break;
		}
		

		if (webElement.getAttribute("class").contains("disabled")) {
			System.out.println(webElement.getAttribute("class"));
			return -1;
		} else {
			webElement.click();
			return 1;
		}

	}

	public void getSongDesc(WebElement w) throws IOException {
		

		String title = w.findElement(By.xpath("./td[3]/div/div/a[2]")).getText();

		String artist = new StringTokenizer(
				w.findElement(By.xpath("//*[@id=\"artistName\"]/span/a")).getAttribute("title"), " - ").nextToken();

		String album = w.findElement(By.xpath("./td[5]/div/div/a")).getAttribute("title");
		String albumName = album.substring(0, album.indexOf(" - "));

		System.out.println(title + "^" + artist + "^" + albumName);
		sb.append(title + "^" + artist + "^" + albumName + "\r\n");

	}

	public void mainSearch(String keyword) {
		driver.get(baseUrl);

		webElement = driver.findElement(By.id("top_search"));
		webElement.sendKeys(keyword + Keys.ENTER);

	}

	public void switchLinkTab() {

		webElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/div[1]/div[2]/ul/li[3]/a"));
		webElement.click();

	}

	public String getKeyword() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String keyword = null;

		try {
			while (keyword == null) {

				System.out.print("�˻��� Ű���� : ");
				keyword = br.readLine();
			}
		} catch (InputMismatchException | IOException e) {
			System.out.println("�Է� ����");
			return null;
		} finally {
			try {
				br.close();
				br = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return keyword;
	}

	public String getGenre() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String genre = null;

		try {

			System.out.print("�˻��� �帣");
			System.out.println("1. [kpop] - ��������");
			System.out.println("2. [pop] - �ؿܰ���");
			System.out.print("���� > ");
			switch (Integer.parseInt(br.readLine())) {
			case 1:
				genre = "kpop";
				break;
			case 2:
				genre = "pop";
				break;

			default:
				System.out.println("������ ��� �Է��Դϴ�.");
				return null;
			}

		} catch (InputMismatchException | IOException e) {
			System.out.println("�Է� ����");
			return null;
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return genre;
	}

}
