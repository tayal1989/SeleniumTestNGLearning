package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	WebDriver driver = null;

	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver  = driver ;
	}

	By textboxSearch = By.name("q") ;
	By clickSearchBoxButton = By.xpath("//div[contains(@class, 'FP')]//input[@value='Google Search']") ;
	
	public void setTextInSearchBox(String text) {
		driver.findElement(textboxSearch).sendKeys(text) ;
	}
	
	public void clickSearchButton(){
		driver.findElement(clickSearchBoxButton).sendKeys(Keys.RETURN);
	}
}
