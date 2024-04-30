package IT;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.RemoveFilterPage;


public class TC_011_RemoveFilter_Test extends BaseClass  {
	
	@Test
	public void valiadteThatUserIsAbleToGetUnFilteredPage() throws Throwable
	{
		String expBookPage = uc.readDataFromPropFile(Constants.propFilePath, "expBookPage");
	    RemoveFilterPage fp = new  RemoveFilterPage(driver);
		fp.getBookLink().click();
		Thread.sleep(3000);
		um.assertion(expBookPage, um.getCurrentUrl());
		Reporter.log("user is able to get Books Page", true);
		
		fp.getFilterOption().click();
		Thread.sleep(3000);
		String expFilterPage = uc.readDataFromPropFile(Constants.propFilePath, "filterProductPage");
		um.assertion(expFilterPage, um.getCurrentUrl());
		Reporter.log("user is able to filter the products", true);
		
		fp.getRemoveFilterLink().click();
		Thread.sleep(2000);
		
		String tcName = "TC_011_RemoveFilter_Test";
		String msg = "user is able to get Page after removing filter";
		um.generateReport(expBookPage, um.getCurrentUrl(),tcName,msg);
	}

}
