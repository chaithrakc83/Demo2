package testPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class Titletestcase extends Base {
	
	 @Test(dataProvider="getData")
	 
	    public void basePageNavigation(String Username, String Password) throws IOException, InterruptedException{
	        driver = initializeDriver();
	        
	        Properties prop=new Properties();
	        FileInputStream fis = new FileInputStream("C:\\SELENIUM(WORKSPACE)\\QTProject\\src\\main\\java\\resources\\data.properties");
	        prop.load(fis);
	        
	        driver.get(prop.getProperty("url"));
	        log1.info("Successfully opened the application");
	        LoginPage l=new LoginPage(driver);
			l.enterusername().sendKeys("chaithra.chandraiah@qualitestgroup.com");
			l.enterpassword().sendKeys("p@ssw0rd");
			l.clickloginbutton().click();
			driver.manage().window().maximize();
			log1.info("Successfully entered username and password");
			
	    
	    //Title Recognition
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "QTRecognition";
	        Assert.assertEquals(expectedTitle,actualTitle);
	        System.out.println(""+actualTitle);
	        log1.info("QTRecognition title is displayed");
	    }
	 
	 @DataProvider
		public Object[][] getData() throws IOException {
			  Object[][] data=new Object[0][2];
			  
			 //valid input
			  data[0][0]="chaithra.chandraiah@qualitestgroup.com";
			  data[0][1]="P@ssw0rd";
			  
			 
			  return data;		  

	}
	
	 
}	 



