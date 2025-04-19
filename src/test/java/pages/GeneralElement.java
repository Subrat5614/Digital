package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralElement {
    WebDriver driver;

    public GeneralElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form//button[@aria-label='Next Page']")
    private WebElement nextPageButton;

    public WebElement getNextPageButton() {
        return nextPageButton;
    }

    @FindBy(xpath = "//form//button[@aria-label='Previous Page']")
    private WebElement previousPageButton;

    public WebElement getPreviousPageButton() {
        return previousPageButton;
    }

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchField;

    public WebElement getSearchField() {
        return searchField;
    }

    @FindBy(xpath = "//span[.='Save']/..")
    private WebElement saveButton;

    public WebElement getSaveButton() {
        return saveButton;
    }

    @FindBy(xpath = "//button[@aria-label='Cancel']")
    private WebElement cancelButton;

    public WebElement getCancelButton() {
        return cancelButton;
    }

    @FindBy(xpath = "//span[.='Confirm']/..")
    private WebElement confirmButton;

    public WebElement getConfirmButton() {
        return confirmButton;
    }

    @FindBy(xpath = "//button[@data-pc-section='closebutton']")
    private WebElement closeButton;

    public WebElement getCloseButton() {
        return closeButton;
    }

    @FindBy(xpath = "//div[@data-pc-section='footer']//button[2]")
    private WebElement deleteConfirmButton;

    public WebElement getDeleteConfirmButton() {
        return deleteConfirmButton;
    }

    @FindBy(xpath = "//div[contains(@class,'toast-message')]")
    private WebElement toastMessage;

    public WebElement getToastMessage() {
        return toastMessage;
    }

    @FindBy(xpath = "//button[@aria-label='Yes']")
    private WebElement yesButton;

    public WebElement getYesButton() {
        return yesButton;
    }

    @FindBy(xpath = "//button[@aria-label='No']")
    private WebElement noButton;

    public WebElement getNoButton() {
        return noButton;
    }

    @FindBy(id = "actionButton")
    private WebElement actionButton;

    public WebElement getActionButton() {
        return actionButton;
    }

    @FindBy(xpath = "//span[contains(@class,'pencil')]/..")
    private WebElement editButton;

    public WebElement getEditButton() {
        return editButton;
    }

    @FindBy(xpath = "//span[contains(@class,'trash')]/..")
    private WebElement deleteButton;

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    @FindBy(xpath = "//span[contains(@class,'square')]/..")
    private WebElement approveButton;

    public WebElement getApproveButton() {
        return approveButton;
    }

    @FindBy(xpath = "//span[contains(@class,'file')]/..")
    private WebElement detailsButton;

    public WebElement getDetailsButton() {
        return detailsButton;
    }

    @FindBy(xpath = "//button[@aria-label='Delete']")
    private WebElement deleteMoreButton;

    public WebElement getDeleteMoreButton() {
        return deleteMoreButton;
    }

    @FindBy(xpath = "//button[@aria-label='Assign Users']")
    private WebElement assignButton;

    public WebElement getAssignUsersButton() {
        return assignButton;
    }
    @FindBy(id="date")
    private WebElement dateTextField;
    public WebElement getSendReportDateTextField() {
        return dateTextField;
    }

    @FindBy(xpath = "//button[@aria-label='Send Report']")
    private WebElement sendReportButton;

    public WebElement getSendReportButton() {
        return sendReportButton;
    }

    @FindBy(xpath = "//span[.='Choose']")
    private WebElement chooseButton;

    public WebElement getChooseButton() {
        return chooseButton;
    }

    @FindBy(xpath = "//button[@aria-label='Send Report']")
    private WebElement customSendReport;

    public WebElement getCustomSendReport() {
        return customSendReport;
    }

    @FindBy(xpath = "//div[contains(@class,'dropdown-filter')]/input")
    private WebElement dropdownFilter;

    public WebElement getSingleDropdownFilter() {
        return dropdownFilter;
    }

    @FindBy(xpath = "//div[contains(@class,'multiselect-filter')]/input")
    private WebElement dropdownMultiFilter;

    public WebElement getMultiDropdownFilter() {
        return dropdownMultiFilter;
    }

    @FindBy(xpath = "//button[contains(@class,'multiselect-close')]")
    private WebElement closeMultiFilter;

    public WebElement getMultiFilterCloseButton() {
        return closeMultiFilter;
    }

    @FindBy(xpath = "//td[@class='p-datepicker-today']")
    private WebElement todayDate;

    public WebElement getToday() {
        return todayDate;
    }

    @FindBy(xpath = "//i[contains(@class, 'clear-icon')]/..")
    private WebElement clearIcon;

    public WebElement getClearIcon() {
        return clearIcon;
    }
    @FindBy(xpath="//input[@placeholder='Comments']")
    private WebElement comments;
    public WebElement getCommentsText(){
        return comments;
    }
    @FindBy(xpath = "//button[@aria-label='OK']")
    private WebElement okButton;

    public WebElement getOkBUtton() {
        return  okButton ; 
     }
    @FindBy(xpath = "//button[@aria-label='Next Hour']")
    private WebElement nextHourButton;
    public WebElement getNextHourButton() {
        return nextHourButton;
    }   
    @FindBy(xpath = "//button[@aria-label='Previous Hour']")
    private WebElement previousHourButton;
    public WebElement getPreviousHourButton() {
        return previousHourButton;
    }   
    @FindBy(xpath = "//button[@aria-label='Next Minute']")
    private WebElement nextMinuteButton;
    public WebElement getNextMinuteButton() {
        return nextMinuteButton;
    }
    @FindBy(xpath = "//button[@aria-label='Previous Minute']")
    private WebElement previousMinuteButton;
    public WebElement getPreviousMinuteButton() {
        return previousMinuteButton;
    }
    @FindBy(xpath = "//button[@aria-label='AM']")   
    private WebElement amButton;
    public WebElement getAmButton() {
        return amButton;
    }
    @FindBy(xpath = "//button[@aria-label='PM']")
    private WebElement pmButton;
    public WebElement getPmButton() {
        return pmButton;
    }
}