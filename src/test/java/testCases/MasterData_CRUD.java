package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.MasterData;
import utilities.config;

public class MasterData_CRUD extends BaseClass {
    private boolean isExpandButtonClicked = false;

    @Test(priority = 1, dataProvider = "getMasterCode", dataProviderClass = TestDataProvider.class)
    public void CreateMasterCode(String MasterCode, String MasterValue, String MasterDetail)
            throws IOException, InterruptedException {
        System.out.println(
                "MasterCode: " + MasterCode + "\nMasterValue: " + MasterValue + "\nMasterDetail: " + MasterDetail);
        driver.get(config.getProperty("url") + "master-data");
        MasterData master = new MasterData(driver);
        master.getAddMasterCode().click();
        master.getMasterCodeTextField().sendKeys(MasterCode);
        master.getMasterValueTextField().sendKeys(MasterValue);
        master.getDetailsTextField().sendKeys(MasterDetail);
        ele.getSaveButton().click();
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 2, dependsOnMethods = "CreateMasterCode", dataProvider = "getMasterCode", dataProviderClass = TestDataProvider.class)
    public void updateMasterCode(String MasterCode, String MasterValue, String MasterDetail)
            throws IOException, InterruptedException {
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        ele.getSearchField().sendKeys(MasterValue);
        String editEventButton = String.format("//td[.='%s']/..//div/button", MasterValue);
        driver.findElement(By.xpath(editEventButton)).click();
        // wait.waitForElementPresent((ele.getSaveButton().isDisplayed() ? ele.getSaveButton() : ele.getCancelButton()))
        //         .click();
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 3, dependsOnMethods = "CreateMasterCode", dataProvider = "getMasterDetails", dataProviderClass = TestDataProvider.class)
    public void CreateMasterDetails(String MasterDetailsCode, String MasterDetailsValue, String MasterDetailsDetail)
            throws InterruptedException { 
        MasterData master = new MasterData(driver);
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        if (!isExpandButtonClicked) {
            action.moveToElement(master.getExpandButton()).click().perform();
            isExpandButtonClicked = true; // Mark the button as clicked
        }
        master.getAddMasterDetail().click();
        master.getMasterDetailCodeTextField().sendKeys(MasterDetailsCode);
        master.getMasterDetailValueTextField().sendKeys(MasterDetailsValue);
        master.getDetailsTextField().sendKeys(MasterDetailsDetail);
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 4, dependsOnMethods = "CreateMasterDetails", dataProvider = "getMasterDetails", dataProviderClass = TestDataProvider.class)
    public void UpdateMasterDetails(String MasterDetailsCode, String MasterDetailsValue, String MasterDetailsDetail)
            throws InterruptedException {
        MasterData master = new MasterData(driver);
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        if (!isExpandButtonClicked) {
            action.moveToElement(master.getExpandButton()).click().perform();
            isExpandButtonClicked = true; // Mark the button as clicked
        }
        String editMasterDetailButton = String.format("//td[.='%s']/..//button", MasterDetailsValue);
        driver.findElement(By.xpath(editMasterDetailButton)).click();
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 5, dependsOnMethods = "CreateMasterDetails", dataProvider = "getMasterDetails", dataProviderClass = TestDataProvider.class)
    public void DeleteMasterDetails(String MasterDetailsCode, String MasterDetailsValue, String MasterDetailsDetail)
            throws InterruptedException {
        MasterData master = new MasterData(driver);
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        if (!isExpandButtonClicked) {
            action.moveToElement(master.getExpandButton()).click().perform();
            isExpandButtonClicked = true; // Mark the button as clicked
        }
        String deleteMasterDetailButton = String.format("//td[.='%s']/..//button[2]", MasterDetailsValue);
        driver.findElement(By.xpath(deleteMasterDetailButton)).click();
        wait.waitForElementPresent((ele.getYesButton().isDisplayed() ? ele.getYesButton() : ele.getNoButton())).click();
    }

    @Test(priority = 6, dependsOnMethods = "CreateMasterCode", dataProvider = "getMasterCode", dataProviderClass = TestDataProvider.class)
    public void DeleteMasterCode(String MasterCode, String MasterValue, String MasterDetail)
            throws InterruptedException { 
        MasterData master = new MasterData(driver);
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        ele.getSearchField().sendKeys(MasterValue);
        String deleteMasterCodeButton = String.format("//td[.='%s']/..//div/button[2]", MasterValue);
        driver.findElement(By.xpath(deleteMasterCodeButton)).click();
        wait.waitForElementPresent((ele.getYesButton().isDisplayed() ? ele.getYesButton() : ele.getNoButton())).click();
    }

}