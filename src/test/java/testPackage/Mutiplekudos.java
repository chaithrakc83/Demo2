package testPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Sendkudos;
import resources.Base;

public class Mutiplekudos extends Base {
	
		@Test
		public void open() throws IOException, InterruptedException, AWTException {
			driver= initializeDriver();
			driver.get(prop.getProperty("url"));
			log1.info("successfully opened the application");
			
			LoginPage l=new LoginPage(driver);
			l.enterusername().sendKeys("chaithra.chandraiah@qualitestgroup.com");
			l.enterpassword().sendKeys("p@ssw0rd");
			l.clickloginbutton().click();
			driver.manage().window().maximize();
			log1.info("Successfully entered username and password");
			
			//To send kudos
			
			Sendkudos s=new Sendkudos(driver);
			s.clicksendkudos().click();
			s.emailaddress().sendKeys("Shivani Duggi  (shivani.duggi@qualitestgroup.com)");
			s.emailaddress().click();
			
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			
			//sending multiple kudos type
			
			String arr[]= {"Exceptional Work", "Excellent Team Work", "Innovative Thinker", "Good Client Relations", "Quality Hero", "Quick Learner", "Hard Worker", "Team player"};
			
			for(int i=0;i<arr.length;i++) {
				s.kudostype(arr[i]);
				Thread.sleep(1000);
			}	
			
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src,new File("C:\\Users\\Qualitest\\Pictures\\KudosScreenshot\\screen01.png"));
		
			s.comment().sendKeys("Best");
			Thread.sleep(1000);
			s.send().click();
			log1.info("Successfully kudos sent with citation");
			log1.info("Email sent successfully");
			driver.close();					
  }
				
}
		


