package utilities;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementClicker {
    WebDriver driver;

    public ElementClicker(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUsingJSIfIntercepted(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted, using JavaScript click.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

}
