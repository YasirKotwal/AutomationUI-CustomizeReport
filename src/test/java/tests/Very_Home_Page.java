package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import globalUtilities.DriverManager;
import pages.HomePage;

public class Very_Home_Page extends DriverManager {

	/**
	 * @author yasir
	 * 
	 *         Test to validate automate the given scenario.
	 * 
	 */

	HomePage homePage;

	public Very_Home_Page() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
	}

	@Test(enabled = true)
	public void startCreatingQuickFuseApp() throws InterruptedException, AWTException {

		homePage.clickCreateAnApp();
		homePage.clickOnLetsGetStarted();
		homePage.createNewPage();
		homePage.clickMessagingLink();
		homePage.dragAndDropSmslWidget();
		homePage.enterValuesInsmsAndEmailwidgets();
		homePage.dragHangups();
		homePage.connectWidgets();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(5000);
	}

}

