package stepDefinitions;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageLogin;
import pages.SeleniumFunctions;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static utils.Constants.*;



public class Login {
    SeleniumFunctions functions = new SeleniumFunctions();

    /******** Log Attribute ********/
    Logger log = Logger.getLogger(StepDefinitions.class);

    public Login() {
    }

    /******** Scenario Attributes ********/
    /*Scenario scenario = null;
    public void scenario (Scenario scenario) {
        this.scenario = scenario;
    }*/


    @Given("Open url")
    public void iAmInAppMainSite() throws Exception {
        String url = functions.readProperties("urlApp");
        log.info("Open to url - : " + url);
        PageLogin.getUrl(url);
        //driver.get(url);


        //WebDriverWait wait = new WebDriverWait(driver, 40);
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));

       // functions.HandleMyWindows.put("Principal", driver.getWindowHandle());
        //functions.page_has_loaded();
    }

    @When("login with credentials {string} {string}")
    public void enter_credentials(String user, String password) throws IOException {
        //---------- get environment user and password ----------
        String get_user =  functions.readProperties(user);
        String get_password =  functions.readProperties(password);
        log.info("El usuario es -----------" + get_user);
        log.info("La pass es -----------" + get_password);

        //---------- enter user in input ----------
        String responseInputUser = PageLogin.inputUser(get_user);
        assertEquals(OK, responseInputUser);

        //---------- enter pass in input ----------
        String responseInputPass = PageLogin.inputPass(get_password);
        assertEquals(OK, responseInputPass);

        //--------- clic in btn login -----------
        String validateLogin = PageLogin.btnLogin();
        assertEquals(OK, validateLogin);

    }

    @Then("valid message {string} {string}")
    public void valid_message(String msg, String login) {
        String validateLogin = PageLogin.validateLogin(login);
        assertEquals(msg, validateLogin);
    }


}
