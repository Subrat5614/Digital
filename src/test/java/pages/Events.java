package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Events {
    WebDriver driver;

    public Events(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Add Event']/..")
    private WebElement addEvents;

    public WebElement getAddEvents() {
        return addEvents;
    }

    @FindBy(xpath = "//tbody//td[5]//button")
    private WebElement editEvents;

    public WebElement getEditEvents() {
        return editEvents;
    }

    @FindBy(xpath = "//tbody//td[5]//button[2]")
    private WebElement deleteEvents;

    public WebElement getDeleteEvents() {
        return deleteEvents;
    }

    @FindBy(xpath = "//label[.='Image']/..//span")
    private WebElement chooseImage;

    public WebElement getChooseImageButton() {
        return chooseImage;
    }

    @FindBy(xpath = "//label[.='Resume Image']/..//span")
    private WebElement chooseResumeImage;

    public WebElement getChooseResumeImageButton() {
        return chooseResumeImage;
    }

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement eventName;

    public WebElement getEventNameTextField() {
        return eventName;
    }

    @FindBy(xpath = "//input[@placeholder='Event Type']")
    private WebElement eventTypeName;

    public WebElement getEventTypeTextField() {
        return eventTypeName;
    }

    @FindBy(xpath = "//input[@placeholder='Event Code']")
    private WebElement eventCodeName;

    public WebElement getEventCodeTextField() {
        return eventCodeName;
    }

    @FindBy(xpath = "//tbody//td//button")
    private WebElement editEvent;

    public WebElement getEditEventElementButton() {
        return editEvent;
    }

    @FindBy(xpath = "//tbody//td//button[2]")
    private WebElement deleteEvent;

    public WebElement getDeleteEventElementButton() {
        return deleteEvent;
    }
}