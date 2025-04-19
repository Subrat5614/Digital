package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BhadraSummary {
    WebDriver driver;
    public BhadraSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//aside//descendant::li[5]")
    private WebElement summaryLeftNav;
    public WebElement getSummaryLeftNav() {
        return summaryLeftNav;
    }
    @FindBy(xpath="//aside//descendant::li")
    private WebElement homeLeftNav;
    public WebElement getHomeLeftNav() {
        return homeLeftNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a")
    private WebElement shiftsNav;
    public WebElement getShiftsNav() {
        return shiftsNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[2]")
    private WebElement dimensionsNav;
    public WebElement getDimensionsNav() {
        return dimensionsNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[3]")
    private WebElement plansNav;
    public WebElement getPlansNav() {
        return plansNav;
    }
    @FindBy(xpath="//div[@data-pc-section='navcontainer']//descendant::a[4]")
    private WebElement configureEmailsNav;
    public WebElement getconfigureEmailsNav() {
        return configureEmailsNav;
    }
    @FindBy(xpath="//li[@data-pc-section='home']")
    private WebElement homeLink;
    public WebElement getHomeLink() {
        return homeLink;
    }
}
