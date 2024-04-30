package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItemPage {
	
	public SearchItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id=\"small-searchterms\"]")
	private WebElement searchBar;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@id='Q']")
	private WebElement resultSearchTextField;

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getResultSearchTextField() {
		return resultSearchTextField;
	}

	public void setResultSearchTextField(WebElement resultSearchTextField) {
		this.resultSearchTextField = resultSearchTextField;
	}
	
	

}
