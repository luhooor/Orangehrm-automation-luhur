package tasks;

import OrangeHRM.pageobjects.HRMLoginPageObjects;
import OrangeHRM.pageobjects.HRMPIMPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import fb.pageobjects.LoginPageObjects;

public class NavigateTo {
    public static Performable theURL(String urlType) throws Exception {
        Class url;

        switch (urlType) {
            case "FB Login":
                url = LoginPageObjects.class;
                break;
            case "HRM Login":
                url = HRMLoginPageObjects.class;
                break;
            case "HRM PIM Page":
                url = HRMPIMPageObjects.class;
            default:
                throw new Exception("There is no url type: "+urlType);
        }

        return Task.where("{0} access login url/page", Open.browserOn().the(url));
    }
}
