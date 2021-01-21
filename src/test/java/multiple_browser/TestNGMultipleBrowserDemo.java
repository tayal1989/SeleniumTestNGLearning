package multiple_browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultipleBrowserDemo {
	WebDriver driver = null ;
	
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		System.out.println("Browser name is : " + browserName);
		System.out.println("Thread id : " + Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/resources/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
