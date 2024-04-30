package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterProductPage {
	
	public  FilterProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='header-menu']//a[contains(text(),'Books')]")
	private WebElement bookLink;
	
	@FindBy(xpath="//a[@href=\"https://demowebshop.tricentis.com/books?price=-25\"]")
	private WebElement filterOption;

	public WebElement getBookLink() {
		return bookLink;
    }

	public WebElement getFilterOption() {
		return filterOption;
	}

	public void setFilterOption(WebElement filterOption) {
		this.filterOption = filterOption;
	}
	
	
}