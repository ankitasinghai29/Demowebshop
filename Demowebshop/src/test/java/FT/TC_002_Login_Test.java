package FT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.Constants;
import genericLib.UtilityClass;
import genericLib.UtilityMethod;
import pom.LoginPage;

public class TC_002_Login_Test {
	
	@Test
	public void validateThatUserIsAbleToLogin() throws Throwable
	{
		UtilityClass uc = new UtilityClass();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		driver.manage().window().maximize();
		String expUrl = uc.readDataFromPropFile(Constants.propFilePath, "url");
		Reporter.log("User is able to maximize the screen");
		driver.get(expUrl);
		UtilityMethod um = new UtilityMethod(driver); 
		um.assertion(expUrl, um.getCurrentUrl());
		Reporter.log("user is able to open url",true);
		
		LoginPage lp = new LoginPage(driver);
		lp.getLoginLink().click();
		String loginUrl = uc.readDataFromPropFile(Constants.propFilePath, "loginUrl");
		um.assertion(loginUrl, um.getCurrentUrl());
		Reporter.log("user is able to get login page",true);
		
		//Enter valid username	    
		WebElement user = lp.getEmailField();
		String emailId = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 1, 1);
		user.sendKeys(emailId);
		um.assertion(emailId,  user.getAttribute("value"));
		Reporter.log("user is able to send valid emailid",true);
		
		//Enter the valid password
		WebElement pass = lp.getPasswordField();
		String password = uc.readDataFromExcelSingleValue(Constants.excelPath, "TC", 1, 2);
		pass.sendKeys(password);
		um.assertion(password, pass.getAttribute("value"));
		Reporter.log("user is able to send valid password",true);
		
		
		//Click on remember me checkbox
		WebElement rem = lp.getRemCheckBox();
		rem.click();
		um.assertion(true, rem.isSelected());
		Reporter.log("user is able to click on remember checkbox",true);
		
		//click on login button
		lp.getLoginButton().click();
		String homeUrl = uc.readDataFromPropFile(Constants.propFilePath, "homeUrl");
		
		String tcName = "TC_002_Login_Test";
		String msg = "user is able to login into application";
		um.generateReport(homeUrl, um.getCurrentUrl(),tcName,msg);
	    
	    Thread.sleep(2000);
	    driver.quit();
		Reporter.log("User is able to close browser",true);
		
	}

}
