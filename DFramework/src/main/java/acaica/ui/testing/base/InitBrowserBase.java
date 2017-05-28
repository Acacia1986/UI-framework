package acaica.ui.testing.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by miaomiao on 5/27/2017.
 */
public class InitBrowserBase {

    static enum BrowserType {
        FIREFOX,
        CHROME,
        IE
    }

    protected static WebDriver initBrowser(BrowserType browserName, String browserPath,Boolean maxsize) {
        WebDriver browser = null;
        switch (browserName) {
            case FIREFOX:
                System.getProperty("webdriver.ff.driver", browserPath);
                DesiredCapabilities capabilities_1 = DesiredCapabilities.firefox();
                FirefoxOptions options_1 = new FirefoxOptions();
                options_1.addArguments("Test_type");
                capabilities_1.setBrowserName("FireFox");
                capabilities_1.setCapability("firefox.binary", browserPath);
                capabilities_1.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options_1);
                browser = new FirefoxDriver();
                break;
            case CHROME:
                System.getProperty("webdriver.chrome.driver", browserPath);
                DesiredCapabilities capabilities_2 = DesiredCapabilities.chrome();
                ChromeOptions options_2 = new ChromeOptions();
                options_2.addArguments("Test_Type");
                capabilities_2.setBrowserName("chrome");
                capabilities_2.setCapability("chrome.binary", browserPath);
                capabilities_2.setCapability(ChromeOptions.CAPABILITY, options_2);
                browser = new ChromeDriver(capabilities_2);
                break;
            case IE:
                System.getProperty("webdriver.ie.driver", browserPath);
                browser = new InternetExplorerDriver();
                break;
            default:
                throw new RuntimeException("The browser type '"+browser+"' is not defined.");
        }
        if (maxsize)
            browser.manage().window().maximize();
        return browser;
    }
}
