package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterData {
    WebDriver driver;
    public MasterData(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//button[@aria-label='Add Master Code']")
     private WebElement addMasterCode;
    public WebElement getAddMasterCode() {
        return addMasterCode;
    }
    @FindBy(xpath="//input[@placeholder='Master Code']")
    private WebElement masterCodeTextField;
    public WebElement getMasterCodeTextField() {
        return masterCodeTextField;
    }
    @FindBy(xpath="//input[@placeholder='Master Value']")
    private WebElement masterValueTextField;
    public WebElement getMasterValueTextField() {
        return masterValueTextField;
    }
    @FindBy(xpath="//input[@placeholder='Details']")
    private WebElement detailsTextField;
    public WebElement getDetailsTextField() {
        return detailsTextField;
    }
    @FindBy(xpath="//tr[@data-pc-section='bodyrow']")
    private WebElement rowList;
    public WebElement getRowList() {
        return rowList;
    }
    @FindBy(xpath="//button[@aria-label='Add Master Detail']")
     private WebElement addMasterDetail;
    public WebElement getAddMasterDetail() {
        return addMasterDetail;
    }
    @FindBy(xpath="//tr[@data-pc-section='bodyrow']/td[5]//button")
    private WebElement editMasterCodeButton;
    public WebElement getEditMasterCodeButton() {
        return editMasterCodeButton;
    }
    @FindBy(xpath="//tr[@data-pc-section='bodyrow']/td[5]//button[2]")
    private WebElement deleteMasterCodeButton;
    public WebElement getDeleteMasterCodeButton() {
        return deleteMasterCodeButton;
    }
    @FindBy(xpath="//button[@aria-label='Yes']")
    private WebElement yesButton;
    public WebElement getYesButton(){
        return yesButton;
    }
    @FindBy(xpath="//button[@aria-label='No']")
    private WebElement noButton;
    public WebElement getNoButton(){
        return noButton;
    }
    @FindBy(xpath="//tr[@data-pc-section='bodyrow']/td")
    private WebElement expandButton;
    public WebElement getExpandButton(){
        return expandButton;
    }
    @FindBy(xpath="//input[@placeholder='Detail Code']")
    private WebElement masterDetailCodeTextField;
    public WebElement getMasterDetailCodeTextField() {
        return masterDetailCodeTextField;
    }
    @FindBy(xpath="//input[@placeholder='Detail Value']")
    private WebElement masterDetailValueTextField;
    public WebElement getMasterDetailValueTextField() {
        return masterDetailValueTextField;
    }
    @FindBy(xpath="//tr[contains(@class,'expansion')]//tr[@data-pc-section='bodyrow']")
    private WebElement expandedItems;
    public WebElement getExpandedMasterDetails() {
        return expandedItems;
    }
    @FindBy(xpath="//tr[contains(@class,'expansion')]//tr[@data-pc-section='bodyrow']/td[4]//button")
    private WebElement editMasterDetailsButton;
    public WebElement getEditMasterDetailsButton() {
        return editMasterDetailsButton;
    }
    @FindBy(xpath="//tr[contains(@class,'expansion')]//tr[@data-pc-section='bodyrow']/td[4]//button[2]")
    private WebElement deleteMasterDetailsButton;
    public WebElement getDeleteMasterDetailsButton() {
        return deleteMasterDetailsButton;
    }
    @FindBy(xpath="//td[.='undefined']/..//div/button")
    private WebElement EditCodeUndefinedElement;
    public WebElement getCodeUndefinedEditButton() {
        return EditCodeUndefinedElement;
    }
    @FindBy(xpath="//td[.='undefined']/..//div/button[2]")
    private WebElement deleteCodeUndefinedElement;
    public WebElement getCodeUndefinedDeleteButton() {
        return deleteCodeUndefinedElement;
    }
    @FindBy(xpath="//td[.='undefined']/../td")
    private WebElement expandCodeUndefinedElement;
    public WebElement getCodeUndefinedExpandButton() {
        return expandCodeUndefinedElement;
    }
    @FindBy(xpath="//tr[contains(@id,'expanded')]//td[5]//button[1]")
    private WebElement EditDetailsUndefinedElement;
    public WebElement getDetailsUndefinedEditButton() {
        return EditDetailsUndefinedElement;
    }
    @FindBy(xpath="//tr[contains(@id,'expanded')]//td[5]//button[2]")
    private WebElement deleteDetailsUndefinedElement;
    public WebElement getDetailsUndefinedDeleteButton() {
        return deleteDetailsUndefinedElement;
    }
}
