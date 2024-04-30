package FT;

import java.time.Duration;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.CartPage;

public class TC_004_Cart_Test extends BaseClass{
	
	@Test
	public void validateThatUserIsAbleToClickOnWishlist() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		String expCartPage = uc.readDataFromPropFile(Constants.propFilePath, "expCartPage");
		CartPage cp = new CartPage(driver);
		cp.getCartLink().click();
		String tcName = "TC_004_Cart_Test";
		String msg = "User is able to click shopping cart";
		um.generateReport(expCartPage, um.getCurrentUrl(),tcName,msg);
	
	}

}
