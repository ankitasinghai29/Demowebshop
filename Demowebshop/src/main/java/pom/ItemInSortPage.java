package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemInSortPage {
	
	public ItemInSortPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class=\"header-menu\"]//a[contains(text(),\"Books\")]")
	private WebElement bookLink;
	
	@FindBy(id="products-orderby")
	private WebElement sortDropDown;

	public WebElement getBookLink() {
		return bookLink;
	}

	public WebElement getSortDropDown() {
		return sortDropDown;
	}
	

}
