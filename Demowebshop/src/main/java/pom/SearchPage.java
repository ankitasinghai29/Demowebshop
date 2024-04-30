package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public SearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id=\"small-searchterms\"]")
	private WebElement searchBar;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	
}
