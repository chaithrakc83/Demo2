package testPackage;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class Activitypagetestcase extends Base {
	 @Test
	public void open() throws IOException, InterruptedException
    {
        
		//To launch the browser, Verification and login
		 
		    driver=initializeDriver();
		    
			
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			log1.info("sucessfulyy opened the application");
			LoginPage l=new LoginPage(driver);	
			l.enterusername().sendKeys("chaithra.chandraiah@qualitestgroup.com");
			l.enterpassword().sendKeys("P@ssw0rd");
			l.clickloginbutton().click();
			log1.info("Successfully entered username and password");
			
			//To verify the username is displayed in the left side of acticity page
			
			WebElement ele = driver.findElement(By.xpath("//div[@class='media']"));
	        Point loc = ele.getLocation();
	        int x = loc.getX();
	        System.out.println(+x);
	        int y=loc.getY();
	        System.out.println(+y);
	       
      
        if(x<=450 && y<=200)
        {
            System.out.println("username is displayed in the Left side of the screen");
            log1.info("username is displayed in the left side of the screen");
        }
        else
        {
            System.out.println("username is not in the Left side of the screen");
        }
        	
        driver.close();
	 }
	 
}
