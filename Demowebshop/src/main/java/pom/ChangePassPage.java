package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassPage {
	
	public ChangePassPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[text()='My account']")
	private WebElement myAccLink;
	
	@FindBy (xpath = "//div[@class='listbox']/ul/li[7]/a")
	private WebElement changePassLink;
	
	@FindBy(id = "OldPassword")
	private WebElement oldPasswordTextBox;
	
	@FindBy (id="NewPassword")
	private WebElement newPasswordTextBox;
	
	@FindBy(id="ConfirmNewPassword")
	private WebElement confirmPasswordTextBox;
	
	@FindBy(xpath = "//input[@value='Change password']")
	private WebElement changePasswordButton;

	public WebElement getMyAccLink() {
		return myAccLink;
	}

	public WebElement getChangePassLink() {
		return changePassLink;
	}

	public WebElement getOldPasswordTextBox() {
		return oldPasswordTextBox;
	}

	public WebElement getNewPasswordTextBox() {
		return newPasswordTextBox;
	}

	public WebElement getConfirmPasswordTextBox() {
		return confirmPasswordTextBox;
	}

	public WebElement getChangePasswordButton() {
		return changePasswordButton;
	}
	
	

}
