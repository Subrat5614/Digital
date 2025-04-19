package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.LostHours;

public class LostHours_CRUD extends BaseClass {
    private boolean isExpandSummaryLeftMenu = false;

    // SELECT * FROM logistics.trip_events
    // where parent_uuid = '346f2b57-321c-4863-aade-8ece4099691c'
    // ORDER BY id ASC

    @Test(priority = 1, dependsOnMethods = "ShiftInsights", dataProvider = "getLostHours", dataProviderClass = TestDataProvider.class)
    public void CreateLostHours(String EventType, String Comments) throws InterruptedException {
        System.out.println("Event Type: " + EventType + "\nComments: " + Comments);
        LostHours lostHours = new LostHours(driver);
        wait.customWait();
        // if (!isExpandSummaryLeftMenu) {
        // action.moveToElement(driver.findElement(By.className("summary"))).click().perform();
        // isExpandSummaryLeftMenu = true; // Mark the button as clicked
        // }
        // // wait.customWait();
        // action.moveToElement(ele.getSearchField()).pause(5000).moveToElement(summary.getShiftsNav()).click().pause(3000)
        // .perform();
        // action.moveToElement(wait.waitForElementToBeClickable(ele.getDetailsButton())).click().perform();
        action.moveToElement(ele.getSearchField()).pause(5000)
                .moveToElement(wait.waitForElementToBeClickable(lostHours.getlosttHoursNav(), 2000)).click().perform();
        action.moveToElement(wait.waitForElementToBeClickable(lostHours.getAddLostHoursButton())).click().perform();
        wait.waitForElementPresent(lostHours.getEventTypeDD()).click();
        wait.waitForElementPresent(ele.getSingleDropdownFilter()).sendKeys(EventType);
        driver.findElement(By.xpath("//li[@aria-label='" + EventType + "']")).click();
        wait.waitForElementPresent(lostHours.getStartTime()).click();
        wait.waitForElementPresent(ele.getToday()).click();
        wait.waitForElementPresent(ele.getOkBUtton()).click();
        wait.waitForElementPresent(lostHours.getEndTime()).click();
        wait.waitForElementPresent(ele.getToday()).click();
        wait.waitForElementPresent(ele.getOkBUtton()).click();
        wait.waitForElementPresent(ele.getCommentsText()).sendKeys(Comments);
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 2, dataProvider = "getLostHours", dataProviderClass = TestDataProvider.class)
    public void UpdateLostHours(String EventType, String Comments) throws InterruptedException {
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        ele.getSearchField().sendKeys(EventType);
        String editLostHoursButton = String.format("//td[.='%s']/..//button", EventType);
        wait.waitForElementToBeClickable(driver.findElement(By.xpath(editLostHoursButton))).click();
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 3, dataProvider = "getLostHours", dataProviderClass = TestDataProvider.class)
    public void DeleteLostHours(String EventType, String Comments) throws InterruptedException {
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        ele.getSearchField().sendKeys(EventType);
        String deleteLostHoursButton = String.format("//td[.='%s']/..//button[2]", EventType);
        wait.waitForElementToBeClickable(driver.findElement(By.xpath(deleteLostHoursButton))).click();
        wait.waitForElementPresent(
                (ele.getSaveButton().isDisplayed() ? ele.getSaveButton() : ele.getCancelButton()))
                .click();
        toastHandler.handleRedToastAfterAction();
    }

}
