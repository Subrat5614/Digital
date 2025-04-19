package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PowerUsage {
    WebDriver driver;
    public PowerUsage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[3]")
    private WebElement powerUsagesNav;
    public WebElement getPowerUsagesNav() {
        return powerUsagesNav;
    }
    @FindBy(xpath="//button[@aria-label='Add Power Usage']")
    private WebElement addPowerUsageButton;
    public WebElement getAddPowerUsageButton() {
        return addPowerUsageButton;
    }
    @FindBy(xpath="//input[@placeholder='Start Units']")
    private WebElement startUnits;
    public WebElement getStartUnits(){
        return startUnits;
    }
    @FindBy(xpath="//input[@placeholder='Stop Units']")
    private WebElement stopUnits;
    public WebElement getStopUnits(){
        return stopUnits;
    }
    @FindBy(xpath="//input[@placeholder='difference']")
    private WebElement difference;
    public WebElement getDifference(){
        return difference;
    }

}
