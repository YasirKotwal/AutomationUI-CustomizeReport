package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import globalUtilities.DriverManager;

public class HomePage extends DriverManager {

	/**
	 * @author yasir
	 */

	private WebDriverWait wait;

	@FindBy(id = "link-create")
	WebElement createApp;

	@FindBy(xpath = "//button")
	WebElement letsStartedButton;

	@FindBy(id = "add-page")
	WebElement createNewPage;

	@FindBy(xpath = "//*[@id='create-dialog']//input[@name='name']")
	WebElement newPageName;

	@FindBy(id = "//div[20]/div[3]/button[1][text()='Create']")
	WebElement newPageNameButton;

	@FindBy(id = "//button[text()='Cancel'][@title='']")
	WebElement cancecButton;

	@FindBy(xpath = "//a[contains(text(), 'Messaging')]")
	WebElement messagingButton;

	// @FindBy(xpath = "//*[@id='accordion']/div[4]/ul/li[2]")
	@FindBy(xpath = "//*[@id='accordion']//li[2][text()='Send an Email']")
	WebElement emailWidget;

	@FindBy(xpath = "//*[@id='accordion']//li[3][text()='Send an SMS']")
	WebElement smsWidget;

	@FindBy(xpath = "//*[@name='phone_constant']")
	WebElement smsWidgetName;

	@FindBy(xpath = "//div[2]//textarea[@name='message_phrase[]'][@class='syn-autoexpand syn-constant syn-autogrow']")
	WebElement smsWidgetMessage;

	@FindBy(xpath = "//*[@name='smtp_url']")
	WebElement emailWidgetHost;

	@FindBy(xpath = "//*[@name='port']")
	WebElement emailWidgetPort;

	// Side panel
	@FindBy(xpath = "//a[contains(text(), 'Basic')]")
	WebElement basicRightPanel;

	@FindBy(xpath = "//*[@id='accordion']//li[1][text()='Hang Up or Exit']")
	WebElement hangUpWidget;

	@FindBy(xpath = "//input[@name='username'][@class='text']")
	WebElement emailWidgetUsername;

	@FindBy(xpath = "//input[@name='password']")
	WebElement emailWidgetPassword;

	@FindBy(xpath = "//div[@class='panel-section-nominimize']//*[@name='from_constant']")
	WebElement emailWidgetFrom;

	@FindBy(xpath = "//textarea[@name='to_constant']")
	WebElement emailWidgetTo;

	// @FindBy(xpath =
	// "//*[@id='module-2']//textarea[@name='subject_constant']")
	@FindBy(xpath = "//textarea[@name='subject_constant']")
	WebElement emailWidgetSubject;

	@FindBy(xpath = "//textarea[@name='cc_constant']")
	WebElement emailWidgetCC;

	@FindBy(xpath = "//div[1]/div[3]/div/div[3]//table/tbody/tr/td[1]/div//textarea[@name='message_phrase[]']")
	WebElement emailWidgetTextMessage;

	@FindBy(xpath = "//div[@id='module-1']//*[@class='syn-node ui-draggable syn-node-active']")
	// @FindBy(xpath = "//*[@class='syn-node ui-draggable']")
	WebElement start;

	@FindBy(xpath = "//div[@id='module-2']//*[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']")
	WebElement sendSMS;

	@FindBy(xpath = "//div[@id='module-1']//*[@class='syn-node syn-node-attached-e ui-draggable syn-node-active']")
	WebElement sendSMStoEmail;

	@FindBy(xpath = "//div[@id='module-2']//*[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']")
	WebElement sendEmail;

	// Hangup
	@FindBy(xpath = "//div[@id='module-4']//*[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']")
	WebElement hangup1;

	@FindBy(xpath = "//div[@id='module-3']//*[@class='syn-node syn-node-attached-w ui-draggable']")
	WebElement Mailtohangup1;

	@FindBy(xpath = "//div[@id='module-3']//*[@class='syn-node syn-node-attached-e ui-draggable syn-node-active']")
	WebElement senMailhangup2;

	@FindBy(xpath = "//div[@id='module-6']//*[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']")
	WebElement hangup2;

	@FindBy(xpath = "//div[@id='module-2']//*[@class='syn-node syn-node-attached-w ui-draggable syn-node-active']")
	WebElement sendSMSHungup1;

	@FindBy(xpath = "//div[@id='module-2']//*[@class='syn-node syn-node-attached-w ui-draggable syn-node-active']")
	WebElement hangup3;

	public HomePage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 60);
	}

	public boolean verifyCreateAnApp() {
		return createApp.isDisplayed();
	}

	public HomePage clickCreateAnApp() {
		wait.until(ExpectedConditions.elementToBeClickable(createApp));
		createApp.click();
		System.out.println("Create App clicked");
		return this;
	}

	public HomePage clickOnLetsGetStarted() {
		wait.until(ExpectedConditions.elementToBeClickable(letsStartedButton));
		letsStartedButton.click();
		System.out.println("Lets Start Clicked");
		return this;
	}

	public HomePage createNewPage() throws InterruptedException {
		createNewPage.click();
		newPageName.sendKeys("NewPage");
		newPageName.sendKeys(Keys.ENTER);
		System.out.println("New Page has been created");
		return this;
	}

	public HomePage clickMessagingLink() {
		wait.until(ExpectedConditions.elementToBeClickable(messagingButton));
		messagingButton.click();
		System.out.println("messaging clicked");
		return this;
	}

	public void dragAndDropSmslWidget() throws InterruptedException, AWTException {
		Actions action = new Actions(driver);
		Robot robot = new Robot();
		robot.setAutoDelay(50);
		driver.manage().window().fullscreen();
		action.dragAndDropBy(smsWidget, 400, 200).build().perform();
		action.dragAndDropBy(emailWidget, 850, 200).build().perform();
		System.out.println("SMS Widget Dragged");
	}

	public void dragAndDropEmailWidget() {
		Actions action1 = new Actions(driver);

		action1.dragAndDropBy(emailWidget, 800, 200).build().perform();
		System.out.println("EmmailWidget Dragged");
	}

	public HomePage enterValuesInsmsAndEmailwidgets() {
		smsWidgetName.sendKeys("32323232323");
		smsWidgetMessage.sendKeys("Hello World");
		emailWidgetHost.sendKeys("smtp.gmail.com");
		emailWidgetPort.sendKeys("465");
		emailWidgetUsername.sendKeys("abc@gmail.com");
		emailWidgetPassword.sendKeys("12345");
		emailWidgetFrom.sendKeys("abc@gmail.com");
		emailWidgetTo.sendKeys("xyz@gmail.com");
		emailWidgetSubject.sendKeys("SMS not sent");
		emailWidgetCC.sendKeys("xyz@gmail.com");
		emailWidgetTextMessage.sendKeys("SMS to phone number 32323232323");

		System.out.println("Text entered into teh widgets");

		return this;
	}

	public void dragHangups() throws InterruptedException, AWTException {
		basicRightPanel.click();
		Robot robot = new Robot();
		robot.setAutoDelay(50);
		Actions action = new Actions(driver);
		action.dragAndDropBy(hangUpWidget, 300, 400).build().perform();
		action.dragAndDropBy(hangUpWidget, 500, 500).build().perform();
		action.dragAndDropBy(hangUpWidget, 1150, 500).build().perform();
		System.out.println("All the hang up are dragged");

	}

	public void connectWidgets() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(50);
		Actions action = new Actions(driver);
		action.dragAndDrop(start, sendSMS).build().perform();
		System.out.println("Next Line");
		action.dragAndDrop(Mailtohangup1, hangup1).build().perform();
		action.dragAndDrop(senMailhangup2, hangup2).build().perform();
		action.dragAndDrop(sendSMStoEmail, sendEmail).build().perform();
		action.dragAndDrop(sendSMSHungup1, hangup3).build().perform();

	}

}
