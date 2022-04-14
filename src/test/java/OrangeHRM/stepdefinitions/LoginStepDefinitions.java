package OrangeHRM.stepdefinitions;

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
}
