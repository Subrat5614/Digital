package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductionData {
 WebDriver driver;
    public ProductionData(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a")
    private WebElement productionDataNav;
    public WebElement getProductionDataNav() {
        return productionDataNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[5]")
    private WebElement adjustProductionDataNav;
    public WebElement getadjustProductionDataNav() {
        return adjustProductionDataNav;
    }
    @FindBy(xpath="//button[@aria-label='Add Production Data']")
    private WebElement addProductionDataButton;
    public WebElement getAddProductionDataButton() {
        return addProductionDataButton;
    }
    @FindBy(xpath="//div[@aria-label='Variety']")
    private WebElement VarietyDD;
    public WebElement getVarietyDD(){
        return VarietyDD;
    }
    @FindBy(xpath="//input[@placeholder='Speed']")
    private WebElement Speed;
    public WebElement getSpeedText(){
        return Speed;
    }
    @FindBy(xpath="//input[@placeholder='GSM']")
    private WebElement GSM;
    public WebElement getGSMText(){
        return GSM;
    }
    @FindBy(xpath = "//input[@placeholder=\"Quantity (KG's)\"]")
    private WebElement Qty;
    public WebElement getQuantityText(){
        return Qty;
    }
    @FindBy(xpath = "//input[@placeholder='Actual Quantity']")
    private WebElement ActualQty;
    public WebElement getActualQuantityText(){
        return ActualQty;
    }
    @FindBy(xpath = "//label[text()='Dimensions']/..//div[@data-pc-section='trigger']")
    private WebElement DimensionDD;
    public WebElement getDimensionDD() {
        return DimensionDD;
    }
}
