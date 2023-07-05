package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SignInPage  {
	
	//declaring data member - webElement
	
	@FindBy(xpath = "//a[text()='Sign in']") private WebElement signInHomePageButton;
	@FindBy(xpath = "//input[@id='login_id']") private WebElement emailIdField;
	@FindBy(id = "nextbtn") private WebElement nextButton;
	@FindBy(xpath = "//input[@name='PASSWORD']") public WebElement passwordField;
	@FindBy(xpath = "(//span[text()='Sign in'])[2]") private WebElement signInButton;
	@FindBy(xpath = "(//div[@class='zgh-userPanel'])[3]") private WebElement userIcon;
    @FindBy(xpath = "(//a[text()='My Account'])[3]") private WebElement myAccountButton;
	@FindBy(xpath = "//a[@id='continue_button']") public WebElement iUnderstandButton;
	//initializing webelements
	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilizing 
	public void clickOnSignInHomePage()
	{
		signInHomePageButton.click();
		Reporter.log("Clicking on Home page Sign In ", true);
	}
	public void enterEmailIdOrMobileNumber(String emailId)
	{
		emailIdField.sendKeys(emailId);
		Reporter.log("Entering email id", true);
	}
	 public void clickOnNextButton()
	 {
		 nextButton.click();
		 Reporter.log("Clicking on next button", true);
	 }
	public void enterPassword(String pwd)
	{
		passwordField.sendKeys(pwd);
		Reporter.log("Entering password", true);
	}
	public void clickOnSignIn()
	{
		signInButton.click();
		Reporter.log("Clicking on sign in", true);
	}
	public void clickOnUserIcon()
	{
		userIcon.click();
		Reporter.log("Clicking on user icon", true);
	}
	public void clickOnMyAccount()
	{
		myAccountButton.click();
		Reporter.log("Clicking on my account",true);
	}
	public void clickOniUnderstandButton()
	{
		
		iUnderstandButton.click();
	}
}
