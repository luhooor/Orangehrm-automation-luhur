package tasks;

import OrangeHRM.pageobjects.HRMPIMPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

public class VerifyDisplayed {
    public static Performable element (String elementType) throws Exception {
        Target element;

        switch (elementType) {
            case "Employee List":
                element = HRMPIMPageObjects.RESULT_TABLE;
                break;
            case "Personal Detail":
                element = HRMPIMPageObjects.PERSONAL_DETAIL;
                break;
            default:
                throw new Exception("There is no element type: " + elementType);
        }

        return Task.where("{0} verify element is displayed",
                Ensure.that(element).isDisplayed()
            );
    }

    public static Performable firstNameValue(String firstName) {
        return Task.where("{0} verify the first name result",
                Ensure.that(HRMPIMPageObjects.FIRST_NAME_RESULT).text().contains(firstName)
        );
    }

    public static Performable middleNameValue(String midName) {
        return Task.where("{0} verify the first name result",
                Ensure.that(HRMPIMPageObjects.MIDDLE_NAME).value().isEqualTo(midName)
        );
    }

}
