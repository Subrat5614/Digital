package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Scheduler {
WebDriver driver;
    public Scheduler(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[.='Add Schedule']/..")
    public WebElement addSchedulerButton;
     public WebElement getAddSchedulerButton() {
        return addSchedulerButton;
    }
    @FindBy(id="reportType")
    public WebElement reportTypeDropdown;
     public WebElement getReportTypeDropdown() {
        return reportTypeDropdown;
    }
    @FindBy(id="dropdownItem_0")
    public WebElement MemoReportOption;
     public WebElement getMemoReportOption() {
        return MemoReportOption;
    }
    @FindBy(id="dropdownItem_1")
    public WebElement PlantReportOption;
     public WebElement getPlantReportOption() {
        return PlantReportOption;
    }
    @FindBy(id="dropdownItem_2")
    public WebElement ShiftReportOption;
     public WebElement getShiftReportOption() {
        return ShiftReportOption;
    }
    @FindBy(xpath="//label[.='Custom Report Name']/..//input")
    public WebElement customReportNameTextField;
     public WebElement getCustomReportNameTextField() {
        return customReportNameTextField;
    }
    @FindBy(id="sequence")
    public WebElement SelectRangeDropdown;
     public WebElement getSelectRangeDropdown() {
        return SelectRangeDropdown;
    }
    @FindBy(id="dropdownItem_0")
    public WebElement TodayOption;
    public WebElement getTodayOption() {
         return TodayOption;
    }
    @FindBy(id="dropdownItem_1")
    public WebElement YesterdayOption;
    public WebElement getYesterdayOption() {
        return YesterdayOption;
    }
    @FindBy(xpath="//span[.='Select Frequency']")
    public WebElement SelectTypeDropdown;
    public WebElement getSelectTypeDropdown() {
        return SelectTypeDropdown;
    }
    @FindBy(id="dropdownItem_0")
    public WebElement DailyOption;
    public WebElement getDailyOption() {
         return DailyOption;
    }
    @FindBy(id="dropdownItem_2")
    public WebElement WeeklyOption;
    public WebElement getWeeklyOption() {
         return WeeklyOption;
    }
    @FindBy(id="dropdownItem_1")
    public WebElement MonthlyOption;
    public WebElement getMonthlyOption() {
         return MonthlyOption;
    }
    @FindBy(xpath="//input[@placeholder='Select Time']")
    public WebElement selectTimeTextField;
    public WebElement getSelectTime() {
        return selectTimeTextField;
    }
    @FindBy(xpath="//input[@placeholder='Select Date']")
    public WebElement StartDateTextField;
    public WebElement getStartDate() {
        return StartDateTextField;
    }
    @FindBy(xpath="//label[contains(text(), 'End Date')]/following-sibling::span//input")
    public WebElement EndDateTextField;
    public WebElement getEndDate() {
        return EndDateTextField;
    }
    @FindBy(xpath="//td[@class='p-datepicker-today']/following-sibling::td[1]")
    public WebElement nextDate;
    public WebElement getNextDate() {
        return nextDate;
    }


}

