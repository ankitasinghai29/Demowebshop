package FT;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.SearchPage;

public class TC_005_Search_Test extends BaseClass{
	
	@Test
	public void validateThatUserIsAbleToGetSearchPage() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		String text = "camera";
		SearchPage sp = new SearchPage(driver);
		WebElement searchText = sp.getSearchBar();
		searchText.sendKeys(text);
		sp.getSearchButton().click();
		
		String expSearchPage = uc.readDataFromPropFile(Constants.propFilePath, "seachUrl")+text;
		
		String tcName = "TC_005_Search_Test";
		String msg = "user is able to get searched page";
		um.generateReport(expSearchPage, um.getCurrentUrl(),tcName,msg);
	
		
	}

}
