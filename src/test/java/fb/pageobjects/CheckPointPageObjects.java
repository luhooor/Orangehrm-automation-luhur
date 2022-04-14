package fb.pageobjects;

import net.serenitybdd.screenplay.targets.Target;

public class CheckPointPageObjects {
    public static Target ERROR_MESSAGE = Target.the("Banned account")
            .locatedBy(".aov4n071.bi6gxh9e:first-of-type>span:nth-child(1)");
    public static Target MENU_LIST = Target.the("List of menu")
            .locatedBy(".rq0escxv.l9j0dhe7.du4w35lb");
}
