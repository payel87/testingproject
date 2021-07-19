package helpers;

import cucumber.api.Scenario;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GenericHelper {

     public static WebDriver getChromeDriver() {
            File driverFile = new File("C:\\testingproject\\src\\main\\java\\drivers\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            WebDriver chromeDriver = new ChromeDriver(capabilities);
            return chromeDriver;
    }


    }

