package ST;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.AddNewAddressPage;

public class TC_016_AddNewAddress_Test extends BaseClass {
	
	@Test
	public void vaidateThatUserIsAbleToAddNewAddress() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		AddNewAddressPage ap = new AddNewAddressPage(driver);
		ap.getMyAccLink().click();;
		String expAccInfoPage = uc.readDataFromPropFile(Constants.propFilePath, "accountInfoPage");
		um.assertion(expAccInfoPage, um.getCurrentUrl());
		Reporter.log("user is able to get Account Info Page", true);
		
		ap.getAddressLink().click();
		String expAddressPage = uc.readDataFromPropFile(Constants.propFilePath, "addressPage");
		um.assertion(expAddressPage, um.getCurrentUrl());
		Reporter.log("user is able to get Address Page", true);
		
		ap.getAddNewButton().click();
		String firstName = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 5, 1);
		String lastName = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 5, 2);
		String email = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 5, 3);
		String country = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 5, 5);
		String city = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 5, 6);
		String address = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 5, 7);
		String pincode = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 5, 8);
		String phone = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 5, 9);
		
		ap.getFirstNameField().sendKeys(firstName);
		ap.getLastNameField().sendKeys(lastName);
		ap.getEmailField().sendKeys(email);
		
		um.selectByVisibleText(ap.getCountryDropDown(), country);
		
		ap.getCityField().sendKeys(city);
		ap.getAddressField().sendKeys(address);
		ap.getPincodeField().sendKeys(pincode);
		ap.getPhoneField().sendKeys(phone);
		ap.getSaveButton().click();
		
		String tcName = "TC_018_AddNewAddress_Test";
		String msg = "user is able to get new Address";
		um.generateReport(expAddressPage, um.getCurrentUrl(),tcName,msg);
	}

}
