package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User {
     WebDriver driver;
    public User(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//td[@role='cell']//button[@data-pc-name='button']")
    private WebElement editUser;
    public WebElement getEditUserButton() {
        return editUser;
    }
    @FindBy(xpath="//td[@role='cell']//button[@data-pc-name='button'][2]")
    private WebElement deleteUser;
    public WebElement getDeleteUserButton() {
        return deleteUser;
    }
    @FindBy(xpath="//span[.='Add User']/..")
    private WebElement addUser;
    public WebElement getAddUserButton() {
        return addUser;
    }
    @FindBy(xpath="//span[.='Confirm']/..")
    private WebElement confirmButton;
    public WebElement getConfirmUserDeleteButton() {
        return confirmButton;
    }
    @FindBy(id="loginname")
    private WebElement usernameText;
    public WebElement getUsernameTextField() {
        return usernameText;
    }
    @FindBy(id="firstName")
    private WebElement userFirstNameText;
    public WebElement getUserFirstNameTextField() {
        return userFirstNameText;
    }
    @FindBy(id="lastName")
    private WebElement userLastNameText;
    public WebElement getUserLastNameTextField() {
        return userLastNameText;
    }
    @FindBy(id="email")
    private WebElement emailText;
    public WebElement getUserEmailTextField() {
        return emailText;
    }
    @FindBy(xpath="//label[@for='des']/following-sibling::div")
    private WebElement roleDropdown;
    public WebElement getUserRoleDropdown() {
        return roleDropdown;
    }
    @FindBy(xpath = "//li[@aria-label='Driver']")
    private WebElement operatorOption;
    public WebElement getOperatorOption() {
        return operatorOption;
    }
    @FindBy(xpath = "//li[@aria-label='Driver']")
    private WebElement driverOption;
    public WebElement getDriverOption() {
        return driverOption;
    }
    @FindBy(id="mobileuser")
    private WebElement mobileCheckbox;
    public WebElement getMobileUserCheckbox() {
        return mobileCheckbox;
    }

}
