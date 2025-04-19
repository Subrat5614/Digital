package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.User;
import utilities.config;

public class User_CRUD extends BaseClass {
    @Test(priority = 1, dataProvider = "getUserData", dataProviderClass = TestDataProvider.class)
    public void CreateUser(String username, String firstName, String lastName, String email, String role,
            Boolean is_mobile) throws IOException, InterruptedException {
        System.out.println("Username: " + username + "\nFirst Name: " + firstName + "\nLast Name: " + lastName
                + "\nEmail: " + email + "\nRole: " + role + "\nIs Mobile: " + is_mobile);
        driver.get(config.getProperty("url") + "users");
        User user = new User(driver);
        user.getAddUserButton().click();
        user.getUsernameTextField().sendKeys(username);
        user.getUserFirstNameTextField().sendKeys(firstName);
        user.getUserLastNameTextField().sendKeys(lastName);
        user.getUserEmailTextField().sendKeys(email);
        wait.customWait();
        user.getUserRoleDropdown().click();
        user.getOperatorOption().click();
        user.getMobileUserCheckbox().click();
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 2, dataProvider = "getUserData", dataProviderClass = TestDataProvider.class)
    public void UpdateUser(String username, String firstName, String lastName, String email, String role,
            Boolean is_mobile) throws IOException, InterruptedException {
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        ele.getSearchField().sendKeys(firstName);
        String fullName = firstName + " " + lastName; // Combine firstname and lastname for dynamic selection
        String editUserButton = String.format("//div[.='%s']/../..//button", fullName);
        driver.findElement(By.xpath(editUserButton)).click();
        clicker.clickUsingJSIfIntercepted(wait.waitForElementPresent(ele.getSaveButton(),5));
        toastHandler.handleRedToastAfterAction();
    }

    @Test(priority = 3, dataProvider = "getUserData", dataProviderClass = TestDataProvider.class)
    public void DeleteUser(String username, String firstName, String lastName, String email, String role,
            Boolean is_mobile) throws IOException, InterruptedException {
        wait.customWait();
        action.moveToElement(ele.getSearchField()).click().pause(1000).keyDown(Keys.CONTROL).sendKeys("a")
        .keyUp(Keys.CONTROL).pause(500).sendKeys(Keys.BACK_SPACE).perform();
        String fullName = firstName + " " + lastName; // Combine firstname and lastname for dynamic selection
        String deleteButton = String.format("//div[.='%s']/../..//button[2]", fullName);
        driver.findElement(By.xpath(deleteButton)).click();
        ele.getDeleteConfirmButton().click();
        // ele.getCancelButton().click();
    }
}
