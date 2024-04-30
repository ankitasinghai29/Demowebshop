package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailItemPage {
	
	public EmailItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[@class=\"header-menu\"]//a[contains(text(),\"Books\")]")
	private WebElement bookLink;
	
	@FindBy(xpath = "(//div[@class='product-grid']//a)[1]")
	private WebElement bookItem;
	
	@FindBy (xpath = "//input[@value='Email a friend']")
	private WebElement emailButton;

	public WebElement getBookLink() {
		return bookLink;
	}

	public WebElement getBookItem() {
		return bookItem;
	}

	public WebElement getEmailButton() {
		return emailButton;
	}
	
	

}
