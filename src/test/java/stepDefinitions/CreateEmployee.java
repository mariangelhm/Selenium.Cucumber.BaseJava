package stepDefinitions;

import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.PageCreateEmployee;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static utils.Constants.OK;

public class CreateEmployee {
    static WebDriver driver = Hooks.driver;

    /******** Log Attribute ********/
    static Logger log = Logger.getLogger(StepDefinitions.class);

    public CreateEmployee() {

    }

    @When("Go to module pim {string}")
    public static String goToModulePim(String msg) {
        //---------- Go to module pim----------
        log.info("Entró aquí go to module pim");
        try {
            String responseGoToModulePim = PageCreateEmployee.goToModulePim();
            log.info("Entró2 aquí go to module pim 2");
            assertEquals(msg, responseGoToModulePim);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "OK";
    }

    @When("fill out employee creation form")
    public void fillForm() throws IOException {
        //--------- Clic in addEMployee -------
        String response = PageCreateEmployee.btnAdd();
        assertEquals("Add Employee", response);

        //------- First name ------
        String responseInputName = PageCreateEmployee.inputFirstName();
        assertEquals(OK, responseInputName);

        //------- Middle name ------
        String responseInputMiddle = PageCreateEmployee.inputMiddleName();
        assertEquals(OK, responseInputMiddle);

        //------- Lastname ------
        String responseInputLastName = PageCreateEmployee.inputLastName();
        assertEquals(OK, responseInputLastName);

        //------- Lastname ------
        String responseId = PageCreateEmployee.inputId();
        assertEquals(OK, responseId);

        //--------- Clic Save Employee -------
        String responseSaveResponse = PageCreateEmployee.btnSave();
        assertEquals("Personal Details", responseSaveResponse);
    }

    @When("Add emergency contacts")
    public void emergencyContacts() throws IOException {
        //--------- Go to module emergency contacts --------
        String response = PageCreateEmployee.goToEmergencyContacts();
        assertEquals("Assigned Emergency Contacts", response);


        //------- Clic in add Emergency contact ----------
        String responseClicAddEmergency = PageCreateEmployee.clicAddEmergencyContacts();
        assertEquals("Save Emergency Contact", responseClicAddEmergency);

        //-------- Add emergency contants  ----------
        String reponseAddEmerContacts = PageCreateEmployee.addEmergencyContacts();
        assertEquals("Save Emergency Contact", reponseAddEmerContacts);
    }
}
