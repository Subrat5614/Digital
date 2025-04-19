package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dcf {
      WebDriver driver;
    public dcf(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//ul[@role='tablist']/li[1]/a")
    private WebElement createForm;
    public WebElement getCreateForm() {
        return createForm;
    }
    @FindBy(xpath="//ul[@role='tablist']/li[2]/a")
    private WebElement listOfForms;
    public WebElement getListOfForms() {
        return listOfForms;
    }
    @FindBy(xpath="//ul[@role='tablist']/li[3]/a")
    private WebElement createMasterData;
    public WebElement getCreateMasterData() {
        return createMasterData;
    }
    @FindBy(id="formName")
    private WebElement dcfFormName;
    public WebElement getDcfFormName(){
        return dcfFormName;
    }
    @FindBy(id="formDescription")
    private WebElement dcfFormDescription;
    public WebElement getDcfFormDescription(){
        return dcfFormDescription;
    }
    @FindBy(id="fieldName")
    private WebElement dcfFieldName;
    public WebElement getdcfFieldName(){
        return dcfFieldName;
    }
    @FindBy(id="fieldType")
    private WebElement dcfFieldType;
    public WebElement getDcfFieldType(){
        return dcfFieldType;
    }
    @FindBy(id="displayName")
    private WebElement dcfDisplayName;
    public WebElement getDcfDisplayName(){
        return dcfDisplayName;
    }
    @FindBy(xpath="//div[@role='button']//button")
    private WebElement dcfFormAddButton;
    public WebElement getDcfFormAddButton(){
        return dcfFormAddButton;
    }
    @FindBy(xpath="//span[.='Save']/..")
    private WebElement saveButton;
    public WebElement getSaveButton() {
        return saveButton;
    }
    @FindBy(xpath="//span[.='Cancel']/..")
    private WebElement cancelButton;
    public WebElement getCancelButton() {
        return cancelButton;
    }
    @FindBy(xpath="//span[.='Add Master Code']/..")
    private WebElement addMasterCode;
    public WebElement getAddMasterCode(){
        return addMasterCode;
    }
    @FindBy(xpath="//input[@placeholder='Master Code']")
    private WebElement masterCodeTextFiled;
    public WebElement getMasterCodeTextFiled(){
        return masterCodeTextFiled;
    }
    @FindBy(xpath="//input[@placeholder='Master Value']")
    private WebElement masterValueTextFiled;
    public WebElement getMasterValueTextFiled(){
        return masterValueTextFiled;
    }
    @FindBy(xpath="//input[@placeholder='Details']")
    private WebElement detailsTextFiled;
    public WebElement getDetailsTextFiled(){
        return detailsTextFiled;
    }
    @FindBy(xpath="//table//tbody")
    private WebElement masterElement;
    public WebElement getMasterElement(){
        return masterElement;
    }
    @FindBy(xpath="//table//tbody//td")
    private WebElement masterCodeToggel;
    public WebElement getMasterCodeToggel(){
        return masterCodeToggel;
    }
    @FindBy(xpath="//table//tbody//td[5]//button")
    private WebElement editMasterCode;
    public WebElement getEditMasterCode(){
        return editMasterCode;
    }
    @FindBy(xpath="//button[@data-pc-section='closebutton']")
    private WebElement closeButton;
    public WebElement getCloseButtone(){
        return closeButton;
    }
    @FindBy(xpath="//table//tbody//td[5]//button[2]")
    private WebElement deleteMasterCode;
    public WebElement getDeleteMasterCode(){
        return deleteMasterCode;
    }
    @FindBy(xpath="//span[.='Add Master Details']/..")
    private WebElement addMasterDetails;
    public WebElement getAddMasterDetails(){
        return addMasterDetails;
    }
    @FindBy(xpath="//input[@placeholder='Detail Code']")
    private WebElement detailCodeTextFiled;
    public WebElement getDetailCodeTextFiled(){
        return detailCodeTextFiled;
    }
    @FindBy(xpath="//input[@placeholder='Detail Value']")
    private WebElement detailValueTextFiled;
    public WebElement getDetailValueTextFiled(){
        return detailValueTextFiled;
    }
    @FindBy(xpath="//tr[@data-pc-section='rowexpansion']")
    private WebElement  masterDetailData;
    public WebElement getMasterDetailData(){
        return masterDetailData;
    }
    @FindBy(xpath="//tr[@data-pc-section='rowexpansion']//tbody/tr/td[4]//button")
    private WebElement  editMasterDetail;
    public WebElement getEditMasterDetail(){
        return editMasterDetail;
    }
    @FindBy(xpath="//tr[@data-pc-section='rowexpansion']//tbody/tr/td[4]//button[2]")
    private WebElement  deleteMasterDetail;
    public WebElement getDeleteMasterDetail(){
        return deleteMasterDetail;
    }
    @FindBy(xpath="//span[.='No']/..")
    private WebElement noButton;
    public WebElement getNoButton() {
        return noButton;
    }
    @FindBy(xpath="//span[.='Yes']/..")
    private WebElement yesButton;
    public WebElement getYesButton() {
        return yesButton;
    }
}
