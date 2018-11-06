package browser;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class Browser {
    public static WebDriver driver;
    protected static final Logger log = Logger.getLogger(Browser.class);
    protected static Browser browser = new Browser();


    public void setUpBrowser(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions co = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        Map<String, Object> profile = new HashMap<>();
        Map<String, Object> contentSettings = new HashMap<>();
        co.setExperimentalOption("prefs", prefs);
        co.addArguments("test-type");
        co.addArguments("disable-popup-blocking");
        co.addArguments("disable-save-password-bubble");
        co.addArguments("ignore-certificate-errors");
        co.addArguments("disable-translate");
        co.addArguments("start-maximized");
        co.addArguments("--allow-silent-push");
        co.addArguments("--enable-automation");
        co.addArguments("--enable-javascript");
        System.setProperty("webdriver.chrome.driver", "properties/driver/chromedriver");
        capabilities.setCapability(ChromeOptions.CAPABILITY, co);
        setDriver(new ChromeDriver(capabilities));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(RemoteWebDriver driver) {
        Browser.driver = driver;
    }

    @BeforeScenario
    public void setUpSettings(){
        setUpBrowser();
    }

    @AfterScenario
    public void tearDownTest(){
        getDriver().quit();
    }


}
