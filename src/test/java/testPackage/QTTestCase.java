package testPackage;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;


public class QTTestCase extends Base{
	
	public void logingeneral(String username,String password) throws IOException, InterruptedException {
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log1.info("sucessfulyy opened");
		LoginPage l=new LoginPage(driver);
		l.enterusername().sendKeys(username);
		l.enterpassword().sendKeys(password);
		l.clickloginbutton().click();
		driver.close();
	}	
	
	@Test(dataProvider="getData")
	public void open(String username,String password) throws IOException, InterruptedException {
		driver= initializeDriver();
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\SELENIUM(WORKSPACE)\\QTProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//To launch the browser, Verification and login
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log1.info("sucessfulyy opened");
		LoginPage l=new LoginPage(driver);
		
		l.enterusername().sendKeys(username);
		l.enterpassword().sendKeys(password);
		l.clickloginbutton().click();
		log1.info("Successfully entered username and password");
		
		     
	         
 }
	            
	
		@DataProvider
		public Object[][] getData() throws IOException {
			  Object[][] data=new Object[3][2];
			  
			 //valid input
			  data[0][0]="chaithra.chandraiah@qualitestgroup.com";
			  data[0][1]="P@ssw0rd";
			  
			  //invalid input
			  
			  data[1][0]="c.chandraiah@qualitestgroup.com";
			  data[1][1]="P@ssw0rd";
			  
			 
	           //invalid input  
	          
			  data[2][0]="chaithra.chandraiah@qualitestgroup.com";
			  data[2][1]="P@ssw0rd34";
			  
			 
			  
			  return data;  
				
		}
		
}


