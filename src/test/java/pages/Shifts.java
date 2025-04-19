package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shifts {
 private WebDriver driver;
    public Shifts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//button[@aria-label='Add Shifts']")
    private WebElement addShiftButton;
    public WebElement getAddShiftButton() {
        return addShiftButton;
    }
    @FindBy(xpath="//button[@aria-label='Send Report']")
    private WebElement sendReportButton;
    public WebElement getDailyProductionReport() {
        return sendReportButton;
    }
    @FindBy(xpath="//button[@aria-label='Add Bulk Shifts']")
    private WebElement addBulkShiftButton;
    public WebElement getAddBulkShiftsButton() {
        return addBulkShiftButton;
    }
    @FindBy(xpath="//div[@aria-label='Number']")
    private WebElement shiftNumberDD;
    public WebElement getShiftNumberDropdown() {
        return shiftNumberDD;
    }
    @FindBy(id="dropdownItem_0")
    private WebElement shiftA;
    public WebElement getShiftA() {
        return shiftA;
    }
    @FindBy(id="dropdownItem_1")
    private WebElement shiftB;
    public WebElement getShiftB() {
        return shiftB;
    }
    @FindBy(id="dropdownItem_2")
    private WebElement shiftC;
    public WebElement getShiftC() {
        return shiftC;
    }
    @FindBy(xpath="//input[@placeholder='Date']")
    private WebElement shiftDate;
    public WebElement getShiftDate() {
        return shiftDate;
    }
    @FindBy(xpath="//td[@class='p-datepicker-today']")
    private WebElement todayDate;
    public WebElement getShiftToday() {
        return todayDate;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a")
    private WebElement productionDataNav;
    public WebElement getProductionDataNav() {
        return productionDataNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[2]")
    private WebElement losttHoursNav;
    public WebElement getlosttHoursNav() {
        return losttHoursNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[3]")
    private WebElement powerUsagesNav;
    public WebElement getPowerUsagesNav() {
        return powerUsagesNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[4]")
    private WebElement secondsNav;
    public WebElement getsecondsNav() {
        return secondsNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[5]")
    private WebElement adjustProductionDataNav;
    public WebElement getadjustProductionDataNav() {
        return adjustProductionDataNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[6]")
    private WebElement adjustSecondsNav;
    public WebElement getadjustSecondsNav() {
        return adjustSecondsNav;
    }
    @FindBy(xpath="//button[@aria-label='Add Production Data']")
    private WebElement addProductionData;
    public WebElement getAddProductionData(){
        return addProductionData;
    }
    @FindBy(xpath="//button[@aria-label='Add Lost Hours']")
    private WebElement addLostHours;
    public WebElement getAddLostHours(){
        return addLostHours;
    }
    @FindBy(xpath="//button[@aria-label='Add Power Usage']")
    private WebElement addPowerUsage;
    public WebElement getAddPowerUsage(){
        return addPowerUsage;
    }
    @FindBy(xpath="//button[@aria-label='Add Seconds']")
    private WebElement addSeconds;
    public WebElement getAddSeconds(){
        return addSeconds;
    }
}
