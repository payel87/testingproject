package steps;

import config.EnvironmentConfig;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import helpers.GenericHelper;

import javax.imageio.ImageIO;

/**
 * Created by M64193 on 15/06/2017.
 *
 * This class should be used as a Constructor Parameter in every class where StepDefinitions exists.
 */
public class RunContext {

    public WebDriver driver;
    public Scenario scenario;
    public Map<String,String> params;
    public static String environment;
    public static EnvironmentConfig config;
    public static String apiSessionToken;
    public String envUrl;

    @Before
    public void init(Scenario scenario){
        driver = GenericHelper.getChromeDriver();
        this.scenario = scenario;
        System.out.println("Environment URL: "+config.getEnvironmentUrl());
        envUrl = config.getEnvironmentUrl();
        driver.navigate().to(config.getEnvironmentUrl());
        driver.manage().window().maximize();
        }


     @After
        public void tearDown(Scenario scenario){
      //take screenshot
         final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
         scenario.embed(screenshot, "image/png");
         driver.quit();

    }


    //initialSetUpActions
    static{
        config = new EnvironmentConfig();
        config.setDefaultEnvironment();
        config.setEnvironmentDetails();
        environment = config.getEnvironment();
    }

}
