package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateAddressPage {
	
	public UpdateAddressPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[text()='My account']")
	private WebElement myAccLink;
	
	@FindBy (xpath = "//ul[@class='list']/li/a[text()='Addresses']")
	private WebElement addressLink;
	
	@FindBy (xpath = "//input[@value='Edit']")
	private WebElement editButton;
	
	@FindBy (id="Address_Company")
	private WebElement addressCompanyTextField;
	
	@FindBy (xpath = "//input[@value='Save']")
	private WebElement saveButton;
	
	@FindBy (xpath = "//ul[@class='info']/li[5]")
	private WebElement fetchCompanyDetail;
	


	public WebElement getMyAccLink() {
		return myAccLink;
	}

	public WebElement getAddressLink() {
		return addressLink;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getAddressCompanyTextField() {
		return addressCompanyTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getFetchCompanyDetail() {
		return fetchCompanyDetail;
	}
	
	

}
