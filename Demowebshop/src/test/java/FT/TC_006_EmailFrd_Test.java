package FT;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.EmailItemPage;


public class TC_006_EmailFrd_Test extends BaseClass {
	
	@Test
	public void valiadteThatUserIsAbleToSendMail() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		String expBookPage = uc.readDataFromPropFile(Constants.propFilePath, "expBookPage");
		
		EmailItemPage ep = new EmailItemPage(driver);
		ep.getBookLink().click();
		assertEquals(expBookPage, um.getCurrentUrl());
		Reporter.log("user is able to get Books Page", true);
		ep.getBookItem().click();
		ep.getEmailButton().click();
		String expEmailFrdPage = uc.readDataFromPropFile(Constants.propFilePath, "expEmailFrdPage");
		
		String tcName = "TC_006_EmailFrd_Test";
		String msg = "User is able to get Email Friend Page";
		um.generateReport(expEmailFrdPage, um.getCurrentUrl(),tcName,msg);
		
	}

}
