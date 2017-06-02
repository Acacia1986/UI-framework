package acacia.ui.testing.testcase;

import acacia.ui.testing.utils.ReadConfigFile;
import acacia.ui.testing.utils.ReadXMLFile;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by miaomiao on 6/2/2017.
 */
public class ReadConfigFileTest {

    @Test
    public void test_ConfigProperties() {
        String configFile = System.getProperty("user.dir") + File.separator + "src/test/resources/config/config.properties";
        Properties configProperties = new Properties();
        try {
            configProperties.load(new FileInputStream(configFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String testValue = configProperties.getProperty("Test");
        System.out.print("Value is " + testValue);
        if (testValue.equals("1")) {
            System.out.printf("This is 1");
        } else if (testValue.equals("123")) {
            System.out.printf("This is 123");
        }
    }

    @Test
    public void test_Config() {
        String configPath = "src/test/resources/config/config.properties";
        Properties properties = ReadConfigFile.getConfigProperties(configPath);
        String test_value = properties.getProperty("Test");
        System.out.println(test_value);
    }


    @Test
    public void test_readxmlFile() {
        String xmlFile = "src/test/resources/config/config_1.xml";
        ReadXMLFile.readXMLwithSAXReader(xmlFile);
    }


}
