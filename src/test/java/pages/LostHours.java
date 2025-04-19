package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LostHours {
    
   WebDriver driver;
    public LostHours(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[2]")
    private WebElement losttHoursNav;
    public WebElement getlosttHoursNav() {
        return losttHoursNav;
    }
    @FindBy(xpath="//button[@aria-label='Add Lost Hours']")
    private WebElement addLostHoursButton;
    public WebElement getAddLostHoursButton() {
        return addLostHoursButton;
    }
    @FindBy(xpath="//span[.='Type']")
    private WebElement eventTypeDD;
    public WebElement getEventTypeDD(){
        return eventTypeDD;
    }
    @FindBy(xpath="//label[contains(text(),'Start Time')]/following-sibling::span//input[@placeholder='Select Date & Time']")
    private WebElement startTime;
    public WebElement getStartTime(){
        return startTime;
    }
    @FindBy(xpath="//label[contains(text(),'End Time')]/following-sibling::span//input[@placeholder='Select Date & Time']")
    private WebElement endTime;
    public WebElement getEndTime(){
        return endTime;
    }
    @FindBy(xpath="//input[@placeholder='difference']")
    private WebElement difference;
    public WebElement getDifference(){
        return difference;
    }

}
