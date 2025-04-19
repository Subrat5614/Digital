package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement userName;

    public WebElement getuserName() {
        return userName;
    }

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    public WebElement getpassword() {
        return password;
    }

    @FindBy(xpath = "//span[.='Sign In']")
    private WebElement signIn;

    public WebElement getsignIn() {
        return signIn;
    }
}
