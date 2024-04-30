package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Log in']")
	private WebElement loginLink;
	
	@FindBy(id="Email")
	private WebElement emailField;
	
	@FindBy(id="Password")
	private WebElement passwordField;
	
	@FindBy(id="RememberMe")
	private WebElement remCheckBox;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement loginButton;

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getRemCheckBox() {
		return remCheckBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	

}
