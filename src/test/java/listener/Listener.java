package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.Base;
import utility.Utility;

public class Listener extends Base implements ITestListener
{
	
	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			Utility.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log(result.getName()+"-is succesfully executed", true);
	}
	 @Override
	public void onTestStart(ITestResult result) {
		Reporter.log("The test execution is started", true);
	}
	 
	 @Override
	public void onTestFailure(ITestResult result) {
		
		 
		 try {
			Utility.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 

}
