package testPackage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

 

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

 

public class Colourstestcase extends Base {
    @Test
    public void colours() throws IOException {
        driver =initializeDriver();
        driver.get("https://qtrecognition.testqtwiz.com/");
        Set<String> colours=new HashSet<String>();
        colours.add("#Fdcc16");
        colours.add("#2a2559");
        colours.add("#939598");
        LoginPage l=new LoginPage(driver);
        String Golden=Color.fromString(l.TitleColour().getCssValue("background-color")).asHex();
        String White=Color.fromString(l.BodyColour().getCssValue("background-color")).asHex();
        String Navy=Color.fromString(l.ButtonColour().getCssValue("background-color")).asHex();
        if(colours.contains(Golden)) {
            System.out.println("It has Golden in the page");
        }
        
        else {
        	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src,new File("C:\\Users\\Qualitest\\Pictures\\colorsScreenshot\\Screen02.png"));
		
        }
        
        if(colours.contains(White)) {
            System.out.println("It has White in the page");
            log1.info("Hi");
        }
        
        else {
        	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src,new File("C:\\Users\\Qualitest\\Pictures\\colorsScreenshot\\Screen03.png"));
		
        }
        
        if(colours.contains(Navy)) {
            System.out.println("It has Navy in the page");
            log1.info("It has Navy in the page");
			
        }
        
        else {
        	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src,new File("C:\\Users\\Qualitest\\Pictures\\colorsScreenshot\\Screen04.png"));
		
        }
          driver.close();
        
    }   

}