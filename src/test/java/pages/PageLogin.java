package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.TestRunner;
import java.util.logging.Logger;


public class PageLogin extends TestRunner {

    static SeleniumFunctions functions = new SeleniumFunctions();

    /********** LOG *********/
    private static Logger log = Logger.getLogger(String.valueOf(PageLogin.class));


    /********** highLigh *********/
    private static boolean highLigh(WebElement element) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.err.println("Javascript | highLigh | Excepction descrip:" + e.getMessage());
            return false;
        }

        return true;
    }

    public static void getUrl(String url) throws Exception {
        driver.get(url);
        //WebDriverWait wait = new WebDriverWait(driver, 40);
        functions.waitForElementClikable("afterGoToUrl");
        log.info("YA PASÓ POR AQUÍ, TERMINÓ LA URL");
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
    }

    public static String inputUser(String get_user) {
        Boolean validateInputUser = driver.findElements(By.name("username")).size() > 0;
        if (validateInputUser) {
            driver.findElement(By.name("username")).sendKeys(get_user);
            return "OK";
        } else {
            return "Error in inputUser";
        }

    }


    public static String inputPass(String get_pass) {
        Boolean validateInputPass = driver.findElements(By.name("password")).size() > 0;;
        if (validateInputPass) {
            WebElement inputPass = driver.findElement(By.name("password"));
            inputPass.sendKeys(get_pass);
            return "OK";
        } else {
            return "Error in inputPass";
        }
    }


    public static String btnLogin() {
        Boolean validateBtnLogin = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).size() > 0;;
        if (validateBtnLogin) {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
            return "OK";
        } else {
            return "Error in btnLogin";
        }
    }




    public static String validateLogin(String login) {
        boolean loginB=Boolean.parseBoolean(login);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if(loginB) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]")));
            WebElement msgLoginOk = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]"));
            String textMsgLoginOk = msgLoginOk.getText();
            return textMsgLoginOk;
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]")));
            WebElement msgLoginError = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]"));
            String textMsgLoginError = msgLoginError.getText();
            log.info("get tec alert -----------------------: " + textMsgLoginError);
            return textMsgLoginError;
        }
    }
}
