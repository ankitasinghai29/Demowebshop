package IT;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.FilterProductPage;


public class TC_010_FilterProduct_Test extends BaseClass{
	
	@Test
	public void valiadteThatUserIsAbleToGetFilteredItem() throws Throwable
	{
		String expBookPage = uc.readDataFromPropFile(Constants.propFilePath, "expBookPage");
	    FilterProductPage fp = new  FilterProductPage(driver);
		fp.getBookLink().click();
		Thread.sleep(3000);
		um.assertion(expBookPage, um.getCurrentUrl());
		Reporter.log("user is able to get Books Page", true);
		
		fp.getFilterOption().click();
		Thread.sleep(3000);
		String expFilterPage = uc.readDataFromPropFile(Constants.propFilePath, "filterProductPage");
		
		String tcName = "TC_010_FilterProduct_Test";
		String msg = "user is able to filter the products";
		um.generateReport(expFilterPage, um.getCurrentUrl(),tcName,msg);
		
	}

}
