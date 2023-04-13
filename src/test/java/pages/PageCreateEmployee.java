package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.logging.Logger;
import static utils.DataRandom.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Hooks;


public class PageCreateEmployee extends Hooks {
    static WebDriverWait wait = new WebDriverWait(driver,15);;

    //-------- LOG --------/
    private static Logger log = Logger.getLogger(String.valueOf(PageLogin.class));

    public PageCreateEmployee(){
        //wait = new WebDriverWait(driver,10);
    }

    public static String goToModulePim() {
        log.info("1 --------");
        Boolean validateBtnModulePim = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).size() > 0;
        log.info("2 --------");
        String xpathMsgFormCreateEmployee = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5";
        log.info("3 --------");
        if (validateBtnModulePim) {
            log.info("4 --------");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathMsgFormCreateEmployee)));
            log.info("5 --------");
            WebElement msgFormCreateEmployee = driver.findElement(By.xpath(xpathMsgFormCreateEmployee));
            String textMsg = msgFormCreateEmployee.getText();
            return textMsg;
        } else {
            return "Error in goToModulePim";
        }
    }


    public static String btnAdd() {
        String xpathBtnAdd = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button";
        String xpathMsgAfterAdd = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6";
        Boolean validateBtnAdd = driver.findElements(By.xpath(xpathBtnAdd)).size() > 0;
        if (validateBtnAdd) {
            driver.findElement(By.xpath(xpathBtnAdd)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathMsgAfterAdd)));
            WebElement msgFormCreateEmployee = driver.findElement(By.xpath(xpathMsgAfterAdd));
            String textMsg = msgFormCreateEmployee.getText();
            return textMsg;
        } else {
            return "Error in btnAdd";
        }
    }


    public static String btnSave() {
        String xpathBtnSave = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]";
        String xpathMsgAfterSave = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6";
        Boolean validateBtnSave = driver.findElements(By.xpath(xpathBtnSave)).size() > 0;
        if (validateBtnSave) {
            driver.findElement(By.xpath(xpathBtnSave)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathMsgAfterSave)));
            WebElement msgAfterSaveEmployee = driver.findElement(By.xpath(xpathMsgAfterSave));
            String textMsg = msgAfterSaveEmployee.getText();
            return textMsg;
        } else {
            return "Error in btnSave";
        }
    }

    public static String inputFirstName() {

        String nameInputFirstName = "firstName";
        Boolean inputNameEmployee = driver.findElements(By.name(nameInputFirstName)).size() > 0;
        log.info("inputNameEmployee"+ inputNameEmployee);
        if (inputNameEmployee) {
            String nameEmployee = nameRandom();
            driver.findElement(By.name(nameInputFirstName)).sendKeys(nameEmployee);
            log.info("FIRST NAME -------- " + nameEmployee);
            return "OK";
        } else {
            return "Error in inputFirstName";
        }
    }



    public static String inputMiddleName() {

        String nameinputMiddle = "middleName";
        Boolean inputMiddleName = driver.findElements(By.name(nameinputMiddle)).size() > 0;
        if (inputMiddleName) {
            String middleName = middleRandom();
            driver.findElement(By.name(nameinputMiddle)).sendKeys(middleName);
            log.info("MIDDLE NAME -------- " + middleName);
            return "OK";
        } else {
            return "Error in inputMiddleName";
        }
    }


    public static String inputLastName() {

        String nameInputLastName = "lastName";
        Boolean inputLastName = driver.findElements(By.name(nameInputLastName)).size() > 0;
        if (inputLastName) {
            String lastName = lastNameRandom();
            driver.findElement(By.name(nameInputLastName)).sendKeys(lastName);
            log.info("LAST NAME -------- " + lastName);
            return "OK";
        } else {
            return "Error in inputLastName";
        }
    }

    public static String inputId() {
        try {
            String xpathId = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input";
            Boolean inputId = driver.findElements(By.xpath(xpathId)).size() > 0;
            if (inputId) {
                String idEmployee = idRandom();
                log.info("ID RANDOM - " + idEmployee);
                driver.findElement(By.xpath(xpathId)).clear();
                Thread.sleep(4000);
                driver.findElement(By.xpath(xpathId)).sendKeys(idEmployee);
                log.info("ID EMPLOYEE -------- " + idEmployee);
            }

            return "OK";
        } catch (Exception ex) {
            return "Error in inputId";
        }

    }


    public static String goToEmergencyContacts() {

        String linkText = "Emergency Contacts";
        String xpathTextAfterClic = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/h6";
        Boolean linkEmergencyContacts = driver.findElements(By.linkText(linkText)).size() > 0;
        if (linkEmergencyContacts) {
            driver.findElement(By.linkText(linkText)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathTextAfterClic)));
            String text = driver.findElement(By.xpath(xpathTextAfterClic)).getText();
            return text;
        } else {
            return "Error in goToEmergencyContacts";
        }
    }


    public static String clicAddEmergencyContacts() {
        String xpathAdd = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button";
        String xpathTextAfterClic = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6";
        Boolean btnAddEmContats = driver.findElements(By.xpath(xpathAdd)).size() > 0;
        if (btnAddEmContats) {
            driver.findElement(By.xpath(xpathAdd)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathTextAfterClic)));
            String text = driver.findElement(By.xpath(xpathTextAfterClic)).getText();
            return text;
        } else {
            return "Error in clicAddEmergencyContacts";
        }
    }

    public static String addEmergencyContacts() {

        String xpathInputNameContacts = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input";
        String xpathInputRelations = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input";
        String xpathBtnSave = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/button[2]";
        String xpathInputPhone = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/input";
        String xpathAfterSaveContacts = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/h6";

        // Input Name
        driver.findElement(By.xpath(xpathInputNameContacts)).sendKeys(nameRandom());
        //Input Relations
        driver.findElement(By.xpath(xpathInputRelations)).sendKeys("Sister");
        //Input phone
        driver.findElement(By.xpath(xpathInputPhone)).sendKeys("988556699");
        //CLIC IN SAVE
        driver.findElement(By.xpath(xpathBtnSave)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathAfterSaveContacts)));
        String text = driver.findElement(By.xpath(xpathAfterSaveContacts)).getText();
        return text;

    }






}
