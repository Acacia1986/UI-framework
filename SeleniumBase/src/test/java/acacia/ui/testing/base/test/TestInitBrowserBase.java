package acacia.ui.testing.base.test;

import acaica.ui.testing.base.InitBrowserBase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by miaomiao on 5/28/2017.
 */
public class TestInitBrowserBase extends InitBrowserBase{
    String browserPath = "src/test/resources/Driver/chromedriver.exe";
    String browserPath_FF = "src/test/resources/Driver/geckodriver.exe";

    @Test
    public void test_initBrowser_chrome() {
       WebDriver webDriver = initBrowser(BrowserType.CHROME, browserPath, true);
       webDriver.quit();
    }

    @Test
    public void test_initBrowser_firefox(){
        initBrowser(BrowserType.FIREFOX,browserPath_FF,true);
    }



    @Test
    public void test_browser_logic(){

    }
}
