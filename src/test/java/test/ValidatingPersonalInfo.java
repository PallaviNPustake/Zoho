package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pom.PersonalInformationPage;
import pom.SignInPage;
import utility.Utility;

public class ValidatingPersonalInfo extends Base {
  
	SignInPage signIn ;
	PersonalInformationPage info;
	@BeforeClass
	public void launchZoho() throws InterruptedException, EncryptedDocumentException, IOException
	{
		launchZohoAppplication();
		Utility.implicitWait(driver, 1000);
		signIn= new SignInPage(driver);
		info = new PersonalInformationPage(driver);

		signIn.clickOnSignInHomePage();
		Utility.implicitWait(driver, 1500);
		signIn.enterEmailIdOrMobileNumber(Utility.excelData("Sheet4", 1, 0));
		
		signIn.clickOnNextButton();
		Utility.threadWait(2000);
		driver.navigate().refresh();
		//Assert.assertTrue(signIn.passwordField.isEnabled(),"element should be displayed");
		signIn.enterPassword(Utility.excelData("Sheet4", 1, 1));
		signIn.clickOnSignIn();
		Utility.threadWait(2000);
	    Utility.scrollIntoView(driver, signIn.iUnderstandButton);
	    Utility.threadWait(1000);
		signIn.clickOniUnderstandButton();
		Utility.implicitWait(driver, 2000);
		signIn.clickOnUserIcon();
		signIn.clickOnMyAccount();
		Utility.implicitWait(driver, 3000);
		//driver.navigate().refresh();
		
	}
  @Test(priority = -1)
  public void validateUserName() throws EncryptedDocumentException, IOException {
	  String expectedUN=Utility.excelData("Sheet4", 1, 2);
	  //String expectedUN="Pallavi Pustake";
	  String actualUN = info.getProfileName();
	  Assert.assertEquals(actualUN, expectedUN,"Actual and expected username are not matching-TC is failed");
	  Reporter.log("Actual and expected username are matching", true);
	 
  }
  @Test
  public void validateEmailId() throws EncryptedDocumentException, IOException
  {   
	  String expectedEmail = Utility.excelData("Sheet4", 1, 0);
	  Assert.assertEquals(info.getProfileEmail(), expectedEmail,"Actual and expected email id's are not matching");
	  Reporter.log("Actual and expected email id's are matching", true);
  }
  
  @Test
  public void validateFullName() throws EncryptedDocumentException, IOException
  {   
	  String expectedFullName = Utility.excelData("Sheet4", 1, 3);
	 // String expectedFullName = "Pallavi Pustake";
	  Assert.assertEquals(info.getFullName(), expectedFullName,"Actual and expected full name are not matching");
	  Reporter.log("Actual and expected full names are matching"+expectedFullName, true);
  }
  @Test
  public void validateDisplayName() throws EncryptedDocumentException, IOException
  {   
	  String expectedDisplayName = Utility.excelData("Sheet4", 1, 4);
	  Assert.assertEquals(info.getDisplayName(), expectedDisplayName,"Actual and expected display name's are not matching");
	  Reporter.log("Actual and expected display names are matching", true);
  }
  @Test
  public void validateGender() throws EncryptedDocumentException, IOException
  {   
	  String expectedGender = Utility.excelData("Sheet4", 1, 5);
	  Assert.assertEquals(info.getGender(), expectedGender,"Actual and expected gender selection are not matching");
	  Reporter.log("Actual and expected gender matched", true);
  }
  @Test
  public void validateCountryName() throws EncryptedDocumentException, IOException
  {   
	  String expectedCountry = Utility.excelData("Sheet4", 1, 6);
	  Assert.assertEquals(info.getCountryName(), expectedCountry,"Actual and expected country name's are not matching");
	  Reporter.log("Actual and expected country name matched", true);
  }
  @Test
  public void validateStateName() throws EncryptedDocumentException, IOException
  {   
	  String expectedState = Utility.excelData("Sheet4", 1, 7);
	  Assert.assertEquals(info.getStateName(), expectedState,"Actual and expected state name's are not matching");
	  Reporter.log("Actual and expected state name matched", true);
  }
  @Test
  public void validatelanguageName() throws EncryptedDocumentException, IOException
  {   
	  String expectedLanguage = Utility.excelData("Sheet4", 1, 8);
	 // String expectedFullName = "Pallavi Pustake";
	  Assert.assertEquals(info.getLanguageName(), expectedLanguage,"Actual and expected language's are not matching");
	  Reporter.log("Actual and expected language name matched", true);
  }
  @Test
  public void validateTimeZone() throws EncryptedDocumentException, IOException
  {   
	 // String expectedTimeZone = Utility.excelData("Sheet4", 1, 9);
	  String expectedTimeZone = "(GMT +5:30) India Standard Time ( Asia/Kolkata )	";
	  Assert.assertEquals(info.getTimeZone(), expectedTimeZone,"Actual and expected time zone's are not matching");
	  Reporter.log("Actual and expected time zone matched", true);
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException
  {
	  Utility.threadWait(3000);
	  closingBrowser();
  }
  
}
