package co.com.sofka.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI {
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/driver/windows/chrome/chromedriver.exe";
    private static final String DEMO_QA_URL = "https://zonafit.co/";

    protected WebDriver driver;

    private void setUpWebdriver(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
    }

    private void setUpWebdriverUrl(){
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
    }

    protected void generalSetup(){
        setUplog4j();
        setUpWebdriver();
        setUpWebdriverUrl();
        maximize();
    }
    private void maximize(){
        driver.manage().window().maximize();
    }

    protected void quiteDriver(){
        driver.quit();
    }
    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
