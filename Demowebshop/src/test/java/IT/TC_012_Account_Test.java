package IT;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.AccountPage;

public class TC_012_Account_Test extends BaseClass{
	
	@Test
	public void valiadteThatUserIsAbleToGetAccountByEmail() throws Throwable
	{
		AccountPage ap = new AccountPage(driver);
		ap.getEmailLink().click();
		Thread.sleep(2000);
		String expAccInfoPage = uc.readDataFromPropFile(Constants.propFilePath, "accountInfoPage");
		
		String tcName = "TC_012_Account_Test";
		String msg = "user is able to get Account Info Page";
		um.generateReport(expAccInfoPage, um.getCurrentUrl(),tcName,msg);
	}

}
