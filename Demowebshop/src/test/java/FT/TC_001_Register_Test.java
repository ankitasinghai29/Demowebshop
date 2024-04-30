package FT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLib.Constants;
import genericLib.UtilityClass;
import genericLib.UtilityMethod;
import pom.RegisterPage;

public class TC_001_Register_Test {
	UtilityClass uc;
	UtilityMethod um;
	
	@Test(dataProvider = "register")
	public void validateThatUserIsAbleToRegister(String[] data) throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		Reporter.log("User is able to empty browser",true);
		driver.manage().window().maximize();
		String expUrl = uc.readDataFromPropFile(Constants.propFilePath, "url");
		Reporter.log("User is able to maximize the screen");
		driver.get(expUrl);
		uc = new UtilityClass();
		um = new UtilityMethod(driver);
		um.assertion(expUrl, um.getCurrentUrl());
		Reporter.log("user is able to open url",true);
		
		
		RegisterPage rp = new RegisterPage(driver);
		rp.getRegisterLink().click();
		if(data[0].equalsIgnoreCase("male"))
			rp.getMaleRadioButton().click();
		if(data[0].equalsIgnoreCase("female"))
			rp.getFemaleRadioButton().click();
		rp.getFirstNameText().sendKeys(data[1]);
		rp.getLastNameText().sendKeys(data[2]);
		rp.getEmailId().sendKeys(data[3]);
		rp.getPassword().sendKeys(data[4]);
		rp.getConfirmPassword().sendKeys(data[5]);
		rp.getRegisterButton().click();
		Thread.sleep(10);
		driver.quit();
	}
	
	@DataProvider(name="register")
	public String[][] dataSupply() throws Exception
	{
		uc = new UtilityClass();
	  return uc.readDataFromExcelFullSheet(Constants.excelPath, "registerData");
	}

}
