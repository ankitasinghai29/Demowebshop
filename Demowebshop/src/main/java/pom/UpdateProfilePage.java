package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfilePage {
	
	public UpdateProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[text()='My account']")
	private WebElement myAccLink;
	
	@FindBy (id="LastName")
	private WebElement lastNameTextField;
	
	@FindBy (xpath = "//input[@value='Save']")
	private WebElement saveButton;

	public WebElement getMyAccLink() {
		return myAccLink;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	

}
