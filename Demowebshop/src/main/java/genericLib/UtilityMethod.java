package genericLib;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class UtilityMethod extends BaseClass{

	public WebDriver driver;
	
	public UtilityMethod(WebDriver driver)
	{
		this.driver=driver;
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public void selectByIndex(WebElement ele, int index) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}

	public void selectByValue(WebElement ele, String value) {
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}

	public void selectByVisibleText(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}

	public void assertion(String actual, String expected) {
		assertEquals(actual, expected);

	}

	public void assertion(boolean actual, boolean expected) {
		assertEquals(actual, expected);
	}

	public static String getCuttentTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		String name = localDateTime.toString().replace(":", "-");
		return name;
	}

	public String takeScreenShot(WebDriver driver,String name) {
		String ScreenShotPath = "./ScreenShots/"+ name+UtilityMethod.getCuttentTime() + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(ScreenShotPath);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "." + ScreenShotPath;
	}
	
	public void generateReport(String expUrl,String actUrl,String name, String message) {
		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./ExtentReports/ "+ name+ UtilityMethod.getCuttentTime() + ".html");
		reports.attachReporter(extentSparkReporter);
		ExtentTest extentTest = reports.createTest(name);
		try 
		{
			if (expUrl.equals(actUrl))
			{
				Reporter.log(message, true);
				extentTest.log(Status.INFO, message);
				extentTest.pass(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver,name)).build());
			}
		} 
		catch (Exception e) 
		{
			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver,name)).build());
		}
		reports.flush();

	}

}
