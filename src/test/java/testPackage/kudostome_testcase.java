package testPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

 

import org.testng.annotations.Test;

 

import pageObjects.LoginPage;
import pageObjects.kudostome;
import resources.Base;

 

    public class kudostome_testcase extends Base{
        
        @Test
        
        public void kudostomenavigationpage() throws IOException, InterruptedException {
            
            driver = initializeDriver();
            
            Properties prop=new Properties();
            FileInputStream fis = new FileInputStream("C:\\SELENIUM(WORKSPACE)\\QTProject\\src\\main\\java\\resources\\data.properties");
            prop.load(fis);
            
            driver.get(prop.getProperty("url"));
            log1.info("Successfully opened the application");
            
            //Verification and login
            driver.get(prop.getProperty("url"));
    		driver.manage().window().maximize();
    		log1.info("sucessfuly opened the application");
    		LoginPage l=new LoginPage(driver);
    		l.enterusername().sendKeys("chaithra.chandraiah@qualitestgroup.com");
    		l.enterpassword().sendKeys("P@ssw0rd");
    		l.clickloginbutton().click();
    		log1.info("Successfully entered username and password");
    		
    		
    		
                
            kudostome km = new kudostome(driver);
            
            km.Kudos_to_me().click();
            log1.info("displaying kudos to me");
            driver.close();
            
        }
         
    }
     