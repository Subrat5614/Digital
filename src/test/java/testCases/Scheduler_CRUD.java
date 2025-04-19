package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Scheduler;
import utilities.config;

public class Scheduler_CRUD extends BaseClass{
   @Test(priority = 1)
    public void CreateScheduler() throws IOException, InterruptedException{
        driver.get(config.getProperty("url") + "scheduler");
        Scheduler scheduler = new Scheduler(driver);
        scheduler.getAddSchedulerButton().click();
        scheduler.getReportTypeDropdown().click();
		scheduler.getMemoReportOption().click();
		scheduler.getCustomReportNameTextField().sendKeys("Memo Report");
		scheduler.getSelectRangeDropdown().click();
		scheduler.getTodayOption().click();
		scheduler.getSelectTypeDropdown().click();
		scheduler.getDailyOption().click();
		scheduler.getSelectTime().sendKeys("05:00 PM");
		scheduler.getStartDate().click();
		ele.getToday().click();
		// ele.getOkBUtton().click();
		scheduler.getEndDate().click();
		scheduler.getNextDate().click();
		// ele.getOkBUtton().click();
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction(); 
    }
    @Test(priority = 2)
    public void UpdateScheduler() throws IOException, InterruptedException{
        wait.customWait();
        wait.waitForElementPresent(ele.getEditButton()).click();
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction(); 
    }
    @Test(priority = 3)
    public void DeleteScheduler() throws IOException, InterruptedException{
        wait.customWait();
        wait.waitForElementPresent(ele.getDeleteButton()).click();
        wait.waitForElementPresent(ele.getDeleteConfirmButton()).click();
        ele.getDeleteConfirmButton().click();
    }
}

