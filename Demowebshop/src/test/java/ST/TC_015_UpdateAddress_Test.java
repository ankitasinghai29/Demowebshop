package ST;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.UpdateAddressPage;

public class TC_015_UpdateAddress_Test extends BaseClass{
	
	@Test
	public void validateUserIsAbleToUpdateAddress() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		UpdateAddressPage ua = new UpdateAddressPage(driver);
		ua.getMyAccLink().click();;
		String expAccInfoPage = uc.readDataFromPropFile(Constants.propFilePath, "accountInfoPage");
		um.assertion(expAccInfoPage, um.getCurrentUrl());
		Reporter.log("user is able to get Account Info Page", true);
		
		ua.getAddressLink().click();
		String expAddressPage = uc.readDataFromPropFile(Constants.propFilePath, "addressPage");
		um.assertion(expAddressPage, um.getCurrentUrl());
		Reporter.log("user is able to get Address Page", true);
		ua.getEditButton().click();
		
		String companyName = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 4, 4);
		ua.getAddressCompanyTextField().clear();
		ua.getAddressCompanyTextField().sendKeys(companyName);
		ua.getSaveButton().click();
		
		String actCompany = ua.getFetchCompanyDetail().getText();

		String tcName = "TC_015_UpdateAddress_Test";
		String msg = "user is able to update existing Address";
		um.generateReport(actCompany, companyName,tcName,msg);
		
	}
}
