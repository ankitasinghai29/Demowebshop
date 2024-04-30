package IT;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.SearchItemPage;

public class TC_009_SearchedItem_Test extends BaseClass {
	
	@Test
	public void validateThatUserIsAbleToGetSearchPage() throws Throwable
	{
		String text = "camera";
		SearchItemPage sp = new SearchItemPage(driver);
		WebElement searchText = sp.getSearchBar();
		searchText.sendKeys(text);
		sp.getSearchButton().click();
		
		String expSearchPage = uc.readDataFromPropFile(Constants.propFilePath, "seachUrl")+text;
		um.assertion(expSearchPage, um.getCurrentUrl());
		Reporter.log("user is able to get searched page",true);
		
		String actualtext = sp.getResultSearchTextField().getAttribute("value");
		
		String tcName = "TC_009_SearchedItem_Test";
		String msg = "user is able to get searched item list";
		um.generateReport(text, actualtext,tcName,msg);
		
	}

}
