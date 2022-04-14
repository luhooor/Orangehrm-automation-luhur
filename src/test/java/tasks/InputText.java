package tasks;

import OrangeHRM.pageobjects.HRMLoginPageObjects;
import OrangeHRM.pageobjects.HRMPIMPageObjects;
import fb.pageobjects.LoginPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class InputText {
    public static Performable onField(String fieldType, String value) throws Exception {
        Target field = null;
        switch (fieldType) {
            case "FB Email":
                field = LoginPageObjects.EMAIL_FIELD;
                break;
            case "FB Password":
                field = LoginPageObjects.PASSWORD_FIELD;
                break;
            case "HRM Username":
                field = HRMLoginPageObjects.EMAIL_FIELD;
                break;
            case "HRM Password":
                field = HRMLoginPageObjects.PASSWORD_FIELD;
                break;
            case "firstName":
                field = HRMPIMPageObjects.FIRST_NAME;
                break;
            case "lastName":
                field = HRMPIMPageObjects.LAST_NAME;
                break;
            case "Employee Name":
                field = HRMPIMPageObjects.EMPLOYEE_NAME;
                break;
            case "Middle Name":
                field = HRMPIMPageObjects.MIDDLE_NAME;
                break;
            default:
                throw new Exception("There is no such field: " + fieldType);
        }

        return Task.where("{0} input: " + value,
                Enter.theValue(value)
                        .into(field)
                );

    }
}
