package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import src.Log4jDemo;

@Listeners(listeners.TestNGListeners.class)
public class ExcelDataProvider {
	WebDriver driver = null ;
	private static Logger logger = LogManager.getLogger(Log4jDemo.class) ;
	
	@BeforeTest
	public void setUpTest() {		
		driver = new ChromeDriver();		
		logger.info("Browser Started");
	}	
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
	}
	
	@Test(dataProvider="test1Data")
	public void test1(String username, String password) throws InterruptedException {
		System.out.println(username + " | " + password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(3000);
	}
	
	@DataProvider(name = "test1Data")
	public static Object[][] getData() {
		String projectPath = System.getProperty("user.dir") ;
		Object data[][] = testData(projectPath + "/excel/data.xlsx", "Sheet1");
		return data ;
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName) ;
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount(0);
		
		Object data[][] = new Object[rowCount - 1][colCount] ;
		
		for(int i = 1 ; i < rowCount ; i++) {
			for(int j = 0 ; j < colCount ; j++) {
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData + " | ");
				data[i - 1][j] = cellData ;
			}
			System.out.println();
		}
		
		return data ;
	}

}
