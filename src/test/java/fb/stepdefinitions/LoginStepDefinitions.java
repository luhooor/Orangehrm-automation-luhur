package fb.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import tasks.NavigateTo;

public class LoginStepDefinitions {
    @Given("{actor} open facebook login page")
    public void iOpenFacebookLoginPage(Actor actor) throws Exception {
        actor.wasAbleTo(NavigateTo.theURL("FB Login"));
    }
}
