package dh.selenium.crawlbot;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;

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
	private WebDriverWait wait;
	private BufferedWriter bwTxt;

	private String baseUrl = "https://www.melon.com/";

	public void main() {
//		String keyword = null;
//		String genre = null;
//		while (true) {
//			try {
////				genre = getGenre();
//
//			} catch (InputMismatchException e) {
//				System.out.println("잘못된 입력입니다.");
//
//			}
//
//			if (keyword != null && genre != null) {
//				break;
//			} else {
//				System.out.println("잘못된 입력입니다.");
//			}
//
//		}
		
		String keyword = getKeyword();

		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);

		mainSearch(keyword);
		switchLinkTab();
		
		getSongDesc();
	}
	
	public void getSongDesc(){
		webElement = driver.findElement(By.xpath("//*[@id=\"frm_defaultList\"]/div/table/tbody/tr[1]/td[3]/div/div/a[2]"));
		System.out.println(webElement.getText());
	}

	public void mainSearch(String keyword) {
		driver.get(baseUrl);

		webElement = driver.findElement(By.id("top_search"));
		webElement.sendKeys(keyword+Keys.ENTER);

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

				System.out.print("검색할 키워드 : ");
				keyword = br.readLine();
			}
		} catch (InputMismatchException | IOException e) {
			System.out.println("입력 오류");
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

			System.out.print("검색할 장르");
			System.out.println("1. [kpop] - 국내가요");
			System.out.println("2. [pop] - 해외가요");
			System.out.print("선택 > ");
			switch (br.read()) {
			case 1:
				genre = "kpop";
				break;
			case 2:
				genre = "pop";
				break;

			default:
				System.out.println("범위를 벗어난 입력입니다.");
				return null;
			}

		} catch (InputMismatchException | IOException e) {
			System.out.println("입력 오류");
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
