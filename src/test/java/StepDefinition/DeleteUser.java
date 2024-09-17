package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import POM.Admin;
import static POM.Admin.TotalRecordsFound;


public class DeleteUser {
    Admin admin = new Admin();
    Integer RecordsBeforeDeleting;

    @Given("Get Total Records Before Deleting")
    public void getTotalRecordsBeforeDeleting(){
        admin.waitForAllRecords();
        String stringRecords = admin.getTotalRecordsAsString();
        RecordsBeforeDeleting = admin.getTotalRecordsAsInteger(stringRecords);

    }

    @When("User Searches for the new user {}")
    public void userSearchesForTheNewUser(String arg0) {
        admin.searchForAddedUser(arg0);

    }

    @And("User Deletes the new user")
    public void userDeletesTheNewUser() {

        admin.DeleteUser();
    }

    @And("confirm to delete")
    public void confirmToDelete() {

        admin.clickYesDeleteBtn();

    }

    @And("User waits for success message")
    public void userWaitsForSuccessMessage() {
        
        admin.waitSuccessMsg();
    }

    @And("User clicks on Reset Research")
    public void userClicksOnResetResearch() {
        
        admin.clickReset();
    }

    @Then("User validates that the number of records decreased by {int}")
    public void UserValidatesThatTheNumberOfRecordsDecreasedBy(Integer Value){

        WebElement totalRecords = Hooks.driver.findElement((TotalRecordsFound));
        admin.waitElementToAppear(totalRecords);
        String StringRecords = admin.getTotalRecordsAsString();
        Integer ActualRecordsAfterDeleting = admin.getTotalRecordsAsInteger(StringRecords);
        Integer ExpectedResultAfterDeleting = RecordsBeforeDeleting - Value;
        Assert.assertEquals(ActualRecordsAfterDeleting, ExpectedResultAfterDeleting);

    }

}
