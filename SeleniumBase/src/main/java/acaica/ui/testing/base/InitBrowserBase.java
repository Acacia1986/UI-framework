package acaica.ui.testing.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by miaomiao on 5/27/2017.
 */
public class InitBrowserBase {

   public static enum BrowserType {
        FIREFOX,
        CHROME,
        EDGE
    }

    protected static WebDriver initBrowser(BrowserType browserName, String browserPath, Boolean maxsize) {
        WebDriver browser;
        switch (browserName) {
            case FIREFOX:
                System.setProperty("webdriver.firefox.marionette", browserPath);
                DesiredCapabilities capabilities_1 = DesiredCapabilities.firefox();
                FirefoxOptions options_1 = new FirefoxOptions();
                options_1.addArguments("Test_type");
                capabilities_1.setBrowserName("FireFox");
                capabilities_1.setCapability("firefox.binary", browserPath);
                capabilities_1.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options_1);
                browser = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", browserPath);
                DesiredCapabilities capabilities_2 = DesiredCapabilities.chrome();
                ChromeOptions options_2 = new ChromeOptions();
                options_2.addArguments("Test_Type");
                capabilities_2.setBrowserName("chrome");
                capabilities_2.setCapability("chrome.binary", browserPath);
                capabilities_2.setCapability(ChromeOptions.CAPABILITY, options_2);
                browser = new ChromeDriver();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", browserPath);
                browser = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("The browser type '"+browserName+"' is not defined.");
        }
        if (maxsize)
            browser.manage().window().maximize();
        return browser;
    }

    protected  static WebDriver initBrowser(String configPath) throws IOException {
        WebDriver browser;
        Properties prop = new Properties();
        InputStream input = new FileInputStream(configPath);
        prop.load(input);
        String browserType = prop.getProperty(Configuration.BROWSER_TYPE.toString());
        BrowserType browserName = BrowserType.valueOf(browserType);
        String browser_driver_path = prop.getProperty(Configuration.BROWSER_DRIVER_PATH.toString());
        String maxsize = prop.getProperty(Configuration.MAXSIZE.toString());
        Boolean max_size = Boolean.valueOf(maxsize);
        Boolean enable_grid = Boolean.valueOf(prop.getProperty(Configuration.ENABLE_GRID.toString()));
        if (enable_grid){
            String url = prop.getProperty(Configuration.GRID_URL.toString());
            browser = initGridBrowser(browserName,url,max_size);
        }
        browser = initBrowser(browserName,browser_driver_path,max_size);
       return browser;
    }

    protected  static WebDriver initGridBrowser(BrowserType browserName,String url,Boolean maxsize) throws MalformedURLException {
        WebDriver browser;
        DesiredCapabilities capabilities = null;
        switch (browserName) {
            case FIREFOX:
                capabilities = DesiredCapabilities.firefox();
                FirefoxOptions options_ff = new FirefoxOptions();
                options_ff.addArguments("Test_type");
                capabilities.setBrowserName("FireFox");
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options_ff);
                break;
            case CHROME:
                capabilities = DesiredCapabilities.chrome();
                ChromeOptions options_chrome = new ChromeOptions();
                options_chrome.addArguments("Test_Type");
                capabilities.setBrowserName("chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options_chrome);
                break;
            case EDGE:
                capabilities = DesiredCapabilities.edge();
                capabilities.setBrowserName("Edge");
                break;
            default:
                throw new RuntimeException("The browser type '"+browserName+"' is not defined.");
        }
        browser = new RemoteWebDriver(new URL(url),capabilities);
        if (maxsize)
            browser.manage().window().maximize();
        return browser;
    }

}
