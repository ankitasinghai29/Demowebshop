package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Register")
	private WebElement registerLink;
	
	@FindBy(id="gender-female")
	private WebElement femaleRadioButton;
	
	@FindBy(id="gender-male")
	private WebElement maleRadioButton;
	
	@FindBy(id="FirstName")
	private WebElement firstNameText;
	
	@FindBy(id="LastName")
	private WebElement lastNameText;
	
	@FindBy(id="Email")
	private WebElement emailId;
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPassword;
	
	@FindBy (id="register-button")
	private WebElement registerButton;
	

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}
	
	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getFirstNameText() {
		return firstNameText;
	}

	public WebElement getLastNameText() {
		return lastNameText;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public void setEmailId(WebElement emailId) {
		this.emailId = emailId;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(WebElement confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(WebElement registerButton) {
		this.registerButton = registerButton;
	}
	
	

}
