package genericLib;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public UtilityClass uc = new UtilityClass();
	public UtilityMethod um;

	
	@BeforeSuite
    public void beforeSuite()
    {
		Reporter.log("Report Formation start",true);
		Reporter.log("D/B Connection start", true);
    }
	
	@BeforeTest
	public void browserSetUp() throws Throwable
	{
		String browser = uc.readDataFromPropFile(Constants.propFilePath, "browser");
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		Reporter.log("User is able to empty browser",true);
		driver.manage().window().maximize();
		String expUrl = uc.readDataFromPropFile(Constants.propFilePath, "url");
		Reporter.log("User is able to maximize the screen");
		driver.get(expUrl);
		um = new UtilityMethod(driver);
		um.assertion(expUrl, driver.getCurrentUrl());
		Reporter.log("user is able to open url",true);
	}
	
	@BeforeMethod
	public void userLogin() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		LoginPage lp = new LoginPage(driver);
		lp.getLoginLink().click();
		String loginUrl = uc.readDataFromPropFile(Constants.propFilePath, "loginUrl");
		um.assertion(loginUrl, driver.getCurrentUrl());
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
		um.assertion(true,  rem.isSelected());
		Reporter.log("user is able to click on remember checkbox",true);
		
		//click on login button
		lp.getLoginButton().click();
		String homeUrl = uc.readDataFromPropFile(Constants.propFilePath, "homeUrl");
	    um.assertion(homeUrl, driver.getCurrentUrl());
	    Reporter.log("user is able to login into application",true);
		
	}
	
	@AfterMethod
	public void userLogout()
	{
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		Reporter.log("User is able to logout",true);
	}
	
	@AfterTest
	public void tearDownBrowser()
	{
		driver.quit();
		Reporter.log("User is able to close browser",true);
	}
	
	
	@AfterSuite
    public void afterSuite()
    {
		Reporter.log("Report Formation stop",true);
		Reporter.log("D/B Connection stop", true);
    }
	
	
	
    
}
