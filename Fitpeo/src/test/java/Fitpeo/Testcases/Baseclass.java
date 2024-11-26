package Fitpeo.Testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass {

public static WebDriver driver;
	
	@BeforeClass
		public void setup()
	{	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Welcome\\eclipse-workspace\\velvetresidences\\drivers\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get("https://www.fitpeo.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
	
//	@AfterClass
//	public void teardown() {
//	driver.close();
//	}
	
	 
	
}
