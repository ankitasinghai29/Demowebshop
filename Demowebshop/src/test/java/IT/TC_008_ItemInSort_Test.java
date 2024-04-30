package IT;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.ItemInSortPage;

public class TC_008_ItemInSort_Test extends BaseClass {
	
	@Test
	public void validateUserIsAbleToSortTheProducts() throws Throwable
	{
		String expBookPage = uc.readDataFromPropFile(Constants.propFilePath, "expBookPage");
		ItemInSortPage ip = new ItemInSortPage(driver);
		ip.getBookLink().click();
		um.assertion(expBookPage, um.getCurrentUrl());
		Reporter.log("user is able to get Books Page", true);
		WebElement sortDD = ip.getSortDropDown();
		um.selectByVisibleText(sortDD,"Price: Low to High");
		
		String expOrderByPage = uc.readDataFromPropFile(Constants.propFilePath, "orderByPage");
		
		String tcName = "TC_008_ItemInSort_Test";
		String msg = "user is able to get Books Page Items in the specified order";
		um.generateReport(expOrderByPage, um.getCurrentUrl(),tcName,msg);
		
	}
}
