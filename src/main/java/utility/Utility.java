package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility {
	//common methods - scrollIntoView, takeScreenshot, imlicitWait, threadWait,  exceSheet, propertyfile
	
	
	//scrollIntoView
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
     {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("Scrolling to that element", true);
     }
	
	//implicitwait
	public static void implicitWait(WebDriver driver, long waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("Waiting to load complete page"+waitTime, true);
	}
	
	//threadWait
	public static void threadWait(long waitTime) throws InterruptedException
	{
		Thread.sleep(waitTime);
		Reporter.log("Wait time -"+waitTime, true);
	}
	
	//screenshot
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException
	{
	   File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   String str = RandomString.make(3);
	   File dest = new File("C:\\Users\\palla\\EclipseWorksapce\\Zoho\\screenshots\\"+fileName+"-"+str);
	   FileHandler.copy(src, dest);
	   Reporter.log("taking screenshot and stored at -"+dest, true);
	}
	
	//excelsheet
	public static String excelData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile = new FileInputStream("C:\\Users\\palla\\OneDrive\\Documents\\Automation\\ExcelSheet\\EmployeeData.xlsx");
		String data = WorkbookFactory.create(myFile).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		Reporter.log("Reading data from excel row number-"+rowNum+", cell number-"+cellNum, true);
		return data;	
		
	}
	
	//reading data from property file
	public static String propertyFile(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream myFile = new FileInputStream("C:\\Users\\palla\\EclipseWorksapce\\Zoho\\zohoData.properties");
		//load data 
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("Reading data from property file key is -"+key+"value is-"+value, true);
		return value;
		
	}
	
	
	
	
	

}
