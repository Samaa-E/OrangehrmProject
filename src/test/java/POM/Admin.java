package POM;

import StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Admin {

    WebDriver driver;
    public static By TotalRecordsFound = By.xpath("//div[@class='orangehrm-paper-container']//child::div[2]//child::div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//child::span");

    By AdminIcon = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][text()='Admin']");
    By AddBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By URDropDown = By.xpath("//label[text()='User Role']/following::div[1]");
    By URList = By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//child::div[2]");
    By StatusDD = By.xpath("//label[text()='Status']/following::div[1]");
    By StatusList = By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//div[@class='oxd-select-option'][2]");
    By PassTxtBox = By.xpath("//label[text()='Password']/following::div[1]");
    By EmployeeN = By.xpath("//label[text()='Employee Name']/following::div[1]");
    By EmployeeList = By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']//child::div[@class='oxd-autocomplete-option']//child::span[text()='manda akhil user']");
    By UserTxtBox = By.xpath("//label[text()='Username']/following::div[1]");
    By ConPassword = By.xpath("//label[text()='Confirm Password']/following::div[1]");
    By SaveBtn = By.xpath("//button[text()=' Save ']");
    By SearchTxtBox = By.xpath("//label[text()='Username']/following::div[1]");
    By SearchBtn = By.xpath("//button[text()=' Search ']");
    By DeleteBtn = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']//child::i[@class='oxd-icon bi-trash']");
    By yesBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']//child::i[@class='oxd-icon bi-trash oxd-button-icon']");
    By resetBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']");
    By SuccessMsg = By.id("oxd-toaster_1");


    public void clickAdminIcon(){
        WebElement Admin = Hooks.driver.findElement(AdminIcon);
        waitElementToAppear(Admin);
        Hooks.driver.findElement((AdminIcon)).click();
    }

    public void waitElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAllRecords(){
        WebElement totalRecords = Hooks.driver.findElement((TotalRecordsFound));
        waitElementToAppear(totalRecords);
    }

    public String getTotalRecordsAsString(){

        String numOfRecords = Hooks.driver.findElement((TotalRecordsFound)).getText();
        System.out.println(numOfRecords);
        return numOfRecords;
    }

    public Integer getTotalRecordsAsInteger(String recordsFoundString) {
        String regEx = "\\(\\s*(\\d+)\\s*\\)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(recordsFoundString);
        if (matcher.find()) {
            Integer recordValueInt = Integer.parseInt(matcher.group(1));
            System.out.println("The number in the text is : " + recordValueInt);
            return recordValueInt;
        }
        return 0;
    }

    public void ClickAddBtn() {

        Hooks.driver.findElement(AddBtn).click();
    }


    public void selectFromUserRoleDD(String arg0){

        Hooks.driver.findElement(URDropDown).click();
        WebElement userRoleList = Hooks.driver.findElement((URList));
        waitElementToAppear(userRoleList);
        userRoleList.click();
    }

    public void EnterEmployeeName(String name){
        WebElement EmployeeName = Hooks.driver.findElement(EmployeeN);
        waitElementToAppear(EmployeeName);
        EmployeeName.click();
        EmployeeName.sendKeys(name);

        WebElement Employee = Hooks.driver.findElement(EmployeeList);
        waitElementToAppear(Employee);
        Employee.click();
    }

    public void selectFromStatusDD(String arg1) {
        Hooks.driver.findElement(StatusDD).click();
        WebElement Status = Hooks.driver.findElement(StatusList);
        waitElementToAppear(Status);
        Status.click();
    }

    public void EnterUsername(String username) {
        WebElement userName = Hooks.driver.findElement(UserTxtBox);
        userName.click();
        userName.sendKeys(username);
    }

    public void EnterPassword(String password){
        WebElement Pass = Hooks.driver.findElement(PassTxtBox);
        waitElementToAppear(Pass);
        Hooks.driver.findElement(PassTxtBox).sendKeys(password);
    }


    public void EnterConfirmPassword(String password) {
        WebElement cPass = Hooks.driver.findElement(ConPassword);
        cPass.click();
        cPass.sendKeys(password);
    }

    public void ClickSaveBtn() {
        Hooks.driver.findElement(SaveBtn).click();
    }

    public void searchForAddedUser(String username) {
        Hooks.driver.findElement(SearchTxtBox).sendKeys(username);
        Hooks.driver.findElement(SearchBtn).click();
    }

    public void DeleteUser() {
        Hooks.driver.findElement(DeleteBtn).click();
    }

    public void clickYesDeleteBtn() {
        WebElement yesDeleteBtn = Hooks.driver.findElement((yesBtn));
        waitElementToAppear(yesDeleteBtn);
        yesDeleteBtn.click();

    }

    public void waitSuccessMsg() {
        WebElement yesDeleteBtn1 = Hooks.driver.findElement(SuccessMsg);
        waitElementToAppear(yesDeleteBtn1);
    }

    public void clickReset() {

        Hooks.driver.findElement((resetBtn)).click();
    }

}