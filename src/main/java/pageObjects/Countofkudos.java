package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Countofkudos {
	
	public WebDriver driver;
	
	By count=By.xpath("[id='todayCount']");
	public Countofkudos(WebDriver driver) {
		this.driver=driver;
	}
	 public WebElement Countofkudoss() {
	        return driver.findElement(count);
	    }

}
