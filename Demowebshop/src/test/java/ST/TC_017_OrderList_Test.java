package ST;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.OrderListPage;


public class TC_017_OrderList_Test extends BaseClass{
	
	@Test
	public void validateThatUserIsAbleToGetItemInOrderList() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		OrderListPage op = new OrderListPage(driver);
		
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
		um.assertion(expOrderPlacePage, um.getCurrentUrl());
		Reporter.log("user is able to place order sucessfully", true);
		
		String orderNo = op.getOrderNoField().getText();
		
		op.getContinueShopButton().click();
		op.getOrderLink().click();
		String orderListPage = uc.readDataFromPropFile(Constants.propFilePath, "orderListPage");
		um.assertion(orderListPage, um.getCurrentUrl());
		Reporter.log("user is able to get order list page", true);
		
		List <WebElement> orderNoList = op.getOrderNoList();
		for(WebElement ele:orderNoList)
		{
			if(orderNo.equalsIgnoreCase(ele.getText()))
			{
				String tcName = "TC_017_OrderList_Test";
				String msg = "user is able to get order in the order list";
				um.generateReport("", "",tcName,msg);
				break;
			}
			
		}
		
		
	}

}
