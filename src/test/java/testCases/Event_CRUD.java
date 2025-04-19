package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.Events;
import utilities.config;

public class Event_CRUD extends BaseClass {
        @Test(priority = 1, dataProvider = "getEventData", dataProviderClass = TestDataProvider.class)
        public void CreateEvent(String EventName, String EventType, String EventCode)
                        throws IOException, InterruptedException {
                System.out.println(
                                "EventName: " + EventName + "\nEventType: " + EventType + "\nEventCode: " + EventCode);
                driver.get(config.getProperty("url") + "events");
                Events event = new Events(driver);
                event.getAddEvents().click();
                event.getEventNameTextField().sendKeys(EventName);
                event.getEventTypeTextField().sendKeys(EventType);
                event.getEventCodeTextField().sendKeys(EventCode);
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
        }

        @Test(priority = 2, dataProvider = "getEventData", dataProviderClass = TestDataProvider.class)
        public void UpdateEvent(String EventName, String EventType, String EventCode)
                        throws IOException, InterruptedException {
                wait.customWait();
                action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
                ele.getSearchField().sendKeys(EventName);
                String editEventButton = String.format("//td[.='%s']/../..//button", EventName);
                driver.findElement(By.xpath(editEventButton)).click();
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
        }

        @Test(priority = 3, dataProvider = "getEventData", dataProviderClass = TestDataProvider.class)
        public void DeleteEvent(String EventName, String EventType, String EventCode)
                        throws IOException, InterruptedException {
                wait.customWait();
                action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
                ele.getSearchField().sendKeys(EventName);
                String deleteEventButton = String.format("//td[.='%s']/../..//button[2]", EventName);
                driver.findElement(By.xpath(deleteEventButton)).click();
                ele.getYesButton().click();
                // ele.getNoButton().click();
        }
}
