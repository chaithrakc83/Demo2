package integration;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.testng.annotations.Test;

	import pageObjects.LoginPage;
	import pageObjects.Recentcontacts;
	import resources.Base;
	public class Sendkudostocolleague {
		

	public class Recentcontactstestcase extends Base {
		
		@Test
		public void Recentcontactsnavigationpage() throws InterruptedException, IOException {
		            
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
			    		Thread.sleep(1000);
			    		l.enterusername().sendKeys("chaithra.chandraiah@qualitestgroup.com");
			    		Thread.sleep(1000);
			    		l.enterpassword().sendKeys("P@ssw0rd");
			    		l.clickloginbutton().click();
			    		log1.info("Successfully entered username and password");
			    		
		                //Verification of Recent contacts
			    		
		            Recentcontacts rc = new Recentcontacts(driver);
		            rc.recentcontacts().click();
		            log1.info("kudos sent from me is Displayed");
		            log1.info("Email address is autopopulated in the Emailaddress field");
		            
		            rc.kudostype("Hard Worker"); //sending one kudos 
		            rc.comment().sendKeys("Good");
		            rc.send().click();
		            driver.close();   
		            
		        }

			    }

}
