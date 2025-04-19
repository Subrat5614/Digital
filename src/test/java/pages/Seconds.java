package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Seconds {
 WebDriver driver;
    public Seconds(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
     @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[4]")
    private WebElement secondsNav;
    public WebElement getsecondsNav() {
        return secondsNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[6]")
    private WebElement adjustSecondsNav;
    public WebElement getadjustSecondsNav() {
        return adjustSecondsNav;
    }
    @FindBy(xpath="//button[@aria-label='Add Seconds']")
    private WebElement addSecondsButton;
    public WebElement getAddSecondsButton() {
        return addSecondsButton;
    }
    @FindBy(xpath="//div[@aria-label='Variety']")
    private WebElement VarietyDD;
    public WebElement getVarietyDD(){
        return VarietyDD;
    }
    @FindBy(xpath="//input[@placeholder='Quantity']")
    private WebElement Qty;
    public WebElement getQuantityText(){
        return Qty;
    }
    @FindBy(xpath="//input[@placeholder='Actual Quantity']")
    private WebElement ActualQty;
    public WebElement getActualQuantityText(){
        return ActualQty;
    }
    
}
