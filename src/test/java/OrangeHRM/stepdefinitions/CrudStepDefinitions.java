package OrangeHRM.stepdefinitions;

import OrangeHRM.pageobjects.HRMPIMPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import tasks.ClickOn;
import tasks.InputText;
import tasks.NavigateTo;
import tasks.VerifyDisplayed;

public class CrudStepDefinitions {
    @And("{actor} access employee list")
    public void iAccessEmployeeList(Actor actor) throws Exception {
//        actor.wasAbleTo(NavigateTo.theURL("HRM PIM Page"));
        actor.attemptsTo(ClickOn.button("PIM Menu"));
    }

    @When("{actor} add new employee with required fields only")
    public void iAddNewEmployeeWithRequiredFieldsOnly(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.button("Add"),
                InputText.onField("firstName", "John"),
                InputText.onField("lastName", "Constantine"),
                ClickOn.button("Save")
        );
    }

    @Then("{actor} can see the newly created user personal details")
    public void iCanSeeTheNewlyCreatedUserPersonalDetails(Actor actor) throws Exception {
        actor.attemptsTo(VerifyDisplayed.element("Personal Detail"));
    }

    @Then("{actor} can see the employee list")
    public void iCanSeeTheEmployeeList(Actor actor) throws Exception {
        actor.attemptsTo(VerifyDisplayed.element("Employee List"));
    }

    @When("{actor} search for new employee")
    public void iSearchForNewEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                InputText.onField("Employee Name", "John Constantine"),
                ClickOn.button("Search")
        );
        actor.attemptsTo(VerifyDisplayed.firstNameValue("John"));
    }

    @And("{actor} update the employee middle name")
    public void iUpdateTheEmployeeMiddleName(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.firstNameResult(),
                ClickOn.button("Save"),
                InputText.onField("Middle Name", "Doe"),
                ClickOn.button("Save")
        );
    }

    @Then("{actor} can see the personal detail has changed")
    public void iCanSeeThePersonalDetailHasChanged(Actor actor) {
        actor.attemptsTo(VerifyDisplayed.middleNameValue("Doe"));
    }

    @And("{actor} delete the employee")
    public void iDeleteTheEmployee(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.button("Checkbox"),
                ClickOn.button("Delete"),
                ClickOn.button("OK")
        );
    }

    @Then("{actor} cannot see the deleted employee on the list")
    public void iCannotSeeTheDeletedEmployeeOnTheList(Actor actor) {
        actor.attemptsTo(
                Ensure.that(HRMPIMPageObjects.NO_RESULT).text().isEqualToIgnoringCase("No Records Found")
        );
    }

}
