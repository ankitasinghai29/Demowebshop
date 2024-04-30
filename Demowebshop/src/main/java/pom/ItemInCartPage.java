package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemInCartPage {
	
	public ItemInCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class=\"header-menu\"]//a[contains(text(),\"Books\")]")
	private WebElement bookLink;
	
	@FindBy (xpath = "(//input[@value='Add to cart'])[1]")
	private WebElement itemAddToCart;
	
	@FindBy (id="bar-notification")
	private WebElement barNotification;

	public WebElement getBookLink() {
		return bookLink;
	}

	public WebElement getItemAddToCart() {
		return itemAddToCart;
	}

	public WebElement getBarNotification() {
		return barNotification;
	}
	
	

}
