package tasks;

import OrangeHRM.pageobjects.HRMLoginPageObjects;
import OrangeHRM.pageobjects.HRMPIMPageObjects;
import fb.pageobjects.LoginPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ClickOn {
    public static Performable button(String buttonType) throws Exception {

        Target button;

        switch (buttonType) {
            case "FB Login":
                button = LoginPageObjects.LOGIN_BUTTON;
                break;
            case "HRM Login":
                button = HRMLoginPageObjects.LOGIN_BUTTON;
                break;
            case "Add":
                button = HRMPIMPageObjects.ADD_BUTTON;
                break;
            case "Save":
                button = HRMPIMPageObjects.SAVE_BUTTON;
                break;
            case "Search":
                button = HRMPIMPageObjects.SEARCH_BUTTON;
                break;
            case "Checkbox":
                button = HRMPIMPageObjects.CHECKBOX;
                break;
            case "Delete":
                button = HRMPIMPageObjects.DELETE_BUTTON;
                break;
            case "OK":
                button = HRMPIMPageObjects.OK_BUTTON;
                break;
            case "PIM Menu":
                button = HRMPIMPageObjects.PIM_LINK;
                break;
            default:
                throw new Exception("There is no such button for " + buttonType);
        }

        WaitUntil.the(button, isVisible()).forNoMoreThan(25).seconds();

        return Task.where("{0} Click on " + buttonType +" button",
                Click.on(button)
        );
    }


    public static Performable firstNameResult() {
        return Task.where("{0} click on the first name result",
            Click.on(HRMPIMPageObjects.FIRST_NAME_RESULT)
        );
    }
}
