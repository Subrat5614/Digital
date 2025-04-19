package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.ProductionData;

public class ProductionData_CRUD extends BaseClass {
        @Test(priority = 1, dataProvider = "getProductionData", dataProviderClass = TestDataProvider.class)
        public void CreateProductionData(String Variety, Double Speed, Double GSM, Double QuantityinKG,
                        Double AdjustQuantity) throws InterruptedException {
                System.out.println("Verity: " + Variety + "\nSpeed: " + Speed + "\nGSM: " + GSM + "\nQuantity in KG: "
                                + QuantityinKG + "\nAdjust Quantity: " + AdjustQuantity);
                ProductionData productionData = new ProductionData(driver);
                wait.customWait();
                wait.waitForElementToBeClickable(productionData.getAddProductionDataButton(), 2000).click();
                wait.waitForElementToBeClickable(productionData.getVarietyDD()).click();
                ele.getSingleDropdownFilter().sendKeys(Variety);
                driver.findElement(By.xpath("//li[@aria-label='" + Variety + "']")).click();
                wait.waitForElementToBeClickable(productionData.getSpeedText()).sendKeys(Speed.toString());
                wait.waitForElementToBeClickable(productionData.getGSMText()).sendKeys(GSM.toString());
                wait.waitForElementToBeClickable(productionData.getQuantityText()).sendKeys(QuantityinKG.toString());
                wait.waitForElementToBeClickable(productionData.getDimensionDD()).click();
                driver.findElement(By.xpath("//ul[@role='listbox']//li[1]")).click();
                wait.waitForElementToBeClickable(ele.getMultiFilterCloseButton()).click();
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
        }

        // dependsOnMethods = "CreateProductionData",
        @Test(priority = 2, dataProvider = "getProductionData", dataProviderClass = TestDataProvider.class)
        public void UpdateProductionData(String Variety, Double Speed, Double GSM, Double QuantityinKG,
                        Double AdjustQuantity) throws InterruptedException {
                wait.customWait();
                action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
                ele.getSearchField().sendKeys(Speed.toString());
                String editProductionDataButton = String.format("//td[.='%s']/..//button", Speed);
                wait.waitForElementToBeClickable(driver.findElement(By.xpath(editProductionDataButton))).click();
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
        }

        @Test(priority = 3, dataProvider = "getProductionData", dataProviderClass = TestDataProvider.class)
        public void UpdateAdjustProductionData(String Variety, Double Speed, Double GSM, Double QuantityinKG,
                        Double AdjustQuantity) throws InterruptedException {
                                ProductionData productionData = new ProductionData(driver);
                wait.customWait();
                action.moveToElement(wait.waitForElementToBeClickable(productionData.getadjustProductionDataNav())).click().perform();
                action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
                ele.getSearchField().sendKeys(Speed.toString());
                String editProductionDataButton = String.format("//td[.='%s']/..//button", Speed);
                wait.waitForElementToBeClickable(driver.findElement(By.xpath(editProductionDataButton))).click();
                wait.waitForElementToBeClickable(productionData.getActualQuantityText()).sendKeys(AdjustQuantity.toString());
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
        }

        @Test(priority = 4, dataProvider = "getProductionData", dataProviderClass = TestDataProvider.class)
        public void DeleteProductionData(String Variety, Double Speed, Double GSM, Double QuantityinKG,
                        Double AdjustQuantity) throws InterruptedException {
                                ProductionData productionData = new ProductionData(driver);
                wait.customWait();
                action.moveToElement(wait.waitForElementToBeClickable(productionData.getProductionDataNav())).click().perform();
                action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
                ele.getSearchField().sendKeys(Speed.toString());
                String deleteProductionDataButton = String.format("//td[.='%s']/..//button[3]", Speed);
                wait.waitForElementToBeClickable(driver.findElement(By.xpath(deleteProductionDataButton))).click();
                wait.waitForElementPresent(
                                (ele.getSaveButton().isDisplayed() ? ele.getYesButton() : ele.getNoButton()))
                                .click();
                toastHandler.handleRedToastAfterAction();
        }
}
