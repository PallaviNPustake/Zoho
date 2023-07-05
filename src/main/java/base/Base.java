package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base {
	
	static protected WebDriver driver;
	
	public void launchZohoAppplication()
	{
		driver= new ChromeDriver();
		driver.get("https://www.zoho.com/");
		driver.manage().window().maximize();
		Reporter.log("Launching zoho application", true);
	}
	
	public void closingBrowser()
	{
		driver.quit();
		Reporter.log("Closing browser", true);
	}

}
