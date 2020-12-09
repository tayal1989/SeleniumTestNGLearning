package actual_test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver chromeDriver = null ;

	public static void main(String[] args) {
		searchGoogleEngine();
	}

	public static void searchGoogleEngine(){
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/resources/chromedriver.exe");
		chromeDriver = new ChromeDriver();
		
		chromeDriver.get("https://www.google.com/");
		chromeDriver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		
			// Enter text in search box
			GoogleSearchPage.textboxSearch(chromeDriver).sendKeys("Automation Step By Step");
			
			//Click on Search Box
			GoogleSearchPage.clickSearchBoxButton(chromeDriver).sendKeys(Keys.RETURN);
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			chromeDriver.quit();
		}	
		
	}
}
