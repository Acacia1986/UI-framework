package acacia.ui.testing.object;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by miaomiao on 5/29/2017.
 */
public class WebElementObject implements WebElement {
    WebDriver browser;
    By locateBy;
    Logger logger;
    Long timeout;
    String objectName;

    public WebElementObject(WebDriver browser, By locateBy, Long timeout, String objectName) {
        this.browser = browser;
        this.locateBy = locateBy;
        this.timeout = timeout;
        this.objectName = objectName;
        this.logger = LoggerFactory.getLogger(WebElementObject.class);
    }

    /**
     * Get locate by
     * @return
     */
    public By getBy(){
        return locateBy;
    }
    /**
     * Get the object name
     *
     * @return
     */
    public String getObjectName() {
        if ((objectName != null) && !objectName.isEmpty()) {
            return objectName;
        }
        return locateBy.toString();
    }

    public void click() {
        this.browser.findElement(locateBy).click();
        logger.info("Click the object" + getObjectName());
    }

    /**
     * perform a action click for element
     * Performs a click action on this object at the offset location specified.
     * @param xOffSet
     * @param yOffSet
     */
    public void clickAt(int xOffSet, int yOffSet) {
        Actions actions = new Actions(browser);
        actions.moveToElement(browser.findElement(locateBy), xOffSet, yOffSet).click().perform();
    }

    public void clickAndWaitUntilVisible(Long timeout){
        WebDriverWait wait = new WebDriverWait(browser,timeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(getBy()));
    }
    public void submit() {
        logger.info("Try to Submit the element" + getObjectName());
        browser.findElement(locateBy).submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        logger.info("Try to send key to " + getObjectName());
        browser.findElement(locateBy).sendKeys(keysToSend);
    }

    public void sendKeys(Boolean clearOrNot,CharSequence... keyToSend){
        if (clearOrNot){
            clear();
            sendKeys(keyToSend);
        }
        else {
            sendKeys(keyToSend);
        }
    }

    public void clear() {
        logger.info("Try to clear " + getObjectName());
        browser.findElement(locateBy).clear();
    }

    public String getTagName() {
        return  browser.findElement(locateBy).getTagName();
    }

    public String getAttribute(String name) {
        return browser.findElement(locateBy).getAttribute(name);
    }

    public boolean isSelected() {
        return browser.findElement(locateBy).isSelected();
    }

    public boolean isEnabled() {
        return browser.findElement(locateBy).isEnabled();
    }

    public String getText() {
        return browser.findElement(locateBy).getText();
    }

    public List<WebElement> findElements(By by) {
        List<WebElement> elements = browser.findElements(by);
        return elements;
    }

    public WebElement findElement(By by) {
        return browser.findElement(by);
    }

    public boolean isDisplayed() {
        return browser.findElement(locateBy).isDisplayed();
    }

    /**
     * Get the location of the object.
     * @return
     */
    public Point getLocation() {
        return browser.findElement(locateBy).getLocation();
    }

    /**
     * Get the size of the object.
     * @return
     */
    public Dimension getSize() {
        return browser.findElement(locateBy).getSize();
    }

    /**
     * Get the rect of the object
     * @return
     */
    public Rectangle getRect() {
        return browser.findElement(locateBy).getRect();
    }

    /**
     * Get the css value of object
     * @param propertyName
     * @return
     */
    public String getCssValue(String propertyName) {
        return browser.findElement(locateBy).getCssValue(propertyName);
    }

    /**
     * Take a screenshot for object
     * @param target
     * @param <X>
     * @return
     * @throws WebDriverException
     */
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return browser.findElement(locateBy).getScreenshotAs(target);
    }
}
