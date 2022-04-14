package OrangeHRM.stepdefinitions;

import OrangeHRM.pageobjects.HRMLoginPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import tasks.ClickOn;
import tasks.InputText;
import tasks.NavigateTo;

public class LoginStepDefinitions {
    @Given("{actor} open OrangeHRM login page")
    public void iOpenOrangeHRMLoginPage(Actor actor) throws Exception {
        actor.wasAbleTo(NavigateTo.theURL("HRM Login"));
    }

    @When("{actor} input username and password")
    public void iInputUsernameAndPassword(Actor actor) throws Exception {
        Dotenv dotenv = Dotenv.load();

        String username = dotenv.get("USER_HRM");
        String password = dotenv.get("PASS_HRM");

        actor.attemptsTo(
                InputText.onField("HRM Username", username),
                InputText.onField("HRM Password", password)
        );
    }

    @And("{actor} click on the login button")
    public void iClickOnTheLoginButton(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.button("HRM Login")
        );
    }

    @Then("{actor} can login successfully")
    public void iCanLoginSuccessfully(Actor actor) {
        actor.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().contains("index.php/dashboard")
        );
    }

    @When("{actor} input {string} as username")
    public void iInputAsUsername(Actor actor, String username) throws Exception {
        actor.attemptsTo(
                InputText.onField("HRM Username", username)
        );
    }

    @And("{actor} input {string} as password")
    public void iInputAsPassword(Actor actor, String password) throws Exception {
        actor.attemptsTo(
                InputText.onField("HRM Password", password)
        );
    }

    @Then("{actor} can see an error message: {string}")
    public void iCanSeeAnErrorMessage(Actor actor, String message) {
        actor.attemptsTo(
                Ensure.that(HRMLoginPageObjects.ERROR_ELEMENT).isDisplayed(),
                Ensure.that(HRMLoginPageObjects.ERROR_ELEMENT).text().isEqualToIgnoringCase(message)
        );
    }
}
