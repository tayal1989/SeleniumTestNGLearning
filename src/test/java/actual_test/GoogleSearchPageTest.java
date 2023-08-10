package actual_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	private static WebDriver chromeDriver = null ;

	public static void main(String[] args) {
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/resources/chromedriver");
		chromeDriver = new ChromeDriver();
		
		chromeDriver.get("https://www.google.com/");
		chromeDriver.manage().window().maximize();
		
		GoogleSearchPageObjects gs = new GoogleSearchPageObjects(chromeDriver) ;
		try {
			// Enter text in search box			
			gs.setTextInSearchBox("Automation Step By Step");
			
			//Click on Search Box
			gs.clickSearchButton();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			chromeDriver.quit();
		}
	}
}
