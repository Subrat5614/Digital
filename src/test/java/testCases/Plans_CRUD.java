package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.Plans;

public class Plans_CRUD extends BaseClass {
        private boolean isExpandSummaryLeftMenu = false;
        @Test(priority = 1, dataProvider = "getMemoPlanData", dataProviderClass = TestDataProvider.class)
        public void CreatePlan(String Variety, Double GSM, Double QuantityMT, Double Deckle, String Grain, Double KgsPerReam, 
        Double OrderNo, Double SheetsPerRm, String PartyName, String Comments)
                        throws IOException, InterruptedException {
                System.out.println("Variety: " + Variety + "\nGSM: " + GSM + "\nQuantity (M.T.): " + QuantityMT
                                + "\nDeckle: " + Deckle + "\nGrain: " + Grain + "\nKgs per Ream: " + KgsPerReam
                                + "\nOrder No: " + OrderNo + "\nSheets per Ream: " + SheetsPerRm + "\nParty Name: "
                                + PartyName + "\nComments: " + Comments);
                Plans plan = new Plans(driver);
                         
                wait.customWait();
                if (!isExpandSummaryLeftMenu) {
                        action.moveToElement( driver.findElement(By.className("summary"))).click().perform();
                        isExpandSummaryLeftMenu = true; // Mark the button as clicked
                    }
                // wait.customWait();
                action.moveToElement(ele.getSearchField()).pause(5000).moveToElement(summary.getPlansNav()).click().pause(3000)
                                .perform();
                wait.waitForElementToBeClickable(plan.getAddPlansButton(),2000).click();
                wait.waitForElementToBeClickable(plan.getPlanDateText()).click();
                ele.getToday().click();
                wait.waitForElementToBeClickable(plan.getPlanVarietyDD()).click();
                ele.getSingleDropdownFilter().sendKeys(Variety);
                driver.findElement(By.xpath("//li[@aria-label='" + Variety + "']")).click();
                action.moveToElement(wait.waitForElementPresent(plan.getPlanGSMText())).click().sendKeys(GSM.toString())
                                .perform();
                action.moveToElement(wait.waitForElementPresent(plan.getPlanQtyText())).click().keyDown(Keys.CONTROL)
                                .sendKeys("a").keyUp(Keys.CONTROL)
                                .sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT)
                                .sendKeys(QuantityMT.toString()).perform();

                action.moveToElement(wait.waitForElementPresent(plan.getPlanDeckleText())).click().keyDown(Keys.CONTROL)
                                .sendKeys("a").keyUp(Keys.CONTROL)
                                .sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT)
                                .sendKeys(Deckle.toString()).perform();

                wait.waitForElementToBeClickable(plan.getPlanDimensionDD()).click();
                driver.findElement(By.xpath("//ul[@role='listbox']//li[1]")).click();
                ele.getNextPageButton().click();
                wait.waitForElementToBeClickable(plan.getPlanGrainDD()).click();
                (Grain.equals("LG") ? plan.getGrainLG() : plan.getGrainSG()).click();
                action.moveToElement(wait.waitForElementPresent(plan.getPlanKgsReamtext())).click().keyDown(Keys.CONTROL)
                                .sendKeys("a").keyUp(Keys.CONTROL)
                                .sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT)
                                .sendKeys(KgsPerReam.toString()).perform();
                wait.waitForElementPresent(plan.getPlanOrderNotext()).sendKeys(OrderNo.toString());
                wait.waitForElementPresent(plan.getPlanSheetsReamtext()).sendKeys(SheetsPerRm.toString());
                wait.waitForElementToBeClickable(plan.getPlanPartyNameDD()).click();
                wait.waitForElementPresent(ele.getSingleDropdownFilter()).sendKeys(PartyName);
                wait.waitForElementToBeClickable(driver.findElement(By.xpath("//li[@aria-label='" + PartyName + "']")))
                                .click();
                wait.waitForElementPresent(plan.getPlanCommentstext()).sendKeys(Comments);
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
        }

        @Test(priority = 2, dataProvider = "getMemoPlanData", dataProviderClass = TestDataProvider.class)
        public void EditPlan(String Variety, Double GSM, Double QuantityMT, Double Deckle, String Grain,
                        Double KgsPerReam, Double OrderNo, Double SheetsPerRm, String PartyName, String Comments)
                        throws IOException, InterruptedException {
                Plans plan = new Plans(driver);
                
                wait.customWait();
                action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
                ele.getSearchField().sendKeys(Deckle.toString());
                String editPlanButton = String.format("//td[.='%s']/..//button", PartyName);
                wait.waitForElementToBeClickable(driver.findElement(By.xpath(editPlanButton))).click();
                clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
                toastHandler.handleRedToastAfterAction();
        }

        @Test(priority = 3, dataProvider = "getMemoPlanData", dataProviderClass = TestDataProvider.class)
        public void DeletePlan(String Variety, Double GSM, Double QuantityMT, Double Deckle, String Grain,
                        Double KgsPerReam, Double OrderNo, Double SheetsPerRm, String PartyName, String Comments)
                        throws IOException, InterruptedException {
                
                wait.customWait();
                action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
                                .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
                ele.getSearchField().sendKeys(Deckle.toString());
                String deletePlanButton = String.format("//td[.='%s']/..//button[2]", PartyName);
                wait.waitForElementToBeClickable(driver.findElement(By.xpath(deletePlanButton))).click();
                wait.waitForElementToBeClickable(ele.getYesButton()).click();
                toastHandler.handleRedToastAfterAction();
        }
}
