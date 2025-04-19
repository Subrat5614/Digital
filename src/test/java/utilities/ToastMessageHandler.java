package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToastMessageHandler {
      private WebDriver driver;
    public ToastMessageHandler(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//button[@data-pc-section='closebutton']")
    private WebElement closeButton;
    public WebElement getCloseButton() {
        return closeButton;
    }
    @FindBy(xpath="//span[.='Cancel']/..")
    private WebElement cancelButton;
    public WebElement getCancelButton() {
        return cancelButton;
    }
    @FindBy(xpath = "//div[contains(@class,'toast-message')]")
    private WebElement toastMessage;
    public WebElement getToastMessage() {
        return toastMessage;
    }
    public boolean isToastMessageRed() {
        String borderLeftColor = toastMessage.getCssValue("border-left-color");
        String redColor = "rgba(211, 47, 47, 1)"; // RGB value for red color
        return borderLeftColor.equals(redColor);
    }
    public void handleRedToastAfterAction() throws InterruptedException {
        if (getToastMessage() != null && isToastMessageRed()) {
            String messageText = toastMessage.getText();
            System.out.println("------------------------------\n" + "Error Message Received: " + messageText);
            Thread.sleep(5000);
			getCancelButton().click();
        }
    }
}
