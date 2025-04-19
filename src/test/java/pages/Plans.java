package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Plans {
    WebDriver driver;

    public Plans(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-label='Add Plans']")
    private WebElement addPlansButton;

    public WebElement getAddPlansButton() {
        return addPlansButton;
    }

    @FindBy(xpath = "//input[@placeholder='Plan ID']")
    private WebElement planIDtext;

    public WebElement getPlanIdText() {
        return planIDtext;
    }

    @FindBy(xpath = "//input[@placeholder='Date']")
    private WebElement planDatetext;

    public WebElement getPlanDateText() {
        return planDatetext;
    }

    @FindBy(xpath = "//div[@aria-label='Variety']")
    private WebElement planVarietyDD;

    public WebElement getPlanVarietyDD() {
        return planVarietyDD;
    }

    @FindBy(xpath = "//input[@placeholder='GSM']")
    private WebElement planGSMtext;

    public WebElement getPlanGSMText() {
        return planGSMtext;
    }

    @FindBy(xpath = "//input[@placeholder='Deckle']")
    private WebElement planDeckletext;

    public WebElement getPlanDeckleText() {
        return planDeckletext;
    }

    @FindBy(xpath = "//input[@placeholder='Quantity(in M.T)']")
    private WebElement planQtytext;

    public WebElement getPlanQtyText() {
        return planQtytext;
    }

    @FindBy(xpath = "//label[text()='Dimensions']/..//div[@data-pc-section='trigger']")
    private WebElement planDimensionDD;

    public WebElement getPlanDimensionDD() {
        return planDimensionDD;
    }

    @FindBy(xpath = "//div[contains(@class,'carousel-item-active')]//span[.='Grain']")
    private WebElement planGrain;

    public WebElement getPlanGrainDD() {
        return planGrain;
    }

    @FindBy(xpath = "//span[.='LG']/..")
    private WebElement grain_LG;

    public WebElement getGrainLG() {
        return grain_LG;
    }

    @FindBy(xpath = "//span[.='SG']/..")
    private WebElement grain_SG;

    public WebElement getGrainSG() {
        return grain_SG;
    }

    @FindBy(xpath = "//div[contains(@class,'carousel-item-active')]//input[@placeholder='Kgs / ream']")
    private WebElement planKgsReamtext;

    public WebElement getPlanKgsReamtext() {
        return planKgsReamtext;
    }

    @FindBy(xpath = "//div[contains(@class,'carousel-item-active')]//input[@placeholder='Order No']")
    private WebElement planOrderNotext;

    public WebElement getPlanOrderNotext() {
        return planOrderNotext;
    }

    @FindBy(xpath = "//div[contains(@class,'carousel-item-active')]//input[@placeholder='Sheets / ream']")
    private WebElement planSheetsReamtext;

    public WebElement getPlanSheetsReamtext() {
        return planSheetsReamtext;
    }

    @FindBy(xpath = "//div[contains(@class,'carousel-item-active')]//span[.='Party Name']")
    private WebElement planPartyNameDD;

    public WebElement getPlanPartyNameDD() {
        return planPartyNameDD;
    }

    @FindBy(xpath = "//div[contains(@class,'carousel-item-active')]//input[@placeholder='Comments']")
    private WebElement planCommentstext;

    public WebElement getPlanCommentstext() {
        return planCommentstext;
    }
}