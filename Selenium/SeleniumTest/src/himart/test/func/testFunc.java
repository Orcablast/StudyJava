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
				System.out.print("ID �Է� : ");
				userId = br.readLine();
				System.out.print("PW �Է� : ");
				userPw = br.readLine();
				
				System.out.print("�̴�� �����Ͻðڽ��ϱ�? [ y(����) / n(�ٽ��Է�) ] : ");
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
			System.out.println("Chrome ��ġ ��ΰ� �߸��Ǿ����ϴ�.");
			e.printStackTrace();
		}

		ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor)driver;	
        wait = new WebDriverWait(driver, 1);
        
        driver.get("http://www.e-himart.co.kr/");
        
        webElement = driver.findElement(By.id("loginArea"));
        
        if(webElement.getText().equals("�α���")) {
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
        
        baseUrl = "http://www.e-himart.co.kr/app/goods/goodsDetail?goodsNo=0006295851"; // ����� ��Ű��
//		baseUrl = "http://www.e-himart.co.kr/app/goods/goodsDetail?goodsNo=0006295864"; // ���� Ÿ��Ʋ ��ũ
//		baseUrl = "http://www.e-himart.co.kr/app/goods/goodsDetail?goodsNo=0001077642"; // �׽�Ʈ ��ũ1 ǰ��
//		baseUrl = "http://www.e-himart.co.kr/app/goods/goodsDetail?goodsNo=0004177126"; // �׽�Ʈ ��ũ2 ���Ű���
        
		while(true) {
			driver.get(baseUrl);
			try {
				if(wait.until(ExpectedConditions.alertIsPresent()) != null) {
					System.out.println("���� ���ֳ�");
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
				System.out.println("�����ϱ� ��ư�� Ȱ��ȭ ���� ����");
				driver.get(baseUrl);
				continue;
			}
			
			break;
		}
		
		webElement.click();		
		
		// �ε��� �����ɸ��� ����
		
		webElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("abPaySP")));
		js.executeScript("arguments[0].click();", webElement);
		
		webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("abAgreeB2")));		
		js.executeScript("arguments[0].click();", webElement);
		
		webElement = driver.findElement(By.cssSelector("option[value='03:Y']"));
		js.executeScript("arguments[0].selected = 'true';", webElement);
		
		
		// �����ϱ� ��ư ��Ȱ��ȭ �ð� �����ɸ� �� �����Ƿ� ����ؾ���
		
		while(true) {
			
			try {
				
				webElement = driver.findElement(By.id("doPaybutton0"));		
				js.executeScript("arguments[0].click();", webElement);				
				
			} catch (Exception e) {
				System.out.println("������ư Ȱ��ȭ �����");
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
				System.out.println("Ÿ�Ӿƿ�");
				continue;
			}
			break;
		}
		
		js.executeScript("arguments[0].selected = 'true';", webElement);
	}

}
