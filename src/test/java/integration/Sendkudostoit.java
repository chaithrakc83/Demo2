package integration;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Sendkudos;
import resources.Base;


public class Sendkudostoit {
	

	
		public class Sendsinglekudotestcase extends Base {
			
				@Test
				public void open() throws IOException, InterruptedException, AWTException {
					driver= initializeDriver();
					
					Properties prop=new Properties();
					FileInputStream fis=new FileInputStream("C:\\SELENIUM(WORKSPACE)\\QTProject\\src\\main\\java\\resources\\data.properties");
					prop.load(fis);
					
					driver.get(prop.getProperty("url"));
					log1.info("successfully opened the application");
					
					LoginPage l=new LoginPage(driver);
					Thread.sleep(1000);
					l.enterusername().sendKeys("chaithra.chandraiah@qualitestgroup.com");
					Thread.sleep(1000);
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
		            
		            s.kudostype("Hard Worker"); //sending one kudos 
		            
		            s.comment().sendKeys("Quick solution provided by Shivani towards my new laptop issues");
		            s.send().click();
		            Thread.sleep(10000);
		            log1.info("Kudos successfully sent with citation");
		            log1.info("Email sent successfully");
		            driver.close();
		    }
		    
					
		  }

}
