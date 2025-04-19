package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.Seconds;

public class Seconds_CRUD extends BaseClass {
    @Test(priority = 1, dataProvider = "getSeconds", dataProviderClass = TestDataProvider.class)
    public void CreateSeconds(String Variety, Double Quantity, Double ActualQuantity) throws InterruptedException {
        System.out.println("Variety: " + Variety + "\nQuantity: " + Quantity + "\nActual Quantity: " + ActualQuantity);
        Seconds seconds = new Seconds(driver);
        wait.customWait();
        wait.waitForElementToBeClickable(seconds.getsecondsNav(), 2000).click();
        wait.waitForElementToBeClickable(seconds.getAddSecondsButton()).click();
        wait.waitForElementToBeClickable(ele.getSingleDropdownFilter()).click();
        wait.waitForElementToBeClickable(ele.getSearchField()).sendKeys(Variety);
        driver.findElement(By.xpath("//li[@aria-label='" + Variety + "']")).click();
        wait.waitForElementToBeClickable(seconds.getQuantityText()).sendKeys(Quantity.toString());
        wait.waitForElementToBeClickable(seconds.getActualQuantityText()).sendKeys(ActualQuantity.toString());
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 2, dataProvider = "getSeconds", dataProviderClass = TestDataProvider.class)
    public void UpdateSeconds(String Variety, Double Quantity, Double ActualQuantity) throws InterruptedException {
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        ele.getSearchField().sendKeys(Variety);
        String editSecondsButton = String.format("//td[.='%s']/..//button", Variety);
        wait.waitForElementToBeClickable(driver.findElement(By.xpath(editSecondsButton))).click();
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 3, dataProvider = "getSeconds", dataProviderClass = TestDataProvider.class)
    public void UpdateActualSeconds(String Variety, Double Quantity, Double ActualQuantity)
            throws InterruptedException {
        Seconds seconds = new Seconds(driver);
        wait.customWait();
        action.moveToElement(wait.waitForElementToBeClickable(seconds.getadjustSecondsNav())).click().perform();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        ele.getSearchField().sendKeys(Variety);
        String editAdjustSecondsButton = String.format("//td[.='%s']/..//button", Variety);
        wait.waitForElementToBeClickable(driver.findElement(By.xpath(editAdjustSecondsButton))).click();
        wait.waitForElementToBeClickable(seconds.getActualQuantityText()).sendKeys(ActualQuantity.toString());
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 4, dataProvider = "getSeconds", dataProviderClass = TestDataProvider.class)
    public void DeleteSeconds(String Variety, Double Quantity, Double ActualQuantity) throws InterruptedException {
        Seconds seconds = new Seconds(driver);
        wait.customWait();
        wait.waitForElementToBeClickable(seconds.getsecondsNav(), 2000).click();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        ele.getSearchField().sendKeys(Variety);
        String deleteSecondsButton = String.format("//td[.='%s']/..//button[2]", Variety);
        wait.waitForElementToBeClickable(driver.findElement(By.xpath(deleteSecondsButton))).click();
        wait.waitForElementToBeClickable(ele.getDeleteButton()).click();
        toastHandler.handleRedToastAfterAction();
    }

}
