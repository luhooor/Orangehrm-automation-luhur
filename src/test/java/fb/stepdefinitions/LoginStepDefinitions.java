package fb.stepdefinitions;

import fb.pageobjects.CheckPointPageObjects;
import io.cucumber.java.en.*;
import io.github.cdimascio.dotenv.Dotenv;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import tasks.*;


public class LoginStepDefinitions {
    @Given("{actor} open facebook login page")
    public void iOpenFacebookLoginPage(Actor actor) throws Exception {
        actor.wasAbleTo(NavigateTo.theURL("FB Login"));
    }

    @When("{actor} input email and password")
    public void iInputEmailAndPassword(Actor actor) throws Exception {
        Dotenv dotenv = Dotenv.load();

        String email = dotenv.get("EMAIL_FB");
        String password = dotenv.get("PASSWORD_FB");

        actor.attemptsTo(
                InputText.onField("FB Email", email),
                InputText.onField("FB Password", password)
        );

    }

    @And("{actor} click button login")
    public void iClickButtonLogin(Actor actor) throws Exception {
        actor.attemptsTo(ClickOn.button("FB Login"));
    }

    @Then("{actor} can't see my news feed")
    public void iCanTSeeMyNewsFeed(Actor actor) {
//        actor.should(seeThat(TheMenu.displayed(), not(contains("News Feed"))));

        actor.attemptsTo(
                Ensure.that(CheckPointPageObjects.MENU_LIST).text().not().contains("News Feed")
        );
    }

    @But("{actor} see FB has disabled my account")
    public void iSeeFBHasDisabledMyAccount(Actor actor) {
//        actor.should(
//                seeThat(
//                        TheMessage.displayed(), contains("Your account has been disabled")
//                )
//        );
        actor.attemptsTo(
                Ensure.that(CheckPointPageObjects.ERROR_MESSAGE).text().contains("Your account has been disabled"),
                Ensure.thatTheCurrentPage().currentUrl().contains("checkpoint")
        );
    }
}
