package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {
    public WebDriver driver;
    private String testURL, browser;
    private int implicitWait;


    @BeforeMethod
    public void setupDriverAndOpenTestAddress(){
        readConfig("src/test/resources/config.properties");
        setupDriver();
        driver.get(testURL);

    }

    private void readConfig(String fullPathToConfigFile){
        try{
            FileInputStream fileInputStream = new FileInputStream(fullPathToConfigFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            testURL = properties.getProperty("testURL");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
        }
        catch (IOException t){
            System.out.println(t);
        }
    }

    private void setupDriver(){
        switch (browser){
            case "chrome":
                driver = setupChrome();
                break;
            case "safari":
                driver = setupSafari();
                break;
            case "firefox":
                driver = setupFirefox();
                break;
            default:
                driver = setupChrome();
        }
    }

    private WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    private WebDriver setupSafari(){
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    private WebDriver setupFirefox(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @AfterMethod
    public void closeDown(){
        driver.quit();
    }
}
