package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PersonalInformationPage {
	
	@FindBy(xpath = "//div[@id='profile_name']") private WebElement profileNamefield;
	@FindBy(id = "profile_email") private WebElement profileEmailField;
	@FindBy(xpath = "//input[@id='profile_name_edit']") private WebElement fullNameField;
	@FindBy(xpath = "//input[@name='display_name']") private WebElement displayNameField;
	@FindBy(xpath = "//input[@jsid='gender_select']") private WebElement genderField;
	@FindBy(xpath ="//input[@jsid='localeCn']") private WebElement countryField;
	@FindBy(xpath = "//input[@jsid='localeState']") private WebElement stateField;
	@FindBy(xpath = "//input[@jsid='localeLn']") private WebElement languageField;
	@FindBy(xpath = "//input[@jsid='localeTz']") private WebElement timeZoneField;
	
	
	//initializing
	
	public PersonalInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilizing
	
	public String getProfileName()
	{
		String profileName = profileNamefield.getText();
		Reporter.log("Profile name is-"+profileName,true);
		return profileName;
	}
	public String getFullName()
	{
		String fullName = fullNameField.getAttribute("value");
		Reporter.log("Profile name is-"+fullName, true);
		return fullName;
	}
	public String getProfileEmail()
	{
		String emailID = profileEmailField.getText();
		Reporter.log("Email id is-"+emailID,true);
		return emailID;
	}
	public String getDisplayName()
	{
		String displayName = displayNameField.getAttribute("value");
		Reporter.log("Display name is-"+displayName, true);
		return displayName;
	}
	public String getGender()
	{
		String gender = genderField.getAttribute("value");
		Reporter.log("Gender is-"+gender, true);
		return gender;
	}
	public String getCountryName()
	{
		String countryName = countryField.getAttribute("value");
		Reporter.log("Country name is-"+countryName, true);
		return countryName;
	}
	public String getStateName()
	{
		String stateName = stateField.getAttribute("value");
		Reporter.log("State is-"+stateName, true);
		return stateName;
	}
	public String getLanguageName()
	{
		String languageName = languageField.getAttribute("value");
		Reporter.log("State is-"+languageName, true);
		return languageName;
	}
	public String getTimeZone()
	{
		String timeZoneName = timeZoneField.getAttribute("value");
		Reporter.log("Time zone is-"+timeZoneName, true);
		return timeZoneName;			
	}
	

}
