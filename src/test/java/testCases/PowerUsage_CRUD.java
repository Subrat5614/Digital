package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.PowerUsage;

public class PowerUsage_CRUD extends BaseClass {
    @Test(priority = 1, dataProvider = "getPowerUsage", dataProviderClass = TestDataProvider.class)
    public void CreatePowerUsage(Double StartUnits, Double StopUnits, String Comments) throws InterruptedException {
        System.out.println("Start Units: " + StartUnits + "\nStop Units: " + StopUnits + "\nComments: " + Comments);
        PowerUsage powerusage = new PowerUsage(driver);
        wait.customWait();
        wait.waitForElementToBeClickable(powerusage.getPowerUsagesNav(), 2000).click();
        wait.waitForElementToBeClickable(powerusage.getAddPowerUsageButton()).click();
        wait.waitForElementToBeClickable(powerusage.getStartUnits()).sendKeys(StartUnits.toString());
        wait.waitForElementToBeClickable(powerusage.getStopUnits()).sendKeys(StopUnits.toString());
        wait.waitForElementToBeClickable(ele.getCommentsText()).sendKeys(Comments);
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 2, dataProvider = "getPowerUsage", dataProviderClass = TestDataProvider.class)
    public void UpdatePowerUsage(Double StartUnits, Double StopUnits, String Comments) throws InterruptedException {
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        ele.getSearchField().sendKeys(StartUnits.toString());
        String editPowerUsageButton = String.format("//td[.='%s']/..//button", StartUnits);
        wait.waitForElementToBeClickable(driver.findElement(By.xpath(editPowerUsageButton))).click();
        wait.waitForElementToBeClickable(ele.getCommentsText()).sendKeys(Comments);
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 3, dataProvider = "getPowerUsage", dataProviderClass = TestDataProvider.class)
    public void DeletePowerUsage(Double StartUnits, Double StopUnits, String Comments) throws InterruptedException {
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        ele.getSearchField().sendKeys(StartUnits.toString());
        String deletePowerUsageButton = String.format("//td[.='%s']/..//button[2]", StartUnits);
        wait.waitForElementToBeClickable(driver.findElement(By.xpath(deletePowerUsageButton))).click();
        wait.waitForElementToBeClickable(ele.getDeleteButton()).click();
        toastHandler.handleRedToastAfterAction();
    }
}
