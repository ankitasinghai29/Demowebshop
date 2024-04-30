package ST;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.UpdateProfilePage;

public class TC_014_UpdateProfile_Test extends BaseClass {
	
	@Test
	public void validateUserIsAbleToUpdateProfile() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		UpdateProfilePage up = new UpdateProfilePage(driver);
		up.getMyAccLink().click();
		String expAccInfoPage = uc.readDataFromPropFile(Constants.propFilePath, "accountInfoPage");
		um.assertion(expAccInfoPage, um.getCurrentUrl());
		Reporter.log("user is able to get Account Info Page", true);
		
		String newValue = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 3, 3);
		up.getLastNameTextField().clear();
		up.getLastNameTextField().sendKeys(newValue);
		up.getSaveButton().click();
		
		String actValue = up.getLastNameTextField().getAttribute("value");
		
		String tcName = "TC_014_UpdateProfile_Test";
		String msg = "user is able to update the profile";
		um.generateReport(newValue, actValue,tcName,msg);
	}

}
