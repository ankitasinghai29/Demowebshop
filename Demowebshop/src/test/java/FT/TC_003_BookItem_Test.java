package FT;

import java.time.Duration;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.Constants;
import pom.BookItemPage;

public class TC_003_BookItem_Test extends BaseClass {
	
	@Test
	public void valiadteThatUserIsAbleToGetBookItem() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.wait));
		String expBookPage = uc.readDataFromPropFile(Constants.propFilePath, "expBookPage");
	    BookItemPage bp = new BookItemPage(driver);
		bp.getBookLink().click();
		String tcName = "TC_003_BookItem_Test";
		String msg = "user is able to get Books Page";
		um.generateReport(expBookPage, um.getCurrentUrl(),tcName,msg);

	}

}
