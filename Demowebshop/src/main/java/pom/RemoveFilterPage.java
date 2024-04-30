package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveFilterPage {
	
	public  RemoveFilterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='header-menu']//a[contains(text(),'Books')]")
	private WebElement bookLink;
	
	@FindBy(xpath="//a[@href=\"https://demowebshop.tricentis.com/books?price=-25\"]")
	private WebElement filterOption;
	
	@FindBy (xpath = "//a[text()='Remove Filter']")
	private WebElement removeFilterLink;

	public WebElement getBookLink() {
		return bookLink;
    }

	public WebElement getFilterOption() {
		return filterOption;
	}

	public WebElement getRemoveFilterLink() {
		return removeFilterLink;
	}

}
