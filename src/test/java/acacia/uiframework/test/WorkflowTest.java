package acacia.uiframework.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Created by miaomiao on 5/27/2017.
 */
public class WorkflowTest {


    @Test
    public void test_1(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.close();
    }

    @Test
    public void test_2(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://bej301748.cn.oracle.com:8080/login.html");
        Actions actions = new Actions(driver);
        actions.click().perform();

    }


}
