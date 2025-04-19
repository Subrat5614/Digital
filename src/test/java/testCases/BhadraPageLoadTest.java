package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BhadraSummary;
import pages.Dimension;
import pages.Events;
import pages.GeneralElement;
import pages.MasterData;
import pages.Plans;
import pages.Scheduler;
import pages.Shifts;
import pages.User;
import utilities.Screenshots;
import utilities.ToastMessageHandler;
import utilities.config;

public class BhadraPageLoadTest extends BaseClass {
	@Test(priority = 1)
	public void UsersTab() throws IOException, InterruptedException {
	driver.get(config.getProperty("url") + "users");
	User user = new User(driver);
	wait.waitForElementPresent(user.getAddUserButton()).click();
	Assert.assertTrue(isPageLoaded(), "Create user page is loaded");
	clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
	toastHandler.handleRedToastAfterAction();
	wait.waitForElementPresent(ele.getEditButton()).click();
	Assert.assertTrue(isPageLoaded(), "Edit user page is loaded");
	clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
	toastHandler.handleRedToastAfterAction();
	wait.waitForElementPresent(ele.getDeleteButton()).click();
	Assert.assertTrue(isPageLoaded(), "Delete confirmation loaded");
	ele.getNoButton().click();
	}	
	@Test(priority = 2)
	public void EventsTab() throws IOException, InterruptedException {
		driver.get(config.getProperty("url") + "events");
		Events events = new Events(driver);
		events.getAddEvents().click();
		Assert.assertTrue(isPageLoaded(), "Create events page is loaded successfully");
		clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
		toastHandler.handleRedToastAfterAction();
		events.getEditEvents().click();
		Assert.assertTrue(isPageLoaded(), "Update events page is loaded successfully");
		clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
		toastHandler.handleRedToastAfterAction();
		wait.waitForElementPresent(events.getDeleteEvents()).click();
		Assert.assertTrue(isPageLoaded(), "Delete events page is loaded successfully");
		ele.getNoButton().click();
	}

	@Test(priority = 3)
	public void MasterDataTab() throws IOException, InterruptedException {
		driver.get(config.getProperty("url") + "master-data");
		MasterData masterdata = new MasterData(driver);
		masterdata.getAddMasterCode().click();
		clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
		toastHandler.handleRedToastAfterAction();
		ele.getSearchField().sendKeys("Undefined");
		masterdata.getCodeUndefinedEditButton().click();
		clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
		toastHandler.handleRedToastAfterAction();
		wait.customWait();
		ele.getSearchField().sendKeys("Undefined");
		masterdata.getCodeUndefinedExpandButton().click();
		wait.waitForElementPresent(masterdata.getAddMasterDetail()).click();
		clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
		toastHandler.handleRedToastAfterAction();
		wait.waitForElementPresent(masterdata.getDetailsUndefinedEditButton()).click();
		clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
		toastHandler.handleRedToastAfterAction();
		wait.customWait();
		masterdata.getDetailsUndefinedDeleteButton().click();
		ele.getYesButton().click();
		wait.waitForElementPresent(masterdata.getCodeUndefinedDeleteButton()).click();
		ele.getYesButton().click();
	}

	// @Test(priority = 4)
	public void SummaryTab() throws IOException, InterruptedException {
		Shifts shift = new Shifts(driver);
		Dimension dimension = new Dimension(driver);
		Plans plans = new Plans(driver);
		navigateToSummarySection(summary, ele);
		shiftAction(shift, ele, toastHandler, screenshot);
		summary.getHomeLink().click();
		ele.getActionButton().click();
		ele.getDeleteButton().click();
		ele.getYesButton().click();
		summary.getDimensionsNav().click();
		dimensionAction(dimension, ele, toastHandler, screenshot);
		summary.getPlansNav().click();
		planAction(plans, ele, toastHandler, screenshot);
	}
	@Test(priority = 5)
	public void SchedularTab() throws IOException, InterruptedException{
		driver.get(config.getProperty("url") + "scheduler");
		Scheduler scheduler = new Scheduler(driver);
		scheduler.getAddSchedulerButton().click();
		Assert.assertTrue(isPageLoaded(), "Create scheduler page is loaded successfully");
		clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
		toastHandler.handleRedToastAfterAction();
		wait.waitForElementToBeClickable(ele.getEditButton()).click();
		Assert.assertTrue(isPageLoaded(), "Edit scheduler page is loaded successfully");
		clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
		toastHandler.handleRedToastAfterAction();
		wait.waitForElementToBeClickable(ele.getDeleteButton()).click();
		Assert.assertTrue(isPageLoaded(), "Delete scheduler page is loaded successfully");
		// wait.waitForElementPresent(ele.getYesButton(), 5).click();
		wait.waitForElementPresent(ele.getNoButton(), 5).click();
	}

	@Test(priority = 6)
	public void UserDetailsLogout() {
		action.moveToElement(wait
				.waitForElementPresent(driver.findElement(By.xpath("//div[contains(@class,'accountMenu')]/button")),5))
				.click().perform();
		wait.waitForElementPresent(driver.findElement(By.xpath("//span[.='User Details']/../..")),5).click();
		wait.waitForElementPresent(ele.getCloseButton(), 5).click();
		wait.waitForElementPresent(driver.findElement(By.xpath("//a[contains(@class,'logout')]/..")),5)
				.click();
		wait.waitForElementPresent(driver.findElement(By.name("confirmLogout")), 5).click();
	}

	private void planAction(Plans plans, GeneralElement ele, ToastMessageHandler toastHandler, Screenshots screenshot)
			throws IOException, InterruptedException {
		plans.getAddPlansButton().click();
		wait.waitForElementPresent(ele.getSaveButton(), 5)
				.click();
		if (ele.getSaveButton().isDisplayed())
			toastHandler.handleRedToastAfterAction();
		ele.getActionButton().click();
		wait.waitForElementPresent(ele.getEditButton()).click();
		wait.waitForElementPresent(ele.getSaveButton(), 5)
				.click();
		if (ele.getSaveButton().isDisplayed())
			toastHandler.handleRedToastAfterAction();
		ele.getActionButton().click();
		ele.getDeleteButton().click();
		ele.getNoButton().click();
		// if (ele.getSaveButton().isDisplayed())
		// toastHandler.handleRedToastAfterAction();
	}

	private void dimensionAction(Dimension dimension, GeneralElement ele, ToastMessageHandler toastHandler,
			Screenshots screenshot) throws IOException, InterruptedException {
		wait.waitForElementPresent(dimension.getAddDimensionButton()).click();
		wait.waitForElementPresent(ele.getSaveButton(), 5)
				.click();
		if (ele.getSaveButton().isDisplayed())
			toastHandler.handleRedToastAfterAction();
		ele.getActionButton().click();
		wait.waitForElementPresent(ele.getEditButton()).click();
		wait.waitForElementPresent(ele.getSaveButton(), 5)
				.click();
		if (ele.getSaveButton().isDisplayed())
			toastHandler.handleRedToastAfterAction();
		ele.getActionButton().click();
		ele.getDeleteButton().click();
		ele.getYesButton().click();
		if (ele.getSaveButton().isDisplayed())
			toastHandler.handleRedToastAfterAction();
	}

	private void shiftAction(Shifts shift, GeneralElement ele, ToastMessageHandler toastHandler, Screenshots screenshot)
			throws IOException, InterruptedException {
		wait.clickWithRetry(shift.getAddShiftButton(), 5);
		wait.clickWithRetry(shift.getShiftNumberDropdown(), 5);
		// shift.getShiftNumberDropdown().click();
		// shift.getShiftA().click();
		shift.getShiftB().click();
		// shift.getShiftC().click();
		shift.getShiftDate().click();
		shift.getShiftToday().click();
		wait.waitForElementPresent(ele.getSaveButton(), 5)
				.click();
		if (ele.getSaveButton().isDisplayed())
			toastHandler.handleRedToastAfterAction();
		// ele.getActionButton().click();
		wait.waitForElementPresent(ele.getEditButton(),5).click();
		wait.waitForElementPresent(ele.getSaveButton(), 5)
				.click();
		if (ele.getSaveButton().isDisplayed())
			toastHandler.handleRedToastAfterAction();
		wait.customWait();
		wait.waitForElementToBeClickable(ele.getDetailsButton(), 5).click();
		// wait.waitForElementPresent(shift.getProductionDataNav(), 10).click();
		wait.clickWithRetry(shift.getAddProductionData(), 5);
		wait.waitForElementPresent(ele.getSaveButton(), 5)
				.click();
		if (ele.getSaveButton().isDisplayed())
			toastHandler.handleRedToastAfterAction();
	}

	private void navigateToSummarySection(BhadraSummary summary, GeneralElement ele)
			throws InterruptedException, NumberFormatException, IOException {
		action.moveToElement(driver.findElement(By.className("summary"))).click().perform();
		// wait.waitForElementPresent(summary.getSummaryLeftNav()).click();
		action.moveToElement(ele.getSearchField()).perform();
		wait.customWait();
		wait.waitForElementToBeClickable(summary.getDimensionsNav(), 5).click();
		wait.customWait();
		wait.waitForElementToBeClickable(summary.getPlansNav(), 5).click();
		wait.customWait();
		wait.waitForElementToBeClickable(summary.getconfigureEmailsNav(), 5).click();
		wait.customWait();
		wait.waitForElementToBeClickable(summary.getShiftsNav(), 5).click();
		System.out.println("Summary section is navigate successfully");
	}

	private void navigateToHomeAndRetry(BhadraSummary summary, Shifts shift, Dimension dimension, Plans plans,
			GeneralElement ele, ToastMessageHandler toastHandler, Screenshots screenshot)
			throws InterruptedException, NumberFormatException, IOException {
		Thread.sleep(10000);
		summary.getHomeLeftNav().click();
		Thread.sleep(2000);
		navigateToSummarySection(summary, ele);
		Thread.sleep(2000);
		shiftAction(shift, ele, toastHandler, screenshot);
		Thread.sleep(2000);
		summary.getHomeLink().click();
		dimensionAction(dimension, ele, toastHandler, screenshot);
		Thread.sleep(2000);
		planAction(plans, ele, toastHandler, screenshot);
		Thread.sleep(2000);
	}

	private boolean isPageLoaded() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			return wait.until(driver -> ((JavascriptExecutor) driver)
					.executeScript("return document.readyState").equals("complete"));
		} catch (Exception e) {
			return false;
		}
	}

}
