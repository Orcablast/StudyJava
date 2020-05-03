package himart.test.func;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testFunc {
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/chromedriver.exe";
	
	private WebDriver driver;
	private WebElement webElement;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	public String baseUrl = "http://www.e-himart.co.kr/";
	
	
	
	private String userId = "ldh5271";
	private String userPw = "L#d4h594688";
	
	public void getUserInfo() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			char fin = 'n';
			while(fin == 'n') {
				System.out.print("ID 입력 : ");
				userId = br.readLine();
				System.out.print("PW 입력 : ");
				userPw = br.readLine();
				
				System.out.print("이대로 진행하시겠습니까? [ y(진행) / n(다시입력) ] : ");
				fin = br.readLine().charAt(0);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setUpLogin() {


		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		try {
			Runtime.getRuntime().exec("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe --remote-debugging-port=9222 --user-data-dir=\"C:/selenum/AutomationProfile\"");
		} catch (IOException e) {
			System.out.println("Chrome 설치 경로가 잘못되었습니다.");
			e.printStackTrace();
		}

		ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor)driver;	
        wait = new WebDriverWait(driver, 1);
        
        driver.get("http://www.e-himart.co.kr/");
        
        webElement = driver.findElement(By.id("loginArea"));
        
        if(webElement.getText().equals("로그인")) {
        	webElement.click();
        	
        	webElement = driver.findElement(By.id("ssoId"));
        	webElement.sendKeys(userId);
        	
        	webElement = driver.findElement(By.id("ssoPw"));
        	webElement.sendKeys(userPw);
        	
        	webElement = driver.findElement(By.id("sso"));
        	webElement.click();
        	
        	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        
        
	}
	
	public void main() {
		ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);
        
        baseUrl = "http://www.e-himart.co.kr/app/goods/goodsDetail?goodsNo=0006295851"; // 동디션 패키지
//		baseUrl = "http://www.e-himart.co.kr/app/goods/goodsDetail?goodsNo=0006295864"; // 동숲 타이틀 링크
//		baseUrl = "http://www.e-himart.co.kr/app/goods/goodsDetail?goodsNo=0001077642"; // 테스트 링크1 품절
//		baseUrl = "http://www.e-himart.co.kr/app/goods/goodsDetail?goodsNo=0004177126"; // 테스트 링크2 구매가능
        
		while(true) {
			driver.get(baseUrl);
			try {
				if(wait.until(ExpectedConditions.alertIsPresent()) != null) {
					System.out.println("저기 얼럿있네");
					driver.switchTo().alert().accept();
				}
				
			} catch (Exception e) {
				break;
			}
			continue;
		}
        clickBuy();
	}
	
	public void clickBuy() {
		wait = new WebDriverWait(driver, 10);
		
		while(true) {
			try {
				webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("orderBtnArea")));
				webElement = driver.findElement(By.className("btnOrder"));
			} catch (Exception e) {
				System.out.println("구매하기 버튼이 활성화 되지 않음");
				driver.get(baseUrl);
				continue;
			}
			
			break;
		}
		
		webElement.click();		
		
		// 로딩이 오래걸릴수 있음
		
		webElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("abPaySP")));
		js.executeScript("arguments[0].click();", webElement);
		
		webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("abAgreeB2")));		
		js.executeScript("arguments[0].click();", webElement);
		
		webElement = driver.findElement(By.cssSelector("option[value='03:Y']"));
		js.executeScript("arguments[0].selected = 'true';", webElement);
		
		
		// 결제하기 버튼 비활성화 시간 오래걸릴 수 있으므로 고려해야함
		
		while(true) {
			
			try {
				
				webElement = driver.findElement(By.id("doPaybutton0"));		
				js.executeScript("arguments[0].click();", webElement);				
				
			} catch (Exception e) {
				System.out.println("결제버튼 활성화 대기중");
				continue;
			}
			
			break;
		}
		
						
//		putPayPw();
	}
	
	public void putPayPw() {
		
		webElement = driver.findElement(By.id("lpayWebIframe"));
		System.out.println(webElement.getAttribute("name"));
		driver.switchTo().frame(webElement);
		
		wait = new WebDriverWait(driver, 1);		
		
		while(true) {
			
			try {
				webElement = driver.findElement(By.xpath("//*[@id=\"jzpx83fev4\"]"));
				
			} catch (Exception e) {
				System.out.println("타임아웃");
				continue;
			}
			break;
		}
		
		js.executeScript("arguments[0].selected = 'true';", webElement);
	}

}
