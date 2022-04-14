package tasks;

import fb.pageobjects.CheckPointPageObjects;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Collection;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TheMenu {
    public static Question<Collection<String>> displayed() {
        WaitUntil.the(CheckPointPageObjects.MENU_LIST, isVisible()).forNoMoreThan(25).seconds();

        return Text.ofEach(CheckPointPageObjects.MENU_LIST).describedAs("the messages displayed");
    }
}
