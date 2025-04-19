package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.Dimension;

public class Dimension_CRUD extends BaseClass {

        @Test(priority = 1, dataProvider = "getDimensionData", dataProviderClass = TestDataProvider.class)
        public void CreateDimension(String Dimension, String Units) throws IOException, InterruptedException {
                System.out.println("Dimension: " + Dimension + "\nDimension Units: " + Units);
                Dimension dimension = new Dimension(driver);
                
                wait.customWait();
                driver.findElement(By.className("summary")).click();
                wait.customWait();
                action.moveToElement(ele.getSearchField()).pause(1000).moveToElement(summary.getDimensionsNav()).click()
                                .perform();
                wait.waitForElementToBeClickable(dimension.getAddDimensionButton()).click();
                dimension.getDimensionTextField().sendKeys(Dimension);
                dimension.getUnitDropdown().click();
                (Units.equals("CMS") ? dimension.getCMSDropdown() : dimension.getINCHESDropdown()).click();
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
                toastHandler.handleRedToastAfterAction();

        }

        @Test(priority = 2, dependsOnMethods = "CreateDimension", dataProvider = "getDimensionData", dataProviderClass = TestDataProvider.class)
        public void UpdateDimension(String Dimension, String Units) throws IOException, InterruptedException {
                wait.customWait();
                action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
                ele.getSearchField().sendKeys(Dimension);
                String editDimensionButton = String.format("//td[.='%s']/..//button", Dimension);
                driver.findElement(By.xpath(editDimensionButton)).click();
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton()));
                toastHandler.handleRedToastAfterAction();
        }

        @Test(priority = 3, dependsOnMethods = "CreateDimension", dataProvider = "getDimensionData", dataProviderClass = TestDataProvider.class)
        public void DeleteDimension(String Dimension, String Units) throws IOException, InterruptedException {
                wait.customWait();
                action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
                ele.getSearchField().sendKeys(Dimension);
                String deleteDimensionButton = String.format("//td[.='%s']/..//button[2]", Dimension);
                driver.findElement(By.xpath(deleteDimensionButton)).click();
                wait.waitForElementPresent((ele.getYesButton().isDisplayed() ? ele.getYesButton() : ele.getNoButton()))
                                .click();
                toastHandler.handleRedToastAfterAction();
        }
}
