package ST;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.ChangePassPage;

public class TC_013_ChangePass_Test extends BaseClass{
	
	@Test
	public void validateThatUserIsAbleToChangePassword() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		ChangePassPage cp = new ChangePassPage(driver);
		cp.getMyAccLink().click();
		String expAccInfoPage = uc.readDataFromPropFile(Constants.propFilePath, "accountInfoPage");
		um.assertion(expAccInfoPage, um.getCurrentUrl());
		Reporter.log("user is able to get Account Info Page", true);
	
		cp.getChangePassLink().click();
		String expChangePassPage = uc.readDataFromPropFile(Constants.propFilePath, "changePassPage");
		um.assertion(expChangePassPage, um.getCurrentUrl());
		Reporter.log("user is able to get change Password Page", true);
		
		String oldPass = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 1, 2);
		cp.getOldPasswordTextBox().sendKeys(oldPass);
		String newPass = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 2, 1);
		cp.getNewPasswordTextBox().sendKeys(newPass);
		cp.getConfirmPasswordTextBox().sendKeys(newPass);
		cp.getChangePasswordButton().click();
		
		uc.writeDataInExcelOneCell(Constants.excelPath,"TC", 1, 2, newPass);
		String actPass = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 1, 2);
	
		String tcName = "TC_013_ChangePass_Test";
		String msg = "user is able to Change Password";
		um.generateReport(actPass, newPass,tcName,msg);
		
	}

}
