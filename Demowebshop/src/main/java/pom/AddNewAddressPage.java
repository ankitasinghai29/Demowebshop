package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressPage {
	
	public AddNewAddressPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[text()='My account']")
	private WebElement myAccLink;
	
	@FindBy (xpath = "//ul[@class='list']/li/a[text()='Addresses']")
	private WebElement addressLink;
	
	@FindBy (xpath = "//input[@value='Add new']")
	private WebElement addNewButton;
	
	@FindBy (id="Address_FirstName")
	private WebElement firstNameField;
	
	@FindBy(id ="Address_LastName")
	private WebElement lastNameField;
	
	@FindBy (id="Address_Email")
	private WebElement emailField;
	
	@FindBy(id = "Address_CountryId")
	private WebElement countryDropDown;
	
	@FindBy (id = "Address_City")
	private WebElement cityField;
	
	@FindBy(id = "Address_Address1")
	private WebElement addressField;
	
	@FindBy (id="Address_ZipPostalCode")
	private WebElement pincodeField;
	
	@FindBy(id="Address_PhoneNumber")
	private WebElement phoneField;
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveButton; 

	public WebElement getMyAccLink() {
		return myAccLink;
	}

	public WebElement getAddressLink() {
		return addressLink;
	}

	public WebElement getAddNewButton() {
		return addNewButton;
	}

	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getCityField() {
		return cityField;
	}

	public WebElement getAddressField() {
		return addressField;
	}

	public WebElement getPincodeField() {
		return pincodeField;
	}

	public WebElement getPhoneField() {
		return phoneField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
