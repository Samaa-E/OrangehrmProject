package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import POM.Admin;


public class AddUser {

    Admin admin = new Admin();
    public Integer recordsBeforeAdding;


    @Given("User navigates to admin icon")
    public void userNavigatesToAdminIcon(){
        admin.clickAdminIcon();
    }


    @When("The number of records found")
    public void theNumberOfRecordsFound(){
        admin.waitForAllRecords();
        String StringRecords = admin.getTotalRecordsAsString();
        recordsBeforeAdding = admin.getTotalRecordsAsInteger(StringRecords);
    }

    @And("User clicks on add button")
    public void userClicksOnAddButton() {

        admin.ClickAddBtn();
    }

    @And("User Fills the required fields {}, {}, {}, {}, {}, {}")
    public void userFillsTheRequiredFields(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        admin.selectFromUserRoleDD(arg0);
        admin.EnterEmployeeName(arg1);
        admin.selectFromStatusDD(arg2);
        admin.EnterUsername(arg3);
        admin.EnterPassword(arg4);
        admin.EnterConfirmPassword(arg5);
    }

    @And("User clicks on save button")
    public void userClicksOnSaveButton() {
        admin.ClickSaveBtn();
    }

    @Then("User validates Total Number of Records Increased by {int}")
    public void userValidatesTotalNumberOfRecordsIncreasedBy(int Value){

        String StringRecords = admin.getTotalRecordsAsString();
        Integer ActualRecordsAfterAdding = admin.getTotalRecordsAsInteger(StringRecords);
        Integer ExpectedResultAfterAdding = recordsBeforeAdding + Value;
        Assert.assertEquals(ActualRecordsAfterAdding, ExpectedResultAfterAdding);
    }


}
