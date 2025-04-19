package utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) throws NumberFormatException, IOException {
        this.driver = driver;
        int defaultTimeout = Integer.parseInt(config.getProperty("explicitWaitTime"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
    }

    // Method to wait for visibility of an element
    public WebElement waitForElementPresent(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Overloaded method to wait with custom timeout
    public WebElement waitForElementPresent(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return customWait.until(ExpectedConditions.visibilityOf(element));
    }

    // Method to wait for Clickable of an element
    public WebElement waitForElementToBeClickable(WebElement element) {
        waitForElementPresent(element);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Overloaded method to wait with custom timeout
    public WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        waitForElementPresent(element);
        return customWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Retry Clicking with a Wrapper Method
    public void clickWithRetry(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(driver -> {
            try {
                element.click();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    // customWait method for loading
    public void customWait() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
