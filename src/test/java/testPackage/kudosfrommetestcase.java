package testPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.kudosfromme;
import resources.Base;

public class kudosfrommetestcase extends Base{
	@Test
	public void kudosfrommenavigationpage() throws InterruptedException, IOException {
	            
	            driver = initializeDriver();
	            
	            Properties prop=new Properties();
	            FileInputStream fis = new FileInputStream("C:\\SELENIUM(WORKSPACE)\\QTProject\\src\\main\\java\\resources\\data.properties");
	            prop.load(fis);
	            
	            driver.get(prop.getProperty("url"));
	            log1.info("Successfully opened the application");
	            
	            
	          //To launch the browser, Verification and login
	    		
	    		driver.get(prop.getProperty("url"));
	    		driver.manage().window().maximize();
	    		log1.info("sucessfulyy opened");
	    		LoginPage l=new LoginPage(driver);
	    		l.enterusername().sendKeys("chaithra.chandraiah@qualitestgroup.com");
	    		l.enterpassword().sendKeys("P@ssw0rd");
	    		l.clickloginbutton().click();
	    		log1.info("Successfully entered username and password");
	    		
	    		kudosfromme kfm = new kudosfromme(driver);
	            kfm.kudosfromme().click();
	            log1.info("kudos sent from me is Displayed successfully");
	            driver.close();
	            
	        }
	 

	    }
	     


