package OrangeHRM.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/pim/viewPimModule")
public class HRMPIMPageObjects extends PageObject {
    public static Target RESULT_TABLE = Target.the("Employee result table")
            .locatedBy("#resultTable");
    public static Target PIM_LINK = Target.the("PIM Link")
            .locatedBy("#menu_pim_viewPimModule");

//    Add employee elements
    public static Target ADD_BUTTON = Target.the("Add employee button")
            .locatedBy("#btnAdd");
    public static Target SAVE_BUTTON = Target.the("Save employee button")
            .locatedBy("#btnSave");
    public static Target FIRST_NAME = Target.the("First name field")
            .locatedBy("#firstName");
    public static Target LAST_NAME = Target.the("Last name field")
            .locatedBy("#lastName");
    public static Target PERSONAL_DETAIL = Target.the("Personal Detail title")
            .locatedBy("#pdMainContainer .head h1");

    //    Search employee elements
    public static Target EMPLOYEE_NAME = Target.the("Employee name field")
            .locatedBy("#empsearch_employee_name_empName");
    public static Target SEARCH_BUTTON = Target.the("Search Button")
            .locatedBy("#searchBtn");
    public static Target FIRST_NAME_RESULT = Target.the("First Name Result")
            .locatedBy("tbody tr td:nth-child(3) a");
    public static Target MIDDLE_NAME = Target.the("Middle Name field")
            .locatedBy("#personal_txtEmpMiddleName");
    public static Target CHECKBOX = Target.the("Checkbox")
            .locatedBy("//*[contains(@id, 'ohrmList_chkSelectRecord')]");
    public static Target DELETE_BUTTON = Target.the("Delete Button")
            .locatedBy("#btnDelete");
    public static Target OK_BUTTON = Target.the("OK Button")
            .locatedBy("#dialogDeleteBtn");
    public static Target NO_RESULT = Target.the("No result element")
            .locatedBy("tbody tr td");
}
