package testPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.SearchKudos;
import resources.Base;
	    public class Searchkudos_testcases extends Base {
	        @Test
	        
	        public void searchkudospage() throws IOException, InterruptedException, AWTException {
	            
	            driver = initializeDriver();
	            
	            Properties prop=new Properties();
	            FileInputStream fis = new FileInputStream("C:\\SELENIUM(WORKSPACE)\\QTProject\\src\\main\\java\\resources\\data.properties");
	            prop.load(fis);
	            
	            driver.get(prop.getProperty("url"));
	            log1.info("Successfully opened the application");
	            
	            //Verification and login
	            
	        	driver.get(prop.getProperty("url"));
	    		driver.manage().window().maximize();
	    		log1.info("sucessfulyy opened");
	    		LoginPage l=new LoginPage(driver);
	    		l.enterusername().sendKeys("chaithra.chandraiah@qualitestgroup.com");
	    		l.enterpassword().sendKeys("P@ssw0rd");
	    		l.clickloginbutton().click();
	    		log1.info("Successfully entered username and password");
	    		
	            
	            //To search kudos
	    		
	            SearchKudos SK = new SearchKudos(driver);
	            SK.search().click();
	            Thread.sleep(1000);
	            SK.emailfeild().sendKeys("Chaithra K Chandraiah");
	            Thread.sleep(1000);
	            Robot R = new Robot();
	            R.keyPress(KeyEvent.VK_DOWN);
	            R.keyPress(KeyEvent.VK_ENTER);
	            R.keyPress(KeyEvent.VK_TAB);
	            R.keyPress(KeyEvent.VK_ENTER);
	            
	            Thread.sleep(1000);
	            
	            SK.searchbutton().click();
	            driver.close();
	        }
	       
	    }
	     
	           


