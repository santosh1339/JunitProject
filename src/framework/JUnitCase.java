package framework;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class JUnitCase {
	
	WebDriver driver;// delared here to make it accesable to all methods 
	

	@Before
	public void setUp() throws Exception
	{
		
        System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit(); // method is used to clean up hence using driver quit
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		
		
		driver.findElement(By.id("userName")).sendKeys("Santosh Angadi");

        driver.findElement(By.id("userEmail")).sendKeys("Santosh Angadi@gmail.com");

        WebElement cAddress = driver.findElement(By.id("currentAddress"));
        cAddress.sendKeys("123, Cross1 , Street2 , Delhi");

         String currAdd = cAddress.getText();
        		 
        Actions actions = new Actions(driver);


        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();



        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();


        actions.sendKeys(Keys.TAB).build().perform();

        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

        WebElement pAddress = driver.findElement(By.id("permanentAddress"));
        String permAdd = pAddress.getText();
        
        assertEquals(currAdd, permAdd);
        
        /*
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();



        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();


        actions.sendKeys(Keys.TAB);
        actions.build().perform();

        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();

       */

        //driver.quit();

 
	}

}
