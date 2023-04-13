package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import init.CreateDriver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import stepDefinitions.Hooks;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "classpath:stepDefinitions",
        tags = "@login"
)


public class TestRunner extends Hooks{

    static Logger log = Logger.getLogger(Hooks.class);
    private static InputStream in = CreateDriver.class.getResourceAsStream("target/allure-results/environment.properties");
    private static Properties prop = new Properties();

    @BeforeClass
    public static void setupClass() {
        try {
            log.info("***********************************************************************************************************");
            log.info("[ Configuration ] - Initializing driver configuration");
            log.info("***********************************************************************************************************");
            log.info("#################################### BEFORE CLASS ################################");
            driver = CreateDriver.initConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @AfterClass
    public static void exit() throws IOException {
        System.out.println("#################################### CUSTOMIZE REPORT ###############################");

        // --- ENVIRONMENT IN REPORT -----
        OutputStream output = new FileOutputStream("target/allure-results/environment.properties");
        Properties prop = new Properties();
        prop.setProperty("Browser", "Chrome");
        prop.setProperty("Browser.Version", "XXX Version Variable");
        prop.setProperty("Environment", "Production");
        prop.setProperty("Service", "Front Payment");
        prop.store(output, null);


        // --- HTML IN REPORT -----
        // .allure/allure-2.7.0/bin/allure generate target/allure-results -o report
        /*
        executeScript();





        Files.copy(originPathApp, destinationPathApp, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(originPathHtml, destinationPathHtml, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(originPathCss, destinationPathCss, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(originPathExecutor, destinationPathExecutor, StandardCopyOption.REPLACE_EXISTING);
        */
        System.out.println("#################################### CLOSED DRIVER ###############################");
        driver.quit();
    }


    public static void executeScript(){
        try{

            ProcessBuilder builder = new ProcessBuilder();
            builder.command("sh", "-c");
            String path = new File("script.sh").getAbsolutePath();
            log.info("path: ".concat(path));
            builder.directory(new File(path));

            Process process = builder.start();

            /*
            String[] cmd = {"/bin/sh -c ls %s"};
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecutions = null;
            while((resultOfExecutions = br.readLine()) != null) {
                log.info(resultOfExecutions);
            }




            Process process = Runtime.getRuntime().exec("cmd /c dir");
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecutions = null;
            while((resultOfExecutions = br.readLine()) != null) {
                log.info();
            }*/


        }catch(Exception e){
            e.printStackTrace();
        }

    }



}
