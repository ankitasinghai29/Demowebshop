package ST;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.OrderPlacePage;

public class TC_018_OrderPlace_Test extends BaseClass{
	
	@Test
	public void validateThatUserIsAbleToPlaceOrder() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		OrderPlacePage op = new OrderPlacePage(driver);
		
		op.getBookLink().click();
		String expBookPage = uc.readDataFromPropFile(Constants.propFilePath, "expBookPage");
		um.assertion(expBookPage, um.getCurrentUrl());
		Reporter.log("user is able to get Books Page", true);
		
		op.getItemAddToCart().click();
		op.getCartLink().click();
		Thread.sleep(3000);
		String expCartPage = uc.readDataFromPropFile(Constants.propFilePath, "expCartPage");
		um.assertion(expCartPage, um.getCurrentUrl());
		Reporter.log("User is able to click shopping cart",true);
		
		op.getTncCheckBox().click();
		op.getCheckOutButton().click();
		
		String expOrderCheckoutPage = uc.readDataFromPropFile(Constants.propFilePath, "orderCheckOutPage");
		um.assertion(expOrderCheckoutPage, um.getCurrentUrl());
		Reporter.log("user is able to get order checkout Page", true);
		
		op.getBillingAddContinueButton().click();
		op.getShippingAddContinueButton().click();
		op.getShippingMethodContinueMethod().click();
		op.getPaymentMethodContinueButton().click();
		op.getPaymentInfoContinueButton().click();
		Thread.sleep(5000);
		op.getConfirmButton().click();
		Thread.sleep(5000);
		String expOrderPlacePage = uc.readDataFromPropFile(Constants.propFilePath, "orderPlacePage");
		
		String tcName = "TC_016_OrderPlace_Test";
		String msg = "user is able to place order sucessfully";
		um.generateReport(expOrderPlacePage, um.getCurrentUrl(),tcName,msg);
	}

}
