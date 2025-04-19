package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dimension {
 WebDriver driver;
    public Dimension(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//button[@aria-label='Add Dimensions']")
    private WebElement addDimensionButton;
    public WebElement getAddDimensionButton() {
        return addDimensionButton;
    }
    @FindBy(xpath="//input[@placeholder='Dimension']")
    private WebElement dimensionTextField;
    public WebElement getDimensionTextField() {
        return dimensionTextField;
    }
    @FindBy(xpath="//div[@aria-label='Unit']")
    private WebElement unitDropdown;
    public WebElement getUnitDropdown() {
        return unitDropdown;
    }
    @FindBy(id = "dropdownItem_0")
    private WebElement cmsDropdown;
    public WebElement getCMSDropdown() {
        return cmsDropdown;
    }
    @FindBy(id = "dropdownItem_1")
        private WebElement inchesDropdown;
    public WebElement getINCHESDropdown() {
        return inchesDropdown;
    }
}
