package acacia.ui.testing.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by miaomiao on 5/29/2017.
 */
public abstract class PageObjectBase {
    WebDriver browser;
    String PageName;
    Locale locale = Locale.US;
    String locatorPath = "src/test/resources/locators";



    String host;




    String port;

    public PageObjectBase(WebDriver browser, String PageName) {
        this.browser = browser;
        this.PageName = PageName;
        initLog(PageName);
    }


    /**
     * Init logger
     */
    public void initLog(String pageName) {
        Logger logger = LoggerFactory.getLogger(pageName);
    }

    /**
     * Get locale
     *
     * @return
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Set Locale
     *
     * @param locale
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Get host
     * @return
     */
    public String getHost() {
        return host;
    }

    /**
     * Set host
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Get port
     * @return
     */
    public String getPort() {
        return port;
    }

    /**
     * Set port
     * @param port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Get Page name
     */
    public String getPageName() {
        return PageName;
    }

    public void setPageName(String PageName) {
        this.PageName = PageName;
    }

    /**
     * Get browser
     */
    public WebDriver getBrowser() {
        return browser;
    }

    /**
     * Set Browser
     */
    public WebDriver setBrowser(WebDriver browserType) {
        this.browser = browserType;
        return browser;
    }

    /**
     * Get object with locate
     *
     * @param by
     * @param ObjectName
     * @return
     */
    protected WebElementObject getObject(By by, String ObjectName) {
        return new WebElementObject(browser, by, ObjectName);
    }

    /**
     * Get webElementObject
     * @return
     */
    protected WebElementObject getObject() {
        String objectName = getCallingMethodName(3);
        String locator_name = getLocatorFromFile(objectName);
        By locater = getBy(locator_name);
        return getObject(locater, objectName);
    }


    /**
     * Get locator from file
     * @param objectName
     * @return
     */
    public String getLocatorFromFile(String objectName){
        ResourceBundle bundle = getLocatorFile();
        String locator = bundle.getString(objectName);
        return  locator;
    }

    /**
     * Get the locator file
     * @return
     */
    public ResourceBundle getLocatorFile() {
        try {
            File file = new File(locatorPath);
            URL[] urls = {file.toURI().toURL()};
            ClassLoader loader = new URLClassLoader(urls);
            return ResourceBundle.getBundle(getPageName(), getLocale(), loader);
        } catch (Throwable t) {
            throw new RuntimeException("Unable to load the locator file '" + locatorPath + "/" + getPageName() + "'.", t);
        }

    }

    private String getCallingMethodName(int index) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String methodName = stackTraceElements[index].getMethodName();
        return methodName;
    }

    /**
     * Choose locator by type
     * @param locator
     * @return
     */
    public By getBy(String locator){
        if(locator.startsWith("//")){
            return By.xpath(locator);
        }
        else if(locator.startsWith("xpath=")){
            return By.xpath(locator.replace("xpath=", ""));
        }
        else if(locator.startsWith(".")){
            return By.xpath(locator);
        }
        else if(locator.startsWith("id=")){
            return By.id(locator.replace("id=", ""));
        }
        else if(locator.startsWith("class=")){
            return By.className(locator.replace("class=", ""));
        }
        else if(locator.startsWith("name=")){
            return By.name(locator.replace("name=", ""));
        }
        else if(locator.startsWith("css=")){
            return By.cssSelector(locator.replace("css=", ""));
        }
        else if(locator.startsWith("link=")){
            return By.linkText(locator.replace("link=", ""));
        }
        else if(locator.startsWith("partiallink=")){
            return By.partialLinkText(locator.replace("partiallink=", ""));
        }
        else{
            return By.id(locator);
        }
    }

    /**
     * Open the url page
     */
    public void open(){
        browser.get(getBaseURL());
    }

    /**
     * Get the bas url
     * @return
     */
    private String getBaseURL(){
        String url = "http://" + getHost() + ":" + getPort();
        return  url;
    }

    public void goBack(){
        browser.navigate().back();
    }

    public Object executeScript(String script, Object... args){
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) browser;
        return javaScriptExecutor.executeScript(script, args);
    }
}
