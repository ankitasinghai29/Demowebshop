package IT;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.ItemInCartPage;

public class TC_007_CartItem_Test extends BaseClass {
	
	@Test
	public void valiadteThatUserIsAbleToAddItemInCart() throws Throwable
	{
		String expBookPage = uc.readDataFromPropFile(Constants.propFilePath, "expBookPage");
		ItemInCartPage ip = new ItemInCartPage(driver);
		ip.getBookLink().click();
		um.assertion(expBookPage, um.getCurrentUrl());
		Reporter.log("user is able to get Books Page", true);
		ip.getItemAddToCart().click();
		Thread.sleep(4000);
		WebElement popup = ip.getBarNotification();
		Thread.sleep(1000);
		String popupValue = popup.getAttribute("style");
		String popupValueIdeal = "display: none;";
		
		String tcName = "TC_007_CartItem_Test";
		String msg = "user is able to get Add to cart popup";
		um.generateReport(popupValueIdeal, popupValue,tcName,msg);
		
	}


}
