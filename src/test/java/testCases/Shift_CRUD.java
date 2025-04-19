package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.Shifts;

public class Shift_CRUD extends BaseClass {
        @Test(priority = 1)
        public void CreateShift() throws IOException, InterruptedException {
                Shifts shift = new Shifts(driver);         
                wait.customWait();
                action.moveToElement(driver.findElement(By.className("summary"))).click().perform();
                action.moveToElement(ele.getSearchField()).pause(5000).moveToElement(shift.getAddShiftButton()).click()
                                .perform();
                wait.waitForElementToBeClickable(shift.getShiftNumberDropdown()).click();
                shift.getShiftA().click();
                // shift.getShiftB().click();
                // shift.getShiftC().click();
                shift.getShiftDate().click();
                shift.getShiftToday().click();
                // wait.waitForElementPresent(
                //                 (ele.getSaveButton().isDisplayed() ? ele.getSaveButton() : ele.getCancelButton()))
                //                 .click();
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
        }

        @Test(priority = 2)
        public void UpdateShift() throws IOException, InterruptedException {
                wait.customWait();
                wait.waitForElementToBeClickable(ele.getEditButton()).click();
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
        }
        @Test(priority = 3)
        public void GenerateShiftReport() throws InterruptedException{
                wait.customWait();
                wait.waitForElementToBeClickable(ele.getActionButton()).click();
                wait.waitForElementToBeClickable(ele.getSendReportButton()).click();
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
                System.out.println("Shift Report Generated");
        }
        @Test(priority = 4)
        public void GenerateDailyProductionReport() throws InterruptedException{
                wait.customWait();
                wait.waitForElementToBeClickable(ele.getCustomSendReport()).click();
                wait.waitForElementToBeClickable(ele.getSendReportDateTextField()).click();
                wait.waitForElementToBeClickable(ele.getToday()).click();
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
                System.out.println("Daily Production Report Generated");
        }
        @Test(priority = 5)
        public void ShiftInsights() throws IOException, InterruptedException {
                wait.customWait();
                wait.waitForElementToBeClickable(ele.getDetailsButton()).click();
                System.out.println("Shift Insights");
        }

}
